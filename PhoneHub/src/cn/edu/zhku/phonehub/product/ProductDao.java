package cn.edu.zhku.phonehub.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.phonehub.util.DB;

public class ProductDao {

	public void add(Product p) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConnection();
			String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?)";
			pstmt = DB.prepare(conn, sql);
			pstmt.setString(1, p.getProductName());
			pstmt.setFloat(2, p.getPrice());
			pstmt.setString(3, p.getCpu());
			pstmt.setString(4, p.getRam());
			pstmt.setString(5, p.getBrand());
			pstmt.setString(6, p.getScreenSize());
			pstmt.setString(7, p.getSize());
			pstmt.setString(8, p.getNetworkType());
			pstmt.setString(9, p.getColor());
			pstmt.setString(10, p.getSystem());
			pstmt.setString(11, p.getMemory());
			pstmt.setString(12, p.getBattery());
			pstmt.setString(13, p.getFormCamera());
			pstmt.setString(14, p.getBehindCamera());
			pstmt.setInt(15, p.getCoreNum());
			pstmt.setInt(16, p.getStoreId());
			pstmt.setFloat(17, p.getProductScore());
			pstmt.setInt(18, p.getNum());
			pstmt.setString(19, p.getWeight());
			pstmt.setString(20, p.getDescribe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
		}
	}

	public void delete(int id) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		String sql;
		try {
			conn = DB.getConnection();
			sql = "delete from product where id = " + id;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} finally {
			conn.close();
			stmt.close();
		}
	}

	public List<Map<String, String>> getProductsByBrand(String brand)
			throws Exception { // 参数可为品牌,或者为all ,返回map类型的list

		Connection conn = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		PreparedStatement pstmt = null;
		try {
			String sql;
			conn = DB.getConnection();
			if (brand.equals("all")) {

				sql = "select * from product ";
				pstmt = DB.prepare(conn, sql);

			} else {
				sql = "select * from product where brand = ?";
				pstmt = DB.prepare(conn, sql);
				pstmt.setString(1, brand);
			}

			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd;
			rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colName = rsmd.getColumnName(i);
					map.put(colName, rs.getString(colName));
				}
				list.add(map);

			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;

	}
}