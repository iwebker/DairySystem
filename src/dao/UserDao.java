package dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import util.DBUtil;
import util.MD5;
import vo.User;

public class UserDao extends DBUtil {
	public User login(User loginUser) throws UnsupportedEncodingException{
		User user=null;
		super.getConn();
		super.exeQuery("select * from t_user where userName=? and passWord=?",loginUser.getUserName(),MD5.encoderPass(loginUser.getPassWord()));
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
