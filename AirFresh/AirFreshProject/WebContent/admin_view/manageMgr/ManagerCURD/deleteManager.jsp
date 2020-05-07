<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../include/header.jsp" %>


<%
	//ManagerMemberDto mrgMem = new ManagerMemberDto(6000, 0, "k_admin", null, "왕관리자", 0, 01012341234, 0);
	//session.setAttribute("mrgLogin", mrgMem);
	//session.setMaxInactiveInterval(3600);
%>
<script type="text/javascript">
	setTimeout(function(){
	window.location.href='<%=request.getContextPath() %>/showMrgMember';
	},2000);
</script>



<div class="container">
	<h1 class="mt-4 mb-3" >위치명</h1>
	<div style="
    width: 100%;
    height: 100%;
    text-align: -webkit-center;">
		<div style="
	    width: 80%;
	    height: 80%;
	    display: block;
	    text-align: center;">
			<h1> 삭제되었습니다 </h1>
			<h3> 2초후에 "직원리스트"로 이동합니다. </h3>
		</div>
	</div>
</div>
	
			
<%@ include file="./../../include/footer.jsp" %>
