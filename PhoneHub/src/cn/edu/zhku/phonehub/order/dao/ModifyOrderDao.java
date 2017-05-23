package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ModifyOrderDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sqlQuery;
	
	public ModifyOrderDao() throws Exception{
		conn = null;
		ps = null;
		rs = null;
		sqlQuery = null;
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
	}
	
	//查看orderId是否存在
	public boolean testOrderId(int orderId) throws SQLException{
		sqlQuery = "select* from order_table where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, orderId);
		rs = ps.executeQuery();
		if(rs.next())
			return true;
		return false;
	}
	

	//修改地址-省份
	public boolean modifyProvince(int orderId, String province) throws Exception{
		sqlQuery = "update order_table set province = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, province);
		ps.setInt(2, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//修改地址-城市
	public boolean modifyCity(int orderId, String city) throws Exception{
		sqlQuery = "update order_table set city = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, city);
		ps.setInt(2, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//修改地址-详细
	public boolean modifyDetailAddress(int orderId, String detailAddress) throws Exception{
		sqlQuery = "update order_table set detailAddress = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, detailAddress);
		ps.setInt(2, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//修改手机号码
	public boolean modifyPhone(int orderId, String phone) throws SQLException{
		sqlQuery = "update order_table set phone = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, phone);
		ps.setInt(2, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//修改名字
	public boolean modifyName(int orderId, String name) throws SQLException{
		sqlQuery = "update order_table set name = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, name);
		ps.setInt(2, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//修改总价
	public boolean modifyAmount(int orderId, String amount, String message) throws SQLException{
		sqlQuery = "update order_table set amount = ?,message = ? where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setFloat(1, Float.parseFloat(amount));
		ps.setString(2, message);
		ps.setInt(3, orderId);
		if(ps.executeUpdate() !=0){
			return true;
		}
		return false;
	}
	
	//显示修改后的订单信息
	public StoreSeeOrder showOrder(int orderId_) throws SQLException{
		StoreSeeOrder order = null;
		sqlQuery = "select * from store_see_order where orderId=?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, orderId_);
		rs = ps.executeQuery();
		if(rs.next()){
			order = new StoreSeeOrder();
			
			 int storeId = rs.getInt("storeId");					//店铺编号
			 int orderId = rs.getInt("orderId");					//订单编号
			 String image1 = rs.getString("image1");				//商品图片地址
			 String productName = rs.getString("productName");		//商品名称
			 String color = rs.getString("color");					//颜色
			 String ram = rs.getString("ram");						//ram
			 String networkType = rs.getString("networkType");		//网络类型
			 int num = rs.getInt("num");							//购买数量
			 float amount = rs.getFloat("amount");					//总价
			 String createTime = rs.getString("createTime");		//创建时间
			 String orderTime = rs.getString("orderTime");			//付款时间
			 String sendTime = rs.getString("sendTime");			//发货时间
			 String getTime = rs.getString("getTime");				//收货时间
			 String message = rs.getString("message");				//
			 int status = rs.getInt("status");						//状态
			
			//买家信息
			 String province = rs.getString("province");			//省份
			 String city = rs.getString("city");					//城市
			 String detailAddress = rs.getString("detailAddress");	//详细地址
			 String phone = rs.getString("phone");					//买家电话
			 float cost = rs.getFloat("cost");						//单价
			 String name_ = rs.getString("name");					//买家姓名
			 int userId = rs.getInt("userId");						//买家编号
			
			//卖家信息
			 String storeName = rs.getString("storeName");	//店铺名称
			 String location = rs.getString("location");	//店家地址
			
			 //----------------------------------------------------------------
			 order.setStoreId(storeId);
			 order.setOrderId(orderId);
			 order.setImage1(image1);
			 order.setProductName(productName);
			 order.setColor(color);
			 order.setRam(ram);
			 order.setNetworkType(networkType);
			 order.setNum(num);
			 order.setAmount(amount);
			 order.setCreateTime(createTime);
			 order.setOrderTime(orderTime);
			 order.setSendTime(sendTime);
			 order.setGetTime(getTime);
			 order.setMessage(message);
			 order.setStatus(status);
			 order.setProvince(province);
			 order.setCity(city);
			 order.setDetailAddress(detailAddress);
			 order.setPhone(phone);
			 order.setCost(cost);
			 order.setName(name_);
			 order.setUserId(userId);
			 order.setStoreName(storeName);
			 order.setLocation(location);
			
			 //System.out.println("StoreSeeOrderDao------order="+order.toString());
			 
		}
		
		return order;
	}
	
	
}
