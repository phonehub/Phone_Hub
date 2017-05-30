package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.phonehub.store.service.ProductManageServer;
import cn.edu.zhku.phonehub.store.util.JSONUtil;

/**
 * Servlet implementation class GetProductListCtrl
 */
public class GetProductListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductManageServer ps = new ProductManageServer();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductListCtrl() {
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
		System.out.println("test");
		String storeId = request.getParameter("storeId");
		List ls = ps.getProductList(Integer.parseInt(storeId));
		JSONObject object =new JSONObject();
		object.put("productList", ls);
//		String param = JSONUtil.ArrayToJsonString(ls);
//		System.out.println(param);
		request.setAttribute("productList", ls);
		//request.getRequestDispatcher("storeManage/getProductList.jsp").forward(request,response);
		response.setCharacterEncoding("utf-8");
		String obj = JSONUtil.ArrayToJsonString(ls);
		String json = JSONUtil.ObjectToJsonString(object);
		System.out.println("---"+json);
//		System.out.print(obj);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
		System.out.print(true);
	}

}
