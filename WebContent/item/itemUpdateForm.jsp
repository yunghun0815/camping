<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/item/itemUpdate.css">
<meta charset="UTF-8">
<title>캠핑장비 수정</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<form action="itemUpdate.item" method="post"
			enctype="multipart/form-data">
			<table border=1>
				<h1>수정 페이지</h1>
				<tr>
					<th>장비 번호</th>
					<td><input type="number" name="itemNo" value="${item.itemNo}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>장비 이름</th>
					<td><input type="text" name="name" value="${item.name}" required="required"></td>
				</tr>
				<tr>
					<th>장비 가격</th>
					<td><input type="number" name="price" value="${item.price }" required="required"></td>
				</tr>
				<tr>
					<th>장비 설명</th>
					<td><input type="text" name="info" value="${item.info }" required="required"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="hidden" name="realName"
						value="${item.imgName}"> <input type="file"
						name="attacheFile" required="required"><img
						src="${item.imgPath}${item.imgName}"></td>
				</tr>
				<tr>
					<!-- <th>카테고리</th> -->
					<th>${item.category }</th>
					<td><select name="category">
							<option value="tent"
							<c:if test="${item.category eq 'tent' }">selected</c:if>
							>텐트/침낭
							</option>
							<option value="table" 
							<c:if test="${item.category eq 'table' }">selected</c:if>>테이블/체어
							</option>
							<option value="sleeping" 
							<c:if test="${item.category eq 'sleeping' }">selected </c:if>>침낭/매트
							</option>
							<option value="itemProp" <c:if test="${item.category eq 'itemProp' }">selected </c:if>>캠핑소품</option>
					</select>
				</tr>
				<tr>
					<td colspan="2"><input class="Button1" type="submit"
						value="전송"></td>
				</tr>
			</table>
		</form>

		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>