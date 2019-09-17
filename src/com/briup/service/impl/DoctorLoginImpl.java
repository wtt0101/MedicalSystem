package com.briup.service.impl;

import java.util.List;

import com.briup.dao.DoctorDao;
import com.briup.pojo.Doctor;
import com.briup.pojo.Manager;
import com.briup.service.IDoctorLogin;

public class DoctorLoginImpl implements IDoctorLogin {
	DoctorDao doctordao = new DoctorDao();

	// π‹¿Ì‘±µ«¬º
	@Override
	public boolean managerlogin(String account, String password) {
		Manager manager = doctordao.Querrymanager(account);
		if (manager != null && manager.getMpassword().equals(password))
			return true;
		return false;
	}

	// ≈–∂œ «∑Òµ«¬º≥…π¶
	@Override
	public boolean login(String account, String password) {
		Doctor doctor = doctordao.QuerrybyAccount(account);
		if (doctor != null && doctor.getDpassword().equals(password))
			return true;
		return false;
	}

	// ◊¢≤·
	@Override
	public boolean register(Doctor doctor) {
		// ≈–∂œ’À∫≈ «∑Ò¥Ê‘⁄
		Doctor d = doctordao.QuerrybyAccount(doctor.getDaccount());
		if (d != null)
			return false;
		return doctordao.add(doctor);
	}

	@Override
	public List<Doctor> querryall() {
		List<Doctor> res = doctordao.Querryall();
		return res;
	}

	@Override
	public boolean deletebyid(int id) {
		return doctordao.deletebyid(id);
	}

	@Override
	public boolean update(Doctor doctor) {
		return doctordao.update(doctor);
	}
	@Override
	public List<Doctor> paging(int page, int num) {
		
		
		return doctordao.paging(page, num);
	}

	@Override
	public int querrynum() {
		return doctordao.Querryall().size();
	}

	@Override
	public List<Doctor> Querrybyname(String name) {
		return doctordao.Querrybyname(name);
	}


}
