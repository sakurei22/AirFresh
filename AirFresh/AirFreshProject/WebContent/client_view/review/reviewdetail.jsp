<%@page import="Dto.ModelReviewPurDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./../include/header.jsp"%>
 <link rel="stylesheet" href="magnific-popup/magnific-popup.css">
 <script src="magnific-popup/jquery.magnific-popup.js"></script>

<% 
	MemberDto mem = (MemberDto)session.getAttribute("login");
	ModelReviewPurDto dto = (ModelReviewPurDto) request.getAttribute("dto");
	String sdate = dto.getWdate().substring(0,10);
	String savePath = request.getServletContext().getRealPath("/reviewupload");

%>


<div class="container">
	<h1 class="mt-4 mb-3">리뷰보기</h1>
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">리뷰보기</li>
		<li class="breadcrumb-item active">리뷰</li>
	</ol>

	<div class="card">
		<div class="card-header">
			<h3 class="card-title"><%=dto.getOrder_re_title()%></h3>
		</div>	
			<div class = "card-body">
			<p align="right">
				<span><a href="<%=request.getContextPath()%>/modelDetail?command=detail&seq=<%=dto.getPrd_index() %>" title="클릭하면 상품상세페이지로 이동합니다."><%=dto.getPrd_name() %></a> /</span>
				<span><%=dto.getRating() %>점 /</span>
				<span><%=dto.getMem_id() %> /</span>
				<span><%=sdate%> /</span>
				<span>조회수:<%=dto.getReadcount() %> </span><br>
			</p>


			<hr>
			<p class="card-text">
			<%
				if (dto.getOrder_re_img_path() != null) {
					int idx = dto.getOrder_re_img_path().lastIndexOf(".");
					String str =dto.getOrder_re_img_path().substring(idx + 1);

					String m_fileFullPath = savePath + "\\" + dto.getOrder_re_img_path();
					System.out.println(m_fileFullPath);
					if (str.equals("png") || str.equals("PNG") || str.equals("JPG") || str.equals("jpg")
							|| str.equals("gif") || str.equals("GIF")) {
			%>
				<div style="width: 200px;height: 200px;">
				<a class="image-popup-vertical-fit" href="http://localhost:8090/AirFreshProject/reviewupload/<%=dto.getOrder_re_img_path()%>" target="_self">
				<img src="http://localhost:8090/AirFreshProject/reviewupload/<%=dto.getOrder_re_img_path()%>" width="100%"
				title="이미지를 클릭하면 확대됩니다.">
				</a>
				</div>
			<%
				}

				}
			%>
			</p>
		<p class="card-text">
				<pre><%=dto.getOrder_re_content()%></pre>
				</p>
			</div>
		</div>
		<div align="center" style="padding :10px;">
			<a href="<%=request.getContextPath()%>/reviewList?command=user" class="btn btn-primary">목록</a>
			<% if(mem.getMem_id().equals(dto.getMem_id())){ %>
				<a href="<%=request.getContextPath()%>/updateReviewPage?seq=<%=dto.getRe_index() %>" class="btn btn-primary">수정</a>
				<%-- <a href="<%=request.getContextPath()%>/deleteReview?seq=<%=dto.getRe_index() %>" class="btn btn-primary" 
					onclick="return confirm('정말 삭제하시겠씁니까?')">삭제</a> --%>
			<%
			}
			%>
	</div>
	<!-- Content Column -->

</div>

<%@ include file="./../include/footer.jsp"%>