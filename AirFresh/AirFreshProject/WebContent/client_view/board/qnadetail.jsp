<%@page import="Dto.MemberDto"%>
<%@page import="Dto.QnaBbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<%
QnaBbsDto qna = (QnaBbsDto) request.getAttribute("qnadto");
MemberDto mem = (MemberDto)session.getAttribute("login");

String sdate = qna.getWdate().substring(0, 10);
%>
<div class="container">
	<h1 class="mt-4 mb-3">QnA</h1>
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">고객센터</li>
		<li class="breadcrumb-item active">QnA</li>
	</ol>
	
	<div class="card mb-4">
		<div class="card-body">
			<h2 class="card-title">
			<% if(qna.getQna_secret()==1){ %>
			<img src="<%=request.getContextPath()%>/client_view/img/lock.png">
			<%} %>
			<%=qna.getQna_title() %></h2>
				
			<p align="right"><span style="margin-right: 30px;"><%=qna.getMem_id()%></span> <span><%=sdate %></span></p>
			<hr>
			<p class="card-text">

				<pre><%=qna.getQna_content() %></pre></p>
			
		</div>

	</div>
	
	<% if(qna.getDepth()==1){ 
		String rdate = qna.getRe_date().substring(0, 10);
	%>
	<div style = "padding-left : 50px;">
		 <div class="card mb-4" >
		 <h5 class="card-header">Air Fresh 답변</h5>
	          <div class="card-body">
	            	
	            	<p class="card-text"><pre><%=qna.getRe_content() %></pre></p>
	            	
	            	<p align = "right"><span style ="padding-right:20px">관리자</span><%=rdate %></p>
	            </div>
	        </div>
        </div>
     <%} %>
	<div align="right" style = "padding :10px;">
		<%if(mem != null){ %>
				<% if(qna.getDepth()==0 && mem.getMem_id().equals(qna.getMem_id()) ){%>
				<a href="<%=request.getContextPath()%>/updateqnabbs?command=user&qna_index=<%=qna.getQna_index() %>" class="btn btn-primary">수정</a>
				<%} %>
				<a href="#" onclick="deleteFunc()" class="btn btn-primary">삭제</a>
				
		<%} %> 
				<a href="<%=request.getContextPath()%>/qnalist?command=user" class="btn btn-primary">목록</a>
	</div>
	</div>
	
	
<script type="text/javascript">
	function deleteFunc() {
	var answer = confirm("정말 삭제하시겠습니까?");
	
	if(answer){
		location.href="<%=request.getContextPath()%>/qnadelete?command=user&qna_index=<%=qna.getQna_index() %>";
	} else {
		return;
	}
}
</script>
<%@ include file="./../include/footer.jsp"%>