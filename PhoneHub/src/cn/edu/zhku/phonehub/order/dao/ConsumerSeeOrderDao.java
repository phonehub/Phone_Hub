package cn.edu.zhku.phonehub.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.OrderProductInfo;
import cn.edu.zhku.phonehub.order.model.PageBean;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ConsumerSeeOrderDao {

	public ArrayList<StoreSeeOrder> getOrderFromDb(int userId,PageBean pageBean) throws Exception{
		ArrayList<StoreSeeOrder> storeSeeOrderList = null;
		int curPage = pageBean.getCurPage();	//获得当前显示的页数
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		//先获得总行数
		String sqlQuery = null;
		sqlQuery = "select count(*)from store_see_order where userId=?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, userId);
		rs = ps.executeQuery();
		rs.next();
		pageBean.setTotalRows(rs.getInt(1));		//总行数
		
		
		//获得
		sqlQuery = "Select * from store_see_order where userId=? ORDER BY createTime DESC LIMIT ?,?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, userId);
		ps.setInt(2, (pageBean.getCurPage()-1)*pageBean.getPageSize());		
		ps.setInt(3, pageBean.getPageSize());
		rs = ps.executeQuery();
		
		System.out.println("consumerSeeOrderDao  ==rs.next()");
		System.out.println("consumerSeeOrderDao  ==ps"+ps.toString());
		
		while(rs.next()){
			int storeId = rs.getInt("storeId");					 	//店铺编号
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
			 int userId_ = rs.getInt("userId");						//买家编号
			
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
			 order.setUserId(userId_);
			 order.setStoreName(storeName);
			 order.setLocation(location);
			
			 System.out.println("ConsumerSeeOrderDao------order="+order.toString());
			 
			 if(storeSeeOrderList==null){
				 storeSeeOrderList = new ArrayList<StoreSeeOrder>();
			 }
			 storeSeeOrderList.add(order);
		}
		System.out.println("consumerSeeOrderDao-------storeSeeOrderList="+storeSeeOrderList.toString());
		
		return storeSeeOrderList;
	}
	
}
