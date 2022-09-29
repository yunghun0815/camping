<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 캠핑장 상세 정보</h1>
<c:if test="${not empty camp}">
캠핑장 번호 : ${camp.campingNo}<br>
이름: ${camp.name} <br>
정보: ${camp.info} <br>
가격: ${camp.price} <br>
주소: ${camp.address} <br>
이미지 경로: ${camp.imgPath} <br>
이미지 이름: ${camp.imgName } <br>

<a href = "campingUpdate.camping?campno=${camp.campingNo}">수정</a>

<form action="campingDelete.camping" method="post"> 
<input type="hidden" name="campno" value="${camp.campingNo}">
<input type="submit" value="삭제">
</form>
</c:if>

<c:if test="${empty camp.campingNo}">
캠핑 정보가 없습니다.
</c:if>

</body>
</html>