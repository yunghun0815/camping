<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	main{
		width: 1300px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<main>
		<a href="reservationList.res">예약하기</a>
		<a href="reservationList.res?campingNo=1">KCC 예약페이지</a>
		<a href="reservationDetail.res?memberId=${id}">내 예약 목록</a>
	</main>
	<%@ include file="common/footer.jsp"%>
	<a href="signup.member">회원가입</a>
	<a href="itemList.item">캠핑장비 조회</a>
	<a href="campingList.camping">캠핑 리스트</a>
</body>
</html>

