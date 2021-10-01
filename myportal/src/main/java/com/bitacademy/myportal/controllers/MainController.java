package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.myportal.exception.CustomException;

@Controller
public class MainController {
	
	
	@RequestMapping({"/home", "/"}) 
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home"); // Setting한 ViewResolver의 Prefix Suffix를 조합해서 정확한 URL을 만들어 준다.
		return mav;
	}
	
	// 테스트용 예외 강제 발생
	
	@RequestMapping("/except")
	@ResponseBody
	public String except() {
		// Runtime Exception 으로 전환
		// -> 보다 구체적으로 구현한 Runtime Exception 자식 객체로 전환하는 것이 바람직
		try {
			int result = 4 / 0; 
		} catch (Exception e) {
			throw new CustomException("Main Controller Error");
		}
		

		return "Exception Test";
	}
	
	// Controller의 예외 처리 v1
	// 컨트롤러 내부에서 발생하는 모든 예외를 여기서 일괄 처리한다.
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public String handleControllerException(Exception e) {
//		return "Exception : " + e.getMessage();
//	}
//	
	
	// Controller의 예외 처리 v2
//	@ExceptionHandler(RuntimeException.class)
//	public String handleControllerException(RuntimeException e, Model model) {
//		model.addAttribute("name", e.getClass().getSimpleName());
//		model.addAttribute("message", e.getMessage());
//		
//		return "errors/exception";
//	}
	
	// Controller의 예외 처리 v3
	@ExceptionHandler(CustomException.class)
	public String handleControllerException(CustomException e, Model model) {
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
