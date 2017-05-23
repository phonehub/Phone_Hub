package cn.edu.zhku.phonehub.order.service;

import java.sql.Time;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.dao.CommitOrderDao;
import cn.edu.zhku.phonehub.order.model.Order;
import cn.edu.zhku.phonehub.order.model.OrderItem;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.model.ShowPreviewOrder;
import cn.edu.zhku.phonehub.order.model.entity.OrderOrderItemEntity;

public class CommitOrderService {

	//获得确认后的订单信息
	public static ShowOrder getCommitOrder(ArrayList<ShowPreviewOrder> previewOrder) throws Exception{
		
		ShowOrder showOrder = null;
		
		
		//封装插入数据库的数据
		//对于order_item_table
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		
		float amount = 0;		//总价
		for(int i=0;i<previewOrder.size();i++){
			OrderItem item = new OrderItem();
			
			int orderId = 0;										//订单编号
			int productId = previewOrder.get(i).getProductId();		//商品编号
			int num = previewOrder.get(i).getNum();					//购买数量
			float cost = previewOrder.get(i).getPrice();			//单价
			
			amount+=cost;		//增加金额
			
			item.setOrderId(orderId);
			item.setProductId(productId);
			item.setNum(num);
			item.setCost(cost);
			
			orderItemList.add(item);
		}
		//对于order_table
		Order order = new Order();
		//订单总金额是上面的amount
		//订单号由数据库自动生成
		int userId = previewOrder.get(0).getUserId();
		//订单创建时间由数据库自动生成
		//支付时间为0
		//订单提示信息为null
		//订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
		int status = 1;
		
		order.setAmount(amount);
		order.setUserId(userId);
		order.setStatus(status);
		
		
		//封装参数
		OrderOrderItemEntity entity = new OrderOrderItemEntity();
		entity.setOrder(order);
		entity.setOrderItemList(orderItemList);
		
		CommitOrderDao commitOrderDao = new CommitOrderDao();
		showOrder = commitOrderDao.getCommitOrderFromDb(entity);
		
		return showOrder;
	}
	
}
