package com.teldrasill.dao;

import com.teldrasill.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsDao
{
    int addGoods(Goods goods);

    int deleteAGoods(Integer id);

    int updateGoodsById(Goods goods);

    Goods queryGoodsById(Integer id);

    List<Goods> queryAllGoods();

    List<Goods> selectAllGoodsByPage(Map<String, Object> map);

}
