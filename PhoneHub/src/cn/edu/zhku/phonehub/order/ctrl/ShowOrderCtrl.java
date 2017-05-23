package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.order.model.ShowPreviewOrder;
import cn.edu.zhku.phonehub.order.model.entity.ShowPreviewOrderEntity;
import cn.edu.zhku.phonehub.order.service.ShowOrderService;
/*
 * 类名：ShowOrderCtrl
 * 功能：用户在购物车中点击结算，跳转到该Service,
 * 		主要从数据库中获取预览的订单数据
 * 输入：
 * 		界面获取：商品id，
 * 输出：订单预览数据
 * 作者：feven
 */
public class ShowOrderCtrl extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//从jsp中获得数据
		
		
//		ArrayList<ShopCartDao> shopCart = null;
//		shopCart = (ArrayList<ShopCartDao>) request.getAttribute("shopCart");
		
		//原来的想法是从jsp中传购物车的信息到servlet，现在改变方案，直接从Dao中再次获取购物车信息
		//所以下面的代码注释，但不删除，以备之后需要使用
//		HttpSession session = request.getSession();
//		ArrayList<ShopCartDao> shopCart = (ArrayList<ShopCartDao>)session.getAttribute("shopCart");
//		System.out.println("showOrderCtrl-----shopCart"+shopCart);
		
		//获得用户名字
		String userName = (String) request.getSession().getAttribute("userName");
		System.out.println("ctrl-----userName="+userName);
		//String[]中的每个值为购物车中选中商品的id 
		//前台要确保有选中至少一个，才可以跳转到这个Servlet
		String[] selectedProduct =  request.getParameterValues("selectedProduct");
		if(selectedProduct!=null && selectedProduct.length>0){
			for(int i=0;i<selectedProduct.length;i++){
				System.out.println(selectedProduct[i]);
			}
		}
		else{
			System.err.println("前台没有判断至少选中一项");
		}
		
		//封装用户Id和选中的购物车商品
		ShowPreviewOrderEntity showPreviewOrderEntity = new ShowPreviewOrderEntity();
		showPreviewOrderEntity.setSelectedProduct(selectedProduct);
		showPreviewOrderEntity.setUserName(userName);
		
		ArrayList<ShowPreviewOrder> showPreviewOrder = null;
		//获取订单预览信息
		try {
			showPreviewOrder = ShowOrderService.getPreviewOrderInfo(showPreviewOrderEntity);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("showPreviewOrder", showPreviewOrder);
			rd = request.getRequestDispatcher("/order/showPreviewOrder.jsp");	//显示订单预览界面
			rd.forward(request, response);
			
			
		}
		
		System.out.println("ctrl----最终得到的getShowPreviewOrder=");
		for(int i=0;i<showPreviewOrder.size();i++)
			System.out.println(showPreviewOrder.get(i).toString());
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
