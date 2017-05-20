package cn.edu.zhku.phonehub.order.service;

import java.util.ArrayList;

import cn.edu.zhku.phonehub.order.dao.StoreSeeOrderDao;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrderEntity;

public class StoreSeeOrderService {

	public static ArrayList<StoreSeeOrder> getStoreSeeOrder(StoreSeeOrderEntity entity) throws Exception{
		ArrayList<StoreSeeOrder> storeSeeOrderList =  null;
		StoreSeeOrderDao dao = new StoreSeeOrderDao();
		
		//解封
		int select = entity.getSelect();
		int orderId = entity.getOrderId();
		int userId = entity.getUserId();
		String orderTime = entity.getOrderTime();
		
		//1(订单编号递增)
		if(select == 1){
			storeSeeOrderList = dao.orderIdIncrease();
		}
		//2(订单编号递减) 
		else if(select == 2){
			storeSeeOrderList = dao.orderIdReduce();
		}
		//3(付款时间最新)
		else if(select == 3){
			storeSeeOrderList = dao.orderTimeNewest();
		}
		//4(状态为1)
		else if(select == 4){
			storeSeeOrderList = dao.statusOne();
		}
		//5(状态为2)
		else if(select == 5){
			storeSeeOrderList = dao.statusTwo();
		}
		//6(状态为3)
		else if(select == 6){
			storeSeeOrderList = dao.statusThree();
		}
		//7(状态为4)
		else if(select == 7){
			storeSeeOrderList = dao.statusFour();
		}
		//8(+orserId)
		else if(select == 8){
			storeSeeOrderList = dao.searchByorderId(orderId);
		}
		//9(+orderTime)
		else if(select == 9){
			storeSeeOrderList = dao.searchByorderTime(orderTime);
		}
		//10(+userId)
		else if(select == 10){
			storeSeeOrderList = dao.searchByUserId(userId);
		}
		else{
			return null;
		}
		
		return storeSeeOrderList;
	}
	
	
}
