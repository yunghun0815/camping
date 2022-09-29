<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장비 조회</title>
</head>
<body>
<style>
	.itemImage{
		width: 20px;
	}
</style>
<table border=1>
	<tr>
		<th>장비 번호</th>
		<th>장비 이름</th>
		<th>장비 가격</th>
		<th>장비 설명</th>
		<th>사진</th>
	</tr>
<c:forEach var="item" items="${itemList }">
	<tr>
		<td><a href="itemDetail.item?itemNo=${item.itemNo}">${item.itemNo }</a></td>
		<td>${item.name }</td>
		<td>${item.price }</td>
		<td>${item.info }</td>
		<td><img class="itemImage" src="${item.imgPath}${item.imgName}"></td>
	</tr>
</c:forEach>
</table>
	<a href="itemInsert.item">캠핑장비 등록</a>
</body>
</html>