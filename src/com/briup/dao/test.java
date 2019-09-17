package com.briup.dao;

import java.util.List;

import com.briup.pojo.Doctor;
import com.briup.pojo.Manager;
import com.briup.service.impl.DoctorLoginImpl;

public class test {
	public static void main1(String[] args) {
		DoctorDao dao = new DoctorDao();
//		Doctor querrybyAccount = dao.QuerrybyAccount("123");
//		System.out.println(querrybyAccount);
		Doctor d = new Doctor("ls", 16, "女", "医生", "222", "987");
		boolean add = new DoctorLoginImpl().register(d);
//		boolean add =dao.add(d);
		System.out.println(add);
	}
	public static void main2(String[] args) {
		DoctorDao dao = new DoctorDao();
		Manager manager = dao.Querrymanager("123");
		System.out.println(manager);
	}
	public static void main3(String[] args) {
		DoctorDao dao = new DoctorDao();
		List<Doctor> x = dao.Querryall();
		System.out.println(x);
	}
	public static void main4(String[] args) {
		DoctorDao dao = new DoctorDao();
		 boolean deletebyid = dao.deletebyid(3);
		System.out.println(deletebyid);
	}
	public static void main(String[] args) {
		DoctorDao dao = new DoctorDao();
		Doctor doctor = new Doctor("ls", 33, "女", "医师", "111", "222");
		doctor.setDid(34);
		 boolean deletebyid = dao.update(doctor);
		System.out.println(deletebyid);
	}

}
