<%@page import="Dto.PurchaseNameDto"%>
<%@page import="java.util.List"%>
<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
 <%
	 MemberDto mem = (MemberDto)session.getAttribute("login");
     String prd_name = request.getParameter("prd");
     String seq = request.getParameter("seq"); 
 %>
 
 
 <div class="container" style="margin-bottom: 100px;">
	 <h1 class="mt-4 mb-3">A/S신청<small>----</small></h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">마이페이지</a>
      </li>
      <li class="breadcrumb-item active">as예약</li>
    </ol>
    
    	<hr>
		<form action="<%=request.getContextPath() %>/addAsApp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pur_index" value="<%=seq %>">
			<input type="hidden" name="mem_id" value="<%=mem.getMem_id()%>">
			<fieldset>
				<div class="form-group">
					<label for="exampleTextarea">AS요청제품</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								readonly="readonly" name="prd_name" value="<%=prd_name %>">
						</div>
						<div style="clear: left"></div>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleTextarea">AS희망방문일</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control"
								name="req_date" id="datepicker" placeholder="희망 날짜를 선택해주세요" readonly="readonly">
						</div>
						<div style="clear: left"></div>
					</div>
				</div>
					<div class="form-group">
					<label class="col-form-label" for="inputDefault">제목</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								name="astitle">
						</div>
						<div style="clear: left"></div>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleTextarea">증상설명</label>
					<textarea class="form-control" id="exampleTextarea" rows="10"
						cols="50" name="ascontent"></textarea>
				</div>
				<div class="form-group">
					<input type="file" class="form-control-file" id="exampleInputFile"
						aria-describedby="fileHelp" name="fileload">
				</div>
				<div align="center">
					<button type="submit" class="btn btn-primary">글쓰기</button>
				</div>
			</fieldset>
		</form>

	
	<%-- <form id="frm" action="<%=request.getContextPath() %>/addAsApp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pur_index" value="<%=seq %>">
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td><input type="text" readonly="readonly" name="mem_id" value="<%= mem.getMem_id() %>"></td>
			</tr>
			<tr>
				<td>AS요청제품</td>
				<td><input type="text" readonly="readonly" name="prd_name" value="<%=prd_name %>"></td>
			</tr>
			<tr>
				<td>as방문희망일</td>
				<td><input type="text" name="req_date" id="datepicker" placeholder="희망 날짜를 선택해주세요" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>이미지첨부</td>
				<td><input type="file" name="fileload" style="width: 400px"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="astitle" id="_astitle" size="50"></td>
			</tr>
			<tr>
				<td>증상설명</td>
				<td><textarea rows="20" cols="50" name="ascontent" id="_ascontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="메인으로" onclick="location.href='#'">
					<input type="button" value="A/S신청하기" id="_asBtn">
				</td>
			</tr>
		</table>
	</form> --%>

</div>
<script>
	$(function () {
		 $( "#datepicker" ).datepicker(
	    			{ minDate: 0, 
	    			  maxDate: "+1M +10D",
	    			  dateFormat: "yy-mm-dd"
	    });
		 
		 $("button").click(function() {
/* 			if($("#datepicker").val()==""){
				alert("as방문 희망날짜를 선택해주세요.");
				$("#datepicker").focus();
			} else if($("#_astitle").val()==""){
				alert("제목을 작성해주세요");
				$("#_astitle").focus();
			} else if($("#_ascontent").val()==""){
				alert("증상을 작성해주세요");
				$("#_ascontent").focus();				
			} else {
				alert("as신청이 정상적으로 접수되었습니다.");
				$("#frm").submit();
			} */
			
			// $("#frm").submit();
		});
	});
</script>
<%@ include file="./../include/footer.jsp"%>