package cn.ahut.core.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}



	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String uri = request.getRequestURI();
		//判断当前请求地址是否是登录的请求地址
		if(!uri.contains("sys/login.jsp")){
			//非登录请求
			if(request.getSession().getAttribute("info") != null){
				//说明已经登录过
				
						chain.doFilter(request, response);
					}else {
						//没有登录，跳转到登录页面
						response.sendRedirect(request.getContextPath() + "/login.jsp");
					
				
					}
		}else {chain.doFilter(request, response);}
		
	}	
	
	@Override
	public void destroy() {
	}
	
}
