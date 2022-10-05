<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="js/payment.js"></script>
<link rel="stylesheet" type="text/css" href="css/reservation/reservationInsertForm.css">
<head>
<meta charset="UTF-8">
<title>예약등록 페이지</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div>
			<h1>${campNo}</h1>
			<form action="reservationInsert.res" method="post">
				<input id="no" type="hidden" name="campingNo" value="${campingNo}">
				<input id="id" type="hidden" name="memberId" value="${id}">
				<input type="hidden" name="reservationDate" value="${reservationDate}">
				<input id="name" type="hidden" value="${camping.name}">
				<table>
					<tr>
						<td>이름</td>
						<td>${camping.name}</td>
					</tr>
					<tr>
						<td>날짜</td>
						<td>${reservationDate}</td>
					</tr>
					<tr>
						<td>인원</td>
						<td><input type="number" name="personnel" min="1" max="6" step="1" value="1"></td>
					</tr>
					<tr>
						<td>가격</td>
						<td><fmt:formatNumber value="${camping.price}"/>원</td>
					</tr>
					<tr>
						<td colspan="2"><span class="reservationBtn" onclick="requestPay2()">예약하기</span></td>
					</tr>
				</table>
				<!-- <input type="submit" value="예약하기"> -->
			</form>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>