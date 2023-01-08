package com.teldrasill.dao;

import com.teldrasill.pojo.Goods;
import com.teldrasill.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsTypeDao
{
    public List<GoodsType> selectGoodsType();
    public int addType(String typename);
    public int deleteType(Integer id);
    public List<Goods> selectGoodsByType(Integer id);
}
