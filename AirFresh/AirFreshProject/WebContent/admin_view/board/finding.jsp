<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String str = request.getParameter("isS");
	String command = request.getParameter("command");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (command.equals("upload")) {
	%>

	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 추가되었습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("추가되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; 
	</script>
	<%
		}
	%>
	<%
		} else if(command.equals("delete")){
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 삭제되었습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("삭제되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; 
	</script>
	<%
		}
	%>
	<%
		} else if(command.equals("update")){
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 수정되었습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("수정되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; 
	</script>
	<%
		}
	%>
	
	<%
		} else if(command.equals("qnare")){
			String qna_index = request.getParameter("qna_index");
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 답변이 등록 되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna_index%>"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
			
	%>
	<script type="text/javascript">
		alert("답변이 등록 되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna_index%>"; 
	</script>
	<%
		}
	%>
		<%
		} else if(command.equals("qnaAdminUpdate")){
			String qna_index = request.getParameter("qna_index");
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 수정되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna_index%>"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
			
	%>
	<script type="text/javascript">
		alert("수정 되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna_index%>"; 
	</script>
	<%
		}
	%>

		<%
		} else if(command.equals("qnaDeleteAf")){
			String qna_index = request.getParameter("qna_index");
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 삭제되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnalist?command=admin"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
			
	%>
	<script type="text/javascript">
		alert("삭제 되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=admin&qna_index=<%=qna_index%>"; 
	</script>
	<%
		}
	%>
	
	<%
		} else if(command.equals("multiDelete")){
	%>
	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 삭제되었습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
			
	%>
	<script type="text/javascript">
		alert("삭제 되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/noticelist?command=admin"; 
	</script>
	<%
		}
	%>
	
	<%
	
	}
	%>
</body>
</html>