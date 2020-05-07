<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<%
	MemberDto mem = (MemberDto)session.getAttribute("login");
%>
<div class="container">
	<h1 class="mt-4 mb-3">QnA</h1>
	<hr>
	 <div class="row"  style = "width:90%; margin: 0 auto;">
      <div class="col mb-4">
        <form id="qnaform" method="post">
        	<input type="hidden" name="mem_id" value="<%=mem.getMem_id() %>">
          <div class="control-group form-group">
			<div class = "controls" align = "right">
                 <p>비밀글 <input type="checkbox"  id="secret" name="secret"></p>
            </div>
           </div>
          <div class="control-group form-group">
            <div class="controls" >
              <label>제목</label>
              <input type="tel" class="form-control" id="qna_title" name="qna_title">
            </div>
            
          </div>

          <div class="control-group form-group">
            <div class="controls">
              <label>내용</label>
              <textarea rows="10" cols="100" class="form-control" id="qna_content" name ="qna_content" style="resize:none"></textarea>
            </div>
          </div>
        <div align="center">
          	<button type="button" class="btn btn-primary" id="btn_add">문의하기</button>
          	<button type="button" class="btn btn-primary" onclick = "location.href='<%=request.getContextPath()%>/qnalist?command=user'">취소</button>
        </div>
        </form>
      </div>
    </div>
</div>
<script type="text/javascript">
$("#btn_add").click(function(){
	if($("#qna_title").val().trim()==""){
		alert("제목을 입력해주세요.");
		$("#qna_title").focus();
	} else if($("#qna_content").val().trim() ==""){
		alert("질문 내용을 입력해주세요.");
		$("#qna_content").focus();
	} else {
		$("#qnaform").attr({"action":"<%=request.getContextPath()%>/addQna?command=addAf", "target":"_self"}).submit();
	}
});
</script>

<%@ include file="./../include/footer.jsp"%>