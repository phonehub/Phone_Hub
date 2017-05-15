package cn.edu.zhku.phonehub.cart.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.cart.dao.CartDao;
import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.cart.model.CartItem;
import cn.edu.zhku.phonehub.product.dao.ShowProductDetailDao;
import cn.edu.zhku.phonehub.product.model.Product;

public class DelCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int productId = Integer.parseInt((String) request.getParameter("productId"));
		int num = Integer.parseInt((String) request.getParameter("num"));
		CartItem ci = new CartItem();
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String) session.getAttribute("userId"));
		response.setContentType("text/html;charset=utf-8");
		ShowProductDetailDao dao = new ShowProductDetailDao();
		CartDao cdao = new CartDao();
		try {   //稍待思考   ，此方法删除购物车中某个产品的信息，而非减去一
			Cart cart=(Cart)session.getAttribute("px_cart");
			if(cart==null){
				cart = new Cart();
				session.setAttribute("px_cart", cart);
			}
		//	cart=cdao.getCart(userId);
			Product p=dao.getProductDetailFromDb(productId);
			ci.setCount(num);
			ci.setProduct(p);
			cart.deleteItemById(productId);
			cdao.update(cart);
			session.setAttribute("xpx_cart", cart);
			
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
		
	}

}
