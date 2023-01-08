package com.teldrasill.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.teldrasill.pojo.Buser;
import com.teldrasill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@ModelAttribute Buser buser, Model model) {
        buser.setBpwd(DigestUtil.sha256Hex(buser.getBpwd()));
        int n = userService.register(buser);
        if(n > 0) {
            return "login";
        }else {
            model.addAttribute("msg", "Register Fail!!!");
            return "register";
        }
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute Buser buser, Model model, HttpSession session) {
        Buser ruser = null;
        buser.setBpwd(DigestUtil.sha256Hex(buser.getBpwd()));
        List<Buser> list = userService.login(buser, model, session);
        if(list.size() > 0)
        {
            ruser = list.get(0);
        }
        if(ruser != null)
        {
            session.setAttribute("bruser", ruser);
            return "redirect:/goods/allGoods";
//            return "/";
        }else
        {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/allGoods";
    }
}
