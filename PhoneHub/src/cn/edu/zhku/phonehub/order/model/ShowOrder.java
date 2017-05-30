package cn.edu.zhku.phonehub.order.model;

import java.util.ArrayList;

public class ShowOrder {

	ArrayList<OrderProductInfo> productInfo = null;

	//买家信息
	private int userId;				//买家编号
	private String name;			//收件人名字
	private String province;		//省份
	private String city;			//城市
	private String detailAddress;	//详细地址
	private String phone;			//电话
	
	//订单信息
	private int orderId;			//订单编号
	private String orderTime;		//支付时间
	private String createTime;		//创建时间
	private String sendTime;		//发货时间
	private String getTime;			//收货时间
	private String message;			//
	private String status;			//订单状态
	private float amount;			//总价
	private String storeName;		//店铺名称
	




	@Override
	public String toString() {
		return "ShowOrder [productInfo=" + productInfo + ", userId=" + userId
				+ ", name=" + name + ", province=" + province + ", city="
				+ city + ", detailAddress=" + detailAddress + ", phone="
				+ phone + ", orderId=" + orderId + ", orderTime=" + orderTime
				+ ", createTime=" + createTime + ", sendTime=" + sendTime
				+ ", getTime=" + getTime + ", message=" + message + ", status="
				+ status + ", amount=" + amount + ", storeName=" + storeName
				+ "]";
	}


	public String getSendTime() {
		return sendTime;
	}


	public String getGetTime() {
		return getTime;
	}


	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}


	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}


	public int getOrderId() {
		return orderId;
	}
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public ShowOrder() {
		super();
	}
	public ArrayList<OrderProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ArrayList<OrderProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
	
	
}
