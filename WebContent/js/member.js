$(function(){
	
		if($("#failAlert").val() == 'fail')	{
			alert("아이디 또는 비밀번호를 확인하세요.")			
		}
	
	
		var validationName = false;
		var validationId = false;
		var validationPw = false;
		var validationPwCheck = false;
		var validationPhone = false;
		var idDBCheck = false;
		var name = /[가-힣]{2}$/; //한글자 이상
		var phoneNumberRegex = /^010-?([0-9]{4})-?([0-9]{4})$/; //전화번호 정규식 010-네자리-네자리 
		var idPwRegx = /^[a-zA-Z0-9]{4,12}$/; //4-12자리 이상 영어, 숫자만 가능
		$("small").hide();
			$("#checkButton").click(function(){
				if(validationId == true){
				var btnCheckId = $("#loginId").val();
					$.ajax({
						url: "idCheck.ajax?checkId="+btnCheckId,
						type: "GET",
						success : function(result){
							if(result == 1){ 
								alert("이미 사용중인 아이디입니다.")
							}else{ //가입 가능
								alert("사용 가능한 아이디입니다.")
								$("#loginId").attr("disabled", "disabled");
								$("#checkButton").attr("disabled", "disabled");
								$("#checkButton").addClass("fail");
								idDBCheck = true;
								valCheck();
							}
						}
					});	
				}
			});
		
		function valCheck(){
			if(validationName && validationId && validationPw && validationPwCheck && validationPhone && idDBCheck){
				$(".signUpBtn").removeClass("fail");
				$(".signUpBtn").removeAttr("disabled");
			}else{
				$(".signUpBtn").addClass("fail");
				$(".signUpBtn").attr("disabled","disabled");
			}	
		}
		
		$("#loginName").keyup(function(){
			if(!name.test($(this).val())){
				$("#warnName").show();
				validationName = false;
			}else{
				$("#warnName").hide();
				validationName = true;
			}
			valCheck();
		});
		$("#loginId").keyup(function(){
			if(!idPwRegx.test($(this).val())){
				$("#warnId").show();
				validationId = false;
			}else{
				$("#warnId").hide();
				validationId = true;
			}
			valCheck();
		});
		$("#loginPw").keyup(function(){
			if(!idPwRegx.test($(this).val())){
				$("#warnPw").show();
				validationPw = false;
			}else{
				$("#warnPw").hide();
				validationPw = true;
			}
			valCheck();
		});
		$("#loginPwCheck").keyup(function(){
			if($("#loginPwCheck").val() != $("#loginPw").val()){
				$("#warnPwCheck").show();
				validationPwCheck = false;
			}else{
				$("#warnPwCheck").hide();
				validationPwCheck = true;
			}
			valCheck();
		});
		$("#loginPhone").keyup(function(){
			if(!phoneNumberRegex.test($(this).val())){
				$("#warnPhone").show();
				validationPhone = false;
			}else{
				$("#warnPhone").hide();
				validationPhone = true;
			}
			valCheck();
		});

	});