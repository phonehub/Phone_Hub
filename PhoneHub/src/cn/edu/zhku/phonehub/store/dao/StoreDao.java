package cn.edu.zhku.phonehub.store.dao;

import java.util.HashMap;
import java.util.Map;

import cn.edu.zhku.phonehub.store.util.DBUtil;

public class StoreDao {
	
	
	DBUtil dbUtil = new DBUtil();
	
	//对store_table进行插入操作，即创建店铺
	public boolean insertStore(Map<String,String> map){
		String sql = "insert into store_table(" +
				"userId," +
				"storeName," +
				"location," +
				"businessBrand," +
				"holderName," +
				"idCardNumber," +
				"idCard)" +
				"value(?,?,?,?,?,?,?)";
		String[] params={
				map.get("userId"),
				map.get("storeName"),
				map.get("location"),
				map.get("businessBrand"),
				map.get("holderName"),
				map.get("idCardNumber"),
				map.get("idCard"),
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
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("userId", "2");
//		map.put("storeName", "phoneHub");
//		map.put("location", "广州海珠");
//		map.put("businessBrand", "华为");
//		map.put("holderName", "小明");
//		map.put("idCardNumber", "787842555");
//		map.put("idCard", "gsuewehg");
//		StoreDao sd = new StoreDao();
//		System.out.println(sd.insertStore(map));
//	}

}
