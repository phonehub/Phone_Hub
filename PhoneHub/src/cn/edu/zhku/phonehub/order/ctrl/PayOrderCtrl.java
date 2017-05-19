package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.service.PayOrderService;

/*
 * 类名：PayOrderCtrl
 * 功能：对订单进行付钱
 * 输入：订单编号
 * 输出：
 * 作者：feven
 */
public class PayOrderCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//获得参数
		int orderId = (Integer) request.getSession().getAttribute("orderId");
		int userId = (Integer) request.getSession().getAttribute("userId");
		String userPassword = (String) request.getSession().getAttribute("userPassword");
		
		ShowOrder showOrder = null;
		
		try {
			showOrder = PayOrderService.getFinalOrder(orderId, userId, userPassword);
			System.out.println("payOrderCtrl----showOrder="+showOrder);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("showOrder", showOrder);
			rd = request.getRequestDispatcher("/order/PayResult.jsp");	//显示付款完成页面
			rd.forward(request, response);
			
			
		}
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
