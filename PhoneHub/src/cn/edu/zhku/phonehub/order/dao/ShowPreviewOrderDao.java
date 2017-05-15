package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.ShowPreviewOrder;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ShowPreviewOrderDao {

	public ArrayList<ShowPreviewOrder> getPreviewOrderFromDb(String userName) throws Exception{
		
		ArrayList<ShowPreviewOrder> showPreviewOrder = null;
//		ArrayList<ShopCart> shopCar = null;
		
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
		sqlQuery = "Select * from showPreviewOrder where userName = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, userName);
		rs = ps.executeQuery();
		System.out.println("dao-----ps="+ps.toString());
		
		while(rs.next()){
			if(showPreviewOrder == null){
				showPreviewOrder = new ArrayList<ShowPreviewOrder>();
			}
			 int productId = rs.getInt("productId");			//商品ID
			 int userId = rs.getInt("userId");					//买家ID
			 int storeId = rs.getInt("storeId");				//卖家ID
			 String image = rs.getString("image1");				//商品图片
			 String productName = rs.getString("productName");		//商品名字
			 String color = rs.getString("color");				//商品颜色
			 String ram = rs.getString("ram");					//ram
			 String networkType = rs.getString("networkType");	//网络类型
			 float price = rs.getFloat("price");				//单价
			 int	num = rs.getInt("num");						//购买数量
			 String userName_ = rs.getString("userName");		//买家名字
			 String province = rs.getString("province");		//地址-省份
			 String city = rs.getString("city");				//城市
			 String detailAddress = rs.getString("detailAddress");	//详细地址
			 String phone = rs.getString("phone");				//电话
			
			 
			 ShowPreviewOrder spo = new ShowPreviewOrder();
			 spo.setProductId(productId);
			 spo.setUserId(userId);
			 spo.setStoreId(storeId);
			 spo.setImage1(image);
			 spo.setProductName(productName);
			 spo.setColor(color);
			 spo.setRam(ram);
			 spo.setNetworkType(networkType);
			 spo.setPrice(price);
			 spo.setNum(num);
			 spo.setUserName(userName_);
			 spo.setProvince(province);
			 spo.setCity(city);
			 spo.setDetailAddress(detailAddress);
			 spo.setPhone(phone);
			 
			 showPreviewOrder.add(spo);
			 spo.toString();
			 
		}
		
		return showPreviewOrder;
		
		
	}
	
	
}
