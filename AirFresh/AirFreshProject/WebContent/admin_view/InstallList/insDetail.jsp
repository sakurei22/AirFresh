<%@page import="Dto.InstallDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="./../include/header.jsp" %>

<% 
	InstallDto dto = request.getAttribute("detailDto")==null? null:(InstallDto)request.getAttribute("detailDto");
%>

	<div class="container-fluid">
		<h1 class="mt-4 mb-3" >선택한 설치리스트 상세정보</h1>
		<hr><br>
		<div>
			<ol>
				<li>설치인덱스: <%=dto.getIns_index() %></li>
				<li>제품명: <%=dto.getPrd_model_name() %></li>
				<li>설치희망일: <%=dto.getIns_date() %></li>
				<li>회원아이디 : <%=dto.getMem_id() %></li>
				<li>회원이름 : <%=dto.getMem_name() %></li>
				<li>회원주소 : <%=dto.getMem_addr2() %></li>

			</ol>
		</div>
		<div align="center">
			<a href="#" id="back" class="btn btn-primary">돌아가기</a>
			<a href="#" id="comp" class="btn btn-primary">설치완료</a>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#back").click(function () {
				
				location.href="<%=request.getContextPath() %>/installConfirm?command=home";
			});
			
			$("#comp").click(function () {
				
				$.ajax({
					
					url:"<%=request.getContextPath() %>/installConfirm",
					type:"post",
					data:{
						command:"comp",
						ins: '<%=dto.getIns_index() %>'
					},
					datatype:"json",
					success: function (data) {
						//alert("통신성공");
						//alert(data);
						if(data=="true"){
							//alert("true");
							alert("설치완료 처리 성공");
							location.href="<%=request.getContextPath() %>/installConfirm?command=home";
						}else{
							//alert("false");
							alert("설치완료 처리에 실패했습니다.");
						}						
					},
					error: function () {
						alert("통신실패");
					}
				});
			});
			
			
		});
	</script>
	
<%@ include file="./../include/footer.jsp" %>