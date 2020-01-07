package com.alice.photo.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

	public void destroy() {
	

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("user")!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect("login.html");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
