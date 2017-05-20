package cn.edu.zhku.phonehub.order.service;

import cn.edu.zhku.phonehub.order.dao.GetProductDao;

public class GetProductService {

	public static boolean getProductResult(int orderId) throws Exception{
		
		boolean result = false;
		
		GetProductDao getProductDao = new GetProductDao();
		result = getProductDao.getProductResultFromDb(orderId);
		
		
		return result;
	}
	
}
