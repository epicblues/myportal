package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.repository.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDaoImpl;
	
	@Override
	public List<BoardVo> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo getContent(long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean write(BoardVo vo) {
		int insertedCount = boardDaoImpl.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public boolean update(BoardVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
