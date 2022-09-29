<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="../common/header.jsp"%>
	<main>
	
		<h1>내 예약목록 페이지</h1>
		<span>${list.size()}</span>
		<c:if test="${list.size() == 0}">
			<h1>예약하신 정보가 없습니다.</h1>
		</c:if>
		<c:if test="${list.size() > 0}">
			<table>
				<tr>
					<th>사진</th>
					<th>이름</th>
					<th>가격</th>
					<th>예약날짜</th>
					<th>인원</th>
					<th>주소</th>
					<th> </th>
				</tr>
				<c:forEach items="${list}" var="result">
					<tr>
						<td><img src="${result.imgPath}${result.imgName}"></td>
						<td>${result.name}</td>
						<td>${result.price }</td>
						<td>${result.reservationDate }</td>
						<td>${result.personnel}</td>
						<td>${result.address }</td>
						<td>
							<form action="reservationDelete.res" method="post">
								<input type="hidden" name="memberId" value="${id}">
								<input type="hidden" name="reservationNo" value="${result.reservationNo}">
								<input type="submit" value="예약 취소">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</main>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>