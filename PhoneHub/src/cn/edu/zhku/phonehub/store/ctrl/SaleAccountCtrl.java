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


public class SaleAccountCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductManageServer ps = new ProductManageServer();
       
    public SaleAccountCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String storeId = request.getParameter("storeId");
		List ls = ps.getSaleList(Integer.parseInt(storeId));
		JSONObject object =new JSONObject();
		object.put("saleList", ls);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSONUtil.ObjectToJsonString(object));
		out.flush();
		out.close();
	}

}
