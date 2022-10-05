<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/camping/campingList.css">
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div>
		<h1 class="title"> 캠핑장</h1>
		<div class="button">
			<a href="campingInsert.camping?campno=${camp.campingNo}"class="insertButton">등 록</a>
		</div>
		
			<table class="cl" align="center">
				<c:if test="${campList.size()/3 <1}">
					<tr>
						<c:forEach items="${campList}" var="camp">
							<td>
								<div id="imgbox">
									<a href="campingDetail.camping?campno=${camp.campingNo}">
									<!--<img class="campingImage" src="${camp.imgPath}${camp.imgName}">  -->
									<img src="images/1.png">
									</a>
								</div> <br>
								<div id="content">
									<h2 class="campingName">
										${camp.name}
									</h2><br>
									${camp.address} <br>
									<fmt:formatNumber value="${camp.price}" type="currency" var="price"/>
									${price} <br>
								</div>
							</td>
						</c:forEach>
					</tr>
				</c:if>
				
				<c:if test="${campList.size()/3 >=1}">
					<c:forEach begin="0" end="${campList.size() / 3}" var="i">
						<c:if test="${campList[i*3] !=null}">
							<tr>
								<c:forEach begin="${i*3}" end="${(i*3)+2}" var="j">
									<c:if test="${campList[j] !=null}">
										<td height ="50px">
												<div id="imgbox">
													<a href="campingDetail.camping?campno=${campList[j].campingNo}">
										 			<img src="images/1.png">
													</a>
												</div><br>
												<div id="content">
												<h2 class="campingName">
												${campList[j].name}
												</h2> <br>
												${campList[j].address} <br>
												<fmt:formatNumber value="${campList[j].price}" type="currency" var="price"/>
												${price} <br>
												</div>
										</td>
										
									</c:if>
								</c:forEach>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
				
			</table>
		</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>