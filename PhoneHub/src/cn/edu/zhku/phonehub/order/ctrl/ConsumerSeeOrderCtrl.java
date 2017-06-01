package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.PageBean;
import cn.edu.zhku.phonehub.order.model.StoreSeeOrder;
import cn.edu.zhku.phonehub.order.service.ConsumerSeeOrderService;

public class ConsumerSeeOrderCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		int userId = (Integer) request.getSession().getAttribute("userId");
		//int userId = 3;
		System.out.println("consumerSeeOrderCtrl------userId="+userId);
		//显示要显示的页数
		String page = request.getParameter("page");
		System.out.println("ctrl--get-----page="+page);
		
		//当前的页数
		int curPage = 1;
		//如果传入页数
		if(page!=null && page.length()>0){
			curPage = Integer.parseInt(page);
		}
		
		//ArrayList<ShowOrder> showOrderList = null;
		//ShowOrder showOrder = null;
		
		ArrayList<StoreSeeOrder> consumerSeeOrderList = null;
		PageBean pageBean = new PageBean();		//用于分页
		pageBean.setCurPage(curPage);
		pageBean.setPageSize(5);				//每页显示5行
		
		try {
			consumerSeeOrderList = ConsumerSeeOrderService.getFinalOrder(userId,pageBean);
			System.out.println("consumerSeeOrderList = "+consumerSeeOrderList.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("consumerSeeOrderList", consumerSeeOrderList);
			
			
			System.out.println("&&&&&&&&&&&&& pageBean="+pageBean.toString());
			
			request.setAttribute("pageBean", pageBean);
			rd = request.getRequestDispatcher("/order/consumerSeeOrder.jsp");	//显示付款完成页面
			rd.forward(request, response);
		}
		
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
