<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	MemberDto mem = (MemberDto) session.getAttribute("login");	
%>
	
<%@ include file="./../include/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/page.css" />

<div class="container" style = "margin-bottom : 40px">
    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Air FRESH 마이페이지</h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">Home</a>
      </li>
      <li class="breadcrumb-item active">마이페이지</li>
      <li class="breadcrumb-item active">내 정보</li>
    </ol>

	<div>
		<p><em><%=mem.getMem_name() %></em> 고객님, 안녕하세요!</p>					
	</div>		
<hr>
<div class="row justify-content-center">
<div class="col-lg-9">
	<div class="card border-0 rounded-lg mt-9">						<!-- update -->
	<form id="frm" action="<%=request.getContextPath()%>/updatemem?command=upview" method="post">
		<fieldset>				
		<div class="form-group" >
      		<label class="col-sm-2 col-form-label">이름</label>
      		<div class="col-sm-7">
        		<input type="text" class="form-control" id="mem_name" name="mem_name" value="<%=mem.getMem_name() %>" readonly="readonly">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">아이디(E-Mail)</label>
      		<div class="col-sm-7">      			
        		<input type="text" class="form-control" id="mem_id" name="mem_id" value="<%=mem.getMem_id() %>" readonly="readonly">        		       		
     		 </div>
    	</div>
    	<%-- <div class="form-group">
      		<label class="col-sm-4 col-form-label">패스워드</label>
      		<div class="col-sm-4" style="margin-bottom:5px;">
        		<input type="text" class="form-control" id="mem_pw" name="mem_pw" value="<%=mem.getMem_pw() %>" readonly="readonly">
        	</div>        	
    	</div> --%>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">휴대폰번호</label>
      		<div class="col-sm-7">
        		<input type="text" class="form-control" id="mem_cell" name="mem_cell" value="<%=mem.getMem_cell() %>" readonly="readonly">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">생년월일</label>
      		<div class="col-sm-7">
        		<input type="text" class="form-control" id="mem_birth" name="mem_birth" value="<%=mem.getMem_birth() %>" readonly="readonly">
     		 </div>
    	</div>
    	<div class="form-group">
      		<label class="col-sm-2 col-form-label">주소</label>
      		<div class="col-sm-7">      			
        		<input type="text" class="form-control" id="mem_addr" name="mem_addr"
					value="<%=mem.getMem_addr1() %> <%=mem.getMem_addr2() %> <%=mem.getMem_addr3() %>" readonly="readonly">								
				<div style="clear:left;"></div>				
     		 </div>	      		       		
    	</div>
    	<div class="form-group" align="center" style ="margin-top:20px; margin-bottom:30px;">
    	<input type="button" class ="btn btn-primary btn-lg"
					value="수정하러가기" id="_btnUpdate">
    	</div>
	</fieldset>

	</form>
	</div>
	</div>
	</div>
</div>

<script type="text/javascript">
	$("#_btnUpdate").click(function () {
		<%-- location.href = "<%=request.getContextPath() %>/updatemem?command=update"; --%>
		$("#frm").submit();
	});
</script>	
<%@ include file="./../include/footer.jsp"%>

