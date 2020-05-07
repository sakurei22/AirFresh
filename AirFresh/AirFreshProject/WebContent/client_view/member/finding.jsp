<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

MemberDto mem = (MemberDto)session.getAttribute("login");
String command = request.getParameter("command");
System.out.println("command:" + command);
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if(command.equals("register")){
	String str = request.getParameter("isS");	
	if(str.equals("true")) {
	%>
		<script type="text/javascript">
		alert("회원이 되신 것을 환영합니다!");			//client_view/member/login.jsp
		location.href = "<%=request.getContextPath() %>/login?command=login";	
		</script>
	<%
	}else if(str.equals("false")) {
	%>
		<script type="text/javascript">
		alert("가입 실패!");
		<%-- location.href = "<%=request.getContextPath() %>/addmem?command=regi"; --%>
		history.back();
		//history.go(-1);
		</script>
<%
	}
}
%>

<%
if(command.equals("update")){
	String str = request.getParameter("isS");	
	if(str.equals("true")){
	%>
		<script type="text/javascript">	
		alert("성공적으로 수정 되었습니다");
		location.href = "<%=request.getContextPath() %>/updatemem?command=update&id=<%=mem.getMem_id() %>";	
		</script>	
	<%
	}else if(str.equals("false")){
	%>
		<script type="text/javascript">	
		alert("수정 되지 않았습니다");	
		location.href = "<%=request.getContextPath() %>/login?command=login";
		</script>
<%
	}
}
%>

<%
if(command.equals("delete")){
	String str = request.getParameter("isS");	
	if(str.equals("true")){
	%>	
		<script type="text/javascript">
		alert("정상적으로 삭제되었습니다");		
		location.href = "<%=request.getContextPath() %>/login?command=logout";
		</script>
	<%
	}else if(str.equals("false")){
	%>
		<script type="text/javascript">
		alert("아이디 또는 비밀번호가 일치하지 않습니다");
		location.href = "<%=request.getContextPath() %>/login?command=login";
		</script>
<%
	}
}
%>	
 				
<%
if(command.equals("findi")){	
	String str1 = request.getParameter("id");	// FindID(PW)
	System.out.println("str1:" + str1);
	if(str1 != null && !str1.equals("")){
	%>
		<script type="text/javascript">
		alert("가입하신 아이디는 " + '<%=str1 %>' + "입니다.");
		location.href = "<%=request.getContextPath() %>/login?command=login";
		</script>		
	<%
	}else if(str1 == null || str1.equals("")){
	%>
		<script type="text/javascript">
		alert("찾으시는 아이디가 없습니다.");
		location.href = "<%=request.getContextPath() %>/findidpw?command=searchidpw";
		</script>
	<% 
	}	
}	
%>
	
<%
if(command.equals("findp")){	
	String str2 = request.getParameter("pw");	// Find(ID)PW
	System.out.println("str2:" + str2);
	if(str2 != null && !str2.equals("")){
	%>
		<script type="text/javascript">
		alert("귀하의 비밀번호는 " + '<%=str2%>' + "입니다.");
		location.href = "<%=request.getContextPath() %>/login?command=login";
		</script>
	<%
	}else if(str2 == null || str2.equals("")){
	%>
		<script type="text/javascript">
		alert("가입하신 내역이 없거나 잘못 입력하셨습니다");
		location.href = "<%=request.getContextPath() %>/findidpw?command=searchidpw";
		</script>	
	<%
	}	
}
%>

</body>
</html>