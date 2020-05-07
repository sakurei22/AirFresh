<%@page import="Dto.ModelReviewPurDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="./../include/header.jsp" %>

<%@page import="Dto.MemberDto"%>
<%@page import="Dto.ModelDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	ModelDto model = (ModelDto)request.getAttribute("model");
	//System.out.println("model :"+model.toString());

	MemberDto mem = (MemberDto)session.getAttribute("login"); 
	List<ModelReviewPurDto> list = (List<ModelReviewPurDto>) request.getAttribute("list");
	
	//model session
	session.setAttribute("model", model);
	int price = model.getPrd_price();
	
	DecimalFormat formatter = new DecimalFormat("###,###");
	String sprice = formatter.format(price);

%>
<style>
      a.top {
        position: fixed;
        bottom:10px;
        right:10px;
        display: none;
      }
</style>

<!-- <a href="#" class="top">Top</a> -->
<a href="#" class="top" title=”맨위로"><img src="<%= request.getContextPath()%>/client_view/img/btn_top.png" style="width: 80px;"></a>
<script>
$( document ).ready( function() {
    $( window ).scroll( function() {
      if ( $( this ).scrollTop() > 200 ) {
        $( '.top' ).fadeIn();
      } else {
        $( '.top' ).fadeOut();
      }
    } );
    $( '.top' ).click( function() {
      $( 'html, body' ).animate( { scrollTop : 0 }, 600 );
      return false;
    } );
  } );
