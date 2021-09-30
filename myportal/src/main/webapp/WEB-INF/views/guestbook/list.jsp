<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/javascript/jquery/jquery-3.6.0.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
<meta charset="UTF-8">
<title>My Homepage</title>
</head>
<body>
  
  <c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
  <c:import url="/WEB-INF/views/includes/navigation.jsp"/>
	<h1>방명록</h1>
	<form action='<c:url value="/guestbook/write"/>' 
			method="POST">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>

	
	<table width=510 border=1>
		<c:forEach items="${list }" var="vo" varStatus="status">
			<tr>
			<td>[${vo.no }]</td>
			<td>${vo.name }</td>
			<td>${vo.regDate }</td>
			<td>
				<!-- 수정 -->
				<a href="<c:url value="/guestbook/delete/${vo.no }" />">
					삭제
				</a>
			</td>
		</tr>
		<tr>
			<td colspan=4>${vo.content}</td>
		</tr>
		
		</c:forEach>
		
	</table>
    <c:import url="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>