package cn.edu.zhku.phonehub.product.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static String driverName= "com.mysql.jdbc.Driver";
//	private static String url = "jdbc:mysql://localhost:3306/phonehub?useUnicode=true&characterEncoding=UTF-8";
	private static String url = "jdbc:mysql://localhost:3306/phonehub?characterEncoding=utf8";
	private static String userName = "root";
	private static String password = "";
	
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		//通过反射机制动态的引入应用的数据库的驱动
		Class.forName( ConnectionManager.driverName );
		conn = DriverManager.getConnection(ConnectionManager.url,ConnectionManager.userName,ConnectionManager.password);
		return conn;
	}
}
