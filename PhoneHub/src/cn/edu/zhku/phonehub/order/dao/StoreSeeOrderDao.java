package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

/*
 * 类名：StoreSeeOrderDao
 * 功能：店铺查看所有订单信息（每一个方法对应一个select）
 * 输入：	方式：select =  1(订单编号递增)、2(订单编号递减)、3(付款时间最新)、
 * 					  4(状态为1)、5(状态为2)、6(状态为3)、7(状态为4)
 * 					  8(+orserId)、9(+orderTime)、10(+userId)   
 * 		
 * 		备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
 * 输出：	订单信息
 * 作者：feven
 */
public class StoreSeeOrderDao {
	
	private ArrayList<StoreSeeOrder> storeSeeOrderList;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sqlQuery;
	
	public StoreSeeOrderDao() throws Exception{
		storeSeeOrderList = null;
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
	
	
	//1(订单编号升序)
	public ArrayList<StoreSeeOrder> orderIdIncrease() throws Exception{
		sqlQuery = "select * from store_see_order ORDER BY orderId";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//2(订单编号降序)
	public ArrayList<StoreSeeOrder> orderIdReduce() throws Exception{
		sqlQuery = "select * from store_see_order ORDER BY orderId DESC";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//3(付款时间降序)
	public ArrayList<StoreSeeOrder> orderTimeNewest() throws Exception{
		sqlQuery = "select * from store_see_order where status!=1 ORDER BY orderTime DESC";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//4(状态为1未付款、创建时间降序)
	public ArrayList<StoreSeeOrder> statusOne() throws Exception{
		sqlQuery = "select * from store_see_order WHERE `status`=1 ORDER BY createTime DESC ";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//5(状态为2已付款、付款时间升序)
	public ArrayList<StoreSeeOrder> statusTwo() throws Exception{
		sqlQuery = "select * from store_see_order WHERE `status`=2 ORDER BY orderTime";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//6(状态为3已发货、发货时间降序)
	public ArrayList<StoreSeeOrder> statusThree() throws Exception{
		sqlQuery = "select * from store_see_order WHERE `status`=3 ORDER BY sendTime DESC";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//7(状态为4已收货、收货时间降序)
	public ArrayList<StoreSeeOrder> statusFour() throws Exception{
		sqlQuery = "select * from store_see_order WHERE `status`=4 ORDER BY getTime DESC";
		this.exectueSql();
		return storeSeeOrderList;
	}
	//8(+orderId)
	public ArrayList<StoreSeeOrder> searchByorderId(int orderId) throws Exception{
		sqlQuery = "select * from store_see_order WHERE orderId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, orderId);
		this.exectueSql();
		return storeSeeOrderList;
	}
	//9(+orderTime)
	public ArrayList<StoreSeeOrder> searchByorderTime(String orderTime) throws Exception{
		sqlQuery = "select * from store_see_order WHERE orderTime LIKE ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, "%"+orderTime+"%");
		this.exectueSql();
		return storeSeeOrderList;
	}
	//10(+userId、创建时间降序)
	public ArrayList<StoreSeeOrder> searchByUserId(int userId) throws Exception{
		sqlQuery = "select * from store_see_order WHERE userId = ? ORDER BY createTime DESC";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, userId);
		this.exectueSql();
		return storeSeeOrderList;
	}
	
	private void exectueSql() throws Exception{
		if(ps==null)
			ps = conn.prepareStatement(sqlQuery);
		rs = ps.executeQuery();
		while(rs.next()){
			
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
			 String name = rs.getString("name");					//买家姓名
			 int userId = rs.getInt("userId");						//买家编号
			
			//卖家信息
			 String storeName = rs.getString("storeName");	//店铺名称
			 String location = rs.getString("location");	//店家地址
			
			 //----------------------------------------------------------------
			 StoreSeeOrder order = new StoreSeeOrder();
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
			 order.setName(name);
			 order.setUserId(userId);
			 order.setStoreName(storeName);
			 order.setLocation(location);
			
			 System.out.println("StoreSeeOrderDao------order="+order.toString());
			 
			 if(storeSeeOrderList==null){
				 storeSeeOrderList = new ArrayList<StoreSeeOrder>();
			 }
			 this.storeSeeOrderList.add(order);
		}
		
	}
	
}
