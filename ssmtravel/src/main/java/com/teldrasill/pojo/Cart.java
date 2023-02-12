package com.teldrasill.pojo;

import java.util.List;
import java.util.Map;

public class Cart
{
    private List<Map<String, Integer>> goodsList;
    private int total;

    public List<Map<String, Integer>> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Map<String, Integer>> goodsList) {
        this.goodsList = goodsList;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }
}
