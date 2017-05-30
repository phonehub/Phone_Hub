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

public class PlusCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

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
		// int num = Integer.parseInt((String) request.getParameter("num"));
		// CartItem ci = new CartItem();
		HttpSession session = request.getSession();
		// int userId = Integer.parseInt((String)
		// session.getAttribute("userId"));
		response.setContentType("text/html;charset=utf-8");
		CartService cs = new CartService();
		Cart cart = null;
		if (session.getAttribute("px_cart") == null) {
			return;
		} else {
			cart = (Cart) session.getAttribute("px_cart");
			cart.plus(productId);
			try {
				cs.update(cart);
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

}
