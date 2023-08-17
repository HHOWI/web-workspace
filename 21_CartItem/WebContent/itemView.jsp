<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		text-align: center;
	}
	#menu {
		text-align: right;
	}
	span {
		margin: 30px;
	}
	.container {
        display: flex;
        align-items: center; /* 아이템들을 수직으로 가운데 정렬 */
    }
    #info {
        display: flex; /* 내부 span들을 수직으로 정렬하기 위해 flex 사용 */
        flex-direction: column; /* 수직 방향으로 정렬 */
        justify-content: center; /* 수직 방향 가운데 정렬 */
        margin-left: 30px;
    }
	
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h1>${item.itemName}의 정보</h1>
	
	<div id="menu">
		<span>조회수 : ${item.count} </span>
		<button id="cartInsert" data-id="${item.itemId}" value="${item.itemName},${item.price},${item.pictureUrl}" >장바구니 담기</button>
		<a href="cartList.jsp">장바구니 확인</a>
		<a href="itemList.do">상품 목록 보기</a>
	</div>
	
	<div class="container">
		<img src="${item.pictureUrl}">
		<div id="info">
			<p>종류 : ${item.itemName}</p>
			<p>가격 : ${item.price}</p>
			<p>설명 : ${item.description}<p>
		</div>
	</div>
	
	<script>
		$('#cartInsert').click(function() {
			localStorage.setItem('cart-'+$(this).attr('data-id'),$(this).val());
			//alert('장바구니에 담겨졌습니다!');
		});
	</script>
</body>
</html>