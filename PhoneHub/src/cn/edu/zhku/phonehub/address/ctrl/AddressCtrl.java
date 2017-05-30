package cn.edu.zhku.phonehub.address.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.zhku.phonehub.address.model.Address;
import cn.edu.zhku.phonehub.address.service.AddressService;

public class AddressCtrl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddressService addressService = new AddressService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String method = "";
		if (request.getParameter("methods") != null)
			method = request.getParameter("methods");
		if (method.equals("get")) {
			try {
				get(request, response);
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/address.jsp");
				rd.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("delete")) {
			try {
				delete(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("add")) {
			try {
				add(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("set")) {

			try {
				System.out.println("set");
				setDegfault(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("get1")) {
			try {
				get(request, response);
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/addressModify.jsp");
				rd.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (method.equals("update")) {
			try {
				System.out.println("update");
				update(request, response);
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/addressModify.jsp");
				rd.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/user/address.jsp");
			rd.forward(request, response);
			return;

		}

	}

	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		List<Address> list = addressService.get(userId);
		if(list==null){
			request.setAttribute("address_list", "noinfo");
		}
		request.setAttribute("address_list", list);

	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException,
			SQLException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		Address address = new Address();
		String receiver = request.getParameter("receiver");
		String phone = request.getParameter("phone");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String detailAddress = request.getParameter("detailAddress");
		address.setReceiver(receiver);
		address.setPhone(phone);
		address.setProvince(province);
		address.setCity(city);
		address.setDetailAddress(detailAddress);
		address.setIfdefault(0);
		address.setUserId(userId);
		addressService.add(address);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/user/address.jsp");
		rd.forward(request, response);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException,
			SQLException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		int addressId = -1;
		if ((String) request.getParameter("addressId") != null) {
			addressId = Integer.parseInt((String) request
					.getParameter("addressId"));
		}

		addressService.delete(userId, addressId);
	}

	public void setDegfault(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		int addressId = -1;
		if ((String) request.getParameter("addressId") != null) {
			addressId = Integer.parseInt((String) request
					.getParameter("addressId"));
		}
		System.out.println("set" + addressId);
		addressService.setDegfault(userId, addressId);

	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException,
			SQLException {

		HttpSession session = request.getSession();
		int userId = -1;
		Integer inter = (Integer) session.getAttribute("userId");
		userId = inter.intValue();
		int addressId = -1;
		if ((String) request.getParameter("addressId") != null) {
			addressId = Integer.parseInt((String) request
					.getParameter("addressId"));
		}
		Address address = new Address();
		String receiver = (String) request.getParameter("receiver");
		String phone = (String) request.getParameter("phone");
		String province = request.getParameter("province");
		String city = (String) request.getParameter("city");
		String detailAddress = (String) request.getParameter("detailAddress");
		address.setReceiver(receiver);
		address.setPhone(phone);
		address.setProvince(province);
		address.setCity(city);
		address.setDetailAddress(detailAddress);
		address.setIfdefault(0);
		address.setUserId(userId);
		address.setAddressId(addressId);
		System.out.println("update" + receiver + addressId);
		addressService.Update(addressId, userId, address);

	}

}
