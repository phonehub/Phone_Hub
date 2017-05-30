package cn.edu.zhku.phonehub.cart.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.cart.dao.CartDao;
import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.cart.model.CartItem;
import cn.edu.zhku.phonehub.cart.service.CartService;
import cn.edu.zhku.phonehub.product.dao.ShowProductDetailDao;
import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.service.ShowProductDetailServer;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class ShowCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ 
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
        CartItem ci = new CartItem();
		HttpSession session = request.getSession();
		int userId = Integer.parseInt((String) session.getAttribute("userId"));
		response.setContentType("text/html;charset=utf-8");
		//ShowProductDetailServer showproduct = new ShowProductDetailServer();
	//	CartDao cdao=new CartDao();
		try {
			Cart cart=(Cart)session.getAttribute("px_cart");
			CartService service =new CartService();
			if(cart==null){
				cart = new Cart();
				String msg ="对不起购物车为空";
				RequestDispatcher rd = null;
				request.setAttribute("MSG", msg);
				out.println(msg);
				rd = request.getRequestDispatcher("cart/cartresult.jsp");
				rd.forward(request, response);
				//session.setAttribute("px_cart", cart);
			}
			else	
			{
			 List<CartItem> items=cart.getItems();
			 JSONArray jsonarray = JSONArray.fromObject(items);
			 out.print(jsonarray);
			 out.flush();
			 out.close();
			 
			}
			
			
			//	cart = service.showCart(userId);  ;
			// cart=cdao.getCart(userId);
		
		//	ci.setCount(num);
		//	ci.setProduct(p);
		//	cart.add(ci);
			//cdao.update(cart);
		//	session.setAttribute("px_cart", cart);
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	/*public void java2Json(List object, String[] excludes) {
		// 使用json-lib将PageBean对象转为json数据
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);// 指定哪些属性不需要
		//防止死循环
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		String json = JSONArray.fromObject(object, jsonConfig).toString();
		// 通过输出流将json数据写回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
		ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
		e.printStackTrace();
		}*/
	

}
