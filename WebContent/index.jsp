<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="js/payment.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f15e87f34a476fe8fa135f049ed1d36b"></script>
<head>
<meta charset="UTF-8">
<title>camping shop</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<img src="${weatherLink}"><br>
	<span>오늘의 날씨 : ${weather}</span><br>
	<span>기온 : ${temperature} ℃</span><br>
	<div id="map" style="width:500px;height:400px;"></div>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
	</script>
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
	<select onchange="location.href=(this.value);">
		<option>도별 보기</option>
		<option value="campingList.camping?category=경기도">경기도</option>
		<option value="campingList.camping?category=강원도">강원도</option>
		<option value="campingList.camping?category=충청도">충청도</option>
		<option value="campingList.camping?category=전라도">전라도</option>
		<option value="campingList.camping?category=경상도">경상도</option>
		<option value="campingList.camping?category=제주도">제주도</option>
	</select>
	<section class="main">
		<div style="height: 1000px; border: 1px solid black; ">
			<button onclick="requestPay()" class="payment">결제 테스트</button>
			<input type="hidden" id="payId" value="123">
			<input type="hidden" id="payPrice" value="100">
			<input type="hidden" id="payName" value="${name}">
		</div>
	</section>
	<%@ include file="common/footer.jsp"%>
</body>
</html>

