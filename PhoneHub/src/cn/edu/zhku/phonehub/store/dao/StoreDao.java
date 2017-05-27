package cn.edu.zhku.phonehub.store.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.phonehub.store.util.DBUtil;

public class StoreDao {
	
	
	DBUtil dbUtil = new DBUtil();
	
	/**
	 * 功能：新建店铺
	 * 作者：yanghang
	 * @param map
	 * @return
	 */
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
	 * 获取所有店铺列表
	 * @return
	 */
	public List getStoreList(){
		String sql = "select * from store_table";
		String[] params = {};
		List ls = dbUtil.getList(sql, params);
		return ls;
	}
	
	/**
	 * 通过店铺申请
	 * @param map
	 * @return
	 */
	public boolean passApply(Map map){
		String sql = "update store_table set status = 0 where storeId = ?";
		Object[] params = {
				map.get("storeId")
		};
		boolean resualt = false;
		if(dbUtil.update(sql, params)==1){
			resualt = true;
			return resualt;
		}
		return resualt;
			
	}
	
	/**
	 * 查看店铺登记详情
	 * @param map
	 * @return
	 */
	public Map getApplyDetail(Map map){
		String sql = "select * from store_table where storeId = ?";
		Object[] params = {
				map.get("storeId")
		};
		Map resualtMap = dbUtil.getMap(sql, params);
		return resualtMap;
	}
	
	/**
	 * 拒接开店申请
	 * @param map
	 * @return
	 */
	public boolean refuseApply(Map map){
		String sql = "update store_table set status = 3 where storeId = ?";
		Object[] params = {
			map.get("storeId")	
		};
		boolean resualt = false;
		if(dbUtil.update(sql, params)==1){
			resualt = true;
			return resualt;
		}
		return resualt;
	}
	
	/**
	 * 禁止店铺销售
	 * @param map
	 * @return
	 */
	public boolean forbidSale(Map map){
		String sql = "update store_table set status = 4 where storeId = ?";
		Object[] params ={
				map.get("storeId")
		};
		boolean resualt = false;
		if(dbUtil.update(sql, params)==1){
			resualt = true;
			return resualt;
		}
		return resualt;
	}
	
	/**
	 * 暂停营业
	 * @param map
	 * @return
	 */
	public boolean suspendSale(Map map){
		String sql = "update store_table set status = 5 where storeId = ?";
		Object[] params = {
				map.get("storeId")
		};
		boolean resualt = false;
		if(dbUtil.update(sql, params)==1){
			resualt = true;
			return resualt;
		}
		return resualt;
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
		
//		StoreDao sd = new StoreDao();
//		Map<String,Object> map = new HashMap<String,Object>();
		
//		测试获取店铺列表
//		List ls = sd.getStoreList();
//		for(int i = 0;i<ls.size();i++){
//			HashMap<String,Object> resualtMap = (HashMap<String, Object>) ls.get(i);
//			for (Map.Entry<String, Object> entry : resualtMap.entrySet()) {
//				if(entry.getValue()==null)
//					entry.setValue("");
//				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//			}
//			
//		}
		
//		测试店铺审核通过
//		map.put("storeId", 3);
//		if(sd.passApply(map))
//			System.out.print(true);
//		System.out.print(false);
		
//	}

}
