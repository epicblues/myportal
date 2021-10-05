package com.bitacademy.myportal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal.repository.UserVo;

// 컨트롤러에서 요청을 가로채서 필요한 경우 로그인 페이지로 전송
public class AuthInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("AuthInterceptor");
		// 세션 체크
		HttpSession session = request.getSession();
		// 로그인 사용자 체크
		UserVo authUser=null;
		if(session != null) {
			// session에서 로그인 사용자 정보 확인.
			authUser = (UserVo)session.getAttribute("authUser");
			if(authUser == null) {
				// 로그인 사용자 아님
				// 로그인 페이지로 리다이렉트
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}
		
		// 로그인 사용자
		return true;// 컨트롤러로 요청을 전달한다.
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
