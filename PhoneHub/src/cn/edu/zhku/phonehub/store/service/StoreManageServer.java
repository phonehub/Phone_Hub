package cn.edu.zhku.phonehub.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.phonehub.store.dao.StoreDao;
import cn.edu.zhku.phonehub.store.model.Store;

public class StoreManageServer {

	StoreDao sd = new StoreDao();
	
	/**
	 * 获取所有店铺列表
	 * @param store
	 * @return
	 */
	public List getStoreList(){
		List ls = sd.getStoreList();
		return ls;
	}
	
	/**
	 * 获取店铺申请详细信息
	 * @param store
	 * @return
	 */
	public Map getApplyDetail(Store store){
		Map map = new HashMap();
		map.put("userId", store.getUserId());
		return sd.getApplyDetail(map);
	}
	
	/**
	 * 通过审核
	 * @param store
	 * @return
	 */
	public boolean passApply(Store store){
		boolean resualt = false;
		Map map = new HashMap();
		map.put("storeId", store.getStoreId());
		resualt = sd.passApply(map);
		return resualt;
	}
	
	/**
	 * 审核不通过
	 * @param store
	 * @return
	 */
	public boolean refuseApply(Store store){
		boolean resualt = false;
		Map map = new HashMap();
		map.put("storeId", store.getStoreId());
		resualt = sd.refuseApply(map);
		return resualt;
	}
	
	/**
	 * 禁止店铺销售
	 * @param store
	 * @return
	 */
	public boolean forbidSale(Store store){
		boolean resualt = false;
		Map map = new HashMap();
		map.put("storeId", store.getStoreId());
		resualt = sd.forbidSale(map);
		return resualt;
	}
	
	/**
	 * 暂停营业
	 * @param store
	 * @return
	 */
	public boolean suspendSale(Store store){
		boolean resualt = false;
		Map map = new HashMap();
		map.put("storeId", store.getStoreId());
		resualt = sd.suspendSale(map);
		return resualt;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StoreManageServer sm = new StoreManageServer();
		Store store = new Store();
		store.setStoreId(4);
		if(sm.passApply(store)){
			System.out.println("----"+true);
		}
		else{
			System.out.println("----"+false);
		}
	}

}
