package cn.edu.zhku.phonehub.product.model;

public class Product {
	private int productId;			//主键（数据库自增）
	private int storeId;			//店铺ID（主键）
	private String productName;		//商品名称
	private float price;			//商品价格
	private String cpu;				//CPU参数
	private String ram; 			//运行内存
	private String brand;			//手机品牌
	private String screenSize;		//屏幕大小
	private String size; 			//体积（长*宽*厚度，由业务计算）
	private String networkType;		//网络类型
	private String color;			//颜色
	private String system;			//操作系统
	private String memory; 			//手机存储大小
	private String battery;			//电池容量
	private String formCamera; 		//前置摄像头
	private String behindCamera;	//后置摄像头
	private int coreNum; 			//cpu核心数
	private float productScore; 	//商品评分
	private int num; 				//库存
	private String weight;			//重量
	private String describe; 		//产品描述
	private String image1;			//图片1
	private String image2;			//图片2
	private String image3;			//图片3
	
	public Product() {
		super();
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getFormCamera() {
		return formCamera;
	}

	public void setFormCamera(String formCamera) {
		this.formCamera = formCamera;
	}

	public String getBehindCamera() {
		return behindCamera;
	}

	public void setBehindCamera(String behindCamera) {
		this.behindCamera = behindCamera;
	}

	public int getCoreNum() {
		return coreNum;
	}

	public void setCoreNum(int coreNum) {
		this.coreNum = coreNum;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public float getProductScore() {
		return productScore;
	}

	public void setProductScore(float productScore) {
		this.productScore = productScore;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

}
