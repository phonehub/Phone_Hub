package cn.edu.zhku.phonehub.order.model;

public class OrderItem {

	private int orderId;		//订单编号
	private int productId;		//商品编号
	private int num;			//购买数量
	private float cost;			//单价
	
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", productId=" + productId
				+ ", num=" + num + ", cost=" + cost + "]";
	}
	public OrderItem() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	
	
}
