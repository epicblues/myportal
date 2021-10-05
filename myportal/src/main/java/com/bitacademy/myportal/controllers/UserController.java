package com.bitacademy.myportal.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

	// 로거 세팅
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	
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
		logger.debug("회원가입");
		return "/users/joinform";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String register(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		logger.debug("가입폼으로부터 전송된 데이터 : " + vo);
		
		if(result.hasErrors()) { // 검증이 실패
			// 에러 목록 받아오기(검증 실패한 오류의 목록 확인)
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				logger.error("검증에러" + error);
			}
			
			// 에러 정보를 모델에 적재
			model.addAllAttributes(result.getModel());
			return "/users/joinform";
		}
		
		boolean joinSuccess = false;
		try {
			joinSuccess = userServiceImpl.join(vo);
		} catch (UserDaoException e) {
		
			logger.error("에러 상황의 UserVo : " + vo);
			e.printStackTrace();
		}

		if (joinSuccess) {
			logger.debug("가입 성공!");
			return "/users/joinsuccess";
		}
		logger.debug("가입 실패");
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
			logger.error("로그인 불가능. 데이터 입력 필요");
			return "redirect:/user/login";
		} else if (authUser == null) {
			logger.error("로그인 실패 : 이메일 또는 패스워드 불일치");
			return "redirect:/user/login";
		}
		logger.error("로그인 성공");
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
