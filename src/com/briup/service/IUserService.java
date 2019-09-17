package com.briup.service;
import com.briup.pojo.User;

public interface IUserService {
	//管理员登录
	boolean managerlogin(int userid,String password);
	//普通成员登录
	boolean login(int userid,String password);
	//注册
	boolean register(User user);
}
