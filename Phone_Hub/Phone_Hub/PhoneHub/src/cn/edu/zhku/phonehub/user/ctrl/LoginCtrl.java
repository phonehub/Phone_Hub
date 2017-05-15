package cn.edu.zhku.phonehub.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.cart.dao.CartDao;
import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.services.LoginServices;

public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	LoginServices ls = new LoginServices();

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
		user.setUserName(userName);
		user.setPassWord(userPassword);
		int userId = -1;
		String msg = null;
		out.println(user.getUserName() + user.getPassWord());
		try {
			userId = ls.checkUserNameAndPassword(user);  //若有该用户返回其id否则返回-1；
			if (userId!=-1 ) {
				Cart cart= new Cart();
				CartDao cdao =new CartDao();
				cart = cdao.getCart(userId);
				msg = "欢迎" + userName + "回来!";
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("px_cart", cart);
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
