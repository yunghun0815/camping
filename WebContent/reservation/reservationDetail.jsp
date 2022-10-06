<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/reservation/reservationDetail.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<head>
<meta charset="UTF-8">
<title>내 예약목록</title>
</head>
<script type="text/javascript">
		
	$(function(){
		$(".delete").click(function(){
			var check = confirm('정말로 취소하시겠습니까?');
			if(check == true){
				$("form").submit();
				alert("취소가 완료되었습니다.");	
			}
		});
		
	});
</script>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<c:if test="${list.size() > 0}">
			<h1>${name}님께서 예약하신 목록입니다.</h1>
		</c:if>
		<c:if test="${list.size() == 0}">
			<h1 class="no">예약하신 정보가 없습니다.</h1>
		</c:if>
		<c:if test="${list.size() > 0}">
			<table>
				<tr>
					<!-- <th>사진</th> -->
					<th>이름</th>
					<th>주소</th>
					<th>가격</th>
					<th>예약날짜</th>
					<th>인원</th>
					<th></th>
				</tr>
				<c:forEach items="${list}" var="result">
					<tr>
						<%-- <td><img src="${result.imgPath}${result.imgName}"></td> --%>
						<td>${result.name}</td>
						<td>${result.address }</td>
						<td><fmt:formatNumber value="${result.price}" />원</td>
						<td>${result.reservationDate }</td>
						<td>${result.personnel}명</td>
						<td>
							<form action="reservationDelete.res" method="post">
								<input type="hidden" name="memberId" value="${id}">
								<input type="hidden" name="reservationNo" value="${result.reservationNo}">
								<!-- <input id="delete" type="submit" value="취소하기"> -->
								<span class="delete">취소하기</span>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>