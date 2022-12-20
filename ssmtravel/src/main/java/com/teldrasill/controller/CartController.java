package com.teldrasill.controller;

import com.teldrasill.pojo.Buser;
import com.teldrasill.pojo.Goods;
import com.teldrasill.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController
{
    @Autowired
    CartService cartService;
    @RequestMapping("/selectCart")
    public String selectCart(Model model, HttpSession session)
    {
        Buser user = (Buser)session.getAttribute("bruser");
        List<Map<String, Object>> list = cartService.selectCart(user.getId());
        double sum = 0;
        for (Map<String, Object> map : list) {
            sum = sum + (Double)map.get("smallsum");
        }
        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);
        return "selectCart";
    }
    //添加购物车
    @RequestMapping("/putCart")
    public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session)
    {
        Buser ruser = (Buser)session.getAttribute("bruser");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", ruser.getId());
        map.put("gid", id);
        map.put("shoppingnum", shoppingnum);
        return cartService.putCart(map);
    }

    //删除购物车
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Model model,Integer id,HttpSession session,Integer shoppingnum,Integer reshoppingnum)
    {
        shoppingnum = reshoppingnum - shoppingnum;
        if(shoppingnum != 0)
        {
            return putCart(model, shoppingnum, id, session);
        }
        return cartService.deleteAgoods(id, session);
        //js控制，不允许减到0，只能减到1否则删除，在加号一栏添加putCart操作
    }

    //去结算
    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model, HttpSession session) {
        List<Map<String, Object>> list = cartService.orderConfirm(session);
        double sum = 0;
        for (Map<String, Object> map : list) {
            sum = sum + (Double)map.get("smallsum");
        }
        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);
        return "orderconfirm";
    }
}
