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

import com.tour.commons.utils.RJLog;

public class EncodeFilter implements Filter {

	public void destroy() {
		RJLog.debug("-----------------编码过滤器结束-----------------");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");
		// httpServletRequest.setCharacterEncoding("GBK");
		// httpServletResponse.setCharacterEncoding("GBK");

		chain.doFilter(request, response);
	}

	/*
	 * (非 Javadoc) <p>Title: init</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	public void init(FilterConfig arg0) throws ServletException {
		RJLog.debug("-----------------编码过滤器开启-----------------");
	}

}
