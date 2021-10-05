package com.bitacademy.myportal.repository;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class UserVo {
	private long no; // PRIMARY KEY 반환
	@NotEmpty
	@Length(min = 2, max = 8)
	private String name; // 사용자 이름
	@NotEmpty
	@Email
	private String email; // 사용자 이메일
	@NotEmpty
	@Length(min = 4, max = 20)
	private String password; // 비밀번호
	private String gender; // 성별 정보
	private Date createdAt; // 계정 생성 날짜.

	public UserVo( ) {
		System.out.println(UserVo.class + " : Constructed");
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
}
