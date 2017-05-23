package cn.edu.zhku.phonehub.order.service;

import cn.edu.zhku.phonehub.order.dao.ModifyOrderDao;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.order.model.entity.ModifyOrderEntity;

public class ModifyOrderService {

	public static StoreSeeOrder getModifyResult(ModifyOrderEntity entity) throws Exception{
		
		boolean result = false;
		StoreSeeOrder order = null;
		ModifyOrderDao dao = new ModifyOrderDao();
		
		 int orderId = entity.getOrderId();						//订单编号
		 String province = entity.getProvince();				//修改地址-省份
		 String city = entity.getCity();						//修改地址-城市
		 String detailAddress = entity.getDetailAddress();		//修改地址-详细地址
		 String phone = entity.getPhone();						//修改的手机号码
		 String name = entity.getName();						//修改的名字
		 String amount = entity.getAmount();					//修改的总价
		 String message = entity.getMessage();					//修改的总价的备注
		
		//判断orderId是否存在
		if(dao.testOrderId(orderId)==false)
			return null;
		
		//修改province
		if(province!=null){
			result = dao.modifyProvince(orderId, province);
			System.out.println("修改province="+result);
		}
		//修改city
		if(city!=null){
			dao.modifyCity(orderId, city);
			System.out.println("修改city="+result);
		}
		//修改detailAddress
		if(detailAddress!=null){
			dao.modifyDetailAddress(orderId, detailAddress);
			System.out.println("修改detailAddress="+result);
		}
		//修改phone
		if(phone!=null){
			dao.modifyPhone(orderId, phone);
			System.out.println("修改phone="+result);
		}
		//修改name
		if(name!=null){
			dao.modifyName(orderId, name);
			System.out.println("修改name="+result);
		}
		//修改amount
		if(amount!=null){
			dao.modifyAmount(orderId, amount, message);
			System.out.println("修改amount="+result);
		}
		order = dao.showOrder(orderId);
		System.out.println("ModifyOrderService=======order="+order.toString());
		
		return order;
	}
	
	
}
