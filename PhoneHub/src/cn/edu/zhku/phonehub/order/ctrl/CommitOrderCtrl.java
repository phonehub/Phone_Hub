package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.cart.service.CartService;
import cn.edu.zhku.phonehub.order.model.ShowOrder;
import cn.edu.zhku.phonehub.order.model.ShowPreviewOrder;
import cn.edu.zhku.phonehub.order.service.CommitOrderService;

public class CommitOrderCtrl extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		//获得预览的订单信息
		ArrayList<ShowPreviewOrder> previewOrder = null;
		//previewOrder =(ArrayList<ShowPreviewOrder>) request.getAttribute("previewOrder");
		previewOrder = (ArrayList<ShowPreviewOrder>) request.getSession().getAttribute("previewOrder");
		System.out.println("CommitOrderCtrl------previewOrder="+previewOrder);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String detailAddress = request.getParameter("detailAddress");
		
		previewOrder.get(0).setUserName(name);
		previewOrder.get(0).setPhone(phone);
		previewOrder.get(0).setProvince(province);
		previewOrder.get(0).setCity(city);
		previewOrder.get(0).setDetailAddress(detailAddress);
		
		//获得确认后的订单信息
		ShowOrder showOrder = null;
		try {
			showOrder = CommitOrderService.getCommitOrder(previewOrder);
			
			System.out.println("CommitOrderCtrl-------showOrder.getProductInfo="+showOrder.getProductInfo());
			
			CartService cartservice = new CartService();
			request.getSession().setAttribute("px_cart",cartservice.showCart(previewOrder.get(0).getUserId()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("showOrder", showOrder);
			rd = request.getRequestDispatcher("/order/ShowOrder.jsp");	//显示订单预览界面
			rd.forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
