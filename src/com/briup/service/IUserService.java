package com.briup.service;
import com.briup.pojo.User;

public interface IUserService {
	//����Ա��¼
	boolean managerlogin(int userid,String password);
	//��ͨ��Ա��¼
	boolean login(int userid,String password);
	//ע��
	boolean register(User user);
}
