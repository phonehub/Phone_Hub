package cn.edu.zhku.phonehub.user.services;

import cn.edu.zhku.phonehub.user.dao.LoginDao;
import cn.edu.zhku.phonehub.user.model.User;

public class LoginServices {

	public User checkUserNameAndPassword(User user) throws Exception {
		LoginDao ld = new LoginDao(); // 建一个logindao对象
		// int result = -1;

		// User newUser = new User();
		// newUser = ld.getUserByName(user); //
		// 使用其方法获得一个user对象,当此方法传入user的密码与用户名在数据库存在时,返回的user对象存有密码用户名,否则为空
		// System.out.println(newUser.getUserName());
		// if (newUser.getUserName() != null) {

		// }

		return ld.getUserByName(user);
	}
}
