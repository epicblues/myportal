package com.bitacademy.myportal.repository;

import java.util.Date;

public class GuestbookVo {
	private long no; // PRIMARY KEY
	private String name; // 이름
	private String password; //비밀번호
	private String content; // 게시물 정보
	private Date regDate; // 등록 날짜
	
	public GuestbookVo() { // POJO 클래스는 기본 생성자가 반드시 있어야 한다.
		super();
	}
	
	// 삭제할 때 통신할 데이터
	public GuestbookVo(long no, String password) {
		this.no = no;
		this.password = password;
	} 
	
	// 작성 정보 생성자
	public GuestbookVo(String name, String password, String content) {
		this.name = name;
		this.password = password;
		this.content = content;
		
	}

	// 전체 필드 초기화 생성자
	public GuestbookVo(long no, String name, String password, String content, Date regDate) {
		this(name,password,content);
		this.no = no;
		this.regDate = regDate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}
