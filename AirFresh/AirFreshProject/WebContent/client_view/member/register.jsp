<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<div class="container" style = "margin-bottom : 40px">
	<h1 class="mt-4 mb-3">Air Fresh 회원가입</h1>
<hr>
<div class="row justify-content-center">
<div class="col-lg-9">
	<div class="card border-0 rounded-lg mt-9">
	<form id="frm" onsubmit="return validate();"
		action="<%=request.getContextPath()%>/addmem" method="post">
		<fieldset>
		<input type="hidden" name="command" value="addAf">
		
		<div class="form-group" >
      		<label class="col-sm-2 col-form-label">이름</label>
      		<div class="col-sm-4">
        		<input type="text" class="form-control" id="mem_name" name="mem_name" placeholder="이름">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">아이디(E-Mail)</label>
      		<div class="col-sm-6">
      			<div style="float:left;margin-right:10px;">
        		<input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="ID@email_account.com" maxlength="50">
        		</div>
        		<div style="float:left; padding-top:3px;">
        		<button type="button" id="_btnid" class="btn btn-primary btn-sm">ID check</button>
        		</div>
        		<div style="clear:left;"><p id="idcheck" style="font-size:8pt; padding-top:3px;">id 확인</p></div>
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-4 col-form-label">패스워드<small style="font-size:8pt">(영문, 숫자, 특수문자 3가지를 조합한 6자리 이상)</small></label>
      		<div class="col-sm-4" style="margin-bottom:5px;">
        		<input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="6자리 이상 입력해주세요." maxlength="20">
        	</div>
        	<div class="col-sm-4">
        		<input type="password" class="form-control" id="mem_pw1" name="mem_pw" placeholder="비밀번호 재확인" maxlength="20"><div style="height:30px;"><font id="chkNotice" size="2"></font></div>  		
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">휴대폰번호</label>
      		<div class="col-sm-4">
        		<input type="text" class="form-control" id="mem_cell" name="mem_cell" placeholder="- 없이 숫자만 입력해주세요." maxlength="11">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">생년월일</label>
      		<div class="col-sm-4">
        		<input type="text" class="form-control" id="mem_birth" name="mem_birth" placeholder="ex) 19801012" maxlength="8">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">주소</label>
      		<div class="col-sm-6">
      			<div style="float:left;margin-right:10px;">
        		<input type="text" class="form-control" id="mem_addr1" name="mem_addr1"
					placeholder="우편번호" readonly="readonly" onclick="sample6_execDaumPostcode();">
				</div>
				<div style="float:left; padding-top:3px;">
				<input type="button" class ="btn btn-primary btn-sm" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				</div>
				<div style="clear:left;"></div>				
     		 </div>	 
     		 <div class="form-group" style="margin-top:3px">
      			<div class="col-sm-9">
      			<div style="float:left;margin-right:10px;">
        			<input type="text" class="form-control" id="mem_addr2" name="mem_addr2" placeholder="주소" readonly="readonly">
        		</div>
        		<div style="float:left; padding-top:3px;">
        			<input type="text" class="form-control" id="mem_addr3" name="mem_addr3" placeholder="상세주소">
        			</div>
        			<div style="clear:left;"></div>	
     		 	</div>
    		</div>
        		<input type="hidden" class="form-control" id="sample6_extraAddress" placeholder="참고항목" readonly="readonly">
    	</div>
    	<div class="form-group" align="center" style ="margin-top:20px; margin-bottom:30px;">
    	<input type="button" class ="btn btn-primary btn-lg"
					value="회원가입" id="_btnJoin">
    	</div>
	</fieldset>

	</form>
	</div>
	</div>
	</div>
</div>

