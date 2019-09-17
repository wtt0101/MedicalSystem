package com.briup.service.impl;

import java.util.List;

import com.briup.dao.WardDao;
import com.briup.pojo.Ward;
import com.briup.service.IWardService;

public class WardServiceImpl implements IWardService{
	WardDao wardao=new WardDao();

	public List<Ward> paging(int page, int size) {
		return null;
	}

	@Override
	public List<Ward> querryall() {
		List<Ward> war=wardao.Querryall();
		return war;
	}

	@Override
	public boolean deletebyid(int id) {
		return wardao.deletebyid(id);
	}

	@Override
	public boolean update(Ward ward) {
		return wardao.update(ward);
	}
}