</script>
</script>
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3"><%= model.getPrd_name() %>
      <small><%= model.getPrd_model_name() %></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="<%=request.getContextPath()%>/modelist">상품목록</a>
      </li>
      <li class="breadcrumb-item active">공기청정기</li>
    </ol>

    <!-- 상품정보-->
    <div class="row">

      <div class="col-md-8">
        <img class="img-fluid"  id="big_img" name="big_img"
        style="width: 480px;height: 480px;" 
        src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m1.png" alt="">
      </div>

      <div class="col-md-4">
        <h3 class="my-3"><%= model.getPrd_name() %> <%=model.getPrd_model_name() %></h3>
         <h3 class="my-3">24개월약정/ 등록비 0원</h3>

       

        <ul >
          <li style="display: block;">렌탈가격 : <%= sprice %> 원</li>
          <li style="display: block;">렌탈시스템 : 24개월이후 소유권이전</li>
          <li style="display: block;">제품규격 : 상세정보 참고</li>
         <!--  <li>Adipiscing Elit</li> -->
        </ul>
         <div style="background: #EAEAEA; padding: 20px 30px; font-size: 15px;">
			<span
				style="font-size: 13px; font-color: #8C8C8C; line-height: 20px;">
				- 대표요금제 기준이며 요금제에 따라 총 렌탈요금이 다를 수 있음</span><br> <span
				style="font-size: 13px; font-color: #8C8C8C; line-height: 20px;">
				- 2년동안 무상 A/S (계약기간 내), 초기 구입비용 0원 (24개월 분할납부)</span><br> <span
				style="font-size: 13px; font-color: #8C8C8C; line-height: 20px;">
				- 단, 등록비 및 설치비는 가입시에는 면제되나 중도해지시 별도 부과</span><br>
			<dl>
				<dd style="padding: 0px 0px 10px 0px;">
					<span
						style="font-size: 13px; font-color: #8C8C8C; font-weight: 600; line-height: 20px;">※
						상기 내용은 제품에 따라 다를수 있음.</span><br>
				</dd>
			</dl>
		</div>
		<input type="hidden" name="command" value="purcha">
		<ul class="shop_btns" style="margin-top: 15px;">
			<li class="order"><a href="./modelDetail?seq=<%=model.getPrd_index() %>&command=purcha">렌탈신청하기</a></li>
			<li class="qna"><a href="<%=request.getContextPath()%>/qnalist?command=user">Q&A게시판</a></li>
		</ul>
		<style>
		
			.shop_btns {
				padding-left: 0;
				width: 100%;
			}
	 		.order {
				float: left;
			} 
			
			.shop_btns li {
				width: 50%;
				display: inline-block;
				margin: 0 auto;
				border: 1px solid #fff;
				background-color: #343a40;
				font-size: 16px;
				line-height: 50px;
			}
			
			.shop_btns li a {
				display: block;
				color: #fff;
				text-align: center;
			}
			
			a:hover, a:active, a:visited, a:link {
				text-decoration: none;
			}
		</style>
      </div>

    </div>
    <!-- /.row -->
    <!-- Related Projects Row -->
    <script>
	  /* 이미지 전환 */
	  function changeImage(img_url, width, height,alt){
	    document.getElementsByName('big_img')[0].src = img_url;

	    document.getElementsByName('big_img')[0].alt = alt;
	    return;
	}
	</script>
    <h3 class="my-4">상품 이미지</h3>

    <div class="row">

      <div class="col-md-3 col-sm-6 mb-4">
       <a href="#big_img"
		onmouseover="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m1.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);"
		onfocus="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m1.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);">
		<img class="img-fluid" src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m1.png"></a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#big_img"
		onmouseover="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m2.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);"
		onfocus="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m2.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);">
		<img class="img-fluid" src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m2.png"></a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
        <a href="#big_img"
		onmouseover="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m3.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);"
		onfocus="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m3.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);">
		<img class="img-fluid" src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m3.png"></a>
      </div>

      <div class="col-md-3 col-sm-6 mb-4">
       <a href="#big_img"
		onmouseover="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m4.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);"
		onfocus="javascript:changeImage(&#39;<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m4.png&#39;,&#39;&#39;,&#39;250&#39;,&#39;WD501GB&#39;);">
		<img class="img-fluid" src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_m4.png"></a>
      </div>

    </div>

    <!-- 해당상품 review -->
	<div style="margin-top:80px;">
		 <h3 class="my-4">상품 리뷰</h3>
		<div style="width:100%; height: 300px;">
				<table class="table table-hover">
				<col width="70">
				<col width="200">
				<col width="250">
				<col width="120">
				<col width="100">
				<col width="70">
				<thead>
					<tr align="center">
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">내용</th>
						<th scope="col">작성일</th>
						<th scope="col">작성자</th>
						<th scope="col">별점</th>
					</tr>
				</thead>
				<tbody>

					<%
						if (list.size() == 0 || list == null) {
					%>
					<tr align="center">
						<th colspan="6">작성된 리뷰가없습니다.</th>
					</tr>

					<%
						} else {
							for (int i = 0; i < list.size(); i++) {
								ModelReviewPurDto dto = list.get(i);
								if(dto.getRe_auth()==0){
					%>
					<tr align="center" title="클릭하면 전체보기로 이동합니다." 
						onclick="location.href='<%= request.getContextPath() %>/reviewDetail?seq=<%=dto.getRe_index() %>'"  style="cursor:pointer;">
						<th><%= i+1 %></th>
						<td><%= dto.getOrder_re_title()%></td>
						<td align="left">
						<%= dto.getOrder_re_content() %>
						</td>
						<td><%=dto.getWdate().substring(0,10) %></td>
						<td><%=dto.getMem_id()%></td>
						<td><%=dto.getRating() %></td>
					</tr>
					<%
								}//.if
							}//.for
						}//.if문
					%>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.review -->
	
    <!-- /.row -->
   <!-- 상세이미지 -->
  	<div id="pd_detail_cont"
		style="border-top: 1px solid #ddd; text-align: center; margin-top: 50px; padding: 50px 0;">
		<img src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_1.jpg" alt="">
		<img src="<%= request.getContextPath() %>/client_view/model/prd_detail_img/<%=model.getPrd_model_name() %>_2.jpg" alt="">
		<img
			src="http://o2orental.co.kr/rentalcommerce/content/view_bnr_liks.jpg"
			alt="">
	</div>
	<!-- /.상세이미지 -->

  </div>
  <!-- /.container -->


<%@ include file="./../include/footer.jsp" %>