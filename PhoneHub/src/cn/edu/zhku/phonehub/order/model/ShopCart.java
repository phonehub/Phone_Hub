package cn.edu.zhku.phonehub.order.model;

import java.io.Serializable;

public class ShopCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;				//用户的id
	private int productId;			//商品的id
	private int storeId;			//店铺的id
	private int num;				//购买数量
	private	String productName;		//商品名称
	private float price;			//商品价格
	private String image;			//商品图片
	private String color;			//商品颜色
	
	
	@Override
	public String toString() {
		return "ShopCartDao [userId=" + userId + ", productId=" + productId
				+ ", storeId=" + storeId + ", num=" + num + ", productName="
				+ productName + ", price=" + price + ", image=" + image
				+ ", color=" + color + "]";
	}
	public ShopCart() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	
}
