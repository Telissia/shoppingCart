package com.teldrasill.dao;

import com.teldrasill.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IndexDao
{
    public List<Goods> search(String mykey);
}
