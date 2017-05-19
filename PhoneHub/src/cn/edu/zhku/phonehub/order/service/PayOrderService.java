package cn.edu.zhku.phonehub.order.service;

import cn.edu.zhku.phonehub.order.dao.PayOrderDao;
import cn.edu.zhku.phonehub.order.model.ShowOrder;

public class PayOrderService {

	public static ShowOrder getFinalOrder(int orderId,int userId,String userPassword) throws Exception{
		ShowOrder order = null;
		
		PayOrderDao payOrderDao = new PayOrderDao();
		order = payOrderDao.getPayOrderResultFromDb(orderId, userId, userPassword);
		
		return order;
	}
	
}
