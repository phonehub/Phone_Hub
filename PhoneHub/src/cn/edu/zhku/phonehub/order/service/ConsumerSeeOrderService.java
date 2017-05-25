package cn.edu.zhku.phonehub.order.service;


import cn.edu.zhku.phonehub.order.dao.ConsumerSeeOrderDao;
import cn.edu.zhku.phonehub.order.model.ShowOrder;

public class ConsumerSeeOrderService {

	public static ShowOrder getFinalOrder(int userId) throws Exception{
		ShowOrder showOrder =null;
		
		ConsumerSeeOrderDao dao = new ConsumerSeeOrderDao();
		showOrder = dao.getOrderFromDb(userId);
		
		return showOrder;
	}
	
	
}
