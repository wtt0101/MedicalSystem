package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.pojo.Medicinal;
import com.briup.utils.JDBCUtils;

public class MedicinalDao {

	//增加药品
	public void add(Medicinal med) throws SQLException{
		//获取连接
		Connection conn=JDBCUtils.getConnection();
		String sql="insert into medicine values(null,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, med.getName());
		ps.setString(2, med.getType());
		ps.setString(3, med.getDescription());
		ps.setDouble(4, med.getPrice());
		ps.executeUpdate();
	}
	
	//删除药品
	public void delete(int id) throws SQLException{
	Connection conn=JDBCUtils.getConnection();
	String sql="delete from medicine where id=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, id);
	ps.executeUpdate();
	}

	//更新药品
	public void update(Medicinal med) throws SQLException{
		Connection conn=JDBCUtils.getConnection();
		String sql="update medicine set name=?,type=?,description=?,price=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, med.getName());
		ps.setString(2, med.getType());
		ps.setString(3, med.getDescription());
		ps.setDouble(4, med.getPrice());
		ps.setInt(5, med.getId());
		ps.executeUpdate();
	}
	
	//查询所有药品
	
	public List<Medicinal> queryAll() throws SQLException{
	List<Medicinal> meds=new ArrayList<>();
	Connection conn=JDBCUtils.getConnection();
	String sql="select * from medicine";
	PreparedStatement ps=conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		Medicinal med=new Medicinal();
		med.setId(rs.getInt(1));
		med.setName(rs.getString(2));
		med.setType(rs.getString(3));
		med.setDescription(rs.getString(4));
		med.setPrice(rs.getDouble(5));
		meds.add(med);
	}
	return meds;
	}
	
}
