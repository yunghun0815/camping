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
<h1> ķ���� �� ����</h1>
<c:if test="${not empty camp}">
ķ���� ��ȣ : ${camp.campingNo}<br>
�̸�: ${camp.name} <br>
����: ${camp.info} <br>
����: ${camp.price} <br>
�ּ�: ${camp.address} <br>
�̹��� ���: ${camp.imgPath} <br>
�̹��� �̸�: ${camp.imgName } <br>

<a href = "campingUpdate.camping?campno=${camp.campingNo}">����</a>

<form action="campingDelete.camping" method="post"> 
<input type="hidden" name="campno" value="${camp.campingNo}">
<input type="submit" value="����">
</form>
</c:if>

<c:if test="${empty camp.campingNo}">
ķ�� ������ �����ϴ�.
</c:if>

</body>
</html>