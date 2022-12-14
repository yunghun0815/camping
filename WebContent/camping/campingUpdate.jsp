<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/camping/campingInsert.css">
<body>
	<%@ include file="../common/header.jsp"%>
	<h1>캠핑장 수정</h1>
	<form action="campingUpdate.camping" method="post"
		enctype="multipart/form-data">
		<table border=1>
			<input type="hidden" name="campingNo" value="${camp.campingNo}">
			<tr>
				<th>캠핑장 이름</th>
				<td><input type="text" name="name" value="${camp.name}" class="input">
				</td>
				<!-- 서버에서 name 명으로 꺼낸 값에는 value 에 해당하는 값이 들어있어요 -->
			</tr>
			<tr>
				<th>상세정보</th>
				<td>
					<textarea rows="5" cols="75" style="margin-top: 5px; margin-left: 12px;" name="info">${camp.info}</textarea>
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" value="${camp.price}" class="input"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="${camp.address}" class="input"></td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>
					<select name="category">
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="인천">인천</option>
						<option value="울산">울산</option>
						<option value="광주">광주</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청도">충청도</option>
						<option value="전라도">전라도</option>
						<option value="경상도">경상도</option>
						<option value="제주도">제주도</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="attachedFile" 
					 value="${camp.imgName}" class="input">
					<img src="${camp.imgPath}${camp.imgName}"  style="width: 300px;">
				</td>
			</tr>
		</table>

		<div class="buttonBox">
			<input type="submit" value="저 장" class="submitButton"> 
			<input type="reset" value="취 소" class="resetButton">
		</div>

	</form>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>