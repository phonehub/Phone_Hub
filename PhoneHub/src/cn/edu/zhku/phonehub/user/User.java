package cn.edu.zhku.phonehub.user;

public class User {

	private String name = null;
	private String password = null;
	private String phone;
	private byte headimage;
	private String paykey;
	private double wallet;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getHeadimage() {
		return headimage;
	}

	public void setHeadimage(byte headimage) {
		this.headimage = headimage;
	}

	public String getPaykey() {
		return paykey;
	}

	public void setPaykey(String paykey) {
		this.paykey = paykey;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
