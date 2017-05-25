package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.ShopCart;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ShowShopcartDao {

	public ArrayList<ShopCart> getShopcart(int userId) throws Exception{
		ArrayList<ShopCart> shopcartList = null;
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		//获取购物车中的信息(后来发现，可以直接获取订单预览信息，故这一步可以不用)
		//获取订单预览信息
		String sqlQuery = null;
		//这里没有传入userId的参数
		sqlQuery = "Select * from show_shopcart where userId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		
		while(rs.next()){
			if(shopcartList==null)
				shopcartList = new ArrayList<ShopCart>();
			
			 int userId_ = rs.getInt("userId");					//用户的id
			 int productId = rs.getInt("productId");			//商品的id
			 int storeId = rs.getInt("storeId");				//店铺的id
			 int num = rs.getInt("num"); 						//购买数量
			 String productName = rs.getString("productName");	//商品名称
			 float price = rs.getFloat("price");				//商品价格
			 String image = rs.getString("image1");				//商品图片
			 String color = rs.getString("color");				//商品颜色
			
			 ShopCart shopcart = new ShopCart();
			 
			 shopcart.setUserId(userId_);
			 shopcart.setProductId(productId);
			 shopcart.setStoreId(storeId);
			 shopcart.setNum(num);
			 shopcart.setProductName(productName);
			 shopcart.setPrice(price);
			 shopcart.setImage(image);
			 shopcart.setColor(color);
			
			 shopcartList.add(shopcart);
			
		}
		
		
		return shopcartList;
	}
	
}
