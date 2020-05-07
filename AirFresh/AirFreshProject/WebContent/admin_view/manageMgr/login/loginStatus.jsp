<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ManagerMemberDto memdto = (ManagerMemberDto )session.getAttribute("managerLogin");
	session.setMaxInactiveInterval(20*60);//session 시간설정. 설정하지 않을시 default 30분
	System.out.println("session info " + memdto);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Session data 출력 </h2>
	<h3>
		<%=memdto.toString()%>
	</h3>
	
	<script type="text/javascript">
	
		window.location.href="./../showManagerAll.jsp";
	</script>

</body>
</html>