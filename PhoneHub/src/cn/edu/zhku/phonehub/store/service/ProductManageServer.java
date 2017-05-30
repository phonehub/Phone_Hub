package cn.edu.zhku.phonehub.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.phonehub.store.dao.ProductDao;
import cn.edu.zhku.phonehub.store.model.Product;

public class ProductManageServer {
	
	ProductDao pd = new ProductDao();
	
	/**
	 * 修改商品库存数
	 * @param product
	 * @return
	 */
	public boolean alterCount(Product product){
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("productId",product.getProductId());
		map.put("num", product.getNum());
		
		if(pd.alterNum(map))
			return true;
		else
			return false;
	}
	
	/**
	 * 下架商品
	 * @param product
	 * @return
	 */
	public boolean dropProduct(Product product){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("productId", product.getProductId());
		if(pd.dropProduct(map))
			return true;
		else
			return false;
	}
	
	/**
	 * 查询店铺所有商品
	 * @param storeId
	 * @return
	 */
	public List getProductList(int storeId){
		Map<String,Integer> map = new HashMap();
		map.put("storeId", storeId);
		List list = pd.getProductList(map);
		return list;
	}
	
	/**
	 * 查看店铺所有商品销量
	 * @param storeId
	 * @return
	 */
	public List getSaleList(int storeId){
		Map<String,Integer> map = new HashMap();
		map.put("storeId", storeId);
		List list = pd.getSaleList(map);
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductManageServer ps = new ProductManageServer();
		List ls = ps.getProductList(1);
		for(int i = 0;i<ls.size();i++){
			HashMap<String,Object> resualtMap = (HashMap<String, Object>) ls.get(i);
			for (Map.Entry<String, Object> entry : resualtMap.entrySet()) {
				if(entry.getValue()==null)
					entry.setValue("");
				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			}
			
		}

	}

}
