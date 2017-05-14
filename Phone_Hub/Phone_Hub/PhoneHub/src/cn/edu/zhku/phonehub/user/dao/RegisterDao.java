package cn.edu.zhku.phonehub.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class RegisterDao {

	   public boolean InsertUser(User user) throws ClassNotFoundException, SQLException{
		   Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = null;
			
			String sql="insert into user_table (userId, userName, passWord) values (null,?,?)";
			ps=ConnectionManager.prepare(conn,sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			if(ps.executeUpdate()!=0)
			{
			ps.close();
			conn.close();
			return  true;
			}
			
			else
			{
				ps.close();
				conn.close();
				return false;
			}
			
	   }
	
}
