<%@page import="Dto.ModelDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	    
<%@ include file="./../include/header.jsp" %>

  <%
  	int totalPage = (Integer)request.getAttribute("totalPage");
  	int nowPage = (Integer)request.getAttribute("nowPage");
  	List<ModelDto> list = (List<ModelDto>)request.getAttribute("modelList");

  %>
  
    <style>
  	div.itemwrap{
  		overflow: hidden;
  		display: block;
  	}
  	div .itemwrap > .col-lg-4 {
  		position: relative;
	    display: inline-block;
	    width: 350px;
	    margin-right: 15px;
	    vertical-align: top;
	    margin-top: 30px;
  	}
  
  </style>
<div class = "container" style="margin-bottom: 30px;">
	<h1 class="mt-4 mb-3">공기청정기</h1>

	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
		<li class="breadcrumb-item active">렌탈하기</li>
	</ol>
	
<div class="itemwrap">
<%
	int w = 0; //루프형변수
	for(int i = 0; i < list.size(); i++){
%>
<div class ="col-lg-4">
	<div class = "bs-component">
		<div class="card mb-3">
 			<h3 class="card-header" align="center" style="font-size: 18pt;"><%=list.get(w).getPrd_name()%></h3>
   			<input type="hidden" name="command" value="detail">
   			<a href ="<%=request.getContextPath()%>/modelDetail?seq=<%=list.get(w).getPrd_index() %>&command=detail"> 
   			<img src="<%=request.getContextPath()%>/client_view/model/prd_img/<%=list.get(w).getPrd_model_name()%>.png" width="300"></a>
		</div>
	</div>
</div>
			<%
			w++;
		if(w==list.size()) break;	
	}//.for i
%>
</div>
		<div class="paging" align="center" style="margin: 50px auto;">
			<%
				for(int i=0; i < totalPage; i++){
					if(nowPage == i){ //현재페이지
			%>
					<span style="font-size: 26px;margin: 0 10px;border-bottom: 1px solid #000;"><%=i + 1 %></span>
			<%
				} else {
			%>
					<a href="<%=request.getContextPath()%>/modelist?nowPage=<%=i %>" title="<%=i+1%>페이지" style="font-size: 20px;">
					
					<%= i+1 %></a>
			<%
				}//.else
			}//.for
			%>
		</div> 
</div>
<script>
	<%-- function goPage(pageNum) {
		location.href = <%=request.getContextPath()%>+"/modelist?nowPage="+pageNum;
		
		
	} --%>
</script>

<!--  -->
<%-- <%	
	//as버튼을 눌렀는데 구매내역이 없을때 이동했을때 창을 띄우기 위한 변수
	int jc = request.getAttribute("jc")==null?0:(int)request.getAttribute("jc");

	if(jc>0){
		%>
		<script type="text/javascript">
			$(document).ready(function () {
				alert("AS신청을 위해서는 구매가 필요합니다");
			});		
		</script>
		<%
	
	}
%> --%>
<%@ include file="./../include/footer.jsp" %>

