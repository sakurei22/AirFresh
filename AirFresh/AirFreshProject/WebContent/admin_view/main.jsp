<%@page import="Dto.InstallDto"%>
<%@page import="Dto.PurchaseNameDto"%>
<%@page import="Dto.NoticeBbsDto"%>
<%@page import="java.util.List"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	HttpSession adminlogincheck = request.getSession();
	//ManagerMemberDto managerMem = (ManagerMemberDto) session.getAttribute("managerLogin");
	
	List<NoticeBbsDto> list = request.getAttribute("mainList")==null?null:(List<NoticeBbsDto>) request.getAttribute("mainList");
	List<PurchaseNameDto> plist = request.getAttribute("mainPList")==null?null:(List<PurchaseNameDto>) request.getAttribute("mainPList");
	List<InstallDto> ilist = request.getAttribute("mainIList")==null?null:(List<InstallDto>) request.getAttribute("mainIList");
%>

<div class="container-fluid">
	<h1 class="mt-4">AirFresh 관리자 페이지입니다.</h1>
	<hr>
	<div class="row">
		<div class="col">
			<div class="card mb-4">
				<div class="card-header">
					공지사항
					<div style="float: right">
						<a href="<%=request.getContextPath()%>/noticelist?command=admin">>more</a>
					</div>
				</div>
				<div class="card-body">
					<ul style="list-style-type: decimal;">
						<%
							if(list != null && list.size() > 0 ){
								for (int i = 0; i < list.size(); i++) {
						%>
						<li><a
							href="<%=request.getContextPath()%>/noticedetail?command=admin&noti_index=<%=list.get(i).getNoti_index()%>">
								<%=list.get(i).getNoti_title()%> </a></li>
						<%
								}
							}else{
								%>
								<li><span>데이터가 없습니다</span></li>
								<%
							}
						%>
					</ul>
					
				</div>
			</div>
		</div>
		</div>
		<div class="row">
		<div class="col-xl-6">
			<div class="card mb-4">
				<div class="card-header">
					렌탈 리스트
					<div style="float: right">
					<a href="<%=request.getContextPath()%>/rentallist">>more</a></div>
				</div>
				<div class="card-body">
				<ul style="list-style-type: decimal;">
						<%
							if(plist != null && plist.size() > 0 ){
								for (int i = 0; i < plist.size(); i++) {
						%>
						<li><a
							href="<%=request.getContextPath()%>/detailPur?command=admin&seq=<%=plist.get(i).getPur_index()%>">
								<%=plist.get(i).getPrd_model_name()%>&nbsp;&nbsp;&nbsp;<%=plist.get(i).getPur_date()%></a></li>
						<%
								}
							}else{
								%>
								<li><span>데이터가 없습니다</span></li>
								<%
							}
						%>
					</ul>
				
				</div>
			</div>
		</div>
		<div class="col-xl-6">
				<div class="card mb-4">
					<div class="card-header">
						설치 리스트
						<div style="float: right">
						<a href="<%=request.getContextPath()%>/InstallController?command=installk">>more</a>
						</div>
					</div>
					<div class="card-body">
					
					<ul style="list-style-type: decimal;">
						<%
							if(ilist != null && ilist.size() > 0 ){
								for (int i = 0; i < ilist.size(); i++) {
						%>
						<li>
								<%=ilist.get(i).getPrd_model_name()%>&nbsp;&nbsp;&nbsp;<%=ilist.get(i).getComp_date()%></li>
						<%
								}
							}else{
								%>
								<li><span>데이터가 없습니다</span></li>
								<%
							}
						%>
					</ul>
					
					</div>
				</div>
		</div>

	</div>
</div>

<%@ include file="./include/footer.jsp"%>
