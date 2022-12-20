package com.teldrasill.controller;

import com.teldrasill.pojo.Buser;
import com.teldrasill.pojo.Goods;
import com.teldrasill.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController
{
    @Autowired
    private IndexService indexService;

    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        return indexService.toLogin(model);
    }

    @RequestMapping("/search")
    public String search(Model model, String mykey) {
        List<Goods> list = indexService.search(mykey);
        model.addAttribute("searchlist",list);
        return "searchResult";
    }

}
