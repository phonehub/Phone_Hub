package cn.edu.zhku.phonehub.user.model;

public class User {

	private String userName = null;
	private String passWord = null;
	private byte headImage;
	private String payKey;
	private double wallet;
	private int userId;
	private int power;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public byte getHeadImage() {
		return headImage;
	}

	public void setHeadImage(byte headImage) {
		this.headImage = headImage;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
