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
import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.dao.ShowProductDetailDao;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class CartDao {

	public boolean Insert(Cart cart) throws SQLException, ClassNotFoundException { // 数据插入用的方法
		boolean result = true;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt;
		String sql = "insert into shopcart_table (id,userId,productId,num) values (null,?,?,?)";
		pstmt = ConnectionManager.prepare(conn, sql);
		int userId = cart.getUserId();
		List<CartItem> items = new ArrayList<CartItem>();
		items = cart.getItems();
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			pstmt.setInt(1, userId);
			pstmt.setInt(2, item.getProduct().getProductId());
			pstmt.setInt(3, item.getCount());
			if (pstmt.executeUpdate() == 0)
				result = false;
		}
		return result;

	}

	public Cart getCart(int userId) throws Exception {
		Cart cart = new Cart();
		CartItem cartitem = new CartItem();
		Connection conn = ConnectionManager.getConnection();
		ShowProductDetailDao spd = new ShowProductDetailDao();
		PreparedStatement ps = null;
		Product p;
		String sql = "select * from shopcart_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			p = spd.getProductDetailFromDb(rs.getInt("productId"));
			cartitem.setProduct(p);
			cartitem.setCount(rs.getInt("num"));
			cart.add(cartitem);
			//
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
				if (cartitem.getCount() == num && cartitem.getProduct().getProductId() == productid) {
					length++;
				}
			}
		}
		if (itemlength == length)
			result = true;
		rs.close();
		ps.close();
		conn.close();
		return result;
	}

	public boolean update(Cart cart) throws Exception {  //更新购物车到数据库
		boolean result =true;
		if(ifUpdate(cart)==false){
			deleteByuserId(cart.getUserId());
			if(Insert(cart)!=true)
				result = false;
		}
		return result;
	}
	public boolean deleteByuserId(int userId) throws ClassNotFoundException, SQLException{     //删除某用户数据库中购物车中的信息
		Connection conn = ConnectionManager.getConnection();
		boolean result=true;
		PreparedStatement ps = null;
		String sql = "delete  from shopcart_table where userId=?";
		ps = ConnectionManager.prepare(conn, sql);
		ps.setInt(1, userId);
		int len = ps.executeUpdate();
		if(len==0){
			result = false;
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
