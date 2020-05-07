<%@page import="Dto.ManagerMemberDto"%>
<%@page import="Dto.QnaBbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
    
    <%
    	List<QnaBbsDto> list = (List<QnaBbsDto>)request.getAttribute("qnalist");
  	  //  ManagerMemberDto mrgMem = (ManagerMemberDto) session.getAttribute("managerLogin");   	
		int len = (int) request.getAttribute("len");

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
<div class="container-fluid">
	<h1 class="mt-4 mb-3" >QnA</h1>
				<!-- Content Column -->
			
			<table class="table table-hover">
				<col width="70">
				<col width="350">
				<col width="120">
				<col width="100">
				<col width="150">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">답변유무</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (list.size() == 0 || list == null) {
					%>
					<tr align="center">
						<th colspan="5">QnA가 없습니다.</th>
					</tr>

					<%
						} else {
							for (int i = 0; i < list.size(); i++) {
								QnaBbsDto qna = list.get(i);
					%>
					<tr align="center" onclick = "location.href='<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna.getQna_index()%>'" style="cursor:pointer;">
						<th><%=i + 1%></th>
						<td align="left">
						<%if(qna.getQna_secret()==1){ //비밀글일경우 id 체크 하기 위해%>
						 <img src="<%=request.getContextPath()%>/client_view/img/lock.png">
						 <a href="<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna.getQna_index()%>"><%=qna.getQna_title()%></a>
						<% } else if(qna.getQna_secret() ==0) { %>
						<a href="<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna.getQna_index()%>"><%=qna.getQna_title()%></a>
						<%} %>
						</td>
						<td><%=qna.getMem_id()%></td>
						<td>
							<%	if(qna.getDepth()==0){ %>
								답변대기
							<% } else { %>
								답변완료
							<%} %>
						</td>
						<td><%=qna.getWdate().substring(0, 10)%></td>
					</tr>
					<%
							}
						}
					%>
				</tbody>

			</table>
						<div align="center">
				<ul class="pagination" style="display: inline-flex;">

					<%
						for (int i = 0; i < bbsPage; i++) { // [1] 2 [3]
							if (pageNumber == i) { // 현재 페이지
					%>
						<li class="page-item active"><a class="page-link" href="#">
					<%=i + 1%></a></li>
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
	<div>
	</div>
		<div style="float: right">
				<div class="form-group"
					style="float: left; width: 100px; margin-right: 5px;">
					<select class="form-control" id="opt" name="opt">
						<option value="sel">선택</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="form-group" style="float: left; margin-right: 5px;">
					<input type="text" class="form-control" id="keyword"
						name="keyword">
				</div>
				<div class="form-group" style="float: left">
					<button type="button" class="btn btn-primary"
						onclick="searchqna()">검색</button>
				</div>
			</div>
			<div style="clear: left"></div>
			<div style="clear: right"></div>
	</div>
<script type="text/javascript">
	function searchqna(){
		var opt = document.getElementById("opt").value;
		var keyword = $("#keyword").val();
		if(keyword == ""){
			document.getElementById("opt").value = "sel";
		}
		location.href="<%=request.getContextPath()%>/qnalist?command=admin&opt=" + opt + "&keyword=" + keyword;
		}
	
	function goPage( pageNum ) {
		var opt = document.getElementById("opt").value;
		var keyword = $("#keyword").val();
//		alert("pageNum:" + pageNum);
		if(keyword == ""){
			document.getElementById("opt").value = "sel";
		}
		var linkStr = "<%=request.getContextPath()%>/qnalist?command=admin&pageNumber=" + pageNum;
		if(opt != 'sel' && keyword != ""){
			linkStr = linkStr + "&opt=" + opt + "&keyword=" + keyword;
		}
		location.href = linkStr;
//		location.href = "bbslist.jsp?pageNumber=" + pageNum;
	}
	
</script>
<%@ include file="./../include/footer.jsp"%>