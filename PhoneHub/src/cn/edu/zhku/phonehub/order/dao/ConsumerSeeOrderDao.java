package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.OrderProductInfo;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ConsumerSeeOrderDao {

	public ShowOrder getOrderFromDb(int userId) throws Exception{
		ShowOrder showOrder = null;
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		String sqlQuery = null;
		sqlQuery = "Select * from show_order where userId=? ORDER BY createTime DESC";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		
		ArrayList<OrderProductInfo> productInfo = null;
		while(rs.next()){
			if(showOrder==null){
				showOrder = new ShowOrder();
				
				if(productInfo == null){
					productInfo = new ArrayList<OrderProductInfo>();
				}
				
				showOrder.setProductInfo(productInfo);
				//买家信息
				 int userId__ = rs.getInt("userId");						//用户编号
				 String name = rs.getString("name");						//收件人姓名
				 String province = rs.getString("province");				//省份
				 String city = rs.getString("city");						//城市
				 String detailAddress = rs.getString("detailAddress");		//详细地址
				 String phone = rs.getString("phone");						//电话

				 //订单信息
				 int orderId_ = rs.getInt("orderId");						//订单编号
				 String orderTime = rs.getString("orderTime");				//下单时间
				 String createTime = rs.getString("createTime");			//创建时间
				 String sendTime = rs.getString("sendTime"); 				//发货时间  //
				 String getTime = rs.getString("getTime");					//收货时间  //
				 String message = rs.getString("message");					//
				 int status = rs.getInt("status");							//订单状态
				 float amount_ = rs.getFloat("amount");						//总价
				 String storeName = rs.getString("storeName");				//店铺名称
			
				 showOrder.setUserId(userId__);
				 showOrder.setName(name);
				 showOrder.setProvince(province);
				 showOrder.setCity(city);
				 showOrder.setDetailAddress(detailAddress);
				 showOrder.setPhone(phone);
				 showOrder.setOrderId(orderId_);
				 showOrder.setOrderTime(orderTime);
				 showOrder.setCreateTime(createTime);
				 showOrder.setSendTime(sendTime);
				 showOrder.setGetTime(getTime);
				 showOrder.setMessage(message);
				 showOrder.setStatus(String.valueOf(status));
				 showOrder.setAmount(amount_);
				 showOrder.setStoreName(storeName);
			}
			OrderProductInfo orderProductInfo = new OrderProductInfo();
			
			//订单商品条目信息
			 String image1 = rs.getString("image1");			//商品图片
			 String productName = rs.getString("productName"); 	//商品名称
			 String color = rs.getString("color");				//商品颜色
			 String ram = rs.getString("ram");					//内存
			 String networkType = rs.getString("networkType");	//网络类型
			 float cost = rs.getFloat("cost");					//单价
			 int num = rs.getInt("num");						//购买数量
			
			 orderProductInfo.setColor(color);
			 orderProductInfo.setCost(cost);
			 orderProductInfo.setImage1(image1);
			 orderProductInfo.setNetworkType(networkType);
			 orderProductInfo.setNum(num);
			 orderProductInfo.setProductName(productName);
			 orderProductInfo.setRam(ram);
			 
			 productInfo.add(orderProductInfo);
		}
		
		return showOrder;
	}
	
}
