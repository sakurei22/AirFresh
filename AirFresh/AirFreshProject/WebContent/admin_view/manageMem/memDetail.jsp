<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>

<%
	MemberDto dto = (MemberDto) request.getAttribute("dto");
	System.out.println("도착한 정보 : " + dto.toString());

	String addr = dto.getMem_addr2() + dto.getMem_addr3();
%>


<div class="container-fluid">
	<h1 class="mt-4 mb-3">고객 상세정보</h1>
	<hr>
	<div style="text-align: center; margin-top: 20px; padding: 50px 0;">
		<fieldset>
			<div class="tbl_frm01 tbl_wrap" style="text-align: left;">
				<div class="tablewrap" style="margin-left: 100px;">
					<table class="board-view bg_no" cellspacing="0" cellpadding="10px" style="width: 80%;">
						<colgroup>
							<col width="16%">
							<col width="34%">
							<col width="16%">
							<col width="">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">회원 아이디</th>
								<td><%=dto.getMem_id()%></td>
							</tr>
							<tr>
								<th scope="row">이름</th>
								<td><%=dto.getMem_name()%></td>
							</tr>
							<tr>
								<th scope="row">연락처</th>
								<td><%=dto.getMem_cell()%></td>
							</tr>
							<tr>
								<th scope="row">생년월일</th>
								<td><%=dto.getMem_birth()%></td>
							</tr>
							<tr>
								<th scope="row">주소</th>
								<td>(<%=dto.getMem_addr1()%>) <%=addr%></td>
							</tr>
							<tr>
								<th scope="row">가입일</th>
								<td><%=dto.getMem_in_date()%></td>
							</tr>
							<tr align="center" style="margin-top:50px;">
								<td colspan="2" style="border-bottom: none;" >
									<div style="margin-top: 30px;">
									<a href="<%=request.getContextPath()%>/adminMemList" class="btn btn-primary">목록으로</a>
									</div>
								</td>
							</tr> 
						</tbody>
					</table>
				</div>
			</div>
		</fieldset>
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

</style>

<%@ include file="./../include/footer.jsp"%>