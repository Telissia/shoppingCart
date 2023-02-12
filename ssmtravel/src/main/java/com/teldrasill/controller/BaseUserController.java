package com.teldrasill.controller;

import com.teldrasill.exception.UserLoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseUserController
{
    //验证用户是否登录
    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginException
    {
        if(session.getAttribute("bruser") == null)
        {
            throw new UserLoginException("没有登录!!!");
        }
    }
}
