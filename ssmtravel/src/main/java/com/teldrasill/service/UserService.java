package com.teldrasill.service;

import com.teldrasill.pojo.Buser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService
{
    public int register(Buser buser);
    public List<Buser> login(Buser buser);
}
