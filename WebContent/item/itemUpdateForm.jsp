<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장비 수정</title>
</head>
<body>
</style>
<form action="itemUpdate.item" method="post" enctype="multipart/form-data">
	<table border=1>
		<tr>
			<th>장비 번호</th>
			<td><input type="number" name="itemNo" value="${item.itemNo}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>장비 이름</th>
			<td><input type="text" name="name" value="${item.name}"></td>
		</tr>
		<tr>
			<th>장비 가격</th>
			<td><input type="number" name="price" value="${item.price }"></td>
		</tr>
		<tr>
			<th>장비 설명</th>
			<td><input type="text" name="info" value="${item.info }"></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="attachedFile" ><img src="${item.imgPath}${item.imgName }"></td>
			<input type="hidden" name="imgPath" value="${item.imgPath}">
			<input type="hidden" name="imgName" value="${item.imgName}">
		</tr>
	</table>
	<input type="submit" value="전송">
</form>
</body>
</html>