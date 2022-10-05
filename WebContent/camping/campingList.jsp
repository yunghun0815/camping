<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
	.campingImage{
		width: 20px;
	}
</style>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
	<div style="height: 1000px; border: 1px solid black; ">
		<H1>캠핑장 리스트</H1>
		<table border=1>
			<tr>
				<th>번호</th>
				<th>캠핑장 이름</th>
				<th>정보</th>
				<th>가격</th>
				<th>주소</th>
				<th>사진</th>
			</tr>
			
			<c:forEach var="camp" items="${campList}">
				<tr>
					<td><a href="campingDetail.camping?campno=${camp.campingNo}">${camp.campingNo}</a></td>
					<!--? 뒤에 파라미터 -->
					<td>${camp.name}</td>
					<td>${camp.info}</td>
					<td>${camp.price}</td>
					<td>${camp.address}</td>
					<td><img class="campingImage" src="${camp.imgPath}${camp.imgName}"></td>
					<%--vo에 있는 변수명--%>
				</tr>
			</c:forEach>
			</table>
		<a href="campingInsert.camping">캠핑장 등록</a>
	</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>