package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class GetProductDao {

	public boolean getProductResultFromDb(int orderId) throws Exception{
		
		boolean result = false;
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		//更新订单信息（1未付款，2已付款未发货，3已付款已发货、4已收货）
		String sqlQuery = null;
		sqlQuery = "Update order_table set status = ? where orderId = ?";
		
		
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, 4);
		ps.setInt(2, orderId);
		System.out.println("GetProductDao-------sql="+ps.toString());
		int changedNum = ps.executeUpdate();
		
		System.out.println("GetProductDao-------changedNum="+changedNum);
		if(changedNum !=0){
			result = true;
		}
		
		
		
		return result;
	}
	
}
