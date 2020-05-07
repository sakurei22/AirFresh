<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>

 <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
       <div class="carousel-item active" style="background-image: url('<%=request.getContextPath()%>/client_view/img/slide01.jpg'); cursor: pointer;"
       onclick="location.href='<%=request.getContextPath()%>/modelDetail?seq=10004&command=detail'">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/client_view/img/slide02.jpg'); cursor: pointer;" 
        onclick="location.href='<%=request.getContextPath()%>/modelDetail?seq=10010&command=detail'">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/client_view/img/slide03.jpg'); cursor: pointer;"
        onclick="location.href='<%=request.getContextPath()%>/noticedetail?command=user&noti_index=7'">
          <div class="carousel-caption d-none d-md-block">
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </header>

  <!-- Page Content -->
  <div class="container">
    <!-- Portfolio Section -->
    <h1 class="my-4">Best Product</h1>
    <div class="row">
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="<%=request.getContextPath()%>/modelDetail?seq=10003&command=detail"><img class="card-img-top" src="<%=request.getContextPath()%>/client_view/model/prd_img/ACL120UASKCG.png" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="<%=request.getContextPath()%>/modelDetail?seq=10003&command=detail">U필터 공기청정기</a>
            </h4>
            <p class="card-text">월 <span style ="font-size : 2em;font-weight: 500; color:#d80546;">32,900</span>원</p>
          </div>
        </div>
      </div>
      
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <a href="<%=request.getContextPath()%>/modelDetail?seq=10004&command=detail"><img class="card-img-top" src="<%=request.getContextPath()%>/client_view/model/prd_img/ACL121CZSKYL.png" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="<%=request.getContextPath()%>/modelDetail?seq=10004&command=detail">미니언즈 공기청정기</a>
            </h4>
            <p class="card-text">월 <span style ="font-size : 2em;font-weight: 500; color:#d80546;">25,900</span>원</p>
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-sm-6 portfolio-item">
		<div class="card h-100">	
          <a href="<%=request.getContextPath()%>/modelDetail?seq=10000&command=detail"><img class="card-img-top" src="<%=request.getContextPath()%>/client_view/model/prd_img/ACL141MASKWH.png" alt=""></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="<%=request.getContextPath()%>/modelDetail?seq=10000&command=detail">모션공기청정기</a>
            </h4>
            <p class="card-text">월 <span style ="font-size : 2em; font-weight: 500; color:#d80546;">29,900</span>원</p>
          </div>
        </div>
      </div>      
    </div>
    <!-- /.row -->
   </div>

  <!-- /.container -->
<%@ include file="./include/footer.jsp" %>

	