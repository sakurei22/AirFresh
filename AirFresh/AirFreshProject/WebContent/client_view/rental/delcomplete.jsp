<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>

<%
	String command = request.getParameter("command");
	System.out.println("command: "+command);
	
	if(command.equals("true")){
%>

	<div class="container" style="margin-bottom: 100px;">
		<h1>주문 취소 성공</h1>
	</div>
<%
	}
%>

<%@ include file="./../include/footer.jsp"%>