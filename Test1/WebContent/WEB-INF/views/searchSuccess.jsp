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
	<h1>회원정보</h1>
	<table>
	<thead>
		<tr>
			<td>회원번호</td>
			<td>회원아이디</td>
			<td>회원이름</td>
			<td>회원나이</td>
		</tr>
	</thead>
	<c:forEach items="${dto}" var="user" >
	<tbody>
		<tr>
			<td>${dto.userNo}</td>
			<td>${dto.userid}</td>
			<td>${dto.userName}</td>
			<td>${dto.userAge}</td>
		</tr>
	</tbody>
	</c:forEach>
	</table>
	<a href="/index.jsp">메인페이지로 돌아가기</a>
</body>
</html>