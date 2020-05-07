<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String command = request.getParameter("command");
	String isS = request.getParameter("isS");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		if(command.equals("write")){
			if(isS.equals("true")){
%>
				<script>
					alert("리뷰가 작성되었습니다.");
					location.href="<%= request.getContextPath()%>/reviewList?command=user";
				</script>
<%				
			} else {
%>
				<script>
					alert("리뷰작성에 실패했습니다.");
					location.href="<%= request.getContextPath()%>/reviewList?command=user";
				</script>

<%
			} //.else

		} else if (command.equals("update")){
			if(isS.equals("true")){	
%>
				<script>
					alert("리뷰가 수정되었습니다.");
					location.href="<%= request.getContextPath()%>/reviewList?command=user";
				</script>
<%
			} else {
%>
				<script>
					alert("리뷰수정에 실패했습니다.");
					location.href="<%= request.getContextPath()%>/reviewList?command=user";
				</script>
<%
			}
			
		} else if (command.equals("del")){
			if(isS.equals("true")){	
				%>
					<script>
						alert("리뷰가 삭제되었습니다.");
						location.href="<%= request.getContextPath()%>/reviewList?command=user";
					</script>
<%
				} else {
%>
					<script>
						alert("리뷰삭제에 실패했습니다.");
						location.href="<%= request.getContextPath()%>/reviewList?command=user";
					</script>
<%
					}
				}
%>

</body>
</html>