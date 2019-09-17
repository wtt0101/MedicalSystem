package com.briup.pojo;

public class Ward {
	private int id;
	private int wid;//病房编号
	private int wbednum;//病房床位号
	private String wdoctor;//病房管理医生
	private int wdoctornum;//病房管理医生编号
	private String wtype;//病房类型
	private String wdepartment;//病房所属科室
	private String wrespname;//病房负责人
	
	public Ward() {}
	
	public Ward(int id,int wid,int wbednum,String wdoctor,int wdoctornum,
			      String wtype,String wdepartment,String wrespname) {
		this.id=id;
		this.wid=wid;
		this.wbednum=wbednum;
		this.wdoctor=wdoctor;
		this.wdoctornum=wdoctornum;
		this.wtype=wtype;
		this.wdepartment=wdepartment;
		this.wrespname=wrespname;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getWbednum() {
		return wbednum;
	}

	public void setWbednum(int wbednum) {
		this.wbednum = wbednum;
	}

	public String getWdoctor() {
		return wdoctor;
	}

	public void setWdoctor(String wdoctor) {
		this.wdoctor = wdoctor;
	}

	public int getWdoctornum() {
		return wdoctornum;
	}

	public void setWdoctornum(int wdoctornum) {
		this.wdoctornum = wdoctornum;
	}

	public String getWtype() {
		return wtype;
	}

	public void setWtype(String wtype) {
		this.wtype = wtype;
	}

	public String getWdepartment() {
		return wdepartment;
	}

	public void setWdepartment(String wdepartment) {
		this.wdepartment = wdepartment;
	}

	public String getWrespname() {
		return wrespname;
	}

	public void setWrespname(String wrespname) {
		this.wrespname = wrespname;
	}


	@Override
	public String toString() {
		return "Ward [id=" + id + ", wid=" + wid + ", wbednum=" + wbednum + ","
				+ " wdoctor=" + wdoctor + ", wdoctornum="
				+ wdoctornum + ", wtype=" + wtype + ", wdepartment=" 
				+ wdepartment + ", wrespname=" + wrespname + "]";
	}

	
	
}
