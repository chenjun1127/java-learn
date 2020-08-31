package com.springboot.study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 过滤器
 * @author: chenjun
 * @date: 2020年6月28日 下午5:21:11
 */
@WebFilter(urlPatterns = "/api/testRequest", filterName = "loginFilter")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String id = req.getParameter("id");
		if (id != null && id.equals("1") && !id.isEmpty()) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("/login.html");
		}
	}

}
