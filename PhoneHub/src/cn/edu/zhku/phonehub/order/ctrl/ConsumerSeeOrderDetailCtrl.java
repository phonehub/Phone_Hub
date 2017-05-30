package cn.edu.zhku.phonehub.order.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsumerSeeOrderDetailCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
