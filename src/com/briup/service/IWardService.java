package com.briup.service;

import java.util.List;
import com.briup.pojo.Ward;

public interface IWardService {
	//��ѯ���в�����Ϣ
	List<Ward> querryall();
	//ͨ��idɾ��
	boolean deletebyid(int id);
	//�޸Ĳ�����Ϣ
	boolean update(Ward ward);
	
}
