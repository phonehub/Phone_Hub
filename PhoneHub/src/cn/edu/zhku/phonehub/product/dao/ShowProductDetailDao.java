package cn.edu.zhku.phonehub.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.util.ConnectionManager;

public class ShowProductDetailDao {

	public Product getProductDetailFromDb(int productId) throws Exception{
		Product product = null;
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 通过反射机制动态的引入应用的数据库的驱动
		conn = ConnectionManager.getConnection();
		if(conn==null){
			throw new Exception("数据库连接不成功");
		}
		
		String sqlQuery = null;
		sqlQuery = "Select * from product_table where productId = ?";
		ps = conn.prepareStatement(sqlQuery);
		ps.setInt(1, productId);
		rs = ps.executeQuery();
		
		if(rs.next()){

			 int productId_ = rs.getInt("productId");				//主键（数据库自增）
			 int storeId = rs.getInt("storeId");					//店铺ID（主键）
			 String productName = rs.getString("productName");		//商品名称
			 float price = rs.getFloat("price");					//商品价格
			 String cpu = rs.getString("cpu");						//CPU参数
			 String ram = rs.getString("ram"); 						//运行内存
			 String brand = rs.getString("brand");					//手机品牌
			 String screenSize = rs.getString("screenSize");		//屏幕大小
			 String size = rs.getString("size");; 					//体积（长*宽*厚度，由业务计算）
			 String networkType = rs.getString("networkType");;		//网络类型
			 String color = rs.getString("color");;					//颜色
			 String system = rs.getString("system");;				//操作系统
			 String memory = rs.getString("memory");; 				//手机存储大小
			 String battery = rs.getString("battery");;				//电池容量
			 String frontCanmera = rs.getString("frontCanmera");; 	//前置摄像头
			 String behindCamera = rs.getString("behindCamera");;	//后置摄像头
			 int coreNum = rs.getInt("coreNum"); 					//cpu核心数
			 float productScore = rs.getFloat("productScore"); 		//商品评分
			 int num = rs.getInt("num"); 							//库存
			 String weight = rs.getString("weight");;				//重量
			 String description = rs.getString("description");; 	//产品描述
			 String image1 = rs.getString("image1");;				//图片1
			 String image2 = rs.getString("image2");;				//图片2
			 String image3 = rs.getString("image3");;				//图片3
			
			 product = new Product();
			 product.setProductId(productId_);
			 product.setStoreId(storeId);
			 product.setProductName(productName);
			 product.setPrice(price);
			 product.setCpu(cpu);
			 product.setRam(ram);
			 product.setBrand(brand);
			 product.setScreenSize(screenSize);
			 product.setSize(size);
			 product.setNetworkType(networkType);
			 product.setColor(color);
			 product.setSystem(system);
			 product.setMemory(memory);
			 product.setBattery(battery);
			 product.setBattery(battery);
			 product.setFrontCanmera(frontCanmera);
			 product.setBehindCamera(behindCamera);
			 product.setCoreNum(coreNum);
			 product.setProductScore(productScore);
			 product.setNum(num);
			 product.setWeight(weight);
			 product.setDescription(description);
			 product.setImage1(image1);
			 product.setImage2(image2);
			 product.setImage3(image3);
		}
		
		System.out.println("dao-----product="+product.toString());
		return product;

	}
	
	
}
