package com.teldrasill.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver
{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)
    {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", e);
        if(e instanceof UserLoginException)
        {
            httpServletRequest.setAttribute("msg","您未登录，请先登录");
            return new ModelAndView("login",model);
        }
        return null;
    }
}
