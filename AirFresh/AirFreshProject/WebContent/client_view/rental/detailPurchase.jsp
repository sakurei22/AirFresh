<%@page import="java.text.DecimalFormat"%>
<%@page import="Dto.RentalDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../include/header.jsp"%>


<% 
		RentalDetailDto dto = (RentalDetailDto) request.getAttribute("dto");
	  MemberDto mem = (MemberDto) session.getAttribute("login");
	  
	  String addr = mem.getMem_addr1() + " " + mem.getMem_addr2() + " " + mem.getMem_addr3();

	 	int price = dto.getPrd_price();

		DecimalFormat formatter = new DecimalFormat("###,###");
		String sprice = formatter.format(price);
 

%>

<!-- Page Content -->
<div class="container" style="margin-bottom: 100px;">
	<h1 class="mt-4 mb-3">
		상세 내역 <small>Rental Detail</small>
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">마이페이지</a></li>
		<li class="breadcrumb-item active">렌탈상세내역</li>
	</ol>

	<!-- 주문상세내역 -->
	<div style=" text-align: center; margin-top: 20px; padding: 50px 0;">
		<fieldset>
			<div class="tbl_frm01 tbl_wrap" style="text-align: left;">
				<table class="board-view bg_no" cellspacing="0" cellpadding="8px"
					summary="온라인문의를 위한 상품선택, 고객명, 연락처, 주소 상세내역입니다.">
					<colgroup>
						<col width="16%">
						<col width="34%">
						<col width="16%">
						<col width="">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">제품명</th>
							<td colspan="3">
								<div style="width: 80px; float: left">
									<img
										src="<%=request.getContextPath()%>/client_view/model/prd_img/<%=dto.getPrd_model_name()%>.png"
										width='60px' alt="xx">
								</div>
								<div style="width: 560px; float: left; font-size: 16pt" >
									<a href="<%=request.getContextPath() %>/modelDetail?command=detail&seq=<%= dto.getPrd_index() %>" title="클릭하면 상품정보로 이동합니다." style="text-decoration: none;"><%=dto.getPrd_name()%>
									<%=dto.getPrd_model_name()%>24개월약정 등록비0원 <br> 월 요금 : <span style="color: #ff0000"> <strong> <%=sprice%></strong></span> 원
									</a>
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">신청일</th>
							<td><%= dto.getPur_date() %></td>
						</tr>
						<tr>
							<th scope="row">설치희망일</th>
							<td><%= dto.getIns_date() %></td>
						</tr>
						<tr>
							<th scope="row">연락처</th>
							<td><%=mem.getMem_cell()%></td>
						</tr>
						<tr>
							<th scope="row">받으실 주소</th>
							<td colspan='3'><%=addr%></td>
						</tr>			
						<tr>
							<th scope="row">진행상태</th>
							<% if(dto.getIns_state()==0){ %>
								<td colspan='3'>설치진행 중</td>
							<% } else if(dto.getIns_state()==1) { %>
								<td colspan='3'>설치완료</td>
							<%
								}
							%>
						</tr>
					</tbody>
				</table>
				<div class="" align="center" style="">
					<div class="" style="width: 50%;margin-top:50px; ">
							<ul class="shop_btns">
								<li class="mainhome" style="background-color: #d80546;">
									<a href="<%=request.getContextPath()%>/printPurchase">돌아가기</a>
								</li>
								<li class="btnli">
									<% if( dto.getComp_date() != null && dto.getReview()==0 ){ %>
										<a href="<%=request.getContextPath() %>/reviewWrite?pur=<%=dto.getPur_index() %>">리뷰작성</a>										
									<% } else if(dto.getReview() ==1 ){
									%>
										<a href="<%=request.getContextPath() %>/renReDetail?pur=<%=dto.getPur_index() %>">리뷰보기</a>
									<%	
									}
										else if(dto.getComp_date() == null && dto.getReview()==0 ) { 
										// 설치 완료되지않았고 리뷰가 작성되지않았을때
									%>
										<a href="<%=request.getContextPath()%>/delPur?seq=<%= dto.getPur_index()%>&del=detail" 
										onclick="del()">취소하기</a>
									<%
										}
									%>
								
							</ul>
						</div>
				</div>
				
				<script>
					function del() {
						if(confirm('정말 취소하시겠습니까?')){
							alert("정상적으로 취소되었습니다.");
						}						
					}
				</script>
			<style>	
			th {
				text-align: center;
				border-bottom: 1px solid #EAEAEA;
			}
				
			td {
				border-bottom: 1px solid #EAEAEA;
			}
			
			.shop_btns {
				padding-left: 0;
				width: 100%;
			}
	 		.mainhome {
				float: left;
			} 
			
			.shop_btns li {
				width: 48%;
				display: inline-block;
				margin: 0 auto;
				border: 1px solid #fff;
				background-color: #343a40;
				font-size: 16px;
				line-height: 50px;
			}
			
			.shop_btns li a {
				display: block;
				color: #fff;
				text-align: center;
			}
			
			a:hover, a:active, a:visited, a:link {
				text-decoration: none;
			}
		</style>
			</div>
		</fieldset>
	</div>
</div>


<%@ include file="./../include/footer.jsp"%>