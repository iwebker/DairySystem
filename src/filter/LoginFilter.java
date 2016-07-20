package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		String path=request.getServletPath();
		System.out.println(path);
		Object user=session.getAttribute("curentUser");
		/*if(user==null&&path.indexOf("bootstrap")<0&&path.indexOf("images")<0&&path.indexOf("index")<0&&path.indexOf("Login")<0){
			response.sendRedirect("index.jsp");			
		}else{
			arg2.doFilter(arg0, arg1);
			
		}*/
		
		if(path.indexOf("Login")>-1){
			arg2.doFilter(arg0, arg1);
			return;
		}
		if(path.indexOf("index")>-1){
			arg2.doFilter(arg0, arg1);
			return;
		}
		if(path.indexOf("bootstrap")>-1){
			arg2.doFilter(arg0, arg1);
			return;
		}
		if(user==null){
			response.sendRedirect("index.jsp");
		}else{
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
