<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>ķ���� �Է� ���</h1>
<form action="campingInsert.camping" method="post">
<table border=1>
<tr>
	<td> ķ���� �̸� </td>
	<td> <input type="text" name="name"> </td> <!-- �������� name ������ ���� ������ value �� �ش��ϴ� ���� ����־�� -->
</tr>
<tr>
	<td> ������ </td>
	<td><input type="text" name="info"> </td>
</tr>
<tr>
	<td>����</td>
	<td><input type="number" name="price" ></td>
</tr>
<tr>
	<td>�ּ�</td>
	<td><input type="text" name="address"></td>
</tr>
<tr>
	<td>�̹��� ���</td>
	<td><input type="text" name="imgPath"></td>
</tr>
<tr>
	<td>�̹��� �̸�</td>
	<td><input type="text" name ="imgName"></td>
</tr>
</table>

<input type="submit" value="����">
<input type="reset" value="���">

</form>
</body>
</html>