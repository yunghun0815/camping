<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="js/payment.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f15e87f34a476fe8fa135f049ed1d36b&libraries=services"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 카카오맵 -->
	<div id="map" style="width:500px;height:400px;"></div>

	<!-- 카테고리 분류 -->
	<select onchange="if(this.value)location.href=(this.value);">
		<option>광역시별 보기</option>
		<option value="campingList.camping?category=서울">서울</option>
		<option value="campingList.camping?category=부산">부산</option>
		<option value="campingList.camping?category=인천">인천</option>
		<option value="campingList.camping?category=울산">울산</option>
		<option value="campingList.camping?category=광주">광주</option>
		<option value="campingList.camping?category=대전">대전</option>
		<option value="campingList.camping?category=대구">대구</option>
	</select>
	<select onchange="if(this.value)location.href=(this.value);">
		<option>도별 보기</option>
		<option value="campingList.camping?category=경기도">경기도</option>
		<option value="campingList.camping?category=강원도">강원도</option>
		<option value="campingList.camping?category=충청도">충청도</option>
		<option value="campingList.camping?category=전라도">전라도</option>
		<option value="campingList.camping?category=경상도">경상도</option>
		<option value="campingList.camping?category=제주도">제주도</option>
	</select>
	
	<!-- 결제  -->
		<div style="height: 1000px; border: 1px solid black; ">
			<button onclick="requestPay()" class="payment">결제 테스트</button>
			<input type="hidden" id="payId" value="123">
			<input type="hidden" id="payPrice" value="100">
			<input type="hidden" id="payName" value="${name}">
		</div>
</body>
</html>