package cn.edu.zhku.phonehub.product.model;

public class SearchProductInfo {
	
	private int productId;			//商品ID（用于查找详细商品信息）
	private int storeId;			//店铺ID（用于查找详细商品信息）
	private String productName;		//商品名称
	private float price;			//商品价格
	private String storeName;		//店铺名称
	private String brand;			//手机品牌
	private String location;		//店铺地址
	private String storeScore;		//店铺评分
	private String userName;		//店铺老板名称
	private String image1;			//图片1
	
	
	
	@Override
	public String toString() {
		return "SearchProductInfo [productName=" + productName + ", price="
				+ price + ", storeName=" + storeName + ", brand=" + brand
				+ ", location=" + location + ", storeScore=" + storeScore
				+ ", userName=" + userName + ", image1=" + image1 + "]";
	}
	public SearchProductInfo() {
		super();
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStoreScore() {
		return storeScore;
	}
	public void setStoreScore(String storeScore) {
		this.storeScore = storeScore;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	
	
	
	
}
