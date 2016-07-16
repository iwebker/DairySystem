package dao;

import java.sql.SQLException;

import util.DBUtil;
import vo.User;

public class UserDao extends DBUtil {
	public User login(User loginUser){
		User user=null;
		super.getConn();
		super.exeQuery("select * from t_user where userName=? and passWord=?",loginUser.getUserName(),loginUser.getPassWord());
		try {
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.CloseAll();
		return user;
	}
}
