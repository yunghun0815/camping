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
<h1>캠핑장 수정 양식</h1>
<form action="campingUpdate.camping" method="post" enctype="multipart/form-data">
<table border=1>
<input type="hidden" name="campingNo" value="${camp.campingNo}">
<tr>
	<td> 캠핑장 이름 </td>
	<td> <input type="text" name="name" value="${camp.name}"> </td> <!-- 서버에서 name 명으로 꺼낸 값에는 value 에 해당하는 값이 들어있어요 -->
</tr>
<tr>
	<td> 상세정보 </td>
	<td><input type="text" name="info" value="${camp.info}"> </td>
</tr>
<tr>
	<td>가격</td>
	<td><input type="number" name="price" value="${camp.price}" ></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type="text" name="address" value="${camp.address}"></td>
</tr>
<tr>
	<td>사진</td>
	<td><input type="file" name =attachedFile value="${camp.imgPath}${camp.imgName}"><img src="${camp.imgPath}${camp.imgName}"></td>
</tr>
</table>

<input type="submit" value="저장">
<input type="reset" value="취소">

</form>
</body>
</html>