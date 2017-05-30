package cn.edu.zhku.phonehub.user.services;

import java.sql.SQLException;

import cn.edu.zhku.phonehub.user.dao.Userdao;
import cn.edu.zhku.phonehub.user.model.User;

public class UserService {
	Userdao userdao = new Userdao();

	public User getUser(int userId) throws ClassNotFoundException, SQLException {
		return userdao.Select(userId);
	}

	public boolean doUpdate(User user) throws ClassNotFoundException,
			SQLException {
		System.out.println(user.getUserId());
		return userdao.update(user);
	}

	public boolean delete(User user) throws ClassNotFoundException,
			SQLException {
		return userdao.delete(user);
	}
}
