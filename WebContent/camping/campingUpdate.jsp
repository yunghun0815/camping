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
<h1>ķ���� ���� ���</h1>
<form action="campingUpdate.camping" method="post">
<table border=1>
<input type="hidden" name="campingNo" value="${camp.campingNo}">
<tr>
	<td> ķ���� �̸� </td>
	<td> <input type="text" name="name" value="${camp.name}"> </td> <!-- �������� name ������ ���� ������ value �� �ش��ϴ� ���� ����־�� -->
</tr>
<tr>
	<td> ������ </td>
	<td><input type="text" name="info" value="${camp.info}"> </td>
</tr>
<tr>
	<td>����</td>
	<td><input type="number" name="price" value="${camp.price}" ></td>
</tr>
<tr>
	<td>�ּ�</td>
	<td><input type="text" name="address" value="${camp.address}"></td>
</tr>
<tr>
	<td>���� ī�װ�</td>
	<td>
		<select name="category">
			<option value="����">����</option>
			<option value="�λ�">�λ�</option>
			<option value="��õ">��õ</option>
			<option value="���">���</option>
			<option value="����">����</option>
			<option value="����">����</option>
			<option value="�뱸">�뱸</option>
			<option value="��⵵">��⵵</option>
			<option value="������">������</option>
			<option value="��û��">��û��</option>
			<option value="����">����</option>
			<option value="���">���</option>
			<option value="���ֵ�">���ֵ�</option>
		</select>
	</td>
</tr>
<tr>
	<td>�̹��� ���</td>
	<td><input type="text" name="imgPath" value="${camp.imgPath}"></td>
</tr>
<tr>
	<td>�̹��� �̸�</td>
	<td><input type="text" name ="imgName" value="${camp.imgName}"></td>
</tr>
</table>

<input type="submit" value="����">
<input type="reset" value="���">

</form>
</body>
</html>