package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public Connection conn;
	public ResultSet rs;
	public PreparedStatement ps;
	public int i;
	public static String URL="jdbc:mysql://127.0.0.1:3306/db_dairy";
	public static String USER="root";
	public static String PASS="xzp427926";
	
	
	public void getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(PropertyUtil.getValue("URL"),PropertyUtil.getValue("USER"),PropertyUtil.getValue("PASS"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void exeQuery(String sql,Object...obj){
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1,obj[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void exeUpdate(String sql,Object...obj){
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1,obj[i]);
			}
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CloseAll(){
		try {
			if(rs!=null){
				rs.close();	// TODO Auto-generated catch block
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
