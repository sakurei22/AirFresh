<%@page import="Dto.NoticeBbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NoticeBbsDto> list = (List<NoticeBbsDto>) request.getAttribute("noticeList");

	int len = (int) request.getAttribute("len");
	System.out.println("총 글의 갯수 " + len);

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
<%@ include file="./../include/header.jsp"%>
<div class="container">
	<h1 class="mt-4 mb-3">공지사항</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">고객센터</li>
		<li class="breadcrumb-item active">공지사항</li>
	</ol>


		<!-- Content Column -->
			
			<table class="table table-hover">
				<col width="70">
				<col width="400">
				<col width="120">
				<col width="100">
				<col width="70">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성일</th>
						<th scope="col">작성자</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>

					<%
						if (list.size() == 0 || list == null) {
					%>
					<tr align="center">
						<th colspan="5">공지사항이 없습니다.</th>
					</tr>

					<%
						} else {
							for (int i = 0; i < list.size(); i++) {
								NoticeBbsDto notice = list.get(i);
					%>
					<tr align="center" onclick="location.href='<%=request.getContextPath()%>/noticedetail?command=user&noti_index=<%=notice.getNoti_index()%>'"
					 style="cursor:pointer;">
						<th><%=notice.getNoti_index()%></th>
						<td align="left"><a
							href="<%=request.getContextPath()%>/noticedetail?command=user&noti_index=<%=notice.getNoti_index()%>"><%=notice.getNoti_title()%></a>
						</td>
						<td><%=notice.getWdate().substring(0, 10)%></td>
						<td><%=notice.getNoti_writer()%></td>
						<td><%=notice.getReadcount()%></td>
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
					<li class="page-item active"><a class="page-link" href="#"><%=i + 1%></a></li>
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
						onclick="searchNotice()">검색</button>
				</div>
			</div>
			<div style="clear: left"></div>
			<div style="clear: right"></div>
	</div>
	<!-- /.row -->

<script type="text/javascript">
	function searchNotice(){
		var opt = document.getElementById("opt").value;
		var keyword = $("#keyword").val();
		if(keyword == ""){
			document.getElementById("opt").value = "sel";
		}
		location.href="<%=request.getContextPath()%>/noticelist?command=user&opt=" + opt + "&keyword=" + keyword;
		}
	
	function goPage( pageNum ) {
		var opt = document.getElementById("opt").value;
		var keyword = $("#keyword").val();
//		alert("pageNum:" + pageNum);
		if(keyword == ""){
			document.getElementById("opt").value = "sel";
		}
		var linkStr = "<%=request.getContextPath()%>/noticelist?command=user&pageNumber=" + pageNum;
		if(opt != 'sel' && keyword != ""){
			linkStr = linkStr + "&opt=" + opt + "&keyword=" + keyword;
		}
		location.href = linkStr;
//		location.href = "bbslist.jsp?pageNumber=" + pageNum;
	}

	</script>
<%@ include file="./../include/footer.jsp"%>