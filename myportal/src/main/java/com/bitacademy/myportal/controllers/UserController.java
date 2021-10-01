package com.bitacademy.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateForm() {
		return "/users/updateform";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(@ModelAttribute UserVo vo, HttpSession session) {
		
		int updatedCount = userServiceImpl.updateUser(vo);
		
		if(updatedCount == 1) {
			session.invalidate();
		} else {
			System.out.println("UPDATE 실패!");
		}
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return "/users/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String register(@ModelAttribute UserVo vo) {

		boolean joinSuccess = false;
		try {
			joinSuccess = userServiceImpl.join(vo);
		} catch (UserDaoException e) {
			System.err.println("에러 상황의 userVo : " + e.getUserVo());
			e.printStackTrace();
		}

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
			@RequestParam(value = "password", required = false) String password, HttpSession session) {

		UserVo authUser = userServiceImpl.getUser(email, password);

		if (email.length() == 0 || password.length() == 0) {
			System.out.println("로그인 불가!");
			return "redirect:/user/login";
		} else if (authUser == null) {
			System.out.println("로그인 실패 : 이메일 또는 패스워드 불일치");
			return "redirect:/user/login";
		}
		System.out.println("로그인 성공");
		session.setAttribute("authUser", authUser);
		// Session scope authUser 탑재;
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping(value = "/emailcheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> emailCheck(@RequestBody Map<String, String> json) {

		String email = json.get("email");
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

		UserVo returnedVo = userServiceImpl.getUser(email);

		resultMap.put("result", returnedVo != null);
		return resultMap;
	}

	@ExceptionHandler(UserDaoException.class)
	public String handlerUserDaoException(UserDaoException e, Model model) {

		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		return "errors/exception";
	}
}
