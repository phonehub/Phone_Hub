package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.model.Store;
import cn.edu.zhku.phonehub.store.service.StoreManageServer;


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
		sm.getStoreList();
	}

}
