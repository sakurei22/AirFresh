
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String str = request.getParameter("isS");
	String command = request.getParameter("command");
%>

	<%
		if (command.equals("add")) {
	%>

	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 추가되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnalist?command=user"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("추가되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/addQna?command=add"; 
	</script>
	<%
	}
	%>
	
		<%
		}else if (command.equals("qnaUpdateAf")) {
			String qna_index = request.getParameter("qna_index");
	%>

	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 수정되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=user&qna_index=<%=qna_index%>"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("수정되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=user&qna_index=<%=qna_index%>"; 
	</script>
	<%
	}
	%>

		<%
		}else if (command.equals("qnaDeleteAf")) {
			String qna_index = request.getParameter("qna_index");
	%>

	<%
		if (str.equals("true")) {
	%>
	<script type="text/javascript">
		alert("성공적으로 삭제되었습니다.");
		location.href = "<%=request.getContextPath()%>/qnalist?command=user"; //컨트롤러 거쳐야함
	</script>

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("삭제되지 않았습니다.");
		location.href = "<%=request.getContextPath()%>/qnadetail?command=user&qna_index=<%=qna_index%>"; 
	</script>
	<%
	}
	%>	
	<%
	
}
	%>