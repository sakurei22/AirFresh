<%@page import="Dto.PurchaseNameDto"%>
<%@page import="Dto.ModelDto"%>
<%@page import="java.util.List"%>
<%@page import="Dto.PurchaseDto"%>
<%@page import="Dao.impl.PurchaseDao"%>
<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./../include/header.jsp"%>

<%
	MemberDto mem = (MemberDto)session.getAttribute("login");

	//List<PurchaseDto> list = (List<PurchaseDto>) request.getAttribute("list");	
	List<PurchaseNameDto> list = (List<PurchaseNameDto>)request.getAttribute("list");
	// System.out.println("list 갯수: " + list.size());
	
%>


<div class="container" style="margin-bottom: 100px;">
	<h1 class="mt-4 mb-3">
		구매내역 <small>Rental List</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">마이페이지</a></li>
		<li class="breadcrumb-item active">렌탈내역</li>
	</ol>

	<div style="clear: left"></div>
	<table class="table table-hover">
		<col width="100">
		<col width="100">
		<col width="100">
		<col width="300">
		<col width="100">
		<col width="120">
		<thead>
			<tr align="center">
				<th scope="col">구매일</th>
				<th scope="col">설치희망일</th>
				<th scope="col">진행상태</th>
				<th scope="col">상품명</th>
				<th scope="col">구매여부</th>
				<th scope="col">렌탈후기</th>
			</tr>
		</thead>
		<tbody>

			<%
				if (list == null || list.size() == 0) {
			%>
			<tr align="center">
				<th colspan="6">구매내역이 없습니다.</th>
			</tr>

			<%
				} else {
					for (int i = 0; i < list.size(); i++) {
						PurchaseNameDto dto = list.get(i);

						if (dto.getOrder_auth() == 0) {
						%>
						<tr align="center" >
							<td><%=dto.getPur_date()%></td>
							<td><%=dto.getIns_date()%></td>
								<% if(dto.getIns_state()==0) { %>
									<td>설치진행 중</td>
								<% } else { %>
									<td>설치완료</td>
								<%
									}
								%>
							<td onclick="location.href='<%=request.getContextPath()%>/detailPur?command=user&seq=<%=dto.getPur_index() %>'" style="cursor: pointer;"
							title="클릭하면 상세내역을 보실 수 있습니다."><img
								src="<%=request.getContextPath()%>/client_view/model/prd_detail_img/<%=dto.getPrd_model_name()%>_m1.png"
								alt="" style="width: 40px; height: 40px;"> <b><%=dto.getPrd_name()%></b>
								(<%=dto.getPrd_model_name()%>)</td>
								<% if(dto.getIns_state()==0 ){ %>
							<td><a href="#" class="delPer" aaa="<%=dto.getPur_index()%>">구매취소</a></td>
							<% } else if(dto.getIns_state()==1){ %>
								<td>구매확정</td>
							<%
								}
								if(dto.getReview() == 0 && dto.getIns_state()==1){
									%>
									<td><a href="<%=request.getContextPath() %>/reviewWrite?pur=<%=dto.getPur_index() %>">리뷰작성</a></td>		
									<%
								}else if(dto.getReview()==0 && dto.getIns_state()==0){
									%>
									<td><a href="#" onclick="alert('설치가 완료되어야 리뷰작성이 가능합니다.')">리뷰작성</a></td>
									<%
								} else {
									%>
									<td><a href="<%=request.getContextPath() %>/renReDetail?pur=<%=dto.getPur_index() %>">리뷰보기</a></td>
									<%
								}
							%>	
						</tr>
						<%
						} else if (dto.getOrder_auth() == 1) { //구매취소된 주문일때
						%>
						<tr align="center">
							<td><%=dto.getPur_date()%></td>
							<td>취소완료</td>
							<td>취소완료</td>
							<td style="cursor: pointer;" ><img
								src="<%=request.getContextPath()%>/client_view/model/prd_detail_img/<%=dto.getPrd_model_name()%>_m1.png"
								alt="" style="width: 40px; height: 40px;"> <b><%=dto.getPrd_name()%></b>
								(<%=dto.getPrd_model_name()%>)</td>
							<td>취소완료</td>
							<td>취소완료</td>
						</tr>
						<%
						} //else if문종료
					} //for문종료
				} //else문 종료
			%>
		</tbody>
	</table>
</div>
<script>

			$(document).ready(function() {
				$(".delPer").on("click",function() {
					var result = confirm ("정말 취소하시겠습니까?");			
					/*  if(result){
						alert("정상적으로 취소되었습니다.");
					} else return; 
					 */
					 
					 var aa = $(this).attr("aaa");
					 var del = $(this);
					 //alert(aa);
					 //alert(result);
					  if(result){
						$.ajax({
							url:"<%=request.getContextPath()%>/delPur",
							type : "post",
							data : { seq : aa, del : "rlist" }, 
					traditional : true,
					datatype : "text",
					success : function(data) {
						//alert("통신성공");
						var d = JSON.parse(data);
						//alert("data:"+data+"d: "+d);
						
						var tr = del.parent().parent();
						var td = tr.children();

						//alert("tr:" + tr + ", td: " + td);

						if(d=="true"){
							td.eq(1).text("취소완료");
							td.eq(2).text("취소완료");
							td.eq(3).attr('onclick','').unbind("click");
							td.eq(3).children().removeAttr('href');
							td.eq(4).children().text("취소완료"); 
							td.eq(5).children().text(" ");  
							
							alert("정상적으로 취소되었습니다.");
							console.log("클릭한 row의데이터:"+tr.text());
							
						} else {
							alert("실패");
							
						} 
	
					},
					error : function() {
						alert("통신실패");
					} //error
				});//ajax
			} //if문
		});//click
	});//document
</script>

<%@ include file="./../include/footer.jsp"%> 