package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.UserDaoException;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserVo selectOne(String email, String password) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("email", email);
		map.put("password", password);
		
		UserVo selected = sqlSession.selectOne("user.login",map);
		System.out.println(selected);
		return selected;
	}

	@Override
	public int insert(UserVo vo) {
		int result = 0;
		try {
		result = sqlSession.insert("user.registerUser", vo);
		} catch (Exception e) {
			e.printStackTrace();
			// 상황 정보를 담아서 구체적 예외로 전환.
			throw new UserDaoException("회원 가입 중 오류", vo);
		}
		return result;
	}

}
