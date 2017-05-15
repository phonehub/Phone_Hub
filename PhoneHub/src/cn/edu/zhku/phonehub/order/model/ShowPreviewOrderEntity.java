package cn.edu.zhku.phonehub.order.model;


public class ShowPreviewOrderEntity {

	private String[] selectedProduct;		//选中的商品Id
	private String userName;				//用户姓名
	
	
	
	@Override
	public String toString() {
		return "ShowPreviewOrderEntity [selectedProduct="
				+ selectedProduct.toString() + ", userName=" + userName
				+ "]";
	}
	public ShowPreviewOrderEntity() {
		super();
	}
	public String[] getSelectedProduct() {
		return selectedProduct;
	}
	public void setSelectedProduct(String[] selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
