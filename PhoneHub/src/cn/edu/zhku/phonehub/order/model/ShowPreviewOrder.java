package cn.edu.zhku.phonehub.order.model;

public class ShowPreviewOrder {

	private int productId;			//商品ID
	private int userId;				//买家ID 
	private int storeId;			//卖家ID
	
	private String image1;			//商品图片
	private String productName;		//商品名字
	private String color;			//商品颜色
	private String ram;				//ram
	private String networkType;		//网络类型
	private float price;			//单价
	private int	num;				//购买数量
	private String userName;		//买家名字
	private String province;		//地址-省份
	private String city;			//城市
	private String detailAddress;	//详细地址
	private String phone;			//电话
	
	@Override
	public String toString() {
		return "ShowPreviewOrder [productId=" + productId + ", userId="
				+ userId + ", storeId=" + storeId + ", image1=" + image1
				+ ", productName=" + productName + ", color=" + color + ", ram=" + ram
				+ ", networkType=" + networkType + ", price=" + price
				+ ", num=" + num + ", userName=" + userName + ", province="
				+ province + ", city=" + city + ", detailAddress="
				+ detailAddress + ", phone=" + phone + "]";
	}
	public ShowPreviewOrder() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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

	
	
}
