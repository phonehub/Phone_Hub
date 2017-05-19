package cn.edu.zhku.phonehub.store.model;

public class Store {
	
	private int storeId;
	private int userId;
	private String storeName;
	private String location;
	private String idCardFront;
	private String idCardBehind;
	private float storeScore;
	
	
	//-----------------------------
	public String fevenadd;
	
	public String getFevenadd() {
		return fevenadd;
	}
	//-----------------------------
	
	
	public void setFevenadd(String fevenadd) {
		this.fevenadd = fevenadd;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIdCardFront() {
		return idCardFront;
	}
	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}
	public String getIdCardBehind() {
		return idCardBehind;
	}
	public void setIdCardBehind(String idCardBehind) {
		this.idCardBehind = idCardBehind;
	}
	public float getStoreScore() {
		return storeScore;
	}
	public void setStoreScore(float storeScore) {
		this.storeScore = storeScore;
	}

}
