package com.bitacademy.myportal.repository;

public interface UserDao {
	public UserVo selectOne(String email, String password);
	public int insert(UserVo vo);
}
