package cn.edu.zhku.phonehub.user.ctrl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.zhku.phonehub.user.model.User;
import cn.edu.zhku.phonehub.user.services.UserService;
import cn.edu.zhku.phonehub.user.util.FileUtil;

public class UserCtrl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	/*
	 * savePath = request.getSession().getServletContext() 獲取路徑名
	 * .getRealPath("\\") + "Image\\" + item.getFieldName() + "\\";
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { // 需要判断getParameter("methods")，如果不为空，则执行修改支付密码
																					// modify_paykey()
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int userId = -1;
		String method = "1";
		UserService service = new UserService();

		if (request.getParameter("methods") != null)
			method = (String) request.getParameter("methods");
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			Integer inter = (Integer) session.getAttribute("userId");
			userId = inter.intValue();
		}
		if (userId == -1) {
			out.println("userId==-1,还没登陆？");
			return;
		}
		if (method.equals("paykey_modify")) {
			try {
				modify_paykey(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		if (method.equals("select")) {
			service = new UserService();
			try {
				User user = service.getUser(userId);
				session.setAttribute("user", user);
				RequestDispatcher rd = null;
				request.setAttribute("user", user);
				rd = request.getRequestDispatcher("/user/information.jsp");
				rd.forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		UserService userService = new UserService();
		User user = null;

		try {
			user = userService.getUser(userId);
			if (user.getPayKey().equals("123456")) {
				String msg = "支付密码尚未设置，请先设置";
				request.setAttribute("MSG", msg);
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/modify.jsp"); // 强迫更改支付密码
				rd.forward(request, response);
				return ;
			}

			Map<String, String> map = new HashMap<String, String>();
			// 文件临时存放路径
			String tempPath = request.getSession().getServletContext()
					.getRealPath("\\")
					+ "Image\\temp\\";
			// 测试---打印temp绝对路径
			System.out.println("wee" + tempPath);

			File tmpFile = new File(tempPath);
			if (!tmpFile.exists()) {
				tmpFile.mkdirs();
			}
			ServletFileUpload upload = FileUtil.createUpload(tmpFile,
					4096 * 1024);

			// 文件存储的绝对路径
			String savePath = "";
			// 文件存储的相对路径
			String relativePath = "";
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<FileItem> iteratorItem = items.iterator();

			while (iteratorItem.hasNext()) {
				FileItem item = iteratorItem.next();
				if (item.isFormField()) {
					map.put((String) item.getFieldName(),
							(String) item.getString());
				} else {
					savePath = request.getSession().getServletContext()
							.getRealPath("\\")
							+ "Image\\" + item.getFieldName() + "\\";
					// 测试----打印路径
					System.out.println(savePath);

					relativePath = FileUtil.saveFile(item, savePath, userId);
					// 测试----打印绝对路径
					item.delete();
					System.out.println("绝对路径:" + relativePath);
					if (relativePath != null) {
						relativePath = FileUtil.getRelativePath(relativePath);
						relativePath = "Image" + relativePath;
						out.println("<img src=\"" + relativePath
								+ " \"height=\"200\" width=\"200\">");
					}
					if (map.containsKey(item.getFieldName())) {
						relativePath = map.get(item.getFieldName()) + ","
								+ relativePath;
						map.put(item.getFieldName(), relativePath);
					} else {
						map.put(item.getFieldName(), relativePath);
					}

				}
			}
			Iterator<?> entries = map.entrySet().iterator();
			String password = null;
			while (entries.hasNext()) {

				Map.Entry entry = (Map.Entry) entries.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				System.out.println("Key = " + key + ", Value = " + value
						+ "ddd" + user.getPassWord());
				if (key.equals("passWord")) {
					password = value;

				} else if (key.equals("HeadImage")) {
					if (value != null)
						user.setHeadImage(value);
				} else if (key.equals("oldpassWord")) {

					if (!value.equals(user.getPassWord())) {

						request.setAttribute("MSG", "密码不正确!");
						RequestDispatcher rd = null;
						rd = request
								.getRequestDispatcher("/user/modifyresult.jsp");
						rd.forward(request, response);
						return ;
					}

				}

			}
			user.setPassWord(password);
			System.out.println(user.getUserId());
			userService.doUpdate(user);
			logout(request, response);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/user/login.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean modify_paykey(HttpServletRequest request,
			HttpServletResponse response) throws IOException,
			ClassNotFoundException, SQLException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = null;
		int userId = -1;
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			Integer inter = (Integer) session.getAttribute("userId");
			userId = inter.intValue();
		}
		String oldpaykey = (String) request.getParameter("oldpayKey");
		String payKey = (String) request.getParameter("payKey");
		if (userId == -1) {

		} else {
			msg = "对不起，支付密码修改失败";
			UserService userService = new UserService();
			User user = null;
			user = userService.getUser(userId);
			if (!user.getPayKey().equals(oldpaykey)) {
				request.setAttribute("MSG", "支付密码不正确!");
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/modifyresult.jsp");
				rd.forward(request, response);
			}

			user.setPayKey(payKey);
			if (user != null) {
				if (userService.doUpdate(user)) {
					msg = "支付密码修改成功";

				}

			}
			request.setAttribute("MSG", msg);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("/user/modifyresult.jsp");
			rd.forward(request, response);
			return true;
		}
		return false;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException,
			ServletException {

		HttpSession session = request.getSession();
		session.invalidate();

	}
}
