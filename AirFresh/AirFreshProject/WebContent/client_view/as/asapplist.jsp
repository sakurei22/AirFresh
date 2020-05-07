<%@page import="Dto.AsAppDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	List<AsAppDto> list = (List<AsAppDto>)request.getAttribute("list");
 	System.out.println("asapplist list갯수: "+list.size());
 %>
<%@ include file="./../include/header.jsp"%>
	<div class="container" style="margin-bottom: 100px;">
		 <h1 class="mt-4 mb-3">수리신청내역
      <small>AS Application List</small>
    </h1>
    
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">마이페이지</a>
      </li>
      <li class="breadcrumb-item active">as신청내역</li>
    </ol>
    
    		<div style="clear: left"></div>
			<table class="table table-hover">
				<col width="200">
				<col width="200">
				<col width="300">
				<col width="100">
			<thead>
					<tr align="center">
						<th scope="col">a/s요청제품</th>
						<th scope="col">a/s희망일</th>
						<th scope="col">제목</th>
						<th scope="col">수리취소</th>
					</tr>
			</thead>
			<tbody>
					<%
						if(list.size()==0|| list ==null){
					%>
						<tr align="center">
							<th colspan="4">AS신청내역이 없습니다.</th>
						</tr>
					
						<% } else {
							for(int i=0; i<list.size(); i++){
								AsAppDto dto = list.get(i);
					    %>
			
					<tr align="center">
						<td><%=dto.getPrd_name() %></td>
						<td><%=dto.getReq_date() %></td>
						<td><a href="asDetail?seq=<%=dto.getAsSeq() %>"><%=dto.getAsTitle() %></a></td>
						<td><a href="./delAsApp?seq=<%=dto.getAsSeq() %>" onclick="return confirm('정말삭제하시겠씁니까?')">[수리취소]</a></td>
					</tr>
			
					<%
							}//for문종료
						}//else문종료
					%>  
					</tbody>
				</table>
		</div>
<%@ include file="./../include/footer.jsp"%>


