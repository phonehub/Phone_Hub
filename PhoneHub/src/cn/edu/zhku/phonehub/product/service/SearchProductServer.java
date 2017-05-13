package cn.edu.zhku.phonehub.product.service;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.product.dao.SearchProductDao;
import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.model.SearchProductEntity;
import cn.edu.zhku.phonehub.product.model.SearchProductInfo;

/*
 * 类名：SearchProductServer
 * 功能：判断商品查询输入的查询类型，
 * 输入：searchProductEntity
 * 输出：商品信息ArrayList，若为null则表示数据库中没有匹配的商品信息
 * 作者：feven
 */

public class SearchProductServer {

	public static ArrayList<SearchProductInfo> getProductList(SearchProductEntity searchProductEntity) throws Exception{
		//商品ArrayList
		ArrayList<SearchProductInfo> productList = null;
		
		SearchProductDao searchProductDao = new SearchProductDao();
		productList = searchProductDao.getProductFromDb(searchProductEntity);
		
		return productList;
	}
	 
}
