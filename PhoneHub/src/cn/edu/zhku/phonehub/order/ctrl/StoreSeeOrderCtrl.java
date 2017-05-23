package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.order.model.entity.StoreSeeOrderEntity;
import cn.edu.zhku.phonehub.order.service.StoreSeeOrderService;
/*
 * 类名：StoreSeeOrderCtrl
 * 功能：店铺查看所有订单信息
 * 输入：	方式：select =  1(订单编号递增)、2(订单编号递减)、3(时间最新)、
 * 					  4(状态为1)、5(状态为2)、6(状态为3)、7(状态为4)
 * 					  8(+orserId)、9(+orderTime)、10(+userId)   
 * 		
 * 		备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
 * 输出：	订单信息
 * 作者：feven
 */
public class StoreSeeOrderCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//获得参数
		int select = (Integer) request.getSession().getAttribute("storeSeeOrder_select");
		int orderId = (Integer) request.getSession().getAttribute("storeSeeOrder_orderId");
		int userId = (Integer) request.getSession().getAttribute("storeSeeOrder_userId");
		String orderTime = (String) request.getSession().getAttribute("storeSeeOrder_orderTime");
		
		//封装
		StoreSeeOrderEntity entity = new StoreSeeOrderEntity();
		entity.setOrderId(orderId);
		entity.setOrderTime(orderTime);
		entity.setSelect(select);
		entity.setUserId(userId);
		System.out.println("StoreSeeOrderCtrl ------- entity="+entity.toString());
		
		
		ArrayList<StoreSeeOrder> storeSeeOrderList =  null;
		
		try {
			storeSeeOrderList = StoreSeeOrderService.getStoreSeeOrder(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("storeSeeOrderList", storeSeeOrderList);
			rd = request.getRequestDispatcher("/order/ShowStoreSeeOrder.jsp");	//显示订单预览界面
			rd.forward(request, response);
		}
		
			
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
