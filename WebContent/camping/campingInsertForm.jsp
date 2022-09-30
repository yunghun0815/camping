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
<h1>캠핑장 입력 양식</h1>
<form action="campingInsert.camping" method="post" enctype="multipart/form-data">
<table border=1>
<tr>
   <td> 캠핑장 이름 </td>
   <td> <input type="text" name="name"> </td> <!-- 서버에서 name 명으로 꺼낸 값에는 value 에 해당하는 값이 들어있어요 -->
</tr>
<tr>
   <td> 상세정보 </td>
   <td><input type="text" name="info"> </td>
</tr>
<tr>
   <td>가격</td>
   <td><input type="number" name="price" ></td>
</tr>
<tr>
   <td>주소</td>
   <td><input type="text" name="address"></td>
</tr>
<tr>
	<td>지역 카테고리</td>
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
   <td><input type="file" name="attachedFile"></td>
</tr>
</table>

<input type="submit" value="저장">
<input type="reset" value="취소">

</form>
</body>
</html>