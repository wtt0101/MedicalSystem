package com.briup.pojo;

import java.util.HashMap;
import java.util.Map;

public class Cost {
	private int id;//费用凭单号
	private int bid;//病历号
	private String username;//姓名
	private String mtypes;//药品种类
	private String sfnr;//收费内容
	private double tcost;//总的费用
	
	public Cost(int id,int bid,String username,
			String mtypes,String sfnr,double tcost) {
		this.id=id;
		this.bid=bid;
		this.username=username;
		this.mtypes=mtypes;
		this.sfnr=sfnr;
		this.tcost=tcost;
	}
	/*public static void main(String[] args) {
		//通过使用HashMap存入对象
		HashMap<Integer,Object> cost=new HashMap<Integer,Object>(); 
		cost.put(1, new Cost(1001,1,"jack","2","yaopf","12"));
		cost.put(2, new Cost(1002,2,"jack","2","yaopf","12"));
		cost.put(3, new Cost(1003,3,"jack","2","yaopf","12"));
		cost.put(4, new Cost(1004,4,"jack","2","yaopf","12"));
		cost.put(5, new Cost(1005,5,"jack","2","yaopf","12"));
		cost.put(6, new Cost(1006,6,"jack","2","yaopf","12"));
		cost.put(7, new Cost(1007,7,"jack","2","yaopf","12"));
		cost.put(8, new Cost(1008,8,"jack","2","yaopf","12"));
		
		
		//通key值病历号，来获取Cost属性值
	}*/
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMtypes() {
		return mtypes;
	}
	public void setMtypes(String mtypes) {
		this.mtypes = mtypes;
	}
	public String getSfnr() {
		return sfnr;
	}
	public void setSfnr(String sfnr) {
		this.sfnr = sfnr;
	}
	public double getTcost() {
		return tcost;
	}
	public void setTcost(double tcost) {
		this.tcost = tcost;
	}
	@Override
	public String toString() {
		return "Cost [id=" + id + ", bid=" + bid + ", username=" + username + ","
				+ " mtypes=" + mtypes + ", sfnr=" + sfnr+ ", tcost=" + tcost + "]";
	}
	
}
