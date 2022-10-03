<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="js/member.js"></script>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/member/member.css">
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div class="loginform">
			<h1>회원가입</h1>
			<form action="signup.member" method="post">
				<p>이름</p>
				<input id="loginName" type="text" name="name" placeholder="이름을 입력해주세요."><br>
				<small id="warnName">2자리 이상 한글만 가능합니다</small><p>
				<p>아이디</p>
				<input id="loginId" type="text" placeholder="아이디를 입력해주세요."><button id="checkButton" type="button">중복체크</button><br>
				<small id="warnId">4-12자리 영어, 숫자만 사용 가능합니다.</small><p>
				<input id="returnId" type="hidden" name ="id">
				<input type="hidden" id="count" value="${count}">
				<p>비밀번호</p>
				<input id="loginPw" type="password" name="pw" placeholder="비밀번호를 입력해주세요.(4자리 이상)"><br>
				<small id="warnPw">4-12자리 영어, 숫자만 사용 가능합니다.</small><p>
				<p>비밀번호 확인</p>
				<input id="loginPwCheck" type="password" placeholder="비밀번호를 확인해주세요."><br>
				<small id="warnPwCheck">동일한 비밀번호를 입력해주세요.</small><p>
				<p>핸드폰번호</p>
				<input id="loginPhone" type="text" name="phoneNumber" placeholder="핸드폰번호를 입력해주세요.(010-xxxx-xxxx)"><br>
				<small id="warnPhone">양식을 확인해주세요. ex)010-1234-1234</small><p>
				<input class="fail signUpBtn" type="submit" value="가입하기" disabled="disabled">
			</form>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>