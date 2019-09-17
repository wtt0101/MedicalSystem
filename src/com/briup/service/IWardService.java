package com.briup.service;

import java.util.List;
import com.briup.pojo.Ward;

public interface IWardService {
	//查询所有病房信息
	List<Ward> querryall();
	//通过id删除
	boolean deletebyid(int id);
	//修改病房信息
	boolean update(Ward ward);
	
}