<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	//  비번 재확인
	$(function(){
		$('#mem_pw').keyup(function(){
		      $('#chkNotice').html('');
		    });

		    $('#mem_pw1').keyup(function(){

		        if($('#mem_pw').val() != $('#mem_pw1').val()){
		          $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
		          $('#chkNotice').attr('color', '#f82a2aa3');
		        } else{
		          $('#chkNotice').html('비밀번호 일치함<br><br>');
		          $('#chkNotice').attr('color', '#199894b3');
		        }

		    });
	}); 
	 
	 
	$("#_btnid").click(function () {	
		 $.ajax({
			type:"post",	
			url:"${pageContext.request.contextPath}/idcheck",	// idcheck / ./idcheck.jsp
			data:{ _id : $("#mem_id").val() },
			traditional : true,
			datatype : "text",
			success:function( data ){	// idcheck에서 넘겨준 결과값	
				
				var d = JSON.parse(data);
				//alert("d: "+d);
				
				if(d=="true"){
					//아이디가 존재해서 사용불가능
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html('사용 중인 id입니다');
					$("#mem_id").val("");
					$("#mem_id").focus();
				} else {
					//아이디 사용가능
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html('사용할 수 있는 id입니다');
				}
				
				
				/* if(data.trim() == "YES"){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html('사용할 수 있는 id입니다');
				}else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html('사용 중인 id입니다');
					$("#mem_id").val("");
					$("#mem_id").focus();
				}		 */	
			},
			error:function(){
				alert("error");
			}		

		}); //end ajax


	});
	
	
	$("#_btnJoin").click(function () {
		if( $("#mem_id").val().trim() == "" ){
			alert("id를 입력해 주십시오");
			$("#mem_id").focus();
		}
		else if( $("#mem_pw").val().trim() == "" ){
			alert("password를 입력해 주십시오");
			$("#mem_pw").focus();
		}
		else if( $("#mem_name").val().trim() == "" ){
			alert("이름을 입력해 주십시오");
			$("#mem_name").focus();
		}
		else if( $("#mem_cell").val().trim() == "" ){
			alert("휴대폰번호를 입력해 주십시오");
			$("#mem_cell").focus();
		}
		else if( $("#mem_birth").val().trim() == "" ){
			alert("생년월일을 입력해 주십시오");
			$("#mem_birth").focus();
		}
		else if( $("#mem_addr1").val().trim() == "" ){
			alert("주소를 입력해 주십시오");
			$("#mem_addr1").focus();
		}
		else{
			$("#frm").submit();		
		}	
	});	
	
});

// sample6_execDaumPostcode()함수  시작

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('mem_addr1').value = data.zonecode;
            document.getElementById("mem_addr2").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("mem_addr3").focus();
        }
    }).open();
}

//sample6_execDaumPostcode() 끝


function validate() {
	var id = $("#mem_id").val();	// 이메일 정규식
	var idReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
	var pw = $("#mem_pw").val();	// 특수문자 / 문자 / 숫자 포함 형태의 6~20자리 이내의 암호 정규식
	var pwReg = /^.*(?=^.{6,20}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		
	var cell = $("#mem_cell").val();	// 핸드폰번호 정규식
	var cellReg = /^01[0179][0-9]{7,8}$/;
						
	var birth = $("#mem_birth").val();
	var birthReg = /^(19|20)[0-9]{2}(0[1-9]|1[1-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
				// /^(19|20)[0-9]{2}(0[1-9]|1[1-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
				// /^[1-2]{1}[0-9]{3}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}$/;		
	// ex) 19801012
	
	if(idReg.test(id)==false){
		alert("적합하지 않은 이메일 형식입니다.");
		id = "";
		$("#mem_id").focus();
		return false;
	}else if(pwReg.test(pw)==false){
		alert("패스워드는 6~20자리 이내의 영문,숫자,특수문자로만 입력해주세요.");
		pw = "";
		$("#mem_pw").focus();
		return false;
	}else if(cellReg.test(cell)==false){
		alert("적합하지 않은 휴대폰번호 형식입니다.");
		cell = "";
		$("#mem_cell").focus();
		return false;
	}else if(birthReg.test(birth)==false){
		alert("적합하지 않은 생년월일 형식입니다.");
		bitrh = "";
		$("#mem_birth").focus();
		return false;
	}
	return true;	
}


</script>
<%@ include file="./../include/footer.jsp"%>