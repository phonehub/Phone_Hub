package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import cn.edu.zhku.phonehub.store.model.Store;
import cn.edu.zhku.phonehub.store.service.StoreManageServer;
import cn.edu.zhku.phonehub.store.util.JSONUtil;


public class GetStoreListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StoreManageServer sm = new StoreManageServer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStoreListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List ls = sm.getStoreList();
		JSONObject json = new JSONObject();
		json.put("storelist", ls);
		String resualt = JSONUtil.ObjectToJsonString(json);
		System.out.println(resualt);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(resualt);
		out.flush();
		out.close();
	}

}
