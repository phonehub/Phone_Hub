package cn.edu.zhku.phonehub.cart.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.cart.model.CartItem;
import cn.edu.zhku.phonehub.cart.service.CartService;
import cn.edu.zhku.phonehub.product.dao.ShowProductDetailDao;

public class DelCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int productId = 0;
		if ((String) request.getParameter("productId") != null) {
			productId = Integer.parseInt((String) request
					.getParameter("productId"));
		}

		// int num = Integer.parseInt((String) request.getParameter("num"));
		CartItem ci = new CartItem();
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String) session.getAttribute("userId"));
		response.setContentType("text/html;charset=utf-8");
		ShowProductDetailDao dao = new ShowProductDetailDao();
		CartService cs = new CartService();
		if (request.getParameter("all") != null) // 若有all的参数，代表要删除该用户全部购物车信息
		{
			try {
				cs.deleteAll(userId);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try { // 稍此方法删除购物车中某个产品的信息，而非减去一
			Cart cart = null;
			if (session.getAttribute("px_cart") == null) {

				// if (cart == null)
				// System.out.println("cart  null");
				return;
			} else {
				cart = (Cart) session.getAttribute("px_cart");
				cart.deleteItemById(productId);
				cs.delete(cart, productId);
				if (cart.items.size() == 0) {
					session.setAttribute("px_cart", null);
					return;
				} else {
					session.setAttribute("px_cart", cart);
				}
			}

			// cart=cdao.getCart(userId);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/cart/cart.jsp");
			rd.forward(request, response);
		}

	}

}
