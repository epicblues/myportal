package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


// 클래스 상속 방식 : 필요한 메서드만 오버라이드 해서 구현.
public class MyInterceptor2 extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(MyInterceptor2.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor2.preHandle()");
		return true;
	}@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor2.postHandle()");
		
	}@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor2.afterCompletion()");
		
	}
}
