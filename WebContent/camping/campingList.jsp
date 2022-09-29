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
	<H1>ķ���� ����Ʈ</H1>
	<table border=1>
		<tr>
			<th>��ȣ</th>
			<th>ķ���� �̸�</th>
			<th>����</th>
			<th>����</th>
			<th>�ּ�</th>
			<th>���� ���</th>
			<th>���� �̸�</th>
		</tr>
		
		<c:forEach var="camp" items="${campList}">
			<tr>
				<td><a href="campingDetail.camping?campno=${camp.campingNo}">${camp.campingNo}</a></td>
				<!--? �ڿ� �Ķ���� -->
				<td>${camp.name}</td>
				<td>${camp.info}</td>
				<td>${camp.price}</td>
				<td>${camp.address}</td>
				<td>${camp.imgPath}</td>
				<td>${camp.imgName}</td>
				<%--vo�� �ִ� ������--%>
			</tr>
		</c:forEach>
		</table>
	<a href="campingInsert.camping">ķ���� ���</a>
</body>
</html>