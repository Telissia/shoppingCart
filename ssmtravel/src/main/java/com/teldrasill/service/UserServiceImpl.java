package com.teldrasill.service;

import com.teldrasill.dao.UserDao;
import com.teldrasill.pojo.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    public int register(Buser buser)
    {
        return userDao.register(buser);
    }

    @Override
    public List<Buser> login(Buser buser, Model model, HttpSession session)
    {
        List<Buser> list = userDao.login(buser);
        return list;
    }
}
