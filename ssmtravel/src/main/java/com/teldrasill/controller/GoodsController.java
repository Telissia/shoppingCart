package com.teldrasill.controller;

import com.teldrasill.pojo.Goods;
import com.teldrasill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController
{
    //controller调用service层
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/allGoods")
    public String list(Model model,Integer pageCur)
    {
        List<Goods> list = goodsService.queryAllGoods();
        int temp = list.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 10);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 10 > temp) {
            pageCur = pageCur - 1;
        }
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur - 1) * 10);//起始位置
        map.put("perPageSize", 10);//每页10个
        list = goodsService.selectAllGoodsByPage(map);
        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        return "allGoods";
    }
    //跳转添加商品页面
    @RequestMapping("/toAddGoods")
    public String toAddGoods()
    {
        return "addGoods";
    }

    //添加商品的请求
    @RequestMapping("/addGoods")
    public String AddGoods(Goods goods)
    {
        System.out.println("addgoods>=" + goods);
        goodsService.addGoods(goods);
        return "redirect:/goods/allGoods";
        //请求复用，重定向请求到allGoods
    }
}
