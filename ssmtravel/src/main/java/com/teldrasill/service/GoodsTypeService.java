package com.teldrasill.service;

import com.teldrasill.pojo.Goods;
import com.teldrasill.pojo.GoodsType;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface GoodsTypeService
{
    public String toAddType(Model model);
    public String addType(String typename, Model model, HttpSession session);
    public String toDeleteType(Model model);
    public String deleteType(Integer id,Model model);
    public List<GoodsType> queryAllGoodsType();
}
