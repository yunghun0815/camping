	//가맹점 식별코드로 IMP객체 초기화
	
	function requestPay() {
		IMP.init("imp79878541");
		var no = $("#no").val(); 
		var id = $("#id").val();
		var price = $("#price").val();
		var date = new Date();
		
	      // IMP.request_pay(param, callback) 결제창 호출
	      IMP.request_pay({ // param
	          pg: "html5_inicis",
	          pay_method: "card",
	          merchant_uid: no+'-camping-'+date, //코드
	          name: "노르웨이 회전 의자", //상품명
	          amount: 100/*price*/, //가격
	          buyer_email: "test@test.com", //이메일
	          buyer_name: id, //이름
	          buyer_tel: "010-7777-7777", //전화번호
	          buyer_addr: "서울특별시 종로구 창경궁로 254 403호", //주소
	          buyer_postcode: "77777" //우편번호
	      }, function (rsp) { // callback
	          if (rsp.success) {
	             $("form").submit();
	          } else {
	              alert("결제 실패");
	          }
	      });
	    }
