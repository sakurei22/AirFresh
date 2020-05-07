<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

	//ManagerMemberDto mrgMem = (ManagerMemberDto) session.getAttribute("managerLogin");
%>
<%@ include file="./../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="mt-4 mb-3" >공지사항</h1>
		<hr>
		<form
			action="<%=request.getContextPath()%>/noticeupload?command=upload"
			method="post" enctype="multipart/form-data">
			<fieldset>
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">제목</label>
					<div>
						<div style="width: 10%; float: left; margin-right: 5px;">

							<select class="form-control" id="exampleSelect1" name="catagory">
								<option value="1">고객</option>
								<option value="2">매니저</option>
							</select>
						</div>
						<div style="width : 89%; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								name="title" required="required">
						</div>
						<div style="clear: left"></div>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleTextarea">내용</label>
					<textarea class="form-control" id="exampleTextarea" rows="20"
						cols="50" name="content" required="required"></textarea>

				</div>
				<div class="form-group">
					<input type="file" class="form-control-file" id="exampleInputFile"
						aria-describedby="fileHelp" name="fileload">
				</div>
				<div align="center" style="padding-bottom : 10px;">
					<button type="submit" class="btn btn-primary">글쓰기</button>
					<button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath() %>/noticelist?command=admin'">취소</button>
				</div>
			</fieldset>
		</form>
	</div>

<%@ include file="./../include/footer.jsp"%>