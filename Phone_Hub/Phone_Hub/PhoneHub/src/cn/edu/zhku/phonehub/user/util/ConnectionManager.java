package cn.edu.zhku.phonehub.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class ConnectionManager {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driver = rb.getString("driver");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		Connection conn = null;
		Class.forName(ConnectionManager.driver);
		conn = DriverManager.getConnection(ConnectionManager.url, ConnectionManager.username, ConnectionManager.password);
		return conn;
	}

	public static PreparedStatement prepare(Connection conn, String sql)
			throws SQLException {
		// TODO Auto-generated method stub

		return conn.prepareStatement(sql);
	}
	public static void closeAll(ResultSet rs, PreparedStatement pstmt,
			Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt = null;
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	
     }
}
