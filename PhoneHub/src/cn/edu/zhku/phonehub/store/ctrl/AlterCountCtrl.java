package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.phonehub.store.model.Product;
import cn.edu.zhku.phonehub.store.service.ProductManageServer;
import cn.edu.zhku.phonehub.store.util.JSONUtil;

/**
 * Servlet implementation class AlterCountCtrl
 */
public class AlterCountCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductManageServer productManageServer = new ProductManageServer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterCountCtrl() {
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
		JSONObject obj = new JSONObject();
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
		product.setNum(Integer.parseInt(request.getParameter("count")));
		//System.out.print("run here");
		if(productManageServer.alterCount(product)){
			obj.put("resualt", true);
		}
		else{
			obj.put("resualt", false);
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSONUtil.ObjectToJsonString(obj));
		out.flush();
		out.close();
	}

}
