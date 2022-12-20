package com.teldrasill.service;

import com.teldrasill.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService
{
    public int addGoods(Goods goods);

    public int deleteAGoods(Integer id);

    public int updateGoodsById(Goods goods);

    public Goods queryGoodsById(Integer id);

    public List<Goods> queryAllGoods();

    public List<Goods> selectAllGoodsByPage(Map<String,Object> map);

}
