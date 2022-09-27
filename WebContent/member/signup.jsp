<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입 테스트</h1>
	<form action="signup.member" method="post">
		<input type="text" name="name" placeholder="이름"><p>
		<input type="text" name="id" placeholder="아이디"><button>중복체크</button><p>
		<input type="password" name="pw" placeholder="비밀번호"><p>
		<input type="text" name="phoneNumber" placeholder="핸드폰번호">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>