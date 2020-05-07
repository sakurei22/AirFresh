<%@page import="Dto.MemberDto"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<title>Air Fresh</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/Jstyles.css" />
<!-- Custom styles for this template -->
  <link href="<%=request.getContextPath()%>/css/modern-business.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
  
  <!-- 쿠키저장 -->
<!--  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>
	<!-- Header -->

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><img src="<%=request.getContextPath()%>/client_view/img/af_Logo.PNG"></a>
      

      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <div class="topSec clearfix">
          <ul class="clearfix">
             <li><a href="<%=request.getContextPath() %>/login?command=login" id="loginBtn">로그인</a></li>
             <li><a href="<%=request.getContextPath() %>/login?command=logout" id="logoutBtn">로그아웃</a></li>
             <li><a href="<%=request.getContextPath()%>/addmem?command=regi" id ="regiBtn">회원가입</a></li>

          </ul>
        </div>
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/modelist">렌탈하기</a>
          </li>
          <li class="nav-item">
           <%--  <a class="nav-link" href="<%=request.getContextPath() %>/OrderReviewController?command=home">렌탈후기</a> --%>
           <a class="nav-link" href="<%=request.getContextPath() %>/reviewList?command=user">렌탈후기</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              	고객센터
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="<%=request.getContextPath()%>/noticelist?command=user">공지사항</a>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/qnalist?command=user">QNA</a>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/faqList">FAQ</a>
            </div>
          </li>

          
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              	마이페이지
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="<%=request.getContextPath()%>/printPurchase">렌탈 내역</a>
               <a class="dropdown-item" href="<%=request.getContextPath()%>/login?command=login">내 정보</a>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- 로그인시 '로그인버튼' 조작  -->
  <script type="text/javascript">
  	$(document).ready(function () {
  		
  		//첫화면 띄웠을 때 다른 페이지 이동시 로그인 버튼 처리 
  		if('<%=request.getSession().getAttribute("login") %>' != 'null'){
			$("#loginBtn").hide();
			$("#logoutBtn").show();
			$("#regiBtn").hide();
		}else if('<%=request.getSession().getAttribute("login") %>' == 'null'){
			$("#loginBtn").show();
			$("#logoutBtn").hide();
			$("#regiBtn").show();
		}
  		
  		
  		//로그아웃 시도시 처리 
  		$(document).on("click","#logoutBtn", function () {
			
  			if(confirm("정말 로그아웃하시겠습니까?")){
  				//확인버튼 클릭시 동작
  				$.ajax({
  					
  					url:"<%=request.getContextPath() %>/login",
  					type:"post",
  					data:{ command: 'logout'},
  					
  					success: function () {
						//alert("통신성공");
						$("#loginBtn").show();
						$("#logoutBtn").hide();
						location.href="<%=request.getContextPath() %>/index.jsp";
					},
					error: function () {
						alert("통신실패");
					}
  				});
  			}else{
  				//취소버튼 클릭시 동작 
  			}
		});
<%--   		
  		//AS신청 처리 
  		$(document).on("click", "#asdiv", function () {
			
  			//alert("as신청");
  			$.ajax({
  				
  				url: "<%=request.getContextPath()%>/asApply",
  				type: 'post',
  				data:{
  					command: 'loginCheck'
  				},
  				success: function () {
					alert("통신 성공");
				},
				error: function () {
					alert("통신 실패 ");
				}
  			});
		}); --%>
	});	
  </script>
		 