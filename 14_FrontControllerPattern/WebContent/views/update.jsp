<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보수정</h2>
	<hr>
	<form action="/front.do" method="post">
		<input type="hidden" name="command" value="update">
	
		ID : <input type="text" name="id" value="${vo.id}" readonly><br>
		PASSWORD : <input type="password" name="pwd" value="${vo.pwd}"><br>
		NAME : <input type="text" name="name" value="${vo.name}"><br>
		ADDRESS : <input type="text" name="addr" value="${vo.addr}"><br>
		<input type="submit" value="정보 수정">
		
	</form>
		
	
</body>
</html>