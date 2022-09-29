
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장비 등록</title>
</head>
<body>
	<form action="itemInsert.item" method="post" enctype="multipart/form-data">
		<table border=1>

			<tr>
				<th>장비 이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>장비 가격</th>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<th>장비 설명</th>
				<td><input type="text" name="info"></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>사진 위치</th> -->
<!-- 				<td><input type="text" name="imgPath"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<th>사진 경로</th> -->
<!-- 				<td><input type="text" name="imgName"></td> -->
<!-- 			</tr> -->
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="attachedFile"></td>
			</tr>		
		</table>
		<input type="submit" value="전송">
	</form>
</body>
</html>