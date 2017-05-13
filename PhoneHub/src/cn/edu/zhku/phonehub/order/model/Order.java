package cn.edu.zhku.phonehub.order.model;

import java.sql.Time;

public class Order {

	private int orderId;		//主键（数据库自增）
	private int userId;			//用户Id（参照user_table）
	private float amount;		//订单总金额（需要计算）
	private int status;			//订单状态（如何定义？）
	private Time createTime;	//订单创建时间
	private Time dateTime;		//支付时间
	private String message;		//订单提示信息
	
	
}
