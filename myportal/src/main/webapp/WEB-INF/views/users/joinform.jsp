<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입폼</title>
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js" />"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="/css/user.css"/>" />
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>회원 가입</h1>

				<form id="join-form" name="registerForm"
					action='<c:url value="/user/join"/>' method="POST">
					<input type="hidden" name="a" value="join"> <label
						for="name">이름</label> <input name="name" type="text"
						placeholder="이름을 입력하십시오"> <br />
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('name') }">
							<strong style="color: red"> 
							<spring:message code = "${errors.getFieldError('name').codes[0]}" text= "${ errors.getFieldError('name').defaultMessage }"/>
							</strong>
						</c:if>
					</spring:hasBindErrors>
					<br /> <label for="password">비밀번호</label> <input name="password"
						type="password" placeholder="비밀번호를 입력하십시오"><br>
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('password') }">
							<strong style="color: red"> 
	<spring:message code = "${errors.getFieldError('password').codes[0]}" 
	text= "${ errors.getFieldError('password').defaultMessage }"/>
							</strong>
						</c:if>
					</spring:hasBindErrors>
					<br /> <label for="email">이메일</label> <input type="text"
						name="email" placeholder="이메일을 입력하십시오.">

					<button
						onclick="checkEmail(this, '<c:url value="/user/emailcheck" />' );event.preventDefault();">중복
						확인</button>
					<br />
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('email') }">
							<strong style="color: red"> 
		<spring:message code = "${errors.getFieldError('email').codes[0]}" text= "${ errors.getFieldError('email').defaultMessage }"/>
							</strong>
						</c:if>
					</spring:hasBindErrors>
					<br /> <br> <label for="gender">성별</label> <input
						type="radio" name="gender" value="M" checked>남성
					</radio>
					<input type="radio" name="gender" value="F">여성
					</radio>
					<br> <input type="submit" value="전송" disabled />

				</form>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
	<script src="<c:url value="/javascript/users.js" />"></script>
</body>
</html>