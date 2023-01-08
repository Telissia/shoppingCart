package com.teldrasill.service;

import com.teldrasill.dao.GoodsDao;
import com.teldrasill.dao.GoodsTypeDao;
import com.teldrasill.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService
{
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    public GoodsDao getGoodsMapper() {
        return goodsDao;
    }

    public void setGoodsMapper(GoodsDao goodsMapper) {
        this.goodsDao = goodsMapper;
    }

    @Override
    public int addGoods(Goods goods)
    {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteAGoods(Integer id) {
        return goodsDao.deleteAGoods(id);
    }

    @Override
    public int updateGoodsById(Goods goods) {
        return goodsDao.updateGoodsById(goods);
    }

    @Override
    public Goods queryGoodsById(Integer id)
    {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }

    @Override
    public List<Goods> selectAllGoodsByPage(Map<String, Object> map) {
        return goodsDao.selectAllGoodsByPage(map);
    }
}
