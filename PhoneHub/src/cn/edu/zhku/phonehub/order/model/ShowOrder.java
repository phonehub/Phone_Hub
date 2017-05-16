package cn.edu.zhku.phonehub.order.model;

import java.util.ArrayList;

public class ShowOrder {

	ArrayList<OrderProductInfo> productInfo = null;
	
	//买家地址信息
	private String province;		//省份
	private String city;			//城市
	private String detailAddress;	//详细地址
	private String phone;			//电话
	
	//订单信息
	private String orderTime;		//下单时间
	private String createTime;		//创建时间
	private String message;			//
	private String status;			//订单状态
	private float amount;			//总价
	private String storeName;		//店铺名称
	
	
	@Override
	public String toString() {
		return "ShowOrder [productInfo=" + productInfo + ", province="
				+ province + ", city=" + city + ", detailAddress="
				+ detailAddress + ", phone=" + phone + ", orderTime="
				+ orderTime + ", createTime=" + createTime + ", message="
				+ message + ", status=" + status + ", amount=" + amount
				+ ", storeName=" + storeName + "]";
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
