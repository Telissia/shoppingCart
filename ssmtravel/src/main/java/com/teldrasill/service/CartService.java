package com.teldrasill.service;

import com.teldrasill.pojo.Cart;
import com.teldrasill.pojo.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface CartService
{
    public List<Map<String, Object>> selectCart(Integer id);
//    public String putCart(Map<String, Object> map);
    public String putCart(Model model, Cart cart, HttpSession session);
    public String deleteAgoods(Integer id,HttpSession session);
    public List<Map<String, Object>> orderConfirm(HttpSession session);
}
