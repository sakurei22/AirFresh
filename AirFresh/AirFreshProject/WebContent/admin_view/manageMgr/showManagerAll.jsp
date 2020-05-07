<%@page import="Dto.ManagerMemberDto"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp" %>
<%-- body  ======================================================== --%>
<%
HttpSession adminlogincheck = request.getSession();
ManagerMemberDto managerMem = (ManagerMemberDto)session.getAttribute("managerLogin");
System.out.println(managerMem);
%>
<%!
	public String Leave(int leave){
		String str = "";
		if (leave == 0){
			str = "재직중";
		} else if(leave ==1){
			str = "퇴사";
		}
		return str;
	}
	
	public String location(int loc){
		String str = "";
		if(loc ==1){
			str ="강남구";
		} else if(loc==2){
			str ="성동구";
		} else if(loc==3){
			str ="중랑구";
		} else if(loc==4){
			str ="기타";
		}
		return str;
	}

%>
<%
request.setCharacterEncoding("utf-8");
List<ManagerMemberDto> managerMemberlist =
		(List<ManagerMemberDto>)request.getAttribute("managerMemberList");
%>

<div class="container-fluid">
  <h1 class="mt-4 mb-3" >직원리스트</h1>
 <div style="margin:10px;" align = "right">
<a href="<%=request.getContextPath() %>/addMrgMember?status=enter" class="btn btn-primary">
 매니저 및 관리자 추가하기 </a>
 </div>
 <table class="table table-hover">
 	<thead>
	 	<tr>
			<th scope="col">사원번호</th>
	 		<th scope="col">아이디</th>
			<th scope="col">이름</th>
			<th scope="col">담당구역</th>
			<th scope="col">재직여부</th>
	 	</tr>
 	</thead>
	<tbody>
    <%
    for(ManagerMemberDto memberdto : managerMemberlist){
    %>	
    <tr onclick="location.href='<%=request.getContextPath() %>/showMgrMemberDetail?mgr_index=<%=memberdto.getMgr_index() %>'">
		<td><%=memberdto.getMgr_index() %></td>
		<td><%=memberdto.getMgr_id() %></td>
		<td><%=memberdto.getMgr_name() %></td>
		<td><%=location(memberdto.getMgr_loc()) %> </td>
		<td><%=Leave(memberdto.getMgr_del()) %> </td>

	</tr>
   <%
    }
    %>
    </tbody>
   </table>
</div>
    <script type="text/javascript">
    
		$(document).ready(function(){
			
    		$(".showMemberInfo").click(function() {
    			  //alert( "now on click. " );
    		});
    		
    		$(".mgr_show_detail_btn").click(function(){
    			console.log("show detail btn on click");
    			$("#go_showdetail").submit();
    		});
			
		});
    			
    </script>
<%@ include file="./../include/footer.jsp" %>