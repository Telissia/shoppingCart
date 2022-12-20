package com.teldrasill.service;

import com.teldrasill.dao.CartDao;
import com.teldrasill.pojo.Buser;
import com.teldrasill.pojo.Goods;
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
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartDao cartDao;

    public CartDao getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<Map<String, Object>> selectCart(Integer id)
    {
        return cartDao.selectCart(id);
    }

    @Override
    public String putCart(Map<String, Object> map)
    {
        //是否已添加购物车
        List<Map<String, Object>> list = cartDao.isPutCart(map);
        if(list.size() > 0)
             cartDao.updateCart(map);
        else
             cartDao.putCart(map);
        return "redirect:/cart/selectCart";
    }

    @Override
    public String deleteAgoods(Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);
        cartDao.deleteAgoods(map);
        return "forward:/cart/selectCart";
    }

    @Override
    public List<Map<String, Object>> orderConfirm(HttpSession session)
    {
        return cartDao.selectCart(MyUtil.getUserId(session));
    }
}
