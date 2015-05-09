package com.tour.commons.filter;

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

import com.tour.commons.utils.RJLog;


public class PowerFilter implements Filter {


	public void destroy() {
	    RJLog.debug("-----------------权限过滤器结束-----------------");
	}

	/**
	 * Title: doFilter
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;
		
		hRequest.setCharacterEncoding("UTF-8");
		hResponse.setCharacterEncoding("UTF-8");
		
		String reqURI = hRequest.getRequestURI().replace(hRequest.getContextPath(), "");
		if (reqURI.equals("/index.html") || reqURI.equals("/system/sys_loginValid")) { 
			
		} else if(reqURI.startsWith("/system") 
				|| reqURI.startsWith("/platform") 
				|| reqURI.startsWith("/common")
				|| reqURI.startsWith("/log")){
			
			HttpSession httpSession = hRequest.getSession();
			if (httpSession.getAttribute("userid") == null) {
				hResponse.setCharacterEncoding("UTF-8");
				java.io.PrintWriter out = hResponse.getWriter();
				String msg = "用户未登录";
				out.print("<script>alert('"+msg+"');window.top.location.href='" + hRequest.getContextPath() + "/index.html';</script>");
				out.flush();
				out.close();
			}
		}
		chain.doFilter(request, response);
	}
	
	/**
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		RJLog.debug("-----------------权限过滤器开启-----------------");
	}
}