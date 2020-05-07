<%@page import="Dto.PurchaseNameDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="./../include/header.jsp"%>
<%
	List<PurchaseNameDto> list = (List<PurchaseNameDto>) request.getAttribute("rentalList");

	int len = (int) request.getAttribute("rentallen");
	
	int bbsPage = len / 10;
	if (len % 10 > 0) {
		bbsPage = bbsPage + 1;
	}

	String spageNumber = request.getParameter("pageNumber");
	int pageNumber = 0;

	if (spageNumber != null && !spageNumber.equals("")) {
		pageNumber = Integer.parseInt(spageNumber);
	}
%>

<%!
	public String purchaseCancle(int order_auth){
		String str = "";
		if (order_auth == 0){
			str = "렌탈 신청";
		} else if(order_auth ==1){
			str = "렌탈 취소";
		}
		return str;
	}

%>


<div class="container-fluid">
	<h1 class="mt-4 mb-3">렌탈 리스트</h1>
	<form id="noticelistForm" method="post">
		<input type="hidden" name="command" value="multiDelete">
		<table class="table table-hover" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" name="alldel"
						onclick="deleteChecks(this.checked)"></th>
					<th>번호</th>
					<th>렌탈번호</th>
					<th>제품명</th>
					<th>구매 아이디</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				
				<%
					if (list.size() == 0 || list == null) {
				%>
				<tr>
				<td colspan="6" align="center">렌탈 내역이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
						for(int i = 0; i < list.size(); i++){
							PurchaseNameDto purchase = list.get(i);
				%>
				<tr>
					<td><input type = "checkbox" name = "delck" value = "<%=purchase.getPur_index()%>"></td>
					<th><%=i+1 %></th>
					<td><%=purchase.getPur_index() %></td>
					<td onclick="location.href='<%=request.getContextPath()%>/detailPur?command=admin&seq=<%=purchase.getPur_index() %>'" style="cursor: pointer;"
				title="클릭하면 상세내역을 보실 수 있습니다."><%=purchase.getPrd_model_name() %></td>
					<td><%=purchase.getMem_id() %></td>
					<td><%=purchaseCancle(purchase.getOrder_auth()) %></td>
				</tr>
				<%	}
				}%>
				
				
			</tbody>
		</table>
	</form>
			<div align = "center">
			<ul class="pagination" style = "display : inline-flex;">
			
				<%
					for (int i = 0; i < bbsPage; i++) { // [1] 2 [3]
						if (pageNumber == i) { // 현재 페이지
				%>
				<li class="page-item active"><a class="page-link" href ="#"><%=i + 1%></a></li>
				<%
					} else { // 그 외의 페이지
				%>
				<li class="page-item"><a href="#none" class="page-link"
					title="<%=i + 1%>페이지" onclick="goPage(<%=i%>)"><%=i + 1%></a></li>
				<%
					}
				}
				%>
			</ul>
		</div>
</div>

<script type="text/javascript">
	function deleteChecks(ch) {
		//alert(ch);
		var arrCheck = document.getElementsByName("delck");
		for (var i = 0; i < arrCheck.length; i++) {
			arrCheck[i].checked = ch;
		}
	}

	function goPage( pageNum ) {


		location.href = "<%=request.getContextPath()%>/rentallist?pageNumber=" + pageNum;
	}
	</script>
<%@ include file="./../include/footer.jsp"%>