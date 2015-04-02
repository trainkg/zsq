/*
 * Author:  peculiar.1@163.com
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.zsq.modelbase.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 提供一个可排除的路径的过滤器代理, 对于一些请求最快的过滤掉
 * @author peculiar.1@163.com
 * @version $ID: ExcludeUrl.java, V1.0.0 2015年4月1日 下午8:00:07 $
 */
public class ExcludeUrlDelegatingFilterProxy extends DelegatingFilterProxy {
	/**
	 * 可排除的路径
	 */
	private String[] excludeUrl;
	/**
	 * 是否采用ANT匹配 , 默认采用简单已...开头匹配
	 */
	private boolean useAnt = false;
	
	private static final String EXCULDE_PARAM_NAME = "exclude";
	/**
	 * 分隔符
	 */
	private static final String EXCULDE_PARAM_SPL = "\\,";
	//private static final AntPathMatcher matcher = new AntPathMatcher();
	
	
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.DelegatingFilterProxy#initFilterBean()
	 */
	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		FilterConfig config = getFilterConfig();
		String exculdePath = config.getInitParameter(EXCULDE_PARAM_NAME);
		if(StringUtils.isNotEmpty(exculdePath)){
			excludeUrl = exculdePath.split(EXCULDE_PARAM_SPL);
		}
	}
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.DelegatingFilterProxy#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		if(excludeUrl != null){
			String url = ((HttpServletRequest)request).getRequestURI();
			String cp = request.getServletContext().getContextPath();
			System.out.println(url);
			for (String pattern : excludeUrl) {
				if(!useAnt){
					System.out.println(url.startsWith(cp+pattern));
					if(url.startsWith(cp+pattern)) return;
				}else{
					throw new RuntimeException("Ant style not impl");
				}
			}
		}
		super.doFilter(request, response, filterChain);
	}
}
