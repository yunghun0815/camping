	//가맹점 식별코드로 IMP객체 초기화
	
	function requestPay() {
		IMP.init("imp79878541");
		var campNo = $("#payId").val(); 
		var name = $("#payName").val();
		var pay = $("#payPrice").val();
		var date = new Date();
		
	      // IMP.request_pay(param, callback) 결제창 호출
	      IMP.request_pay({ // param
	          pg: "html5_inicis",
	          pay_method: "card",
	          merchant_uid: campNo+'-camping-'+date, //코드
	          name: "노르웨이 회전 의자", //상품명
	          amount: 100, //가격
	          buyer_email: "test@test.com", //이메일
	          buyer_name: name, //이름
	          buyer_tel: "010-7777-7777", //전화번호
	          buyer_addr: "뉴욕", //주소
	          buyer_postcode: "77777" //우편번호
	      }, function (rsp) { // callback
	          if (rsp.success) {
	              alert("성공");
	          } else {
	              alert("실패");
	          }
	      });
	    }