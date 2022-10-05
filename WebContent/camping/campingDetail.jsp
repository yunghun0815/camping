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
<link rel="stylesheet" type="text/css" href="css/camping/campingDetail.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".Button3").click(function(){
			var check = confirm('정말로 삭제하시겠습니까?');
			if(check == true){
				$("form").submit();
				alert("삭제가 완료되었습니다");
			}
		});
	});
</script>
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
						<a href="reservationList.res?campingNo=${camp.campingNo}"class="Button1">예 약</a>
						</div>
						<c:if test="${id eq 'admin'}">
							<div class="buttonBox">
								<div class="box4">
								<a href="campingUpdate.camping?campno=${camp.campingNo}"class="Button2">수 정</a>
								</div>
							
								<div class="box4">
								<form action="campingDelete.camping" method="post">
									<input type="hidden" name="campno" value="${camp.campingNo}">
									<span class="Button3">삭 제</span>
								</form>
								</div>
							</div>
						</c:if>
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