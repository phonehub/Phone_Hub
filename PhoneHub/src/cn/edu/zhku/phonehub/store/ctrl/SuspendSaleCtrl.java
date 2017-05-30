package cn.edu.zhku.phonehub.store.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zhku.phonehub.store.model.Store;
import cn.edu.zhku.phonehub.store.service.StoreManageServer;


public class SuspendSaleCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreManageServer ss = new StoreManageServer();
       
    
    public SuspendSaleCtrl() {
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
		store.setStoreId(Integer.parseInt(storeId));
		ss.suspendSale(store);
		
	}

}
