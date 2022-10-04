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
<style>
img{
	 width: 350px;
	 margin-top: 10px;
}
table.cl {
	width: 1300px;

	border-right:none;
	border-left: none;
	border-top:none;
	border-bottom:none;
}
.cl tr{
	height: 200px;
}
.cl td{
	width: 200px;
	flex-direction: column;
}
.campingName{
	margin-top: -15px;
    margin-bottom: -13px;
}
#imgbox {
	text-align: center;
}
#content{
	width: 350px;
    margin: 0 auto;
}
</style>
<body>
	<%@ include file="../common/header.jsp"%>
	<section class="main">
		<div border: 1px solid black;">
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