<%@page import="Dto.ManagerMemberDto"%>
<%@page import="Dto.QnaBbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./../include/header.jsp"%>
<%
QnaBbsDto qna = (QnaBbsDto) request.getAttribute("qnadto");
String sdate = qna.getWdate().substring(0, 10);
%>
<div class="container">
	<h1 class="mt-4 mb-3" >QnA</h1>
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

				<pre><%=qna.getQna_content() %></pre>
			</p>
			
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
     <%} else if(qna.getDepth()==0 && mrgMem.getMgr_auth()==0) {%>
     <div style = "padding-left : 50px;">
     	<div class="card my-4" >
          <h5 class="card-header">QnA 답변</h5>
          <div class="card-body">
            <form id="refrm" method="post">
              <div class="form-group">
                <textarea class="form-control" rows="3" name="re_content" id ="re_content"></textarea>
              </div>
              <button type="button" class="btn btn-primary" id = "btn_add">답변하기</button>
            </form>
          </div>
        </div>
        </div>
     <%} %>
	<div align="right" style = "padding :10px;">
				<a href="<%=request.getContextPath()%>/qnalist?command=admin" class="btn btn-primary">목록</a>
				<a href="<%=request.getContextPath()%>/updateqnabbs?command=adminUpdate&qna_index=<%=qna.getQna_index() %>" class="btn btn-primary">수정</a>
				<a href="#" onclick="deleteFunc()" class="btn btn-primary">삭제</a>
	</div>
</div>

<script type="text/javascript">
$("#btn_add").click(function(){
	if($("#re_content").val().trim()==""){
		alert("답변을 입력해주세요.");
		$("#re_content").focus();
	} else {
		$("#refrm").attr({"action":"<%=request.getContextPath()%>/updateqnabbs?command=admin&qna_index=<%=qna.getQna_index()%>", "target":"_self"}).submit();
	}
});

function deleteFunc() {
	var answer = confirm("정말 삭제하시겠습니까?");
	
	if(answer){
		location.href="<%=request.getContextPath()%>/qnadelete?command=admin&qna_index=<%=qna.getQna_index() %>";
	} else {
		return;
	}
}
</script>
<%@ include file="./../include/footer.jsp"%>