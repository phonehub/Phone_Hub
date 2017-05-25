package cn.edu.zhku.phonehub.order.service;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.dao.ShowShopcartDao;
import cn.edu.zhku.phonehub.order.model.ShopCart;

public class ShowShopcartService {

	public static ArrayList<ShopCart> getShopcart(int userId) throws Exception{
		ArrayList<ShopCart> shopcartList = null;
		
		ShowShopcartDao dao = new ShowShopcartDao();
		shopcartList = dao.getShopcart(userId);
		
		System.out.println("ShowShopcartService-------shopcartList="+shopcartList);
		
		return shopcartList;
	}
	
	
}
