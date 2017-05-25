package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.model.Product;
import cn.edu.zhku.phonehub.store.service.ProductManageServer;

/**
 * Servlet implementation class DropProducrCtrl
 */
public class DropProducrCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductManageServer productManageServer = new ProductManageServer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropProducrCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		//productManageServer.
	}

}
