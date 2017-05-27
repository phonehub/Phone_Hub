package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.model.Product;
import cn.edu.zhku.phonehub.store.service.ProductManageServer;

public class AlterCountCtrl extends HttpServlet {
	
	ProductManageServer productManageServer = new ProductManageServer();

	
	public AlterCountCtrl() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		product.setNum(Integer.parseInt(request.getParameter("count")));
		productManageServer.alterCount(product);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
