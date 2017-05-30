package cn.edu.zhku.phonehub.cart.service;

import java.sql.SQLException;

import cn.edu.zhku.phonehub.cart.dao.CartDao;
import cn.edu.zhku.phonehub.cart.model.Cart;

public class CartService {
	CartDao cartdao = new CartDao();

	public Cart showCart(int userId) throws Exception {
		Cart cart = null;
		cart = cartdao.getCart(userId);
		return cart;
	}

	public Cart add(int num, int productId, int userId) throws Exception {
		Cart cart = null;
		cartdao.addcart(num, productId, userId);
		cart = cartdao.getCart(userId);
		return cart;
	}

	public void update(Cart cart) throws Exception {
		cartdao.update(cart);
	}

	public void delete(Cart cart, int productId) throws ClassNotFoundException,
			SQLException {
		cartdao.delete(cart, productId);
	}

	public boolean deleteAll(int userId) throws ClassNotFoundException,
			SQLException {
		return cartdao.deleteByuserId(userId);
	}
}
