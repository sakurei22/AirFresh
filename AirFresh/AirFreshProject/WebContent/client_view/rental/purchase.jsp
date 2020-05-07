<%@page import="java.text.DecimalFormat"%>
<%@ include file="./../include/header.jsp"%>
<%@page import="Dto.ModelDto"%>
<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<%
	MemberDto mem = (MemberDto) session.getAttribute("login");
	ModelDto model = (ModelDto) session.getAttribute("model");
	String addr = mem.getMem_addr1() + " " + mem.getMem_addr2() + " " + mem.getMem_addr3();

	int price = model.getPrd_price();

	DecimalFormat formatter = new DecimalFormat("###,###");
	String sprice = formatter.format(price);
%>

<div class="container">
	<div class="row" style="display: inline-block;">
			<!-- 항목 -->
				<form id="frm" method="post" action="./addPurchase">
					<fieldset>
						<h1 class="mt-4 mb-3">온라인 렌탈신청</h1>
						<div class="tbl_frm01 tbl_wrap">
							<table class="board-view bg_no" cellspacing="0" cellpadding="8px"
								summary="온라인문의를 위한 상품선택, 고객명, 연락처, 주소 입력란입니다.">
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
													src="<%=request.getContextPath()%>/client_view/model/prd_img/<%=model.getPrd_model_name()%>.png"
													width='60px' alt="xx">
											</div>
											<div style="width: 560px; float: left; font-size: 16pt"><%=model.getPrd_name()%>
												<%=model.getPrd_model_name()%>24개월약정 등록비0원 <br>
												 월 요금 : <span style="color: #ff0000">
													<strong> <%=sprice%></strong></span> 원
											</div>
										</td>
									</tr>
									<tr>
										<th scope="row">고객명</th>
										<td><input type="text" size="40" class="input"
											name="name" id="customer_name" value="<%=mem.getMem_name()%>"
											readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">연락처</th>
										<td><input type="text" name="tel" size="40" class="input"
											value="<%=mem.getMem_cell()%>" readonly="readonly"></td>
									</tr>
									<tr>
										<th scope="row">주소</th>
										<td colspan='3'><input type="text" class="input"
											name="address1" id="customer_name" value="<%=addr%>"
											readonly="readonly" size="60px"></td>
									</tr>
									<tr>
										<th scope="row">설치희망일</th>
										<td><input type="text" name="ins_date" id="datepicker"
											placeholder="선택해주세요" readonly="readonly" style="cursor: pointer;"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</fieldset>

					<div style="">
						<div id="agree_view" style="">
							<span style="font-weight: bold; font-size: 16pt;">※개인정보수집이용동의※</span>
							<dl style="margin: 10px">
								<dt>1. 개인정보의 수집 및 이용목적 :</dt>
								<dd>원활한 렌탈 상담 및 주문을 위한 참조자료로 아래와 같은 항목의 개인정보를 수집하고 있습니다.</dd>
								<dt>2.수집하려는 개인정보 항목:</dt>
								<dd>필수 수집항목 : 이름, 연락처, 주소</dd>
								<dt>3. 개인정보의 보유 및 이용기간 :</dt>
								<dd>수집된 정보는 이용자의 정보 삭제 요구 시까지 보관, 활용하며 수집 및 이용 목적이 달성된 후 해당
									정보를 지체 없이 파기합니다.</dd>
								<dt>4. 개인정보 수집 동의거부 사항 :</dt>
								<dd>이용자의 개인정보는 원활한 상담을 위해 수집하고 있으며, 동의하지 않을 경우 상담 및 주문이
									제한됩니다.</dd>
							</dl>								
						</div>
							<p class="pcls"><input type="checkbox" id="_agree" name="agree" checked onclick=""> &nbsp;<label for="agree" id="agree">개인정보 수집 및 이용에 대해 동의합니다.</label></p>

					</div>
					<div align="center">
						<input type="button" value="신청하기" id="_purBtn">
					</div>
				</form>
				</div>
			</div>
<style>
th {
	text-align: right;
	border-bottom: 1px solid #EAEAEA;
}

td {
	border-bottom: 1px solid #EAEAEA;
}
.pcls {
	margin-top: 10px;
}
#agree_view {
	padding: 20px;
	/* position: absolute; */
/* 	width: 400px; */
	left: 36%;
	top: 112px;
	margin-top:20px;
	background-color: #fff;
	border: 1px solid #343a40;
	overflow: hidden;
	text-align: left;
	color: #555;
}

#_purBtn {
	padding: 0 50px;
	margin-bottom: 20px;
	border: 1px solid #fff;
	color: #fff;
	background-color: #343a40;
	font-size: 16px;
	line-height: 50px;
}
</style>
<script>
	$(document).ready(function() {
		
		

		$("#datepicker").datepicker({
			minDate : 0,
			maxDate : "+1M +10D",
			dateFormat : "yy-mm-dd"
		});

		$("#_purBtn").click(function() {
			if ($("#datepicker").val() == "") {
				alert("설치를 희망하는 날짜를 선택해주세요.");
				$("#datepicker").focus();
			} else if ( $("#_agree").prop("checked")==false){
				alert("개인정보 수집 및 이용에 동의해주셔야합니다.");
				return;
			} else {
				alert("정상적으로 접수되었습니다.");
				$("#frm").submit(); 
			}
		}); 
		
	});
</script>
<%@ include file="./../include/footer.jsp"%>