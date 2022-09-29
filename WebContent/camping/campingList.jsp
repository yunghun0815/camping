<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<H1>캠핑장 리스트</H1>
	<table border=1>
		<tr>
			<th>번호</th>
			<th>캠핑장 이름</th>
			<th>정보</th>
			<th>가격</th>
			<th>주소</th>
			<th>사진 경로</th>
			<th>사진 이름</th>
		</tr>
		
		<c:forEach var="camp" items="${campList}">
			<tr>
				<td><a href="campingDetail.camping?campno=${camp.campingNo}">${camp.campingNo}</a></td>
				<!--? 뒤에 파라미터 -->
				<td>${camp.name}</td>
				<td>${camp.info}</td>
				<td>${camp.price}</td>
				<td>${camp.address}</td>
				<td>${camp.imgPath}</td>
				<td>${camp.imgName}</td>
				<%--vo에 있는 변수명--%>
			</tr>
		</c:forEach>
		</table>
	<a href="campingInsert.camping">캠핑장 등록</a>
</body>
</html>