package com.bitacademy.myportal.repository;

import java.util.Date;

public class BoardVo {
	private long no; // PK
	private String title;
	private String content;
	private long hit; // 조회수 필드
	private Date regDate;
	private long userNo;// 유저 테이블의 PK (Foreign Key)
	private String userName;

	public BoardVo() {
		super();
	}

	public BoardVo(String title, String content, long userNo) {
		this.title = title;
		this.content = content;
		this.userNo = userNo;

	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getHit() {
		return hit;
	}

	public void setHit(long hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public long getUserNo() {
		return userNo;
	}

	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BoardVo(long no, String title, long hit, Date regDate, long userNo, String userName) {
		this.no = no;
		this.title = title;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}

	public BoardVo(long no, String title, String content, long hit, Date regDate, long userNo, String userName) {
		this(no, title, hit, regDate, userNo, userName);
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
				+ regDate + ", userNo=" + userNo + ", userName=" + userName + "]";
	}
	
	

}
