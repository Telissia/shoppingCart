package com.teldrasill.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.teldrasill.pojo.Buser;

public class MyUtil {
	public static String getStringID()
	{
		String id = null;
		Date today = new Date();//得到服务器端系统当前日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmssSSS");
		id = sdf.format(today);//将日期转化为字符串
		return id;
	
	}
	/**
	 * 获得用户ID
	 */
	public static Integer getUserId(HttpSession session) {
		Buser ruser = (Buser)session.getAttribute("bruser");
		return ruser.getId();
	}
}
