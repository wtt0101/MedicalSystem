package com.briup.service;

import java.util.List;

import com.briup.pojo.Doctor;

public interface IDoctorLogin {
	//��¼
	boolean managerlogin(String account,String password);
	//��¼
	boolean login(String account,String password);
	//ע��
	boolean register(Doctor doctor);
	//��ѯ������Ϣ
	List<Doctor> querryall();
	//ͨ��idɾ��
	boolean deletebyid(int id);
	//�޸���Ϣ
	boolean update(Doctor doctor);
	//��ҳ
	List<Doctor> paging(int page, int num);
	//��ѯ���ж�������Ϣ
	int querrynum();
	//ͨ������ģ����ѯ
	List<Doctor> Querrybyname(String name);
}
