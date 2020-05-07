
<%@page import="java.text.DecimalFormat"%>
<%@page import="Dto.RentalDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	RentalDetailDto dto = (RentalDetailDto) request.getAttribute("dto");
	int price = dto.getPrd_price();
	DecimalFormat formatter = new DecimalFormat("###,###");
	String sprice = formatter.format(price);
%>

<%!public String purchaseCancle(int order_auth) {
		String str = "";
		if (order_auth == 0) {
			str = "렌탈 신청";
		} else if (order_auth == 1) {
			str = "렌탈 취소";
		}
		return str;
	}%>
<%@ include file="./../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="mt-4 mb-3">
		고객 렌탈 상세 내역 <small>User Rental Detail</small>
	</h1>
	<hr>
	<div class="tbl_frm01 tbl_wrap" style="text-align: left;">
		<table class="board-view bg_no" cellpadding="8px"  width="100%"
			border="1">
			<tbody>
				<tr>
					<th scope="row">제품명</th>
					<td>
								<%=dto.getPrd_name()%>
					</td>
							<th scope="row">모델명</th>
					<td>
						<%=dto.getPrd_model_name()%>
					</td>
				</tr>

				<tr>
					<th scope="row">신청일</th>
					<td><%=dto.getPur_date()%></td>
					<th scope="row">설치희망일</th>
					<td><%=dto.getIns_date()%></td>
				</tr>
				<tr>
					<th scope="row">아이디</th>
					<td><%=dto.getMem_id()%></td>
					<th scope="row">이름</th>
					<td><%=dto.getMem_name()%></td>
					
				</tr>
				<tr>
					<th scope="row">연락처</th>
					<td><%=dto.getMem_cell()%></td>
					<th scope="row">받으실 주소</th>
					<td><%=dto.getMem_addr2() %></td>
				</tr>
				<tr>
					<th scope="row">진행상태</th>
					<%
						if (dto.getComp_date() == null) {
					%>
					<td colspan="3">설치진행 중</td>
					<%
						} else {
					%>
					<td colspan="3"><%=dto.getComp_date() %> 설치완료</td>
					<%
						}
					%>
				</tr>
				<tr>
					<td colspan="4" align="center"><img
										src="<%=request.getContextPath()%>/client_view/model/prd_img/<%=dto.getPrd_model_name()%>.png"></td>
				</tr>
			</tbody>
		</table>
	<div align="center" style="margin-bottom:10px; margin-top: 10px; ">
			<button type="button" class="btn btn-primary"
				onclick="location.href='<%=request.getContextPath()%>/rentallist'">목록</button>
		</div>
	</div>

	<%@ include file="./../include/footer.jsp"%>