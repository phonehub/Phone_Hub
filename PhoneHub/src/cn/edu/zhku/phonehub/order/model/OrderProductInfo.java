package cn.edu.zhku.phonehub.order.model;

public class OrderProductInfo {

	//订单商品条目信息
	private String image1;			//商品图片
	private String productName; 	//商品名称
	private String color;			//商品颜色
	private String ram;				//内存
	private String networkType;		//网络类型
	private float cost;				//单价
	private int num;				//购买数量
	
	@Override
	public String toString() {
		return "OrderProductInfo [image1=" + image1 + ", productName="
				+ productName + ", color=" + color + ", ram=" + ram
				+ ", networkType=" + networkType + ", cost=" + cost + ", num="
				+ num + "]";
	}
	public OrderProductInfo() {
		super();
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
}
