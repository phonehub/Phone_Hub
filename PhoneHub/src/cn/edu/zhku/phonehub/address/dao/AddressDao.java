package cn.edu.zhku.phonehub.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zhku.phonehub.address.model.Address;
import cn.edu.zhku.phonehub.user.util.ConnectionManager;

public class AddressDao {

	public List<Address> getAddressByUserId(int userId)
			throws ClassNotFoundException, SQLException {
		List<Address> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt;

		String sql = "select * from address_table where userId=?";
		pstmt = ConnectionManager.prepare(conn, sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Address address = new Address();
			if (list == null) {
				list = new ArrayList<Address>();
			}
			address.setAddressId(rs.getInt("addressId"));
			address.setUserId(userId);
			address.setProvince(rs.getString("province"));
			address.setCity(rs.getString("city"));
			address.setDetailAddress(rs.getString("detailAddress"));
			address.setPhone(rs.getString("phone"));
			address.setIfdefault(rs.getInt("ifDefault"));
			address.setReceiver(rs.getString("receiver"));
			list.add(address);
		}
		ConnectionManager.closeAll(rs, pstmt, conn);
		return list;

	}

	public int insert(Address address) throws ClassNotFoundException, // 更新不成功，返回0
			SQLException {
		int result = 1;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt;
		String sql = "insert into address_table (addressId,userId,province,city,detailAddress,phone,ifDefault,receiver) values (null,?,?,?,?,?,?,?)";
		pstmt = ConnectionManager.prepare(conn, sql);

		pstmt.setInt(1, address.getUserId());
		pstmt.setString(2, address.getProvince());
		pstmt.setString(3, address.getCity());
		pstmt.setString(4, address.getDetailAddress());
		pstmt.setString(5, address.getPhone());
		if (address.getIfdefault() != 1)
			pstmt.setInt(6, 0);
		else
			pstmt.setInt(6, 1);
		pstmt.setString(7, address.getReceiver());
		if (pstmt.executeUpdate() == 0)
			result--;
		ConnectionManager.closeAll(null, pstmt, conn);
		return result;
	}

	public int update(Address address) throws ClassNotFoundException, // 更新不成功，返回0
			SQLException {
		int result = 1;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update address_table set province =?,city=?,detailAddress=?,phone=?,ifDefault=?,receiver=?  where userId=? and addressId=?";
		pstmt = ConnectionManager.prepare(conn, sql);
		pstmt.setString(1, address.getProvince());
		pstmt.setString(2, address.getCity());
		pstmt.setString(3, address.getDetailAddress());
		pstmt.setString(4, address.getPhone());
		pstmt.setInt(5, address.getIfdefault());
		pstmt.setString(6, address.getReceiver());
		pstmt.setInt(7, address.getUserId());
		pstmt.setInt(8, address.getAddressId());
		if (pstmt.executeUpdate() == 0)
			result--;
		ConnectionManager.closeAll(null, pstmt, conn);
		return result;

	}

	public int delete(int userId, int addressId) throws SQLException, // 更新不成功，返回0
			ClassNotFoundException {
		int result = 1;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete   from address_table where userId=? and addressId=?";
		pstmt = ConnectionManager.prepare(conn, sql);
		pstmt.setInt(1, userId);
		pstmt.setInt(2, addressId);
		if (pstmt.executeUpdate() == 0)
			result--;
		
		ConnectionManager.closeAll(null, pstmt, conn);
		return result;

	}

}
