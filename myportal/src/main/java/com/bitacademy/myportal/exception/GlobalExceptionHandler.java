package com.bitacademy.myportal.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handlerExceptoin(Exception e, Model model) {
		
		// 1. 로깅
		e.printStackTrace();
		
		// 2. 데이터 탑재 및 뷰로 줜송
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
	
	
	
	
	
}
