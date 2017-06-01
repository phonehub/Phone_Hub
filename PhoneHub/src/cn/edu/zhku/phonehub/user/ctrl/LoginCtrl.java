package cn.edu.zhku.phonehub.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import cn.edu.zhku.phonehub.cart.service.CartService;
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
		String userPassword = (String) request.getParameter("passWord");
		User loginuser = new User();
		User user = null;
		loginuser.setUserName(userName);
		loginuser.setPassWord(userPassword);
		String msg = null;
		JSONObject resultJson = new JSONObject();
		try {
			user = ls.checkUserNameAndPassword(loginuser); //
			if (user != null) {
				HttpSession session = request.getSession();
				CartService cartservice = new CartService();
				msg = "欢迎" + userName + "回来!";

				session.setAttribute("userId", user.getUserId());
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("power", user.getPower());
				session.setAttribute("px_cart",
						cartservice.showCart(user.getUserId()));

				resultJson.put("flag", "true");

				out.println(resultJson);
				out.flush();
				out.close();

			} else {
				resultJson.put("flag", "false");
				msg = "登录失败";
				out.println(resultJson);

				out.flush();
				out.close();

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (msg == null) {
				msg = "数据库异常";
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
