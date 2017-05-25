package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.ShopCart;
import cn.edu.zhku.phonehub.order.service.ShowShopcartService;

//让培鑫写吧~
public class ShowShopcartCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		//获得用户名字
		int userId = (Integer) request.getSession().getAttribute("userId");
		System.out.println("ctrl-----userId="+userId);
		
		
		ArrayList<ShopCart> shopcartList = null;
		
		try {
			shopcartList = ShowShopcartService.getShopcart(userId);
			
			System.out.println("ShowShopcartCtrl-------shopcartList="+shopcartList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("shopcartList", shopcartList);
			rd = request.getRequestDispatcher("/order/shopcartCommit.jsp");	//显示订单预览界面
			rd.forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
