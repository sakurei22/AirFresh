<%@page import="projectutil.ProjectUtil"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@page import="java.util.List"%>

<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp" %>

<style>
.width50 {
	width:50%;
}
.nonborder{
	border:0px solid black;
}

</style>
  
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
//ManagerMemberDto managerSelectOneDTO = (ManagerMemberDto)request.getAttribute("managerInfoSelectOne");
ManagerMemberDto managerSelectOneDTO = (ManagerMemberDto)request.getAttribute("receiveFromIndex");

%>
	
	
	<div class="container">
	<h1>showmgrMemberDetail</h1>

	  <h2> <%=managerSelectOneDTO.getMgr_name() %> 님의 정보수정 페이지</h2>
	  
	  <div class="addClass">
	  	<form action="" id="SelectForm" method="get">
		  <ul class="list-group">
		    <li class="list-group-item">
		    </li>
			<li class="list-group-item">
		     	<label for="mgr_id" class="width50">매니저 인덱스 : </label>
		    	<input type="text" id="mgr_index" class="nonborder" name="mgr_index" value="<%=managerSelectOneDTO.getMgr_index() %>" readonly>
		    </li>
		    <li class="list-group-item">
		     	<label for="mgr_id" class="width50">매니저 아아디 : </label>
		    	<input type="text" id="mgr_id" class="nonborder" value="<%=managerSelectOneDTO.getMgr_id() %>" readonly>
		    </li>
		   	<li class="list-group-item">
			   	<%-- 비밀번호와 비밀번호 확인이 구현되었을때 mgr_pw에 name 테그가 부여됨.  --%>
			   	<label for="mgr_pw" class="width50">매니저 비밀번호 : </label>
			   	<input type="password" id="mgr_pw">
			   	 
			   	<label for="mgr_pw_confirm" class="width50">비밀번호 확인 : </label>
			   	<input type="password" id="mgr_pw_confirm" >
			   	 
			   	<label for="message" class="width50"> 확인 체크 </label>
			   	<label for="mgr_pw_confirm" class="">
			   		<span id='message'></span>
			   	</label>
		   	</li>
		    <li class="list-group-item">
		    <label for="mgr_name" class="width50">매니저 이름 : </label>	
		    	<input type="text" id="mgr_name" name="mgr_name" value="<%=managerSelectOneDTO.getMgr_name() %>">
		    </li>
		    <li class="list-group-item">
		    	<label for="mgr_loc" class="width50">매니저 지역구:</label>
		    	<input type="text" id="mgr_loc" name="mgr_loc" class="nonborder" value="<%=managerSelectOneDTO.getMgr_loc() %><%-- <%=ProjectUtil.locationChange(managerSelectOneDTO.getMgr_loc()) %> --%>" readonly >
		    </li>
		    <li class="list-group-item">
		    	<label for="mgr_cell" class="width50">매니저 휴대전화번호:</label>
		    	<input type="text" id="mgr_cell" name="mgr_cell"  value="<%=managerSelectOneDTO.getMgr_cell()%>" >
		    </li>
		    <li class="list-group-item">
		    	<label for="mgr_auth" class="width50">매니저 권한:</label>
		    	<input type="text" id="mgr_auth" name="mgr_auth" class="nonborder" value="<%=ProjectUtil.managerLevel(managerSelectOneDTO.getMgr_auth()) %>" readonly>
		    </li>
		    <li class="list-group-item">
		    	<label for="mgr_del" class="width50">입사일자:</label>
		    	<input type="text" id="mgr_joindate" name="mgr_joindate" class="nonborder" value="<%=ProjectUtil.outputdataValue(managerSelectOneDTO.getMgr_joinDate()) %>" readonly>
		    </li>
		    <li class="list-group-item">
		    	<button type="button" class="modify_btn"> modify 수정완료 </button>
		    	<button type="button" class="redirMain_btn"> 메인페이지로 이동  </button>
		    </li>
		  </ul>
		</form>
	  </div>
	  
	</div><!-- container  -->

	<div>
	
	
	</div>
		<%--
			권한변경 		auth를 0, 1, 2  로 변경한다. 
			아이디 삭제하기 => del=0 에서 1로 변경 
		--%>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			

			
			$(".modify_btn").click(function(){
				
				alert("수정 버튼 클릭됨.  ");

				
					// $("#SelectForm").attr("action", "<%=request.getContextPath() %>/managerProfileChange?commend=modify");
					// $("#SelectForm").submit(); 
				
				
				//입력된 값을 셋팅한다.
				var mgr_index1		= $("#mgr_index").val();
				var mgr_pw1			= $("#mgr_pw").val();
				var mgr_name1		= $("#mgr_name").val();
				var mgr_cell1		= $("#mgr_cell").val();
				

				console.log(mgr_index1);
				console.log(mgr_pw1);
				console.log(mgr_name1);
				console.log(mgr_cell1);
				alert("데이터전송");
				
				//입력된 값들을 바탕으로 ajax를 실행한다. 
			 $.ajax({
					url:'<%=request.getContextPath() %>/managerProfileChange?ManageProfileCommnd=modify',
					type:"post",
					datatype:"json",
					data:{
						mgr_index:mgr_index1,
						mgr_pw:mgr_pw1,
						mgr_name:mgr_name1,
						mgr_cell:mgr_cell1
					},
					datatype:"text",
					success: function ( data ) {
						console.log("통신성공");
						console.log(data);
						//location.replace("<%=request.getContextPath() %>"+data);
						if(data == "true"){
							alert("수정에 성공하였습니다. ");
							location.href="<%=request.getContextPath() %>/managerProfileChange?ManageProfileCommnd=main";
						}else{
							alert("로그인실패");
						}
						//location.href(data);
					},
					error: function () {
						alert("통신 실패");
					}
				});//end ajax
				 
				
			});
			
			$(".redirMain_btn").click(function(){
				alert("메인페이지로 이동 버튼 ");
				$("#SelectForm").attr("action", "<%=request.getContextPath() %>/managerProfileChange?ManageProfile&Commnd=main");
				//("#mgr_index").removeAttr("readonly");
				//$("#mgr_pw")
				if($("#mgr_pw").val()=="" && $("#mgr_pw_confirm").val()=="" ){
					$("mgr_pw").removeAttr("name");
				}
				
				$("#SelectForm").submit();
			});
			
			//비밀번호 확인 로직.
			/*
				1. 비밀번호 입력칸 두곳에 같은 비밀번호가 입력되어야 한다.
				2. 두곳 모두 입력되지 않았을 경우에는 파라미터생성이 되면 안된다.    */
			$('#mgr_pw, #mgr_pw_confirm').on("keyup", function () {
				if($("#mgr_pw").val()  == $("#mgr_pw_confirm").val()){
					
						$('#message').html('Matching').css('color', 'green');
						$("#mgr_pw").attr("name","mgr_pw");
						
					} else{
						$('#message').html('Not Matching').css('color', 'red');
						$("#mgr_pw").removeAttr("name");
					}
			});
			
			
			
			
			
		});	//$(document).ready(function(){

	</script>
	
				
<%@ include file="./../include/footer.jsp" %>
