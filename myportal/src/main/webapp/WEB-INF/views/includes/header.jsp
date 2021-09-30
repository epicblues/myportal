<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div id="header">
			<h1><a href="#">My Portal</a></h1>
			<ul>
				<!-- 로그인 안했을 때 -->
				<c:if test="${empty authUser }">
					<li><a href="<c:url value="/user/login" />">로그인</a></li>
					<li><a href="<c:url value="/user/join" />">회원가입</a></li>
				</c:if>
				
				<c:if test="${not empty authUser }">
				<li><a href="#">회원정보수정</a></li>
				<li><a href="<c:url value="/user/logout" />">로그아웃</a></li>
				<li> ${authUser } 님 안녕하세요 ^^;</li>
				</c:if>
				<!-- 로그인 했을 때 -->
				
			</ul>
		</div>