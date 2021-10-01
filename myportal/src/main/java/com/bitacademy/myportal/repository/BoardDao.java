package com.bitacademy.myportal.repository;

import java.util.List;

public interface BoardDao {
	public List<BoardVo> selectAll();  // 리스트 출력을 위한 SELECT 
	public int insert(BoardVo boardVo); // 게시물 작성 insert
	
	// 이것들은 과제
	public BoardVo getContent(Long no); // 게시물 조회 select
	public int update(BoardVo boardVo); //게시물 수정 UPDATE
	public int delete(Long no);	//게시물 삭제 DELETE
}
