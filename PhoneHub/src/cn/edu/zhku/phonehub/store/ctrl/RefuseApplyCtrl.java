package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.edu.zhku.phonehub.store.model.Store;
import cn.edu.zhku.phonehub.store.service.StoreManageServer;
import cn.edu.zhku.phonehub.store.util.JSONUtil;


public class RefuseApplyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreManageServer ss = new StoreManageServer();
       
    
    public RefuseApplyCtrl() {
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
		Store store = new Store();
		JSONObject obj = new JSONObject();
		store.setStoreId(Integer.parseInt(storeId));
		if(ss.refuseApply(store)){
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
