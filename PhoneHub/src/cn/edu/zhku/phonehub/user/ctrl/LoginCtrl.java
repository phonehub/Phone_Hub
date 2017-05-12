package cn.edu.zhku.phonehub.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.user.User;
import cn.edu.zhku.phonehub.user.service.LoginService;

public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	LoginService ls = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = (String) request.getParameter("userName");
		String userPassword = (String) request.getParameter("userPassword");
		User user = new User();
		user.setName(userName);
		user.setPassword(userPassword);
		boolean checkResult = false;
		String msg = null;
		out.println(user.getName() + user.getPassword());
		try {
			checkResult = ls.checkUserNameAndPassword(user);
			if (checkResult == true) {
				msg = "欢迎" + userName + "回来!";
				HttpSession session = request.getSession();
				session.setAttribute("username", userName);
			} else {
				msg = "登录失败";

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (msg == null) {
				msg = "数据库异常";
			}
			RequestDispatcher rd = null;
			request.setAttribute("MSG", msg);
			out.println(msg);
			rd = request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
