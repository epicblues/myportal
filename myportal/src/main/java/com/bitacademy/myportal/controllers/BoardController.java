package com.bitacademy.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardServiceImpl;
	
	
	@RequestMapping(value="/delete/{no}")
	public String delete(@PathVariable Long no) {
		
		boolean deleteSuccess = boardServiceImpl.delete(no);
		if(deleteSuccess) {
			return "redirect:/board";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVo vo) {
		boolean updateSuccess = boardServiceImpl.update(vo);
		if(updateSuccess) {
			return "redirect:/board/" + vo.getNo();
		}
		return "redirect:/board";
		
	}
	
	@RequestMapping(value="/update/{boardIndex}",method=RequestMethod.GET)
	public String updateForm(@PathVariable Long boardIndex, Model model) {
		
		model.addAttribute("boardNo", boardIndex);
		
		
		return "/board/modify";
	}
	
	
	@RequestMapping("/{boardIndex}")
	public String view(@PathVariable Long boardIndex, Model model) {
		
		BoardVo content = boardServiceImpl.getContent(boardIndex);
		model.addAttribute("content", content);
		
		return "/board/view";
	}
	
	
	@RequestMapping({"/","","/list"})
	public String list(Model model) {
		
		List<BoardVo> list = boardServiceImpl.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	
	//게시물 작성 폼
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		
		// 로그인 된 사용자 인지 확인
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			System.err.println("로그인 사용자가 아닙니다.");
			return "redirect:/user/login";
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
