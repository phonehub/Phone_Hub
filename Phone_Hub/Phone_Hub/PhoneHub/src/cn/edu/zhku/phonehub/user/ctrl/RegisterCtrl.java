package cn.edu.zhku.phonehub.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.services.RegisterService;

public class RegisterCtrl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	RegisterService  reg =new RegisterService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = (String) request.getParameter("userName");
		String userPassword = (String) request.getParameter("passWord");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(userPassword);
		String msg =null ;
		try {
			if(reg.Insert(user)==true){
				msg="恭喜，注册成功";
				out.println(msg);;
			}
			else
			{
				msg="很遗憾，注册失败了，再试一次？";
				out.println(msg);;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	} 
	
}
