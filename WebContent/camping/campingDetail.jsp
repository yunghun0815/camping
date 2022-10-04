<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.myButton {
	box-shadow: inset 0px 1px 0px 0px #90c8ac;
	background: linear-gradient(to bottom, #90c8ac 5%, #90c8ac 100%);
	background-color: #90c8ac;
	border-radius: 4px;
	border: 1px solid #90c8ac;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 18px;
	font-weight: bold;
	padding: 6px 270px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #90c8ac;
}

.myButton:hover {
	background: linear-gradient(to bottom, #90c8ac 5%, #90c8ac 100%);
	background-color: #90c8ac;
}

.myButton:active {
	position: relative;
	top: 1px;
}
 .font { 
  font-size: xxx-large; 
  margin-top: 20px;
  margin-bottom: 20px;
  }
.box{
	position: relative;
}
.box1 {
    display: inline-block;
}
.box2 {
    display: inline-block;
    position: absolute;
    top: 1px;
    margin-left: 40px;
    
}
.service{
	margin-top: 10px;
    margin-bottom: 10px;
}
.serviceList{
	list-style: none;
	float: left;
	margin: auto;
	margin-left: 20px;
	align-items: center;
	text-align : center;	
}
.line{
    border-bottom: 0.2rem solid #f2f2f2;
    width: 600px;
}
.box3{
	margin-top: 20px;
	margin-bottom: 20px;
}
.box4{
	margin-top: 30px;
	margin-bottom: 44px;
}
</style>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div>
			<c:if test="${not empty camp}">
				<div class="box">
					<div class="box1">
						<!--<img src="${camp.imgPath}${camp.imgName}">  -->
						<img src="images/1.png" width="650px" height="650px">
					</div>
					
					<div class="box2">
						<h2><p class="font">${camp.name}</p></h2>
						${camp.address} <br>
						<fmt:formatNumber value="${camp.price}" type="currency" var="price" />
						<h3>${price}/박</h3>
					
						<div style="height: 190px">	
							<div class="line"></div>
							<div> 
								<h2 class="service">인기시설 서비스</h2>
							</div>
					
							<div style="margin-left: -48px">
								<ul>
									<li class="serviceList">
										<img src="images/주차.png"><br>
										<div>주차가능</div>
									</li>
									<li class="serviceList">
										<img src="images/수영장.png"> 
										<div>수영장</div>
									</li>
									<li class="serviceList">
										<img src="images/와이파이.png"> 
										<div>와이파이</div>
									</li>
									<li class="serviceList">
										<img src="images/바베큐.png"> 
										<div>바베큐</div>
									</li>
									<li class="serviceList">
										<img src="images/매점.png"> 
										<div>매점</div>
									</li>
									<li class="serviceList">
										<img src="images/글램핑.png"> 
										<div>글램핑</div>
									</li>
								</ul>
							</div>
						</div>		
						<div class="line"></div>
								
						
				
						<div class="box3">${camp.info}</div>
						<!--<a href="campingUpdate.camping?campno=${camp.campingNo}">수정</a> -->
						
						<div class="line"></div>
						
						<div class="box4">
						<a href="reservationList.res?campingNo=${camp.campingNo}"class="myButton">예 약</a>
						</div>
						
					</div>
				</div>
			</c:if>

			<c:if test="${empty camp.campingNo}">
				캠핑 정보가 없습니다.
			</c:if>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>