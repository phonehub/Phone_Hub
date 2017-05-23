package cn.edu.zhku.phonehub.order.service;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.dao.ShowPreviewOrderDao;
import cn.edu.zhku.phonehub.order.model.ShowPreviewOrder;
import cn.edu.zhku.phonehub.order.model.entity.ShowPreviewOrderEntity;

public class ShowOrderService {

	public static ArrayList<ShowPreviewOrder>  getPreviewOrderInfo(ShowPreviewOrderEntity showPreviewOrderEntity) throws Exception{
		
		//解封用户名字和已选择的商品Id
		String userName = showPreviewOrderEntity.getUserName();
		String[] selectedProduct = showPreviewOrderEntity.getSelectedProduct();
		
		
		ArrayList<ShowPreviewOrder> showPreviewOrder = null;
		ArrayList<ShowPreviewOrder> getShowPreviewOrder = null;
		ShowPreviewOrderDao showPreviewOrderDao =new ShowPreviewOrderDao();

		//获得购物车中的所有商品
		showPreviewOrder = showPreviewOrderDao.getPreviewOrderFromDb(userName);
		//用selectedProduct获得购物车中已选的商品的信息
		//即删掉showPreviewOrder中未选中的商品

		System.out.println("service----从Dao返回的showPreviewOrder=");
		for(int i=0;i<showPreviewOrder.size();i++)
			System.out.println(showPreviewOrder.get(i).toString());


		for(int i=0;i<showPreviewOrder.size();i++){
			for(int j=0;j<selectedProduct.length;j++){
				if(showPreviewOrder.get(i).getProductId()== Integer.parseInt(selectedProduct[j])){
					if(getShowPreviewOrder==null){
						getShowPreviewOrder = new ArrayList<ShowPreviewOrder>();
					}
					getShowPreviewOrder.add(showPreviewOrder.get(i));
				}
			}
		}

		System.out.println("service----处理过后的getShowPreviewOrder=");
		for(int i=0;i<getShowPreviewOrder.size();i++)
			System.out.println(getShowPreviewOrder.get(i).toString());

		
		return getShowPreviewOrder;
	}
	
}
