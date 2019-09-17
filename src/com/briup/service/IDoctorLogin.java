package com.briup.service;

import java.util.List;

import com.briup.pojo.Doctor;

public interface IDoctorLogin {
	//登录
	boolean managerlogin(String account,String password);
	//登录
	boolean login(String account,String password);
	//注册
	boolean register(Doctor doctor);
	//查询所有信息
	List<Doctor> querryall();
	//通过id删除
	boolean deletebyid(int id);
	//修改信息
	boolean update(Doctor doctor);
	//分页
	List<Doctor> paging(int page, int num);
	//查询共有多少条信息
	int querrynum();
	//通过名字模糊查询
	List<Doctor> Querrybyname(String name);
}
