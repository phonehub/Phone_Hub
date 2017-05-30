package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.model.Store;
import cn.edu.zhku.phonehub.store.service.StoreManageServer;
import cn.edu.zhku.phonehub.store.util.JSONUtil;


public class GetStoreDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreManageServer sm = new StoreManageServer();   
    
    public GetStoreDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		Store store = new Store();
		store.setUserId(Integer.parseInt(userId));
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Map<String,Object> map = sm.getApplyDetail(store);
		request.getSession().setAttribute("storeId",map.get("storeId"));
		String obj = JSONUtil.ObjectToJsonString(map);
		System.out.print(obj);
		out.println(obj);
		out.flush();
		out.close();
		System.out.print(true);
	}

}
