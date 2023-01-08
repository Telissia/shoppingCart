package com.teldrasill.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface GoodsTypeService
{
    public String toAddType(Model model);
    public String addType(String typename, Model model, HttpSession session);
    public String toDeleteType(Model model);
    public String deleteType(Integer id,Model model);
}
