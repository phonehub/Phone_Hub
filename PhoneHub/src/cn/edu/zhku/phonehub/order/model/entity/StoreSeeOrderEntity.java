package cn.edu.zhku.phonehub.order.model.entity;

public class StoreSeeOrderEntity {

	//用于封装参数
	
	private int select;		
	private int orderId;
	private int userId;
	private String orderTime;
	
	
	@Override
	public String toString() {
		return "StoreSeeOrderEntity [select=" + select + ", orderId=" + orderId
				+ ", userId=" + userId + ", orderTime=" + orderTime + "]";
	}
	public StoreSeeOrderEntity() {
		super();
	}
	public int getSelect() {
		return select;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getUserId() {
		return userId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	
	
	
}
