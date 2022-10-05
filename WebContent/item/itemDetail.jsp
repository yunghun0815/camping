<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/item/itemDetail.css">
<meta charset="UTF-8">
<title>캠핑장비 상세조회</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
		const count = document.getElementById("count");
		const amount = document.getElementById("amount");
		const add = document.getElementById("add");
		const minus = document.getElementById("minus");
		const sum = document.getElementById("sum");

		let amountval = amount.value;
		let sumval = sum.value;
		let priceval = count.value;

		if (add) {
			add.addEventListener('click', function() {
				amountval++;
				sumval = amountval * priceval;
				sum.value = sumval;
				amount.value = amountval;
				console.log(amountval, sumval, priceval);
			})
		}
		if (minus) {
			minus.addEventListener('click', function() {
				if (amountval > 1) {
					amountval--;
					sumval = amountval * priceval;
					amount.value = amountval;
					sum.value = sumval;
					console.log(amountval, sumval, priceval);
				} else {
					amountval = 1;
				}
			})
		}
		$(".tab2").hide();
		$(".tab3").hide();
		$(".tab4").hide();

		$(".detail_ul li").click(function() {
			$(".tab1").hide();
			$(".tab2").hide();
			$(".tab3").hide();
			$(".tab4").hide();
			var idx = $(this).index();
			if (idx == 0) {
				$(".tab1").show();
			} else if (idx == 1) {
				$(".tab2").show()
			} else if (idx == 2) {
				$(".tab3").show()
			} else if (idx == 3) {
				$(".tab4").show()
			}
		});
		
	      $(".delete_button").click(function(){
	          var check = confirm('정말로 삭제하시겠습니까?');
	          if(check == true){
	             $("form").submit();
	             alert("삭제가 완료되었습니다.");   
	          }
	       });
	}
</script>
</head>

<body>
	<%@ include file="../common/header.jsp"%>
	<div class="container">
		<div class="imgContainer">
			<img src="${item.imgPath}${item.imgName }">
		</div>
		<div class="productInfo">
			<div class="productTitle">
				<h1>${item.name }</h1>
				<a href="itemUpdate.item?itemNo=${item.itemNo}"
					class="button_update">수정</a>
				<form action="itemDelete.item" method="post">
					<input type="hidden" name="itemNo" value="${item.itemNo}">
					<span class="delete_button">삭제</span>
					<!-- <input type="submit" value="삭제" class="delete_button"> -->
				</form>
			</div>
			<hr>
			<div class="productPrice">
				<table>
					<tr>
						<th>판매가</th>
						<td><fmt:formatNumber value="${item.price }" />원</td>
					</tr>
					<tr>
						<th>배송비</th>
						<td>총 결제금액이 50,000원 미만시 배송비 3,000원이 청구됩니다.</td>
					</tr>
					<tr>
						<th>적립금</th>
						<td>결제금액의 5% 적립</td>
					<tr>
						<th>수량 <input id="count" type=hidden value="${item.price }"></th>
						<td><input type="text" id="amount" value="1" size="1"
							max="50"> <input type="button" value="+" id="add">
							<input type="button" value="-" id="minus"></td>
					</tr>
				</table>
				<hr>
				<div class="productTotal">
					<h1 class="price_left">TOTAOL</h1>
					<h1 class="price_right">
						<input type="text" id="sum" size="11"
							value=<fmt:formatNumber value="${item.price }"/>
							readonly="readonly">원
					</h1>
				</div>
				<div class="item_button">
					<a href="" class="button_first">바로 구매하기</a> <a href=""
						class="button_seccond">장바구니</a>
				</div>
			</div>
		</div>
		<div class="detailTab">
			<ul class="detail_ul">
				<li class="active">상세정보</li>
				<li class="active">상품후기</li>
				<li class="active">상품문의</li>
				<li class="active">배송/교환/반품/AS</li>
			</ul>
		</div>
		<h1 class="tab1">
			<div class="item_info">${item.info }</div>
		</h1>
		<h1 class="tab2">상품후기</h1>
		<h1 class="tab3">상품문의</h1>
		<h1 class="tab4">배송/교환/반품/AS</h1>

	</div>

	<%@ include file="../common/footer.jsp"%>
</body>
</html>