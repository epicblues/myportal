package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitacademy.myportal.repository.GuestbookDao;
import com.bitacademy.myportal.repository.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	public GuestbookDao guestbookDaoImpl;
	
	@Override
	public List<GuestbookVo> getMessageList() {
		List<GuestbookVo> list = guestbookDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int resultNum = guestbookDaoImpl.insert(vo);
		return resultNum == 1;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		int resultNum = guestbookDaoImpl.delete(vo);
		return resultNum == 1;
	}

}
