package com.briup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.briup.pojo.Doctor;
import com.briup.pojo.Manager;
import com.briup.utils.JDBCUtils;

public class DoctorDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	// 管理员登录
	public Manager Querrymanager(String account) {
		String sql = "select * from manager where m_account=?";
		Manager manager = new Manager();
		try {
			manager = qr.query(sql, new ResultSetHandler<Manager>() {
				Manager d = null;

				@Override
				public Manager handle(ResultSet rs) throws SQLException {
					if (rs.next()) {
						d = new Manager();
						d.setMid(rs.getInt("m_userid"));
						d.setMaccount(rs.getString("m_account"));
						d.setMpassword(rs.getString("m_password"));
					}
					return d;
				}
			}, account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

	// 通过account查
	public Doctor QuerrybyAccount(String account) {
		String sql = "select * from doctor where d_account=?";
		Doctor doctor = new Doctor();
		try {
			doctor = qr.query(sql, new ResultSetHandler<Doctor>() {
				Doctor d = null;

				@Override
				public Doctor handle(ResultSet rs) throws SQLException {
					if (rs.next()) {
						d = new Doctor();
						d.setDid(rs.getInt("d_id"));
						d.setDname(rs.getString("d_name"));
						d.setDage(rs.getInt("d_age"));
						d.setDgender(rs.getString("d_gender"));
						d.setDoffice(rs.getString("d_office"));
						d.setDaccount(rs.getString("d_account"));
						d.setDpassword(rs.getString("d_password"));
					}
					return d;
				}
			}, account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}

	// 添加一个doctor
	public boolean add(Doctor doctor) {
		String sql = "insert into doctor (" + "d_name,d_age,d_gender,d_office,d_account,d_password)\r\n"
				+ "VALUES(?,?,?,?,?,?)";
		int res = -1;
		try {
			res = qr.update(sql, doctor.getDname(), doctor.getDage(), doctor.getDgender(), doctor.getDoffice(),
					doctor.getDaccount(), doctor.getDpassword());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res > 0 ? true : false;
	}

	// 查询所有医生信息
	public List<Doctor> Querryall() {
		String sql = "select * from doctor";
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor = new Doctor();
		try {
			doctor = qr.query(sql, new ResultSetHandler<Doctor>() {
				Doctor d = null;

				@Override
				public Doctor handle(ResultSet rs) throws SQLException {
					while (rs.next()) {
						d = new Doctor();
						d.setDid(rs.getInt("d_id"));
						d.setDname(rs.getString("d_name"));
						d.setDage(rs.getInt("d_age"));
						d.setDgender(rs.getString("d_gender"));
						d.setDoffice(rs.getString("d_office"));
						d.setDaccount(rs.getString("d_account"));
						d.setDpassword(rs.getString("d_password"));
						list.add(d);
					}
					return d;
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过did删除
	public boolean deletebyid(int id) {
		String sql = "DELETE from doctor where d_id=?";
		int res = -1;
		try {
			res = qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res > 0 ? true : false;
	}

	// 修改医生信息
	public boolean update(Doctor doctor) {
		String sql = " UPDATE  doctor \r\n" + 
				" set d_name=?,d_age=?,d_gender=?,d_office=?,d_account=?,"
				+ "d_password=?\r\n" + 
				" where d_id=?";
		int res = -1;
		try {
			res = qr.update(sql, doctor.getDname(),doctor.getDage(),doctor.getDgender()
					,doctor.getDoffice(),doctor.getDaccount(),doctor.getDpassword(),doctor.getDid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res > 0 ? true : false;
	}
	// 分页
		public List<Doctor> paging(int page, int num) {
			int x =(page-1)*num;
			
			
			int all = Querryall().size();
			if((page-1)*num+num>all) {
				System.out.println("******************");
				num =  all-(page-1)*num;
			}
			System.out.println(x+"  "+num);
			
			String sql = "select * from doctor limit ?,?";
			List<Doctor> list = null ;
			try {
				list = qr.query(sql, new ResultSetHandler<List<Doctor>>() {
					@Override
					public List<Doctor> handle(ResultSet rs) throws SQLException {
						Doctor d;
						List<Doctor> res = new ArrayList<Doctor>();
						while (rs.next()) {
							d = new Doctor();
							d.setDid(rs.getInt("d_id"));
							d.setDname(rs.getString("d_name"));
							d.setDage(rs.getInt("d_age"));
							d.setDgender(rs.getString("d_gender"));
							d.setDoffice(rs.getString("d_office"));
							d.setDaccount(rs.getString("d_account"));
							d.setDpassword(rs.getString("d_password"));
							res.add(d);
						}
						return res;
					}

				}, x, num);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 查询所有医生信息
			public List<Doctor> Querrybyname(String str) {
				String flag = "%"+str+"%";
				String sql = "SELECT * from doctor where d_name LIKE ?";
				List<Doctor> list = null;
				try {
					list = qr.query(sql, new ResultSetHandler<List<Doctor>>() {
						List<Doctor> doc = new ArrayList<Doctor>();
						Doctor d = null;
						@Override
						public List<Doctor> handle(ResultSet rs) throws SQLException {
							while (rs.next()) {
								d = new Doctor();
								d.setDid(rs.getInt("d_id"));
								d.setDname(rs.getString("d_name"));
								d.setDage(rs.getInt("d_age"));
								d.setDgender(rs.getString("d_gender"));
								d.setDoffice(rs.getString("d_office"));
								d.setDaccount(rs.getString("d_account"));
								d.setDpassword(rs.getString("d_password"));
								doc.add(d);
							}
							return doc;
						}
					},flag);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
			}

}
