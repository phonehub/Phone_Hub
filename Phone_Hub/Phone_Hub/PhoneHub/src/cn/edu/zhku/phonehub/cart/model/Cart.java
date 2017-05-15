package cn.edu.zhku.phonehub.cart.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart { // 方法:setItem ,getItem ,add,getTotalPrice deleteItemById
					// getCartItemPrice() :每个CartItem价格存放在List<float>类型的list中
	List<CartItem> items = new ArrayList<CartItem>();
	private int userId;

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void add(CartItem ci) {
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			if (item.getProduct().getProductId() == ci.getProduct()
					.getProductId()) {
				
					item.setCount(item.getCount() + 1);
					return;	
			}
			
		}

		items.add(ci);
	}
	public void dec(CartItem ci){
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			if (item.getProduct().getProductId() == ci.getProduct().getProductId()) {
					item.setCount(item.getCount() - 1);
					return;	
			}
		}
		
	}

	public float getTotalPrice() {
		float d = (float) 0.0;
		for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
			CartItem current = it.next();
			d += current.getProduct().getPrice() * current.getCount();
		}
		return d;
	}

	public void deleteItemById(int productId) {
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			if (item.getProduct().getProductId() == productId) {
				iter.remove();
			}
		}
	}

	public List<Float> getCartItemPrice() {
		List<Float> list = new ArrayList<Float>();
		for (Iterator<CartItem> iter = items.iterator(); iter.hasNext();) {
			CartItem item = iter.next();
			list.add(item.getPrice());
		}
		return list;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
