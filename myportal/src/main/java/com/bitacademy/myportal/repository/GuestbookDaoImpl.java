package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class GuestbookDaoImpl implements GuestbookDao {

	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = null;
		list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int result = sqlSession.insert("guestbook.write",vo);
		
		return result;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int result = sqlSession.delete("guestbook.delete",vo);
		return result;
	}

}
