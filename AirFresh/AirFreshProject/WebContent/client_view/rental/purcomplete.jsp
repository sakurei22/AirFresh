

<%@page import="Dto.RentalDetailDto"%>
<%@page import="Dto.PurchaseNameDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Dto.PurchaseDto"%>
<%@page import="Dto.ModelDto"%>
<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<%


	MemberDto mem = (MemberDto) session.getAttribute("login");

	String command = request.getParameter("command");


	//상세내역 뽑아내기위한 dto
	RentalDetailDto dto = (RentalDetailDto) request.getAttribute("dto");
	int price = dto.getPrd_price();

	String addr = dto.getMem_addr1() + " " + dto.getMem_addr2() + " " + dto.getMem_addr3();
	DecimalFormat formatter = new DecimalFormat("###,###");
	String sprice = formatter.format(price);

%>

<!-- Page Content -->
<div class="container">
	<!-- Page Heading/Breadcrumbs -->
	<div class="" align="center">
		<h1 class="mt-4 mb-3"><%=mem.getMem_name()%>고객님의 신청이 완료되었습니다.
		</h1>
	</div>

	<ol class="breadcrumb" style="background-color: #fff;width: 1000px; margin: 0 auto;"  >
		<li class="breadcrumb-item">
			<!-- <a href="index.html">Home</a>
        <a href="#" style="padding-left: 20px">My Page</a> -->
			<div class="" style="margin: 20px;">
				<img src="<%=request.getContextPath()%>/client_view/img/apply_step.png"	alt="xx">
			</div>
		</li>
		<!--       <li class="breadcrumb-item active" ></li> -->
	</ol>

	<!-- 주문상세내역 -->
	<div style="border-top: 1px solid #ddd; text-align: center; margin-top: 50px; padding: 50px 0;">
		<fieldset>
			<h1 class="mt-4 mb-3" style="font-size: 27px;text-align: left;border"><span style="color:#d80546"><%=mem.getMem_name() %></span>고객님께서 신청해주신 상세내역입니다.</h1>
			<div class="tbl_frm01 tbl_wrap" style="text-align: left;border-top:3px solid #d80546;">
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
								<div style="width: 560px; float: left; font-size: 16pt"><%=dto.getPrd_name()%>
									<%=dto.getPrd_model_name()%>24개월약정 등록비0원 <br> 월 요금 : <span style="color: #ff0000"> <strong> <%=sprice%></strong></span> 원
								</div>
							</td>
						</tr>
						<tr>
							<th scope="row">신청일</th>
							<td><%= dto.getIns_date() %></td>
						</tr>
						<tr>
							<th scope="row">설치희망일</th>
							<td><%= dto.getIns_date() %></td>
						</tr>
						<tr>
							<th scope="row">고객명</th>
							<td><%=mem.getMem_name()%></td>
						</tr>
						<tr>
							<th scope="row">연락처</th>
							<td><%=mem.getMem_cell()%></td>
						</tr>
						<tr>
							<th scope="row">주소</th>
							<td colspan='3'><%=addr%></td>
						</tr>			
					</tbody>
				</table>
				<div class="" align="center" style="">
					<div class="" style="width: 50%;margin-top:50px; ">
							<ul class="shop_btns">
								<li class="mainhome" style="background-color: #d80546;">
									<a href="<%=request.getContextPath()%>/index.jsp">홈으로</a>
								</li>
								<li class="rentallist">
									<a href="<%=request.getContextPath() %>/printPurchase?id=<%=mem.getMem_id()%>">신청내역</a>
								</li>
							</ul>
						</div>
				</div>
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
				width: 47%;
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
<!-- /.container -->
<%@ include file="./../include/footer.jsp"%>