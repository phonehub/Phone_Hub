package cn.edu.zhku.phonehub.order.service;

import cn.edu.zhku.phonehub.order.dao.SendOrderDao;


public class SendOrderService {

	public static boolean sendOrder(int orderId) throws Exception{
		boolean result = false;
		SendOrderDao sendOrderDao = new SendOrderDao();
		result = sendOrderDao.sendOrderFromDb(orderId);
		
		System.out.println("SendOrderService------result="+result);
		return result;
	}
	
}
