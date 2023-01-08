package com.teldrasill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService
{
    @Autowired
    private GoodsTypeService goodsTypeService;

    @Override
    public String toAddType(Model model) {
        return null;
    }

    @Override
    public String addType(String typename, Model model, HttpSession session) {
        return null;
    }

    @Override
    public String toDeleteType(Model model) {
        return null;
    }

    @Override
    public String deleteType(Integer id, Model model) {
        return null;
    }
}
