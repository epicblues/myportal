package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		int result = sqlSession.insert("user.registerUser", vo);
		return result;
	}

}
