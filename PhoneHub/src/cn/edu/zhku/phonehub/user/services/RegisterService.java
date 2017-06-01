package cn.edu.zhku.phonehub.user.services;

import java.sql.SQLException;

import cn.edu.zhku.phonehub.user.dao.RegisterDao;
import cn.edu.zhku.phonehub.user.dao.Userdao;
import cn.edu.zhku.phonehub.user.model.User;

public class RegisterService {

	public Boolean Insert(User user) throws ClassNotFoundException,
			SQLException {
		boolean result = false;
		RegisterDao rd = new RegisterDao();
		if (rd.InsertUser(user) != false)
			result = true;
		return result;

	}

	public boolean aleardyExist(String name) throws Exception {
		Userdao userdao = new Userdao();
		return userdao.getUserByName(name);
	}
}
