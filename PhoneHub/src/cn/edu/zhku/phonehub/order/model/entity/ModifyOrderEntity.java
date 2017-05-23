package cn.edu.zhku.phonehub.order.model.entity;

public class ModifyOrderEntity {

	private int orderId ;		//订单编号
	private String province;	//修改地址-省份
	private String city;		//修改地址-城市
	private String detailAddress;//修改地址-详细地址
	private String phone ;		//修改的手机号码
	private String name ;		//修改的名字
	private String amount ;		//修改的总价
	private String message ;	//修改的总价的备注
	
	public ModifyOrderEntity() {
		super();
	}
	
	@Override
	public String toString() {
		return "ModifyOrderEntity [orderId=" + orderId + ", province="
				+ province + ", city=" + city + ", detailAddress="
				+ detailAddress + ", phone=" + phone + ", name=" + name
				+ ", amount=" + amount + ", message=" + message + "]";
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
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public String getPhone() {
		return phone;
	}
	public String getName() {
		return name;
	}
	public String getAmount() {
		return amount;
	}
	public String getMessage() {
		return message;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
