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
