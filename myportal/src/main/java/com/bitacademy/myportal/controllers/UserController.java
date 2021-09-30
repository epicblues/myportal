package com.bitacademy.myportal.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return "/users/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String register(@ModelAttribute UserVo vo) {

		boolean joinSuccess = userServiceImpl.join(vo);
		if (joinSuccess) {
			return "/users/joinsuccess";
		}

		return "redirect:/user/join";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {

		return "/users/loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password,
			HttpSession session) {

		UserVo authUser = userServiceImpl.getUser(email, password);

		if (email.length() == 0 || password.length() == 0) {
			System.out.println("로그인 불가!");
			return "redirect:/user/login";
		} else if (authUser == null) {
			System.out.println("로그인 실패 : 이메일 또는 패스워드 불일치");
			return "redirect:/user/login";
		}
		System.out.println("로그인 성공");
		session.setAttribute("authUser", authUser.getName());
		// Session scope authUser 탑재;
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
