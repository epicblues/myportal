package com.bitacademy.myportal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private UserService userServiceImpl;
	
	
	
	// 핵심 responsebody가 필요 없다!
	@RequestMapping(value = "/user/emailcheck", method = RequestMethod.POST)
	public Map<String, Boolean> emailCheck(@RequestBody Map<String, String> json) {

		String email = json.get("email");
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

		UserVo returnedVo = userServiceImpl.getUser(email);
	
		resultMap.put("result", returnedVo != null);
		return resultMap;
	}
}
