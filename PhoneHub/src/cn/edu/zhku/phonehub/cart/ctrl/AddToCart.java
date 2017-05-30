package cn.edu.zhku.phonehub.cart.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.cart.service.CartService;

/*
 * 本类的dopost方法需要用到request.getParameter方法涉及到的参数名字 productId, num (请求页面传入)
 * ,需要从session里面获取userId的值;
 * 参数获取完毕后调用服务层方法,最后写进数据库shopcart表中,若已有productId的数据,则增加num否则执行插入
 * 请用Ajax调用 ,方法中没有跳转
 */

public class AddToCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 杀杀杀

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int productId = -1;
		if ((String) request.getParameter("productId") != null) {
			productId = Integer.parseInt((String) request
					.getParameter("productId"));
		}
		int num = Integer.parseInt((String) request.getParameter("num"));
		// CartItem ci = new CartItem();
		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		response.setContentType("text/html;charset=utf-8");
		CartService cs = new CartService();
		Cart cart = null;

		try {
			cart = cs.add(num, productId, userId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cart.items.size() == 0) {
			session.setAttribute("px_cart", null);
			return;
		} else {
			session.setAttribute("px_cart", cart);

		}

	}
}
