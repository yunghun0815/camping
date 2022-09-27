<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<%@ include file="../common/header.jsp" %>
<body>
	
	<form action="member/login" method="post">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="pw" placeholder="비밀번호"><br> 
		<input type="submit" value="로그인">
	</form>
</body>
</html>