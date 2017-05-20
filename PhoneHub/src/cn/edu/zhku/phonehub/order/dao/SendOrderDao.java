package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class SendOrderDao {

	public boolean sendOrderFromDb(int orderId) throws Exception{
		boolean result = false;
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		//改变order_table中的status状态为3（已发货）
		//改变sendTime为当前时间
		String sqlQuery = "Update order_table set status=3, sendTime=cast(? as datetime) where orderId=?";
		ps = conn.prepareStatement(sqlQuery);
		
			//获取当前时间
			java.util.Date utilDate = new java.util.Date();
			Date time = new Date(utilDate.getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(time);
			System.out.println("dataString-----======"+dateString);
		
		ps.setString(1, dateString);
		ps.setInt(2, orderId);
		int i = ps.executeUpdate();
		
		if(i!=0){
			result=true;
		}
		
		return result;
	}
	
	
}
