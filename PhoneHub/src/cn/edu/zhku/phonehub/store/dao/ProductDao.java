package cn.edu.zhku.phonehub.store.dao;

import java.util.Map;

import cn.edu.zhku.phonehub.store.util.DBUtil;

public class ProductDao {
	
	DBUtil dbUtil = new DBUtil();
	
	public boolean insertProduct(Map<String,String> map){
		String sql = "insert into product_table(" +
				"productName," +
				"storeId," +
				"price," +
				"cpu," +
				"ram," +
				"brand," +
				"screenSize," +
				"size," +
				"networkType," +
				"color," +
				"system," +
				"battery," +
				"frontCanmera," +
				"behindCamera," +
				"coreNum," +
				"num," +
				"weight," +
				"description," +
				"image1," +
				"image2," +
				"image3)";
		String[] params={
				map.get("productName"),
				map.get("storeId"),
				map.get("price"),
				map.get("cpu"),
				map.get("ram"),
				map.get("brand"),
				map.get("screenSize"),
				map.get("size"),
				map.get("networkType"),
				map.get("color"),
				map.get("system"),
				map.get("memory"),
				map.get("frontCanmera"),
				map.get("behindCamera"),
				map.get("coreNum"),
				map.get("num"),
				map.get("weight"),
				map.get("description"),
				map.get("image1"),
				map.get("image2"),
				map.get("image3"),
				
		};
		int i = dbUtil.update(sql, params);
		if(i==1)
			return true;
		else
			return false;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
