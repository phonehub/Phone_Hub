package cn.edu.zhku.phonehub.order.model;


/*
 * 类名：StoreSeeAllOrder
 * 功能：封装店铺查看的订单实体
 * 输入：
 * 输出：
 * 作者：feven
 */
public class StoreSeeOrder {

	private int storeId;		//店铺编号
	private int orderId;		//订单编号
	private String image1;		//商品图片地址
	private String productName;	//商品名称
	private String color;		//颜色
	private String ram;			//ram
	private String networkType;	//网络类型
	private int num;			//购买数量
	private float amount;		//总价
	private String createTime;	//创建时间
	private String orderTime;	//付款时间
	private String sendTime;	//发货时间
	private String getTime;		//收货时间
	private String message;		//
	private int status;			//状态
	
	//买家信息
	private String province;	//省份
	private String city;		//城市
	private String detailAddress;//详细地址
	private String phone;		//买家电话
	private float cost;			//单价
	private String name;		//买家姓名
	private int userId;			//买家编号
	
	//卖家信息
	private String storeName;	//店铺名称
	private String location;	//店家地址
	
	
	


	@Override
	public String toString() {
		return "StoreSeeOrder [storeId=" + storeId + ", orderId=" + orderId
				+ ", image1=" + image1 + ", productName=" + productName
				+ ", color=" + color + ", ram=" + ram + ", networkType="
				+ networkType + ", num=" + num + ", amount=" + amount
				+ ", createTime=" + createTime + ", orderTime=" + orderTime
				+ ", sendTime=" + sendTime + ", getTime=" + getTime
				+ ", message=" + message + ", status=" + status + ", province="
				+ province + ", city=" + city + ", detailAddress="
				+ detailAddress + ", phone=" + phone + ", cost=" + cost
				+ ", name=" + name + ", userId=" + userId + ", storeName="
				+ storeName + ", location=" + location + "]";
	}


	public StoreSeeOrder() {
		super();
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


	public int getStoreId() {
		return storeId;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getImage1() {
		return image1;
	}
	public String getProductName() {
		return productName;
	}
	public String getColor() {
		return color;
	}
	public String getRam() {
		return ram;
	}
	public String getNetworkType() {
		return networkType;
	}
	public int getNum() {
		return num;
	}
	public float getAmount() {
		return amount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
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
	public float getCost() {
		return cost;
	}
	public String getName() {
		return name;
	}
	public int getUserId() {
		return userId;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getLocation() {
		return location;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	
}
