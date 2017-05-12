package cn.edu.zhku.phonehub.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DB {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driver = rb.getString("driver");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		Connection conn = null;
		Class.forName(DB.driver);
		conn = DriverManager.getConnection(DB.url, DB.username, DB.password);
		return conn;
	}

	public static PreparedStatement prepare(Connection conn, String sql)
			throws SQLException {
		// TODO Auto-generated method stub

		return conn.prepareStatement(sql);
	}

}
