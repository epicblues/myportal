<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="/css/guestbook.css"/>" />
</head>
<body>
<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<div id="wrapper">
			<div id="content">
	<c:if test="${not empty result}">
  		<h1 style="color:red;">${result }</h1>
  	 </c:if>
	<form method="post"
		action="<c:url value="/guestbook/delete" />">
		<input type='hidden' name="no" value="${no }"> 
		<label
			for="password">비밀번호</label>
		<input type="password" name="password">
		<input type="submit" value="확인"><br> 
		<a href="<c:url value="/guestbook" />">목록
			보기</a>
	</form>
		</div>
		</div>
		<%@ include file = "/WEB-INF/views/includes/footer.jsp" %>
	</div>
</body>
</html>