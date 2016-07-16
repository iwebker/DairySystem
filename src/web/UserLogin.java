package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao ud=new UserDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
		HttpSession session=request.getSession();
		
		
		User loginUser=new User(userName,passWord);
		User curentUser=ud.login(loginUser);
		if(curentUser==null){
			//Login Failed(登录失败)
			request.setAttribute("name", userName);
			request.setAttribute("pass", passWord);
			request.setAttribute("error","用户名或密码错误");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			//Login Success(登录成功)
			session.setAttribute("curentUser", curentUser);
			response.sendRedirect("main.jsp");
		}
	}

}
