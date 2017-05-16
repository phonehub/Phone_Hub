package cn.edu.zhku.phonehub.order.model;

import java.sql.Time;

public class Order {

	private int orderId;		//主键（数据库自增）订单号
	private int userId;			//用户Id（参照user_table）
	private float amount;		//订单总金额（需要计算）
	private Time createTime;	//订单创建时间
	private Time orderTime;		//支付时间
	private String message;		//订单提示信息
	private int status;			//订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", amount="
				+ amount + ", createTime=" + createTime + ", orderTime="
				+ orderTime + ", message=" + message + ", status=" + status
				+ "]";
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Time getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Time createTime) {
		this.createTime = createTime;
	}
	public Time getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
