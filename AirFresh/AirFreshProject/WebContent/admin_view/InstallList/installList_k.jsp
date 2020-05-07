<%@page import="Dto.InstallDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="./../include/header.jsp"%>
<%
	List<InstallDto> list = (List<InstallDto>) request.getAttribute("installList");
	List<InstallDto> comflist = (List<InstallDto>) request.getAttribute("comfllList");

%>

<div class="container-fluid">
	<h1 class="mt-4 mb-3">설치 리스트</h1>
	<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#wait">설치 대기</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#comp">설치 완료</a>
  </li>
</ul>
<div id="myTabContent" class="tab-content">
  <div class="tab-pane fade show active" id="wait">
  <div style = "padding-top : 10px;">
   <table class="table table-hover" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th>설치번호</th>
					<th>모델명</th>
					<th>회원명</th>
					<th>구매일자</th>
					<th>설치희망일</th>
					<th>주소</th>
					<th>직원이름</th>
				</tr>
			</thead>
			<tbody>
				<%if (list.size() == 0 || list == null) {%>
				<tr>
				<td colspan="6" align="center">설치 내역이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
						for(int i = 0; i < list.size(); i++){
							InstallDto install = list.get(i);
				%>
				<tr>
					<td><%=install.getIns_index() %></td>
					<td><%=install.getPrd_model_name()%></td>
					<td><%=install.getMem_name() %></td>
					<td><%=install.getPur_date().substring(0, 10) %></td>
					<td><%=install.getIns_date().substring(0, 10) %></td>
					<td><%=install.getMem_addr2() %></td>
					<td>
						<%if(install.getMgr_name()!=null){ %>
							<%=install.getMgr_name() %>
						<%} else { %>
						배정중
						<%} %>		
						</td>
				</tr>
				<%	}
				}%>
				
				
			</tbody>
		</table>
		</div>
   </div>
  <div class="tab-pane fade" id="comp">
	<div style = "padding-top : 10px;">
   <table class="table table-hover" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th>설치번호</th>
					<th>모델명</th>
					<th>회원명</th>
					<th>구매일자</th>
					<th>설치희망일</th>
					<th>설치완료일</th>
					<th>직원이름</th>
				</tr>
			</thead>
			<tbody>
				<%if (comflist.size() == 0 || comflist == null) {%>
				<tr>
				<td colspan="7" align="center">설치 완료 내역이 존재하지 않습니다.</td>
				</tr>
				<%
					} else {
						for(int i = 0; i < comflist.size(); i++){
							InstallDto install = comflist.get(i);
				%>
				<tr>
					<td><%=install.getIns_index() %></td>
					<td><%=install.getPrd_model_name()%></td>
					<td><%=install.getMem_name() %></td>
					<td><%=install.getPur_date().substring(0, 10) %></td>
					<td><%=install.getIns_date().substring(0, 10) %></td>
					<td><%=install.getComp_date().substring(0, 10) %></td>
					<td><%=install.getMgr_name() %></td>
				</tr>
				<%	}
				}%>
				
				
			</tbody>
		</table>
		</div>
  </div>
</div>
		
	<%--		<div align = "center">
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
		</div> --%>
</div>

<script type="text/javascript">

	function goPage( pageNum ) {

		location.href = "<%=request.getContextPath()%>/InstallController?command=installk&pageNumber=" + pageNum;
	}
	</script>
<%@ include file="./../include/footer.jsp"%>