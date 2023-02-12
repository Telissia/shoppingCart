package com.teldrasill.dao;

import com.teldrasill.pojo.Cart;
import com.teldrasill.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CartDao
{
    public List<Map<String, Object>> selectCart(Integer id);
    public List<Map<String, Object>> isPutCart(Map<String, Object> map);
    public int putCart (Map<String, Object> map);
    public int updateCart (Map<String, Object> map);
    public int deleteAgoods (Map<String, Object> map);
}
