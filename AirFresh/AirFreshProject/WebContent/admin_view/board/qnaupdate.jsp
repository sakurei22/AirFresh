<%@page import="Dto.QnaBbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    QnaBbsDto qna = (QnaBbsDto) request.getAttribute("qnadto");
    
    %>
<%@ include file="./../include/header.jsp"%>
<div class="container">
	<h1 class="mt-4 mb-3" >QnA</h1>
	<hr>
	 <div class="row"  style = "width:90%; margin: 0 auto;">
      <div class="col mb-4">
        <form id="qnaform" action="<%=request.getContextPath()%>/updateqnabbs?command=adminUpdateAf" method="post">
          <div class="control-group form-group">
          	<input type="hidden" name = "qna_index" value="<%=qna.getQna_index() %>">
			<div class = "controls" align = "right">
                 <p>비밀글 <input type="checkbox"  id="secret" name="secret" <%=qna.getQna_secret()==1? "checked":"" %>></p>
            </div>
           </div>
          <div class="control-group form-group">
            <div class="controls" >
              <label>제목</label>
              <input type="tel" class="form-control" id="qna_title" name="qna_title" readonly value ="<%=qna.getQna_title()%>">
            </div>
            
          </div>

          <div class="control-group form-group">
            <div class="controls">
              <label>내용</label>
              <textarea rows="10" cols="100" class="form-control" id="qna_content" readonly name ="qna_content" style="resize:none"><%=qna.getQna_content() %></textarea>
            </div>
          </div>
        <div align="center">
          	<button type="submit" class="btn btn-primary" >수정하기</button>
          	<button type="button" class="btn btn-primary" onclick = "location.href='<%=request.getContextPath()%>/qnalist?command=admin'">취소</button>
        </div>
        </form>
      </div>
    </div>
</div>


<%@ include file="./../include/footer.jsp"%>