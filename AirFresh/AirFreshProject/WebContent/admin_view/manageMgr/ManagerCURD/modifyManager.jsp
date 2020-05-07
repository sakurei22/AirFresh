<%@page import="projectutil.ProjectUtil"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../../include/header.jsp" %>

<%
request.setCharacterEncoding("utf-8");
ManagerMemberDto managerSelectOneDTO = (ManagerMemberDto)request.getAttribute("managerModify1");
%>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	
	
	<div class="container">
		<h1>modify Member Detail</h1>

	  	<h2>님의 회원정보 수정</h2>
	  
		<div class="addClass">
		<%-- <form action="<%=request.getContextPath() %>/showMgrMemberDetail" id="SelectForm" method="post"> --%>
		<form id="SelectForm" method="get">
		 <ul class="list-group">
		   <li class="list-group-item">
		   </li>
		<li class="list-group-item">
		    	<label for="mgr_id" class="width50" style="border: none;">매니저 인덱스 : </label>
		   	<input type="text" id="mgr_index" name="mgr_index" value="<%=managerSelectOneDTO.getMgr_index()%>" readonly>
		   </li>
		   <li class="list-group-item">
		    	<label for="mgr_id" class="width50">매니저 아아디 : </label>
		   	<input type="text" id="mgr_id" name="mgr_id" value="<%=managerSelectOneDTO.getMgr_id() %>" >
		   </li>
		   <li class="list-group-item">
		   <%-- 비밀번호와 비밀번호 확인이 구현되었을때 mgr_pw에 name 테그가 부여됨.  --%>
		   	<label for="mgr_pw" class="width50">매니저 비밀번호 : </label>
		   	<input type="password" id="mgr_pw"> 
		   	<label for="mgr_pw_confirm" class="width50">비밀번호 확인 : </label>
		   	<input type="password" id="mgr_pw_confirm" > 
		   	
		   	<label for="mgr_pw_confirm" class="width50">
		   		<span id='message'></span>
		   	</label>
		   </li>
		   <li class="list-group-item">
		   	<label for="mgr_name" class="width50">매니저 이름 : </label>	
		   	<input type="text" id="mgr_name" name="mgr_name" value="<%=managerSelectOneDTO.getMgr_name() %>" >
		   </li>
		   <li class="list-group-item">
		   	<label for="loc" class="width50">매니저 지역구:</label>
		   	<input type="text" id="loc_locRead" value="<%=ProjectUtil.locationChange(managerSelectOneDTO.getMgr_loc()) %>" readonly >
			<label for="mgr_loc" class="width50"> 에서 </label>
			<select id="loc_loc" name="mgr_loc">
				<option value="1">강남구</option>
				<option value="2">성동구</option>
				<option value="3">중랑구</option>
				<option value="4">기타</option>
			</select>
			<label for="mgr_loc" class="width50"> 로 변경</label>
		   </li>
		   <li class="list-group-item">
		   	<label for="mgr_cell" class="width50">매니저 휴대전화번호:</label>
		   	<input type="text" id="mgr_cell" name="mgr_cell" value="<%=managerSelectOneDTO.getMgr_cell()%>"  >
		   </li>
		   <li class="list-group-item">
		   	<label for="mgr_auth" class="width50">매니저 권한:</label>
		   	<input type="text" id="mgr_auth_show" value="<%=ProjectUtil.managerLevel(managerSelectOneDTO.getMgr_auth()) %>"  readonly>
		   	<label for="mgr_auth" class="width50">에서</label>
		   	<label>
				<select id="mgr_auth" name="mgr_auth">
					<option value="0"> 최고관리자</option>
					<option value="1"> 부관리자</option>
					<option value="2"> 매니저</option>
					<option value="3"> 설치기사</option>
				</select>
			</label>
			<label for="mgr_auth" class="width50">로 변경</label>
		   </li>
		   <li class="list-group-item">
		   	<label for="mgr_del" class="width50">메니저 탈퇴여부:</label>
		   	<input type="text" id="mgr_delRead"  value="<%=ProjectUtil.managerStatus(managerSelectOneDTO.getMgr_del())%>" readonly>
		    	
		    	<label>
					<select id="mgr_del" name="mgr_del">
						<option value="0" > 재직중</option>
						<option value="1" > 퇴사</option>
					</select>
				</label>
		    	
		    </li>
		    <li class="list-group-item">
		    	<button type="button" class="modify_btn_finish"> 수정완료 </button>
		    </li>
		  </ul>
		</form>
		 </div>
	  
	</div><!-- container  -->

		<%--
			권한변경 		auth를 0, 1, 2  로 변경한다. 
			아이디 삭제하기 => del=0 에서 1로 변경 
		--%>
	<script type="text/javascript" charset="UTF-8">
	
	
	
	console.log("${pageContext.request.contextPath}"+'${pageContext.request.contextPath}');
	sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
	
	
	
	
    </script>
	
	<script src="./admin_view/assets/js/modifyMgrMember.js?v=<%=System.currentTimeMillis() %>"></script>
	
	
	
	
	
<%@ include file="./../../include/footer.jsp" %>