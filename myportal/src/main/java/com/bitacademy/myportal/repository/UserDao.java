package com.bitacademy.myportal.repository;

public interface UserDao {
	public UserVo selectOne(String email, String password);
	public UserVo selectOne(String email);
	public int insert(UserVo vo);
	public int update(UserVo vo);
}
