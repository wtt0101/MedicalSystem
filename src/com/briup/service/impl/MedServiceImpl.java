package com.briup.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.briup.dao.MedicinalDao;
import com.briup.pojo.Medicinal;

public class MedServiceImpl {
	
	//��ѯ
	public List<Medicinal> queryAll(){
		try {
			return new MedicinalDao().queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//����
	public int update(Medicinal med) {
		MedicinalDao mDao=new MedicinalDao();
		try {
			mDao.update(med);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}
	
	
	//ɾ��
	public int delete(int id) {
		MedicinalDao mDao=new MedicinalDao();
		try {
			mDao.delete(id);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}	
	}
	
	//����
	public int insert(Medicinal med) {
		MedicinalDao mDao=new MedicinalDao();
		try {
			mDao.add(med);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1001;
		}
	}

}
