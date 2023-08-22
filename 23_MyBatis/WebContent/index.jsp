<%@page import="model.service.StudentService"%>
<%@page import="model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<StudentVO> student = new StudentService().search(null);
request.setAttribute("student", student);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>

	<input id="word" type="text" name="word">
	<input id="searchBtn" type="submit" value="검색">

	<table border="1">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>주소</th>
				<th>학과</th>
				<th>계열</th>
			</tr>
		</thead>
		<hr>
		<tbody>
			<c:forEach items="${student}" var="item">
				<tr>
					<td>${item.studentNO}</td>
					<td>${item.studentName}</td>
					<td>${item.studentAddr}</td>
					<td>${item.department.departmentName}</td>
					<td>${item.department.category}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>


	<script>
	$('#searchBtn').click(function(){
		const word = $('#word').val();
		$.ajax({
			type: 'get',
			url: 'search.do',
			data: 'word='+word,
			dataType: 'json', 
			
			success:function(data) {
				const result = eval(data.result);
				let resultHtml = '';
				for(let item of result) {
					resultHtml += "<tr>" + 
									"<td>" + item.studentNO + "</td>" +
									"<td>" + item.studentName + "</td>" +
									"<td>" + item.studentAddr + "</td>" +
									"<td>" + item.department.departmentName + "</td>" +
									"<td>" + item.department.category + "</td>" +
									"</tr>";
				}
				$('tbody').html(resultHtml);
			}
		});
	});
</script>
</body>
</html>