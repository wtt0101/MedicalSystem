package com.briup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import com.briup.pojo.Ward;
import com.briup.utils.JDBCUtils;

public class WardDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	// ��ѯ����ҽ����Ϣ
		public List<Ward> Querryall() {
			String sql = "select * from ward";
			List<Ward> list = new ArrayList<Ward>();
			Ward ward = new Ward();
			try {
				ward = qr.query(sql, new ResultSetHandler<Ward>() {
					Ward w = null;

					@Override
					public Ward handle(ResultSet rs) throws SQLException {
						while (rs.next()) {
							w = new Ward();
							w.setId(rs.getInt("id"));
							w.setWid(rs.getInt("wid"));
							w.setWbednum(rs.getInt("wbednum"));
							w.setWdoctor(rs.getString("wdoctor"));
							w.setWdoctornum(rs.getInt("wdoctornum"));
							w.setWtype(rs.getString("wtype"));
							w.setWdepartment(rs.getString("wdepartment"));
							w.setWrespname(rs.getString("wrespname"));
							list.add(w);
						}
						return w;
					}
				});
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

		// ͨ��idɾ��
		public boolean deletebyid(int id) {
			String sql = "DELETE from ward where id=?";
			int res = -1;
			try {
				res = qr.update(sql, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return res > 0 ? true : false;
		}

		// �޸Ĳ�����Ϣ
		public boolean update(Ward ward) {
			String sql = " UPDATE  ward \r\n" + 
					" set id=?,wid=?,wbednum=?,wdoctor=?,wdoctornum=?,wtype=?,wdepartment=?,wrespname=?"
					+ "wtype=?\r\n" + 
					" where d_id=?";
			int res = -1;
			try {
				res = qr.update(sql, ward.getId(),ward.getWid(),ward.getWbednum()
						,ward.getWdoctor(),ward.getWdoctornum(),ward.getWtype()
						,ward.getWdepartment(),ward.getWrespname());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return res > 0 ? true : false;
		}
}
