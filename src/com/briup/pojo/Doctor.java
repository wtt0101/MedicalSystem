package com.briup.pojo;
/*
 * 医生编号 did
 * 姓名 dname
 * 年龄 dage
 * 性别 dgender
 * 所属科室 doffice
 * 账号daccount
 * 密码dpassword
 */
public class Doctor {
	private int did;
	private String dname;
	private int dage;
	private String dgender;
	private String doffice;
	private String daccount;
	private String dpassword;
	public Doctor() {
	}
	public Doctor( String dname, int dage, String dgender, String doffice, String daccount, String dpassword) {
		super();
		this.dname = dname;
		this.dage = dage;
		this.dgender = dgender;
		this.doffice = doffice;
		this.daccount = daccount;
		this.dpassword = dpassword;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDage() {
		return dage;
	}
	public void setDage(int dage) {
		this.dage = dage;
	}
	public String getDgender() {
		return dgender;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public String getDoffice() {
		return doffice;
	}
	public void setDoffice(String doffice) {
		this.doffice = doffice;
	}
	public String getDaccount() {
		return daccount;
	}
	public void setDaccount(String daccount) {
		this.daccount = daccount;
	}
	public String getDpassword() {
		return dpassword;
	}
	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", dage=" + dage + ", dgender=" + dgender + ", doffice="
				+ doffice + ", daccount=" + daccount + ", dpassword=" + dpassword + "]";
	}
	
	

}
