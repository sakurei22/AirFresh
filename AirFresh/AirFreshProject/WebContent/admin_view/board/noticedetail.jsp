<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@page import="Dto.NoticeBbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeBbsDto notice = (NoticeBbsDto) request.getAttribute("noticeBbs");

	//ManagerMemberDto mrgMem = (ManagerMemberDto) session.getAttribute("managerLogin");

	String sdate = notice.getWdate().substring(0, 10);
	String savePath = request.getServletContext().getRealPath("/upload");
%>
<%@ include file="./../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="mt-4 mb-3" >공지사항</h1>
		<hr>
		<div class="card ">
			<div class="card-header">
				<h3 class="card-title"><%=notice.getNoti_title()%></h3>
				<span><%=sdate%></span>
			</div>
			<div class="card-body">
				<%
					if (notice.getFilename() != null) {
				%>
				<p align="right">
					<a
						href="<%=request.getContextPath()%>/filedown?noti_index=<%=notice.getNoti_index()%>"><%=notice.getFilename()%></a>
				</p>
				<hr>
				<%
					}
				%>


				<%
					if (notice.getFilename() != null) {
						int idx = notice.getFilename().lastIndexOf(".");
						String str = notice.getFilename().substring(idx + 1);

						String m_fileFullPath = savePath + "\\" + notice.getTempfile() + "." + str;
						System.out.println(m_fileFullPath);
						if (str.equals("png") || str.equals("PNG") || str.equals("JPG") || str.equals("jpg")
								|| str.equals("gif") || str.equals("GIF")) {
				%>
				<p class="card-text">
					<img 
						src="http://localhost:8090/AirFreshProject/upload/<%=notice.getTempfile()%>.<%=str%>" width = "100%">
				</p>
				<%
					}

					}
				%>
				<p class="card-text"><pre><%=notice.getNoti_content()%></pre></p>
			</div>
		</div>
		<div align="center" style="padding-top:10px">
		<button type="button" class="btn btn-primary btn-lg"
				onclick="location.href='<%=request.getContextPath()%>/noticelist?command=admin'">목록</button>
			<%
				if (mrgMem.getMgr_auth() == 0) {
			%>
			<button type="button" class="btn btn-primary btn-lg"
				onclick="location.href='<%=request.getContextPath()%>/noticeupdate?noti_index=<%=notice.getNoti_index()%>&command=update'">수정</button>
			<button type="button" class="btn btn-primary btn-lg"
				onclick="deleteFunc(<%=notice.getNoti_index()%>)">삭제</button>
			<%
				}
			%>
			
		</div>
	</div>
	
	<script type="text/javascript">
	
		function deleteFunc(noti_index) {
			var answer = confirm("정말 삭제하시겠습니까?");
			
			if(answer){
				location.href="<%=request.getContextPath()%>/noticedelete?command=oneDelete&noti_index="+noti_index;
			} else {
				return;
			}
		}
	</script>
<%@ include file="./../include/footer.jsp"%>