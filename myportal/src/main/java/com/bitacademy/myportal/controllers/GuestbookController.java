package com.bitacademy.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.GuestbookVo;
import com.bitacademy.myportal.service.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {

	@Autowired
	GuestbookService guestbookServiceImpl;

	@RequestMapping({ "", "/", "/list" })
	public String list(Model model) {

		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		System.out.println(list);
		model.addAttribute("list", list);

		return "guestbook/list";
	}

	@RequestMapping(value = { "/write" }, method = RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		boolean result = guestbookServiceImpl.writeMessage(vo);
		if (result) {
			return "redirect: /myportal/guestbook/list";
		}

		return "redirect: /myportal";
	}

	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable long no, Model model) {
		model.addAttribute("no", no);
		
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteForm(@ModelAttribute GuestbookVo vo, Model model) {
		
		boolean result = guestbookServiceImpl.deleteMessage(vo);
		
		if(result) {
			return "redirect: /myportal/guestbook/list";
		}
		model.addAttribute("result", "FAILED! PASSWORD ERROR!");
		return "redirect:/guestbook/delete/" + vo.getNo();
	}
}
