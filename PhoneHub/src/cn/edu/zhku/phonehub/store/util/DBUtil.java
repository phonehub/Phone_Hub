package cn.edu.zhku.phonehub.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * jdbc工具类
 */
public class DBUtil{
	
	private static String url = "jdbc:mysql://localhost:3306/phonehub?useUnicode=true&characterEncoding=utf-8";
    
    private static String user = "root";
    
    private static String password = "citypark";
    
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    
    static{
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public Connection getConnection(){
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public PreparedStatement getPreparedStatement(String sql){
		
			try {
				pstmt=getConnection().prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pstmt;
	}
	
	
	public void setParams(String sql,String[] params){
		pstmt=this.getPreparedStatement(sql);
		for(int i=0;i<params.length;i++){
			try {
				pstmt.setString(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public List getList(String sql,String[] params){
		List list = new ArrayList();
		try{
			this.setParams(sql, params);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				Map m = new HashMap();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String colName = rsmd.getColumnName(i);
					m.put(colName, rs.getString(colName));
				}
				list.add(m);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	public List getList(String sql,Object[] params){
		List list = new ArrayList();
		try{
			this.setParams(sql, params);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				Map m = new HashMap();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String colName = rsmd.getColumnName(i);
					m.put(colName, rs.getString(colName));
				}
				list.add(m);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	
	public Map getMap(String sql,String[] params){
		List list = getList(sql,params);
		if(list.isEmpty())
			return null;
		else
			return (Map)list.get(0);
	}
	
	public int update(String sql,String[] params){
		int recNo = 0;
		try{
			setParams(sql,params);
			recNo = pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return recNo;
	}
	
	public void close(){
		try{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setParams(String sql,Object[] params){
		pstmt=this.getPreparedStatement(sql);
		for(int i=0;i<params.length;i++){
			try {
				pstmt.setObject(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int update(String sql,Object[] params){
		int recNo = 0;
		try{
			setParams(sql,params);
			recNo = pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return recNo;
	}

}
