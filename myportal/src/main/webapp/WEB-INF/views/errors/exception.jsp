<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wrapper">
			<div id="content">
				<h1>Exception</h1>
				<h2>오류가 발생했습니다.</h2>
				<p>예외 이름 : ${name}</p>
				<p>예외 메시지 : ${message }</p>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>