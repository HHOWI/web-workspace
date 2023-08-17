<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	body {
		text-align: center;
	}

	.item {
		display: inline-block;
		margin : 10px;
		text-align: left;
	}
	
	img {
		width: 150px;
		height: 150px;
		object-fit: cover;
	}
</style>
</head>
<body>
	<h1>Fruit Total List</h1>
	
	<c:forEach items="${list}" var="item">
		<div class="item">
			<a href="itemView.do?id=${item.itemId}"><img src="${item.pictureUrl}"></a><br>
			<span>상품명 : ${item.itemName}</span><br>
			<span>가격 : ${item.price}원</span>
		</div>
	</c:forEach>
	
	
	<c:if test="${not empty fruits}">
	<hr>
	<h2>오늘 본 상품들</h2>
	
	<c:forEach items="${fruits}" var="img">
		<img src="${img}">
	</c:forEach>
	</c:if>
</body>
</html>