
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장비 등록</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/item/itemUpdate.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<form action="itemInsert.item" method="post"
			enctype="multipart/form-data">
			<table border=1>
				<h1>등록 페이지</h1>
				<tr>
					<th>장비 이름</th>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<th>장비 가격</th>
					<td><input type="number" name="price" required="required"></td>
				</tr>
				<tr>
					<th>장비 설명</th>
					<td><input type="text" name="info" required="required"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="attachedFile" required="required"></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><select name="category">
							<option value="tent">텐트/타프</option>
							<option value="table">테이블/체어</option>
							<option value="sleeping">침낭/매트</option>
							<option value="itemProp">캠핑소품</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" 
					class="Button1"
					value="전송"></td>
				</tr>
			</table>
			
		</form>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>