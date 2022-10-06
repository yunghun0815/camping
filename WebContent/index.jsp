<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="js/payment.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f15e87f34a476fe8fa135f049ed1d36b&libraries=services"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<head>
<meta charset="UTF-8">
<title>camping shop</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<section class="main">
		<div class="mainBox2 flex">
		 		<div class="weatherBox">
		 			<h1 class="boxTitle">오늘의 날씨</h1>
					<span class="weatherTitle">서울특별시 종로구</span><br>
					<img src="${weatherLink}"><br>
					<span>${weather} / ${temperature} ℃</span>
				</div> 
				<div class="recommend">
					<h1 class="boxTitle">추천 캠핑장</h1>
					<img src="images/sample1.jpg">
					<h2>세인트21 독채 온수풀빌라</h2>
				</div>
		</div>
		<div class="mainMap">
				<h1 class="boxTitle">지역별 캠핑장 보기</h1>
				<a class="seoul" href="campingList.camping?category=서울">서울</a>
				<a href="campingList.camping?category=부산">부산</a>
				<a href="campingList.camping?category=인천">인천</a>
				<a href="campingList.camping?category=울산">울산</a>
				<a href="campingList.camping?category=광주">광주</a>
				<a href="campingList.camping?category=대전">대전</a>
				<a href="campingList.camping?category=대구">대구</a>
				<a href="campingList.camping?category=경기도">경기도</a>
				<a href="campingList.camping?category=강원도">강원도</a>
				<a href="campingList.camping?category=충청도">충청북도</a>
				<a href="campingList.camping?category=충청도">충청남도</a>
				<a href="campingList.camping?category=전라도">전라북도</a>
				<a href="campingList.camping?category=전라도">전라남도</a>
				<a href="campingList.camping?category=경상도">경상북도</a>
				<a href="campingList.camping?category=경상도">경상남도</a>
				<a href="campingList.camping?category=제주도">제주도</a>
				<img src="images/korea.jpg">
			</div>
			<!-- <div class="mainBox1">
				<img src="images/main.png">
			</div> -->
	</section>
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>

