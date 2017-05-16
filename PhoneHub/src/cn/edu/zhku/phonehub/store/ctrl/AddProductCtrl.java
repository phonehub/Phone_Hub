package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.service.AddProductServer;

public class AddProductCtrl extends HttpServlet {
	
	AddProductServer as = new AddProductServer();

	
	public AddProductCtrl() {
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
		
		as.addProduct(request);

//		PrintWriter out = response.getWriter();
//		out.write("success");
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
