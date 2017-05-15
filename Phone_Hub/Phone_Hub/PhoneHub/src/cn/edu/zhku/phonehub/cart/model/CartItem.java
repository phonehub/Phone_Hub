package cn.edu.zhku.phonehub.cart.model;

import cn.edu.zhku.phonehub.product.model.Product;

public class CartItem { // 数据成员:数量,产品实例 ,附加getPrice():float ,返回购物车中该类型手机总价格
	private Product product;
    
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getPrice() {
		return (float) this.count * product.getPrice();
	}

	

	
}
