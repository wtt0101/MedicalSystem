package com.briup.pojo;

public class User {
	private int userid;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String phone;
	
	public User() {}
	public User(int userid,String password,String name,int age,String gender,String phone) {
		this.userid=userid;
		this.password=password;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.phone=phone;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", name=" + name + ", "
				+ "age=" + age + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
}
