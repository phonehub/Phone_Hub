package cn.edu.zhku.phonehub.user.services;

import cn.edu.zhku.phonehub.user.dao.LoginDao;
import cn.edu.zhku.phonehub.user.model.User;

public class LoginServices {
	LoginDao ld = new LoginDao(); 
	public User checkUserNameAndPassword(User user) throws Exception {
		// 寤轰竴涓猯ogindao瀵硅薄
		// int result = -1;

		// User newUser = new User();
		// newUser = ld.getUserByName(user); //
		// 浣跨敤鍏舵柟娉曡幏寰椾竴涓猽ser瀵硅薄,褰撴鏂规硶浼犲叆user鐨勫瘑鐮佷笌鐢ㄦ埛鍚嶅湪鏁版嵁搴撳瓨鍦ㄦ椂,杩斿洖鐨剈ser瀵硅薄瀛樻湁瀵嗙爜鐢ㄦ埛鍚�,鍚﹀垯涓虹┖
		// System.out.println(newUser.getUserName());
		// if (newUser.getUserName() != null) {

		// }

		return ld.getUserByName(user);
	}
}
