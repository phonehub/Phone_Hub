package cn.edu.zhku.phonehub.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.phonehub.user.User;
import cn.edu.zhku.phonehub.util.DB;

public class LoginDao {

	public User getUserByName(User user) throws Exception {
		User newUser = new User();
		Connection conn = DB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = "Select name,password from user where name = ? && password = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		rs = ps.executeQuery();
		boolean result = rs.next();
		if (result == true) {
			String userName = rs.getString("name");
			String userPassword = rs.getString("password");
			newUser.setName(userName);
			newUser.setPassword(userPassword);

		}
		rs.close();
		conn.close();
		return newUser;

	}
}
