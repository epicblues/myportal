package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.repository.UserVo;

// UserDao에서 SQLException이 발생할 때 전환할 구체적인 Exception
public class UserDaoException extends RuntimeException {

	private UserVo userVo = null;
	
	
	// 구체적 상황 정보
	public UserDaoException() {
		super();
	}
	
	
	public UserDaoException(String message) {
		super(message);
	}
	
	public UserDaoException(String message, UserVo vo) {
		super(message);
		setUserVo(vo);
		
	}


	public UserVo getUserVo() {
		return userVo;
	}


	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
}
