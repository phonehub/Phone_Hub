package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.Order;
import cn.edu.zhku.phonehub.order.model.OrderItem;
import cn.edu.zhku.phonehub.order.model.OrderProductInfo;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.model.entity.OrderOrderItemEntity;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class CommitOrderDao {

	public ShowOrder getCommitOrderFromDb(OrderOrderItemEntity entity) throws Exception{
		
		ShowOrder showOrder = null;
		
		//解封
		Order order = entity.getOrder();
		ArrayList<OrderItem> orderItemList = entity.getOrderItemList();
		
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		//插入Order_table
		String sqlQuery = null;
		sqlQuery = "Insert into order_table(userId,amount,message,status) values(?,?,?,?)";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, order.getUserId());
		ps.setFloat(2, order.getAmount());
		ps.setString(3, order.getMessage());
		ps.setInt(4, order.getStatus());
		ps.executeUpdate();
		
		//获得orderId
		sqlQuery = "SELECT MAX(orderId) FROM order_table";
		ps = conn.prepareStatement(sqlQuery);
		rs = ps.executeQuery();
		rs.next();
		int orderId = rs.getInt(1);
		System.out.println("rs--------"+rs.getInt(1));
		
		
		//插入order_item_table  并且减少product_table的数量
		String reduceNumSqlQuery = "Update product_table set num=num-? where productId = ?";
		sqlQuery ="Insert into order_item_table(orderId,productId,num,cost) values(?,?,?,?)";
		for(int i=0;i<orderItemList.size();i++){
			
			ps = conn.prepareStatement(sqlQuery);
			OrderItem orderItem = orderItemList.get(i);		//获得item
			orderItem.toString();							//测试输出
			ps.setInt(1, orderId);
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getNum());
			ps.setFloat(4, orderItem.getCost());
			ps.executeUpdate();
			
			ps = conn.prepareStatement(reduceNumSqlQuery);
			ps.setInt(1, orderItem.getNum());
			ps.setInt(2, orderItem.getProductId());
			ps.executeUpdate();
		}
		
		//删除shopcart_table中对应商品
		for(int i=0;i<orderItemList.size();i++){
			sqlQuery ="Delete from shopcart_table where userId = ? and productId =?";
			ps = conn.prepareStatement(sqlQuery);
			
			OrderItem orderItem = orderItemList.get(i);
			
			orderItem.toString();
			
			ps.setInt(1, order.getUserId());
			ps.setInt(2, orderItem.getProductId());
			
			ps.executeUpdate();
		}
		
		//获得订单信息
		sqlQuery = "SELECT * from show_order where orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, orderId);
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
				 int userId = rs.getInt("userId");							//用户编号
				 String name = rs.getString("name");						//收件人姓名
				 String province = rs.getString("province");				//省份
				 String city = rs.getString("city");						//城市
				 String detailAddress = rs.getString("detailAddress");		//详细地址
				 String phone = rs.getString("phone");						//电话

				 //订单信息
				 int orderId_ = rs.getInt("orderId");						//订单编号
				 String orderTime = rs.getString("orderTime");				//下单时间
				 String createTime = rs.getString("createTime");			//创建时间
				 String message = rs.getString("message");					//
				 int status = rs.getInt("status");							//订单状态
				 float amount = rs.getFloat("amount");						//总价
				 String storeName = rs.getString("storeName");				//店铺名称
			
				 showOrder.setUserId(userId);
				 showOrder.setName(name);
				 showOrder.setProvince(province);
				 showOrder.setCity(city);
				 showOrder.setDetailAddress(detailAddress);
				 showOrder.setPhone(phone);
				 showOrder.setOrderId(orderId_);
				 showOrder.setOrderTime(orderTime);
				 showOrder.setCreateTime(createTime);
				 showOrder.setMessage(message);
				 showOrder.setStatus(String.valueOf(status));
				 showOrder.setAmount(amount);
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
