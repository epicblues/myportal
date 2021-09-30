package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.repository.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;

	@Override
	public boolean join(UserVo vo) {
		int resultNum = userDaoImpl.insert(vo);
		return resultNum == 1;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo selected = userDaoImpl.selectOne(email,password);
		return selected;
	}

	@Override
	public UserVo getUser(String email) {
		
		return null;
	}

}
