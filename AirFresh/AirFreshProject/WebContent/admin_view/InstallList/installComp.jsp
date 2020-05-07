<%@page import="Dto.InstallDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./../include/header.jsp" %>

<%!
	public String subAddr(String addr2, String addr3){
	
		String addr = addr2 + addr3;
		
		addr = addr.substring(0, 9);
		
		addr += "...";
		return addr;	
	}
	
	public String NowState(int state){
		
		String[] sstate = { "설치예정" , "설치완료" };
		
		return sstate[state];
	}
	
	public void ratingChange(int rating){
				
	}
%>

<%
	List<InstallDto> list = request.getAttribute("compList")==null?null:(List<InstallDto>)request.getAttribute("compList");
%>

	<div class="container-fluid">
		<h1 class="mt-4 mb-3" >나의 완료된 설치 리스트 보기</h1>
		<br>
		<div class="listMain">
			<table class="table table-hover">
				<col width="10"><col width="15"><col width="10"><col width="10"><col width="10">
				<col width="10"><col width="10"><col width="10">
				<tr>
					<th>설치신청번호</th><th>제품명</th><th>회원아이디</th><th>설치완료일</th><th>전화번호</th>
					<th>상세주소</th>
				</tr>
				<%
					if(list != null && list.size() > 0 ){
						for(int i = 0; i< list.size(); i++){
							InstallDto dto = list.get(i);
							%>
							<tr>
								<td><%=dto.getIns_index() %></td>
								<td><%=dto.getPrd_model_name() %></td>
								<td><%=dto.getMem_id() %></td>
								<td><%=dto.getComp_date() %></td>
								<td><%=dto.getMem_cell() %></td>
								<td><%=subAddr(dto.getMem_addr2(), dto.getMem_addr3()) %></td>
							</tr>	
							<%
						}
					}else{
						%>
						<tr><td colspan="6">설치를 한번도 안하셨네요.</td></tr>
						<%
					}
				%>
				
			</table>
		</div>
	</div>

<%@ include file="./../include/footer.jsp" %>
