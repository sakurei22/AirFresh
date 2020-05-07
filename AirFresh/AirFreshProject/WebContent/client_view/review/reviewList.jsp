<%@page import="Dto.ModelReviewPurDto"%>
<%@page import="java.util.List"%>
<%@page import="Dto.OrderReviewDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>

<%
	List<ModelReviewPurDto> list = (List<ModelReviewPurDto>) request.getAttribute("list");
	int nowPage = (Integer)request.getAttribute("nowPage");
	int totalPage = (Integer)request.getAttribute("totalPage");
%>

<div class="container" style="margin-bottom: 100px;">
	<h1 class="mt-4 mb-3">
		렌탈후기
	</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">HOME</a></li>
		<li class="breadcrumb-item active">렌탈후기</li>
	</ol>
	<hr>
	
		<table class="table table-hover">
				<col width="70">
				<col width="200">
				<col width="250">
				<col width="120">
				<col width="100">
				<col width="70">
				<col width="70">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">상품명</th>
						<th scope="col">제목</th>
						<th scope="col">작성일</th>
						<th scope="col">작성자</th>
						<th scope="col">별점</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>

					<%
						if (list.size() == 0 || list == null) {
					%>
					<tr align="center">
						<th colspan="7">작성된 리뷰가없습니다.</th>
					</tr>

					<%
						} else {
							for (int i = 0; i < list.size(); i++) {
								ModelReviewPurDto dto = list.get(i);
								if(dto.getRe_auth()==0){
					%>
					<tr align="center" onclick="location.href='<%= request.getContextPath() %>/reviewDetail?seq=<%=dto.getRe_index() %>'"  style="cursor:pointer;">
						<th><%= i+1 %></th>
						<td><%= dto.getPrd_name() %></td>
						<td align="left">
						<%= dto.getOrder_re_title()%>
						</td>
						<td><%=dto.getWdate().substring(0,10) %></td>
						<td><%=dto.getMem_id()%></td>
						<td><%=dto.getRating() %></td>
						<td><%=dto.getReadcount() %></td>
					</tr>
					<%
								}//.if
							}//.for
						}//.if문
					%>
				</tbody>
			</table>
	
		<div class="paging" align="center" style="margin: 50px auto;">
			<%
				for(int i=0; i < totalPage; i++){
					if(nowPage == i){ //현재페이지
			%>
					<span style="font-size: 26px;margin: 0 10px;border-bottom: 1px solid #000;"><%=i + 1 %></span>
			<%
				} else {
			%>
					<a href="<%=request.getContextPath()%>/reviewList?command=user&nowPage=<%=i %>" title="<%=i+1%>페이지" style="font-size: 20px;">
					
					<%= i+1 %></a>
			<%
				}//.else
			}//.for
			%>
		</div> 
	</div>

<%@ include file="./../include/footer.jsp"%>