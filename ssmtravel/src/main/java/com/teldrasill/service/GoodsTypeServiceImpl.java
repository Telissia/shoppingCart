package com.teldrasill.service;

import com.teldrasill.dao.GoodsTypeDao;
import com.teldrasill.pojo.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService
{
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public String toAddType(Model model)
    {
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

    @Override
    public List<GoodsType> queryAllGoodsType()
    {
        return goodsTypeDao.selectGoodsType();
    }
}
