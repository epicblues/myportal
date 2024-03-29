package com.bitacademy.myportal.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor.preHandle()");
		// true 반환 -> 다음번 인터셉터 or 컨트롤러를 실행
		// false 반환 -> 다음번 인터셉터 or 컨트롤러 실행하지 않는다.
		return true;
	}
	
	
	// Controller 호출 이후에 요청과 응답을 처리
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,// 실제 URL을 처리할 컨트롤러의 메서드 참조.
			ModelAndView modelAndView) 
					throws Exception {
		// TODO Auto-generated method stub
		logger.debug("My Interceptor.postHandle()");
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.debug("My Interceptor.afterCompletion()");
	}
	
}
