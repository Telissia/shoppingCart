package com.teldrasill.service;


import com.teldrasill.pojo.Goods;
import org.springframework.ui.Model;

import java.util.List;

public interface IndexService
{
    public String toLogin(Model model);
    public List<Goods> search(String mykey);
}
