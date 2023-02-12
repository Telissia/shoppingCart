package com.teldrasill.service;

import com.teldrasill.dao.IndexDao;
import com.teldrasill.pojo.Buser;
import com.teldrasill.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
public class IndexServiceImpl implements IndexService
{
    @Autowired
    IndexDao indexDao;

    //由于RequestMapping同时接受Post和Get,需要注册时提前注入空user
    //若直接使用PostingMapping和GetMapping则不需要此方法
    @Override
    public String toRegister(Model model) {
        model.addAttribute("rbuser", new Buser());
        return "register";
    }

    @Override
    public String toLogin(Model model)
    {
        model.addAttribute("lbuser", new Buser());
        return "login";
    }

    @Override
    public List<Goods> search(String mykey) {
        return indexDao.search(mykey);
    }

}
