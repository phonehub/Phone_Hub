package cn.edu.zhku.phonehub.order.model.entity;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.model.Order;
import cn.edu.zhku.phonehub.order.model.OrderItem;

public class OrderOrderItemEntity {

	//用于参数传递
	private Order order ;
	private ArrayList<OrderItem> orderItemList;
	private String name;			//收件人名字
	private String province;		//省份
	private String city;			//城市
	private String detailAddress;	//详细地址
	private String phone;			//电话
	
	
	@Override
	public String toString() {
		return "OrderOrderItemEntity [order=" + order + ", orderItemList="
				+ orderItemList + ", name=" + name + ", province=" + province
				+ ", city=" + city + ", detailAddress=" + detailAddress
				+ ", phone=" + phone + "]";
	}
	public String getName() {
		return name;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
