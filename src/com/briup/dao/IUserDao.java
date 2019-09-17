package com.briup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import com.briup.pojo.Manager;
import com.briup.pojo.User;
import com.briup.utils.JDBCUtils;

public class IUserDao {
	
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	// 管理员登录
	public Manager Querrymanager(int userid) {
		String sql = "select * from manager where m_userid=?";
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
			}, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
    //通过名字查询
	public User QuerrybyAccount(int userid) {
		String sql="select * from user where userid=?";
		User user=new User();
		try {
			user = qr.query(sql, new ResultSetHandler<User>() {
				User u = null;

				@Override
				public User handle(ResultSet rs) throws SQLException {
					if (rs.next()) {
						u = new User();
						u.setUserid(rs.getInt("userid"));
						u.setPassword(rs.getString("password"));
						u.setName(rs.getString("name"));
						u.setAge(rs.getInt("age"));
						u.setGender(rs.getString("gender"));
						u.setPhone(rs.getString("phone"));
					}
					return u;
				}
			}, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	// 添加一个doctor
		public boolean add(User user) {
			String sql = "insert into user(userid,password,name,age,gender,phone)"
					+ " values(?,?,?,?,?,?)";
			int res = -1;
			try {
				res = qr.update(sql, user.getUserid(),user.getPassword(),user.getName(),user.getAge(),
						         user.getGender(),user.getPhone());

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return res > 0 ? true : false;
		}
}
