package com.norming.servlet.context;

import javax.servlet.ServletContext;

/**
 * ServletContext上下文环境的持有者.
 * @author lh.jia
 * @date 2013.08.14
 *
 */
public class ServletContextHolder {
	
	private static ServletContext servletContext;
	
	public static void setServletContext(ServletContext servletContext) {
		ServletContextHolder.servletContext = servletContext;
	}
	
	public static ServletContext getServletContext() {
		checkServletContext();
		return servletContext;
	}
	
	/**
	 * 清除servletContext静态变量.
	 */
	public static void cleanServletContext() {
		servletContext = null;
	}
	
	public static boolean isContextReady() {
		return servletContext != null;
	}
	
	private static void checkServletContext() {
		if (servletContext == null) {
			throw new IllegalStateException("servletContext未设置");
		}
	}
}