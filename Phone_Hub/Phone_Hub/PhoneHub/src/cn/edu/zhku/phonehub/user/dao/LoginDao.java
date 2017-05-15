package cn.edu.zhku.phonehub.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.util.*;;

public class LoginDao {

	public User getUserByName(User user) throws Exception {
		User newUser = new User();
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
			String userName = rs.getString("userName");
			String userPassword = rs.getString("passWord");
			newUser.setUserName(userName);
			newUser.setPassWord(userPassword);
            newUser.setUserId(rs.getInt("userId"));
		}
		rs.close();
		conn.close();
		return newUser;

	}
}
