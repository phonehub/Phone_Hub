package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.order.model.entity.ModifyOrderEntity;
import cn.edu.zhku.phonehub.order.service.ModifyOrderService;
/*
 * 类名：ModifyOrderCtrl
 * 功能：店铺修改根据顾客的要求修改订单（买家地址、手机号、收货人名字、总价（修改总价后需要在message中备注））
 * 输入：
 * 		modify_orderId
 * 		modify_address
 * 		modify_phone
 * 		modify_name
 * 		modify_amount
 * 		modify_message
 * 		
 * 输出：成功与否、和修改后的信息
 * 作者：feven
 */
public class ModifyOrderCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
//		int modify_orderId = (Integer) request.getSession().getAttribute("modify_orderId");
//		String modify_province = (String) request.getSession().getAttribute("modify_province");
//		String modify_city = (String) request.getSession().getAttribute("modify_city");
//		String modify_detailAddress = (String) request.getSession().getAttribute("modify_detailAddress");
//		String modify_phone = (String) request.getSession().getAttribute("modify_phone");
//		String modify_name = (String) request.getSession().getAttribute("modify_name");
//		String modify_amount = (String) request.getSession().getAttribute("modify_amount");
//		String modify_message = (String) request.getSession().getAttribute("modify_message");
		
		String getOrderId = request.getParameter("orderId");
		int modify_orderId =0;
		if(getOrderId!=null)
			modify_orderId = Integer.parseInt(getOrderId);
		String modify_province = request.getParameter("province");
		String modify_city = request.getParameter("city");
		String modify_detailAddress = request.getParameter("detailAddress");
		String modify_phone = request.getParameter("phone");
		String modify_name = request.getParameter("name");
		String modify_amount = request.getParameter("amount");
		String modify_message = request.getParameter("message");
		
		
		ModifyOrderEntity entity = new ModifyOrderEntity();
		entity.setOrderId(modify_orderId);
		entity.setProvince(modify_province);
		entity.setCity(modify_city);
		entity.setDetailAddress(modify_detailAddress);
		entity.setAmount(modify_amount);
		entity.setMessage(modify_message);
		entity.setName(modify_name);
		entity.setPhone(modify_phone);
		
		System.out.println("ModifyOrderCtrl-----entity="+entity.toString());
		StoreSeeOrder order = null;
		String msg = null;
		try {
			order = ModifyOrderService.getModifyResult(entity);
			System.out.println("ModifyOrderCtrl-----order="+order);
			
			if(order!=null){
				msg="订单"+order.getOrderId()+"修改成功";
			}
			else {
				msg = "订单修改失败";
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("msg", msg);
			System.out.println("msg="+msg);
			rd = request.getRequestDispatcher("/order/SearchStoreSeeOrder.jsp");	
			rd.forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
