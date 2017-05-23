package cn.edu.zhku.phonehub.order.model.entity;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.Order;
import cn.edu.zhku.phonehub.order.model.OrderItem;

public class OrderOrderItemEntity {

	//用于参数传递
	private Order order ;
	private ArrayList<OrderItem> orderItemList;
	
	
	@Override
	public String toString() {
		return "OrderOrderItemEntity [order=" + order + ", orderItemList="
				+ orderItemList + "]";
	}
	public OrderOrderItemEntity() {
		super();
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	
	
	
}
