<%@page import="servlet.model.vo.MemberDTO"%>
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
	<h1>회원 검색 결과</h1>
	<ul>
		<li>아이디 : ${vo.id}</li>
		<li>이름 : ${vo.name}</li>
		<li>주소 : ${vo.addr}</li>
	</ul>
	<a href="/index.jsp">첫 페이지로 이동</a>
</body>
</html>