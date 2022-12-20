package com.teldrasill.service;

import com.teldrasill.dao.OrderDao;
import com.teldrasill.pojo.Order;
import com.teldrasill.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderDao orderDao;


    @Override
    public String orderSubmit(Model model, HttpSession session, Double amount) {
        List<Map<String, Object>> list = orderDao.selectGoodsShop(MyUtil.getUserId(session));
        Order order = new Order();
        order.setAmount(amount);
        order.setBusertable_id(MyUtil.getUserId(session));
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
        //生成订单详情
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ordersn", order.getId());
        map.put("uid", MyUtil.getUserId(session));
        orderDao.addOrderDetail(map);
        //更新商品库存
        //更新商品库存1.查询商品购买量，以便更新库存使用
        //更新商品库存2.根据商品购买量更新库存
        for (Map<String, Object> map2 : list) {
            orderDao.updateStore(map2);
        }
        //清空购物车
        orderDao.clear(MyUtil.getUserId(session));
        model.addAttribute("ordersn", order.getId());
        return "before/orderdone";
    }

    @Override
    public String pay(Integer ordersn) {
        orderDao.pay(ordersn);
        return "before/paydone";
    }
}
