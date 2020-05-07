<%@page import="Dto.ManagerMemberDto"%>
<%@page import="Dto.NoticeBbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	NoticeBbsDto notice = (NoticeBbsDto) request.getAttribute("noticeBbs");

	//ManagerMemberDto mrgMem = (ManagerMemberDto) session.getAttribute("managerLogin");
    
    
    %>
<%@ include file="./../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="mt-4 mb-3" >공지사항</h1>
		<hr>
		<form
			action="<%=request.getContextPath()%>/noticeupdate?command=updateAf"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name ="noti_index" value ="<%=notice.getNoti_index() %>">
			<input type="hidden" name ="fname" value ="<%=notice.getTempfile() %>">
			<fieldset>
				<div class="form-group">
					<label class="col-form-label" for="inputDefault">제목</label>
					<div>
						<div style="width: 100px; float: left; margin-right: 5px;">

							<select class="form-control" id="exampleSelect1" name="catagory">
								<%if(notice.getNoti_catagory()==1){ %>
								<option value="1" selected>고객</option>
								<option value="2">매니저</option>
								<%} else if(notice.getNoti_catagory()==2){ %>
								<option value="1">고객</option>
								<option value="2" selected>매니저</option>
								<%} %>
							</select>
						</div>
						<div style="width: 500px; float: left;">
							<input type="text" class="form-control" id="inputDefault"
								name="title" value ="<%=notice.getNoti_title() %>">
						</div>
						<div style="clear: left"></div>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleTextarea">내용</label>
					<textarea class="form-control" id="exampleTextarea" rows="20"
						cols="50" name="content"><%=notice.getNoti_content() %></textarea>

				</div>
				<div class="form-group">
				
				<% if(notice.getFilename()!=null){ %>
				<label class="col-form-label" for="inputDefault">업로드 파일</label>
					<input type="text"class="form-control" id="inputDefault"
						name="oldfile" value = <%=notice.getFilename() %>>
				<label class="col-form-label" for="inputDefault">변경파일 업로드</label>
					<input type="file" class="form-control-file" id="exampleInputFile"
						aria-describedby="fileHelp" name="fileload">
						<%} else { %>
				<label class="col-form-label" for="inputDefault">파일 업로드</label>
					<input type="file" class="form-control-file" id="exampleInputFile"
						aria-describedby="fileHelp" name="fileload">						
						<% } %>
				</div>
				<div align="center">
					<button type="submit" class="btn btn-primary">수정하기</button>
					<button type="button" class="btn btn-primary" onclick = "location.href ='<%=request.getContextPath()%>/noticedetail?command=admin&noti_index=<%=notice.getNoti_index()%>'">취소</button>
				</div>
			</fieldset>
		</form>
	</div>
<%@ include file="./../include/footer.jsp"%>