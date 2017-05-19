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
		//�жϵ�ǰ�����ַ�Ƿ��ǵ�¼�������ַ
		if(!uri.contains("sys/login.jsp")){
			//�ǵ�¼����
			if(request.getSession().getAttribute("info") != null){
				//˵���Ѿ���¼��
				
						chain.doFilter(request, response);
					}else {
						//û�е�¼����ת����¼ҳ��
						response.sendRedirect(request.getContextPath() + "/login.jsp");
					
				
					}
		}else {chain.doFilter(request, response);}
		
	}	
	
	@Override
	public void destroy() {
	}
	
}
