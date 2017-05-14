package cn.edu.zhku.phonehub.product.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.product.model.SearchProductEntity;
import cn.edu.zhku.phonehub.product.model.SearchProductInfo;
import cn.edu.zhku.phonehub.product.service.SearchProductServer;
/*
 * 类名：
 * 功能：
 * 输入：
 * 输出：
 * 作者：feven
 */
/*
 * 类名：SearchProductCtrl
 * 功能：买家通过输入品牌/商品名字/店铺名字查找商品信息
 * 输入：从jsp中得到用户选择的查找类型（品牌、商品名字、店铺）
 * 		从jsp中得到用户输入的信息
 * 输出：返回商品信息ArrayList的形式返回到JSP
 * 作者：feven
 */
public class SearchProductCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//从jsp中获得查找类型、查找数据
		String searchType = (String)request.getParameter("searchType");
		String searchInfo = (String)request.getParameter("searchInfo");
		System.out.println("ctrl----searchType="+searchType);
		System.out.println("ctrl----searchInfo="+searchInfo);
		//封装
		SearchProductEntity searchGoodsEntity = new SearchProductEntity();
		searchGoodsEntity.setSearchType(searchType);
		searchGoodsEntity.setSearchInfo(searchInfo);
		
		
		ArrayList<SearchProductInfo> productList = null;
		try {
			productList = SearchProductServer.getProductList(searchGoodsEntity);
			System.out.println("ctrl-----productList="+productList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("productList", productList);
			rd = request.getRequestDispatcher("/searchProduct/showSearchProduct.jsp");	//显示商品概要信息的界面
			rd.forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
