package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import cn.edu.zhku.phonehub.store.service.CreateStoreSever;

public class CreateStoreCtrl extends HttpServlet {

	CreateStoreSever cs = new CreateStoreSever();
	
	public CreateStoreCtrl() {
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
		
		if(cs.createStore(request)){
			request.getSession().setAttribute("power",2);
			PrintWriter out=response.getWriter();
			out.print("<script language='JavaScript'>alert('success');" +
					"window.location.href='/PhoneHub/user/information.jsp';</script>");
		}
		else{
			JOptionPane.showMessageDialog(null, "fail,please try it again");
			response.sendRedirect("/PhoneHub/user/information.jsp");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
