package com.briup.service.impl;

import com.briup.dao.IUserDao;
import com.briup.pojo.Doctor;
import com.briup.pojo.Manager;
import com.briup.pojo.User;
import com.briup.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userdao=new IUserDao();
	
	//¹ÜÀíÔ±µÇÂ¼
	@Override
	public boolean managerlogin(int userid, String password) {
		Manager manager = userdao.Querrymanager(userid);
		if (manager != null && manager.getMpassword().equals(password))
			return true;
		return false;
	}
	//µÇÂ¼
    public boolean login(int userid, String password) {
    	User user = userdao.QuerrybyAccount(userid);
		if (user != null && user.getPassword().equals(password))
			return true;
		return false;
	}
    //×¢²á
	public boolean register(User user) {
		User u = userdao.QuerrybyAccount(user.getUserid());
		if (u != null)
			return false;
		return userdao.add(user);
	}
}
