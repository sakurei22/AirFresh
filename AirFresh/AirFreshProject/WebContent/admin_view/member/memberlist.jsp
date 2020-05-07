<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<div class="container-fluid">
	<h1 class="mt-4 mb-3">고객 리스트</h1>
	<hr>

	<div class="table-responsive">

		<div style="float: right">
			<div class="form-group"
				style="float: left; width: 100px; margin-right: 5px;">
				<select class="form-control" id="opt" name="opt">
					<option value="sel">선택</option>
					<option value="name">이름</option>
					<option value="id">아이디</option>
				</select>
			</div>
			<div class="form-group" style="float: left; margin-right: 5px;">
				<input type="text" class="form-control" id="keyword"
					name="keyword">
			</div>
			<div class="form-group" style="float: left">
				<button type="button" class="btn btn-primary"
					onclick="searchNotice()">검색</button>
			</div>
		</div>
		<div style="clear: left"></div>
		<form id="noticelistForm" method="post">
			<input type="hidden" name="command" value="multiDelete">
			<table class="table table-hover" width="100%" cellspacing="0">
				<thead>
					<tr>
					<th scope="col"><input type ="checkbox" name ="alldel" onclick="deleteChecks(this.checked)"></th>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>휴대폰 번호</th>
						<th>주소</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</form>
	</div>
</div>

	<script type="text/javascript">
	function deleteChecks(ch) {
		//alert(ch);
		var arrCheck = document.getElementsByName("delck");
		for (var i = 0; i < arrCheck.length; i++) {
			arrCheck[i].checked = ch;
		}
	}
	function searchNotice(){
		var opt = document.getElementById("exampleSelect2").value;
		var keyword = $("#inputDefault").val();
		if(keyword == ""){
			document.getElementById("exampleSelect2").value = "sel";
		}
		location.href="<%=request.getContextPath()%>/noticelist?command=admin&opt=" + opt + "&keyword=" + keyword;
		}
	
	function goPage( pageNum ) {
		var opt = $("#opt").val();
		var keyword = $("#keyword").val();
		if(keyword == ""){
			document.getElementById("opt").value = "sel";
		}
		var linkStr = "<%=request.getContextPath()%>/memberlist?pageNumber=" + pageNum;
		if(opt != 'sel' && keyword != ""){
			linkStr = linkStr + "&opt=" + opt + "&keyword=" + keyword;
		}
		location.href = linkStr;
	}
	
	$(function(){
		$("#delBtn").click(function(){
			var arrCheck = $("input[name='delck']:checked").length;

			if(arrCheck==0){
				alert("삭제할 멤버를 선택해주세요");
				return
			}
			//$("#noticelistForm").attr("action","noticedelete?command=multiDelete").submit();
			
		});
	});
	</script>
<%@ include file="./../include/footer.jsp"%>