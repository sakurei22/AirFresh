<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>

<div class="container-fluid" style="margin-bottom:20px;">
	<h2 class="mt-4 mb-3">Air Fresh 직원 추가</h2>
	<hr>
	<%-- 메니저 전체 리스트를 열람, 추가/삭제 해줌. --%>
	<%--<%=request.getContextPath()%>/addMrgMember --%>
	<div class="col-lg-9">
		<div class="card border-0 rounded-lg mt-9">
			<form id="addManagerMem" name="addManagerMem"
				action="<%=request.getContextPath()%>/addMrgMember" method="POST">
				<div class="form-group">
					<label class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="manager_id"
							name="manager_id" placeholder="ID">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-form-label">패스워드</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="manager_pw"
							name="manager_pw" placeholder="패스워드">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="manager_name"
							name="manager_name" placeholder="이름">
					</div>
				</div>

				<div class="form-group">
					<label for="manager_loc" class="col-sm-2 col-form-label">근무지역선택</label>
					<div class="col-sm-4">
						<select class="form-control" name="manager_loc">
							<option value="1">강남구</option>
							<option value="2">성동구</option>
							<option value="3" selected="selected">중랑구</option>
							<option value="4">기타</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="manager_loc" class="col-sm-2 col-form-label">직원구분</label>
					<div class="col-sm-4">
						<select class="form-control" name="authLevel">
						<option value="0">최고관리자</option>
						<option value="2" >매니저</option>
						<option value="3" selected="selected">설치기사</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-form-label">핸드폰 번호</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="manager_phNum" name="manager_phNum" placeholder="핸드폰번호">
					</div>
				</div>
				<div align = "center" >
				<input type="submit" class ="btn btn-primary btn" value="직원 추가">
				</div>
			</form>
		</div>
	</div>
</div>



<%@ include file="./../include/footer.jsp"%>
