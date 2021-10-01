package com.bitacademy.myportal.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardServiceImpl;
	
	@RequestMapping({"/","","/list"})
	public String list(Model model) {
		
		return "board/list";
	}
	
	
	//게시물 작성 폼
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		
		// 로그인 된 사용자 인지 확인
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			System.err.println("로그인 사용자가 아닙니다.");
			return "redirect:/";
		} return "board/write";
		
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeForm(@ModelAttribute BoardVo boardVo, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser == null) {
			return "redirect:/";
		}
		boardVo.setUserNo(authUser.getNo());
		boardServiceImpl.write(boardVo);
		
		return "redirect:/board/list";
	}
}
