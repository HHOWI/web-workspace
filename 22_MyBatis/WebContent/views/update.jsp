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
	<form action="/update.do" method="post">
		ID : <input type="text" name="id" value="${vo.id}" readonly><br>
		PASSWORD : <input type="password" name="pwd" value="${vo.pwd}"><br>
		NAME : <input type="text" name="name" value="${vo.name}"><br>
		ADDRESS : <input type="text" name="addr" value="${vo.addr}"><br>
		<input type="submit" value="정보 수정">
		
	</form>
	<hr>	
	<h2>비밀번호만 변경</h2>
	<form action="/update.do" method="post">
		ID : <input type="text" name="id" value="${vo.id}" readonly><br>
		PASSWORD : <input type="password" name="pwd" value="${vo.pwd}"><br>
		<input type="submit" value="정보 수정">
		
	</form>
</body>
</html>