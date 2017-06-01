package cn.edu.zhku.phonehub.user.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.zhku.phonehub.address.model.Address;
import cn.edu.zhku.phonehub.address.service.AddressService;
import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.services.LoginServices;
import cn.edu.zhku.phonehub.user.services.RegisterService;

public class RegisterCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterService reg = new RegisterService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = (String) request.getParameter("userName");
		String userPassword = (String) request.getParameter("passWord");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(userPassword);
		String msg = null;
		JSONObject resultJson = new JSONObject();

		try {

			if (reg.Insert(user) == true && reg.aleardyExist(userName)) {
				LoginServices ls = new LoginServices();
				user = ls.checkUserNameAndPassword(user);
				msg = "恭喜，注册成功";
				AddressService addressService = new AddressService();
				Address address = new Address();
				String receiver = "还没设置";
				String phone = "还没设置";
				String province = "还没设置";
				String city = "还没设置";
				String detailAddress = "还没设置";
				address.setReceiver(receiver);
				address.setPhone(phone);
				address.setProvince(province);
				address.setCity(city);
				address.setDetailAddress(detailAddress);
				address.setIfdefault(1);
				address.setUserId(user.getUserId());
				addressService.add(address);
				resultJson.put("flag", "true");
				out.println(resultJson);
				out.flush();
				out.close();
				// response.sendRedirect("../login.html");

				return;

			} else {
				msg = "很遗憾，注册失败了，再试一次？";

				System.out.println(msg);
				resultJson.put("flag", "false");
				out.println(resultJson);
				out.flush();
				out.close();
				// response.setHeader("Refresh",
				// "3;url=/PhoneHub/user/register.html");
				return;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	public void addAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
