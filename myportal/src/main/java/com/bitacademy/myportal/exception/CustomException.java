package com.bitacademy.myportal.exception;


// 구체적인 예외 상황 기록하가 위해 Rumtime Exception 상속
// 구체적 예외 클래스 사용
public class CustomException extends RuntimeException {
	public CustomException() {
		super("MainControllerException!!");
	}
	
	public CustomException(String message) {
		super(message);
	}
}
