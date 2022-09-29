<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장비 상세조회</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>장비번호</th>
			<td>${item.itemNo }</td>
		</tr>
		<tr>
			<th>장비이름</th>
			<td>${item.name }</td>
		</tr>
		<tr>
			<th>장비가격</th>
			<td>${item.price }</td>
		</tr>
		<tr>
			<th>장비설명</th>
			<td>${item.info }</td>
		</tr>
		<tr>
			<th>사진</th>
			<td><img src="${item.imgPath} ${item.imgName }"></td>
		</tr>
	</table>
	<a href="itemUpdate.item?itemNo=${item.itemNo}">캠핑장비 수정</a>
	<form action="itemDelete.item" method="post"> 
		<input type="hidden" name ="itemNo" value="${item.itemNo}">
		<input type="submit" value="삭제">
	</form>
</body>
</html>