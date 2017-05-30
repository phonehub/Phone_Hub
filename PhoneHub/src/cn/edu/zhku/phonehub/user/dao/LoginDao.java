package cn.edu.zhku.phonehub.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class LoginDao {

	public User getUserByName(User user) throws Exception {
		User newUser = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = "Select * from user_table where userName = ? && passWord = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		rs = ps.executeQuery();
		boolean result = rs.next();
		if (result == true) {
			if (newUser == null)
				newUser = new User();
			String userName = rs.getString("userName");
			String userPassword = rs.getString("passWord");
			newUser.setUserName(userName);
			newUser.setPassWord(userPassword);
			newUser.setUserId(rs.getInt("userId"));
			newUser.setPower(rs.getInt("power"));
		}

		rs.close();
		conn.close();
		return newUser;

	}
}
