package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.repository.BoardVo;

public interface BoardService {
	public List<BoardVo> getList(); // 게시판 목록 불러오기
	public BoardVo getContent(long no); // 게시물 조회
	public boolean write(BoardVo vo); // 게시물 작성 기능
	public boolean update(BoardVo vo); // 게시물 수정 기능
	public boolean delete(long no); //게시물 삭제 기능
	
}
