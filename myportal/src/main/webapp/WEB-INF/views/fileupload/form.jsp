<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action='<c:url value="/fileupload/upload" />' enctype="multipart/form-data">
		<label>file:</label>
		<input type="file" name="file1" />
		<input type="submit" value="upload"/>
	</form>
	
	
</body>
</html>