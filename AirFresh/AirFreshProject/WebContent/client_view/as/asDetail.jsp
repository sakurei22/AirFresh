<%@page import="Dto.MemberDto"%>
<%@page import="Dto.AsAppDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDto mem = (MemberDto)session.getAttribute("login");
	AsAppDto dto = (AsAppDto) request.getAttribute("dto");
	
	//String wdate = dto.getWdate().substring(0,10);	//요청일
	//String savePath = request.getServletContext().getRealPath("/asupload");
	
	if(dto.getAsImgPath()!= null){
		int idx = dto.getAsImgPath().lastIndexOf(".");
		String str = dto.getAsImgPath().substring(idx+1);	//확장자
	}
	//String m_fileFullPath = savePath+"\\"+ dto.getAsImgPath()+"."+str;	//완전한 이미지 경로
	//System.out.println(m_fileFullPath);
%>
<%@ include file="./../include/header.jsp"%>
 <!-- 이미지 확대 관련 -->
 <link rel="stylesheet" href="magnific-popup/magnific-popup.css">
 <script src="magnific-popup/jquery.magnific-popup.js"></script>

<div class="container" style="margin-bottom: 100px;">
	 <h1 class="mt-4 mb-3">A/S내역
      <small>----</small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">마이페이지</a>
      </li>
      <li class="breadcrumb-item active">as예약내역</li>
    </ol>
    
	<form id="frm" action="<%=request.getContextPath() %>/updateAsApp" 
	method="post" enctype="multipart/form-data">
		<input type="hidden" name="pur_index" value="<%=dto.getPur_index() %>">
		<input type="hidden" name="seq" value="<%=dto.getAsSeq() %>"> 
		<input type="hidden" name="mem_id" value="<%= mem.getMem_id() %>"> 
		<fieldset>
				<div class="form-group">
				<label for="exampleTextarea">AS요청제품</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								readonly="readonly" name="prd_name" value="<%=dto.getPrd_name() %>">
						</div>
						<div style="clear: left"></div>
					</div>
				</div><!-- /form-group -->
				<div class="form-group">
					<label for="exampleTextarea">AS희망방문일</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control"
								name="req_date" id="datepicker" placeholder="희망 날짜를 선택해주세요" value="<%=dto.getReq_date()%>" readonly="readonly">
						</div>
						<div style="clear: left"></div>
					</div>
				</div><!-- /form-group -->
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">제목</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								name="astitle" value="<%=dto.getAsTitle()%>">
						</div>
						<div style="clear: left"></div>
					</div>
				</div><!-- /form-group -->
				<div class="form-group">
					<label for="exampleTextarea">증상설명</label>
					<textarea class="form-control" id="exampleTextarea" rows="10"
						cols="50" name="ascontent"><%=dto.getAsContent() %></textarea>
				</div><!-- /form-group -->
				<div class="form-group">
					<input type="file" class="form-control-file" id="exampleInputFile"
						aria-describedby="fileHelp" name="fileload">
				</div><!-- /form-group -->
				<div class="form-group">
					<% if(dto.getAsImgPath()== null){ %>
						첨부파일 없음
					<%
						} else {
					%>
					<a class="image-popup-vertical-fit" href="http://localhost:8090/AirFreshProject/asupload/<%=dto.getAsImgPath()%>" target="_self">
						<img src="http://localhost:8090/AirFreshProject/asupload/<%=dto.getAsImgPath()%>" style="width: 180px; height: 180px;" data-scale="2">
						</a>
						<input type="hidden" name="oldfile" value="<%=dto.getAsImgPath()%>">
					<%
						}
					%>
				</div><!-- /form-group -->
				
				<div align="center">
					<button type="button" class="btn btn-primary" onclick="location.href='javascript:window.history.back();'">돌아가기</button>
					<button type="button" class="btn btn-primary" id="_asBtn">수정하기</button>
					<button type="button" class="btn btn-primary" id="_delBtn">취소하기</button>
				</div>
		</fieldset>
	</form>	
	
</div>
<script>
	$(function () {
		 $( "#datepicker" ).datepicker(
	    			{ minDate: 0, 
	    			  maxDate: "+1M +10D",
	    			  dateFormat: "yy/mm/dd"
	    });
		 
		 $("#_delBtn").click(function() {
			var result = confirm("정말 취소하시겠습니까?");
			
			if(result){
				alert("정상적으로 취소되었습니다.");
				location.href= "./delAsApp?seq="+<%=dto.getAsSeq()%>
				
			} else return;
		}); 
		 		 
		 $("#_asBtn").click(function() {
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
			
			 var result = confirm("정말 수정하시겠습니까?");
				
				if(result){
					alert("정상적으로 수정되었습니다.");
					$("#frm").submit();
					
				} else return;
			
		
		});
	});
</script>
<%@ include file="./../include/footer.jsp"%>