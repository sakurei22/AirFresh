<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
	    ManagerMemberDto mrgMem = session.getAttribute("managerLogin")==null?null:(ManagerMemberDto) session.getAttribute("managerLogin");   
    	
    %>
   
    
    <!-- 직원들 마이페이지 안되어있음!!  2020/02/17 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Air Fresh Admin</title>
<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- link -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>

</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/adminmain">AirFresh Admin</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar-->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-user fa-fw"></i>
				</a>
				
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#" id="SettingsBtn">Settings</a>
					<a class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" id ="logoutBtn">Logout</a>
				</div>
			</li>
		</ul>
		
		<div style="width: 100%; text-align: end;">
			<div style="display: inline-flex;">
				<h5 style="color:white;display: block;float: left;"><%=mrgMem.getMgr_name() %></h5>
				<h6 style="color:white;display: block;margin: 8px 0 0px 0px;float: left;font-size: 11px;">님 계정으로 로그인 되었습니다.</h6>
			</div>
		</div>
	</nav>
	
	<script type="text/javascript">
		//session 정보 확인. 
		$(document).ready(function(){
			$("#logoutBtn").click(function(){
				//alert(" clicked logout button! ");
				console.log(" clicked logout button! ");
				
				if(confirm("정말 로그아웃 하시겠습니까?") == true){	//confirm
					<%-- <% session.removeAttribute("managerLogin");  %> --%>
					//location.reload();
					location.href="<%=request.getContextPath()%>/managerLogin?command=logout";
					console.log("로그아웃됨");
				} else{ //cancle
					console.log("로그아웃 취소");
				}
			});
			
			$("#SettingsBtn").click(function(){
				//alert(" clicked SettingsBtn button! ");
				console.log(" clicked SettingsBtn button!");
				location.href="<%=request.getContextPath()%>/modifyMgrMember?command=ModifyProfile";
				
				
				
				
			});
			
			
			
		});//end of $(document).ready(function(){}
		
	
	</script>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
				
				<% if(mrgMem.getMgr_auth() == 0 || mrgMem.getMgr_auth() == 1){ %><%--왕관리자, 관리자 --%>
					<div class="nav">
						<a class="nav-link" href="<%=request.getContextPath()%>/noticelist?command=admin">
								<i class="fas fa-chart-area"></i>
							공지사항
						</a> 
						<a class="nav-link" href="<%=request.getContextPath()%>/showMrgMember">
								<i class="fas fa-table"></i>
							직원리스트</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/adminMemList">
								<i class="fas fa-table"></i>
							고객리스트</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/rentallist">
								<i class="fas fa-table"></i>
							 렌탈리스트</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/InstallController?command=installk">
								<i class="fas fa-table"></i>
							 설치리스트</a>
						<%-- a class="nav-link" href="<%=request.getContextPath()%>/InstallController">
								<i class="fas fa-table"></i>
							 AS리스트</a--%>
					<a class="nav-link" href="<%=request.getContextPath()%>/qnalist?command=admin">
								<i class="fas fa-table"></i>
							 문의게시판</a>
					</div>
					<%}  else if( mrgMem.getMgr_auth() == 2){%>	<%-- 코디 (매니저) --%>
					<div class="nav">
						<a class="nav-link" href="<%=request.getContextPath()%>/noticelist?command=admin">
								<i class="fas fa-chart-area"></i>
							공지사항
						</a> 
						<a class="nav-link" href="<%=request.getContextPath()%>/InstallController?command=install">
								<i class="fas fa-table"></i>
							 AS리스트 선택하기</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/installConfirm?command=home">
								<i class="fas fa-table"></i>
							 나의 AS리스트</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/installcompController?command=home">
								<i class="fas fa-table"></i>
							 나의 완료 AS리스트</a>
					</div>
					
					<%} else if (mrgMem.getMgr_auth() == 3){ %>	<%-- 설치기사  --%>
					
					<div class="nav">
						<a class="nav-link" href="<%=request.getContextPath()%>/noticelist?command=admin">
								<i class="fas fa-chart-area"></i>
							공지사항
						</a> 
						<a class="nav-link" href="<%=request.getContextPath()%>/InstallController?command=install">
								<i class="fas fa-table"></i>
							 설치 리스트 선택하기</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/installConfirm?command=home">
								<i class="fas fa-table"></i>
							 나의 설치 리스트</a>
						<a class="nav-link" href="<%=request.getContextPath()%>/installcompController?command=home">
								<i class="fas fa-table"></i>
							 나의 완료 설치 리스트</a>	 
					</div>
					<%} %>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Air Fresh</div>
				</div>
			</nav>
		</div>
            <div id="layoutSidenav_content">
                <main>
                
