<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/member.js"></script>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/member/member.css">
<title>로그인</title>
</head>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div class="loginform">
			<input type="hidden" id="failAlert" value="${loginCheck}">
			<h1>로그인</h1>
			<form action="login.member" method="post">
				<input class="loginId" type="text" name="id" placeholder="아이디">
				<input class="loginPw" type="password" name="pw" placeholder="비밀번호"><br>
				<input class="success" type="submit" value="로그인">
			</form>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</html>