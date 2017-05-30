package cn.edu.zhku.phonehub.order.service;


import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.dao.ConsumerSeeOrderDao;
import cn.edu.zhku.phonehub.order.model.PageBean;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;

public class ConsumerSeeOrderService {

	public static ArrayList<StoreSeeOrder>  getFinalOrder(int userId, PageBean pageBean) throws Exception{
		ArrayList<StoreSeeOrder> storeSeeOrderList =null;
		
		ConsumerSeeOrderDao dao = new ConsumerSeeOrderDao();
		storeSeeOrderList = dao.getOrderFromDb(userId,pageBean);
		
		System.out.println("consumerSeeOrderList = "+storeSeeOrderList.toString());
		return storeSeeOrderList;
	}
	
	
}
