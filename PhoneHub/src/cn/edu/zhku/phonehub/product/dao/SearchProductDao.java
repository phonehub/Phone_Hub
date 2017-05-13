package cn.edu.zhku.phonehub.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.zhku.phonehub.product.model.Product;
import cn.edu.zhku.phonehub.product.model.SearchProductEntity;
import cn.edu.zhku.phonehub.product.model.SearchProductInfo;

/*
 * 类名：SearchProductDao
 * 功能：在数据库的product_table表中查找商品信息
 * 输入：searchType（店铺/商品名称/品牌）、searchInfo（用户输入的数据）
 * 输出：商品信息
 * 作者：feven
 */
public class SearchProductDao {

	public ArrayList<SearchProductInfo> getProductFromDb(SearchProductEntity searchProductEntity) throws Exception{
		//商品ArrayList
		ArrayList<SearchProductInfo> productList = null;
		
		//连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = null;
		// 通过反射机制动态的引入应用的数据库的驱动
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/phonehub",
				"root", "");
		
		if(searchProductEntity.getSearchType().equals("店铺")){
			sqlQuery = "Select * from searchProduct where storeName like ?";
		}
		else if(searchProductEntity.getSearchType().equals("商品")){
			sqlQuery = "Select * from searchProduct where productName = ?";
		}
		else if(searchProductEntity.getSearchType().equals("品牌")){
			sqlQuery = "Select * from searchProduct where brand like ?";
		}
//		String searchInfo = "%"+searchProductEntity.getSearchInfo()+"%";
//		String searchInfo = "%"+"小米"+"%";
//		String searchInfo = "小米6";
		String searchInfo = new String("小米6".toString().getBytes("UTF-8"));
		System.out.println("dao-------searchInfo="+searchInfo);
		
		ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, searchInfo);
		System.out.println("dao-----ps="+new String(ps.toString().getBytes("UTF-8")));
		rs = ps.executeQuery();
		
		
		while(rs.next()){
			if(productList == null){
				productList = new ArrayList<SearchProductInfo>();
			}
			String productName = rs.getString("productName");		//商品名称
			float price = rs.getFloat("price");						//商品价格
			String storeName = rs.getString("storeName");			//店铺名称
			String brand = rs.getString("brand");					//手机品牌
			String location = rs.getString("location");				//店铺地址
			String storeScore = rs.getString("storeScore");			//店铺评分
			String userName = rs.getString("userName");				//店铺老板名称
			String image1 = rs.getString("image1");					//图片1
			
			SearchProductInfo product = new SearchProductInfo();
			product.setProductName(productName);
			product.setPrice(price);
			product.setStoreName(storeName);
			product.setBrand(brand);
			product.setLocation(location);
			product.setStoreScore(storeScore);
			product.setUserName(userName);
			product.setImage1(image1);
			
			System.out.println("dao----productName="+productName);
			
			productList.add(product);
		}
		System.out.println("dao-----productList="+productList);
		return productList;
	}
}
