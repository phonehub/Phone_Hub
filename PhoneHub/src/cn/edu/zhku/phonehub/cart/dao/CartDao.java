package cn.edu.zhku.phonehub.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.zhku.phonehub.cart.model.Cart;
import cn.edu.zhku.phonehub.cart.model.CartItem;
import cn.edu.zhku.phonehub.user.dao.ShowProductDetailDao;
import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class CartDao {

	public int Insert(CartItem cartitem, int userId) throws SQLException,
			ClassNotFoundException { // 数据插入用的方法
		// ,返回为0,插入成功,否则返回插入失败数目
		int result = 0;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt;
		String sql = "insert into shopcart_table (id,userId,productId,num) values (null,?,?,?)";
		// int userId = cart.getUserId();
		// List<CartItem> items = new ArrayList<CartItem>();
		// items = cart.getItems();
		// for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
		pstmt = ConnectionManager.prepare(conn, sql);
		pstmt.setInt(1, userId);
		pstmt.setInt(2, cartitem.getProduct().getProductId());
		pstmt.setInt(3, cartitem.getCount());
		if (pstmt.executeUpdate() == 0)
			result++;
		// }
		return result;
	}

	public void addcart(int num, int productId, int userId) throws Exception {
		Product product = null;
		Cart cart = null;
		boolean flag = false;
		List<CartItem> items = new ArrayList<CartItem>();
		ShowProductDetailDao spd = new ShowProductDetailDao();
		product = spd.getProductDetailFromDb(productId); // p為product實例
		if ((cart = getCart(userId)) != null) {
			items = (List<CartItem>) cart.getItems();
			for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
				CartItem cartitem = iter.next();
				if (cartitem.getProduct().getProductId() == productId) {
					cart.add(cartitem);
					update(cart);
					flag = true;
				}
			}
		}
		if (flag == false) {
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setCount(num);
			Insert(item, userId);

		}
	}

	public Cart getCart(int userId) throws Exception {
		Cart cart = null;
		Connection conn = ConnectionManager.getConnection();
		ShowProductDetailDao spd = new ShowProductDetailDao();
		PreparedStatement ps = null;
		Product p;
		String sql = "select * from shopcart_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			if (cart == null) {
				cart = new Cart();
				cart.setUserId(userId);
			}
			CartItem cartitem = new CartItem();
			p = spd.getProductDetailFromDb(rs.getInt("productId")); // p為product實例
			cartitem.setProduct(p);
			cartitem.setCount(rs.getInt("num"));
			cart.add(cartitem);

		}
		rs.close();
		ps.close();
		conn.close();
		return cart;
	}

	public boolean ifUpdate(Cart cart) throws Exception { // 判断数据库中数据与传入的对象的数据是否一致
		// Cart cart1 = new Cart();
		// cart1=getCart(cart.getUserId());
		boolean result = false;
		int length = 0; // 相同项长度，初始为0
		int userId = cart.getUserId();
		List<CartItem> items = new ArrayList<CartItem>();
		items = (List<CartItem>) cart.getItems();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		int itemlength = items.size(); // items的大小
		String sql = "select * from shopcart_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { // 从将该用户数据库中的数据与cart中的items中的数据比较，若有相同，则相同项长度加一；

			int num = rs.getInt("num");
			int productid = rs.getInt("productId");
			for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
				CartItem cartitem = iter.next();
				if (cartitem.getCount() == num
						&& cartitem.getProduct().getProductId() == productid) {
					length++;
				} else if (cartitem.getCount() != num
						&& cartitem.getProduct().getProductId() == productid) {
					System.out.println("  " + productid + "   "
							+ cartitem.getCount());
					String sql1 = "update shopcart_table set num =? where userId=? and productId=?";
					PreparedStatement ps1 = null;
					ps1 = ConnectionManager.prepare(conn, sql1);
					ps1.setInt(1, cartitem.getCount());
					ps1.setInt(2, cart.getUserId());
					ps1.setInt(3, productid);
					ps1.executeUpdate();
				}
			}
		}
		if (itemlength == length) {
			System.out.println("len" + length);
			result = true;
		}

		rs.close();
		ps.close();
		conn.close();
		return result;
	}

	public boolean update(Cart cart) throws Exception { // 更新购物车到数据库
		boolean result = false;
		if (ifUpdate(cart) == false) {
			result = true;
		}

		return result;
	}

	public int delete(Cart cart, int productId) throws ClassNotFoundException,
			SQLException {
		int rs = 0;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		String sql = "delete   from shopcart_table where userId=? and productId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, cart.getUserId());
		ps.setInt(2, productId);
		rs = ps.executeUpdate();
		return rs;

	}

	public boolean deleteByuserId(int userId) throws ClassNotFoundException,
			SQLException { // 删除某用户数据库中购物车中的信息
		Connection conn = ConnectionManager.getConnection();
		boolean result = true;
		PreparedStatement ps = null;
		String sql = "delete  from shopcart_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		int len = ps.executeUpdate();
		if (len == 0) { // 如果执行结果为0,判断数据库中有无该用户购物车信息
			sql = "select * from shopcart_table where userId=?";
			ps = ConnectionManager.prepare(conn, sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				result = false;
			else
				result = true;
			rs.close();
		}

		ps.close();
		conn.close();
		return result;
	}

}
