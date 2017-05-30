package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.service.SendOrderService;

public class SendOrderCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//获得参数
		//int orderId = (Integer) request.getSession().getAttribute("sendOrder_orderId");
		//System.out.println("orderId="+orderId);
		
		String orderId_ = request.getParameter("sendOrder_orderId");
		int orderId = Integer.parseInt(orderId_);
		
		boolean result = false;
		String msg = null;
		try {
			result = SendOrderService.sendOrder(orderId);
			System.out.println("SendOrderCtrl-----result="+result);
			
			if(result==true){
				msg = "订单"+orderId_+"发货成功";
			}
			else{
				msg = "订单"+orderId_+"发货失败";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("sendOrder_msg", msg);
			rd = request.getRequestDispatcher("/order/SearchStoreSeeOrder.jsp");	//显示付款完成页面
			rd.forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
