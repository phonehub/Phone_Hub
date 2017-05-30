package cn.edu.zhku.phonehub.product.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.model.SearchProductEntity;
import cn.edu.zhku.phonehub.product.service.ShowProductDetailServer;
/*
 * 类名：ShowProductDetailCtrl
 * 功能：通过商品ID查找商品的详细信息
 * 输入：int productID(商品ID)
 * 输出：Product productDetil
 * 作者：feven
 */
public class ShowProductDetailCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//从jsp中获得商品ID
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("ctrl----productId="+productId);
		
		Product productDetail = null;
		try {
			productDetail = ShowProductDetailServer.getProductDetail(productId);
			System.out.println("ctrl-----product="+productDetail.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			RequestDispatcher rd = null;
			request.setAttribute("productDetail", productDetail);
			rd = request.getRequestDispatcher("/searchProduct/showSearchProduct.jsp");	
			rd.forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
