<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/item/itemList.css">
<meta charset="UTF-8">
<title>캠핑장비 조회</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ include file="../common/header.jsp"%>

</head>

<body>
	<section class="serv_list">
		<div class="container">
			<div class="title">
				<h1>캠핑장비</h1>
				<ul>
					<li><a href="itemList.item?category=tent">텐트/타프</a></li>
					<li><a href="itemList.item?category=table">테이블/체어</a></li>
					<li><a href="itemList.item?category=sleeping">침낭/매트</a></li>
					<li><a href="itemList.item?category=itemProp">캠핑소품</a></li>
					<a href="itemInsert.item" class="insert_btn">장비 등록</a>
				</ul>
			</div>
			<div class="item_list">
				<c:forEach var="item" items="${itemList }">
					<div class="card">
						<div class="img">
							<a href="itemDetail.item?itemNo=${item.itemNo}"> <img
								class="itemImage" src="${item.imgPath}${item.imgName}">
							</a>
						</div>
						<div class="text">
							<h3>${item.name }</h3>
							<h3><fmt:formatNumber value="${item.price }"/>원</h3>
							<p class="itemInfo">${item.info }</p>
						</div>
					</div>
				</c:forEach>
			</div>
			
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>