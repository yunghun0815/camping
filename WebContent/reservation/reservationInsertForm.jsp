<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약등록 페이지</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<form action="reservationInsert.res" method="post">
		<input type="hidden" name="campingNo" value="${campingNo}">
		<input type="hidden" name="memberId" value="${id}">
		<input type="hidden" name="reservationDate" value="${reservationDate}">
		<span>캠핑장이름 : 테스트</span><br>
		<span>날짜 : ${reservationDate}</span><br>
		인원 : <input type="number" name="personnel" min="1" max="6" step="1"><br>
		<span>105,000원</span><br>
		<input type="submit" value="예약하기">
	</form>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>