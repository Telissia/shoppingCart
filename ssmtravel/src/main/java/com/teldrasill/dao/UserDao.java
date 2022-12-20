package com.teldrasill.dao;

import com.teldrasill.pojo.Buser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao
{
    public int register(Buser buser);
    public List<Buser> login(Buser buser);
}
