package com.briup.pojo;
/*
 * 管理员管理医生
 */
public class Manager {
	private int mid;
	private String maccount;
	private String mpassword;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMaccount() {
		return maccount;
	}
	public void setMaccount(String maccount) {
		this.maccount = maccount;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public Manager(String maccount, String mpassword) {
		super();
		this.maccount = maccount;
		this.mpassword = mpassword;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", maccount=" + maccount + ", mpassword=" + mpassword + "]";
	}
	
}
