package cn.edu.zhku.phonehub.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class Userdao {
	public User Select(int userId) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		User user = null;
		String sql = "select * from user_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		ResultSet rs = null;
		rs = ps.executeQuery();
		while (rs.next()) {
			if (user == null) {
				user = new User();
			}
			user.setUserId(userId);
			user.setHeadImage(rs.getString("headImage"));
			user.setPassWord(rs.getString("passWord"));
			user.setUserName(rs.getString("userName"));
			user.setPayKey(rs.getString("payKey"));
			user.setWallet(rs.getDouble("Wallet"));
			user.setPower(rs.getInt("power"));
		}
		return user;
	}

	public boolean update(User user) throws SQLException,
			ClassNotFoundException {
		System.out.println(user.getUserId() + user.getUserName()
				+ user.getPayKey() + user.getPower() + user.getHeadImage());
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		String sql = "update  user_table set userName=?,passWord=?,payKey=?,headImage=?, wallet=?,power=?   where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		ps.setString(3, user.getPayKey());
		ps.setString(4, user.getHeadImage());
		ps.setDouble(5, user.getWallet());
		ps.setInt(6, user.getPower());
		ps.setInt(7, user.getUserId());
		if (ps.executeUpdate() != 0)
			return true;
		return false;
	}

	public boolean delete(User user) throws ClassNotFoundException,
			SQLException {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from user_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, user.getUserId());
		if (ps.executeUpdate() != 0)
			return true;
		return false;
	}

	public boolean getUserByName(String name) throws Exception {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = "Select * from user_table where userName =?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, name);
		rs = ps.executeQuery();
		if (rs.next()) {
			return false;
		}

		return true;

	}

}
