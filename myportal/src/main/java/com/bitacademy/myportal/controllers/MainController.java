package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
	@RequestMapping({"/home", "/"}) ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home"); // Setting한 ViewResolver의 Prefix Suffix를 조합해서 정확한 URL을 만들어 준다.
		return mav;
	}
}
