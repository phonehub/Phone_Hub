package cn.edu.zhku.phonehub.product.service;

import cn.edu.zhku.phonehub.product.dao.ShowProductDetailDao;
import cn.edu.zhku.phonehub.product.model.Product;

/*
 * 类名：
 * 功能：
 * 输入：
 * 输出：
 * 作者：feven
 */
public class ShowProductDetailServer {

	public static Product getProductDetail(int productId) throws Exception{
		Product product = null;
		ShowProductDetailDao spdd = new ShowProductDetailDao();
		product = spdd.getProductDetailFromDb(productId);
		System.out.println("server-----product="+product.toString());
		return product;
	}
	
}
