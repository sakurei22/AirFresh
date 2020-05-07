<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="./../include/header.jsp"%>
<script type="text/javascript">
	$(document).ready(
			function() {

				// 약관 동의 여부 변경 시 전체 약관 동의 되어 있으면 전체 약관 동의에 체크, 아니면 체크 해제
				$("input:checkbox[name=agree]", $("#frmJoinAgreeInfo")).click(
						function() {
							var isAllAgree = true;
							$("input:checkbox[name=agree]",
									$("#frmJoinAgreeInfo")).each(function() {
								if (!$(this).is(":checked")) {
									isAllAgree = false;
									return;
								}
							});

							if (isAllAgree) {
								$("#agreeAll").prop("checked", true);
							} else {
								$("#agreeAll").prop("checked", false);
							}
						});

				// 전체약관에 동의여부 체크박스 제어
				$("#agreeAll").click(
						function() {
							if ($(this).is(":checked")) {
								$("input:checkbox[name=agree]",
										$("#frmJoinAgreeInfo")).prop("checked",
										true);
							} else {
								$("input:checkbox[name=agree]",
										$("#frmJoinAgreeInfo")).prop("checked",
										false);
							}
						});

				$("#btnJoinNextStep").click(
						function(e) {

							e.preventDefault();

							// 필수약관 동의 체크
							var isRequiredAgree = true;
							$("input:checkbox[name=agree]",
									$("#frmJoinAgreeInfo")).each(
									function() {
										var agreeId = $(this).attr("id");
										if (agreeId != "agreePrivacyUse"
												&& agreeId != "agree14"
												&& !$(this).is(":checked")) {
											isRequiredAgree = false;
											return;
										}
									});

							if ($('#agree14').prop('checked') == false) {
								alert("14세 미만은 가입할 수 없습니다.");
								return;
							}

							/* ga 개인 약관동의 start */
							try {
								gfn_gaJoinAgreeEvent();
							} catch (e) {
								console.log(e)
							}
							/* ga 개인 약관동의 end */

							if (!isRequiredAgree) {
								$("#txtErrAgreeMsg").show();
								return;
							} else {
								$("#txtErrAgreeMsg").hide();
							}

							// 개인정보 수집/이용 동의 여부 설정
							if ($("#agreePrivacyUse").is(":checked")) {
								$("input:hidden[name=piUseYn]",
										$("#frmJoinAgreeInfo")).val("Y");
							} else {
								$("input:hidden[name=piUseYn]",
										$("#frmJoinAgreeInfo")).val("N");
							}

							// 정보 입력 페이지로 이동			
							$("#frmJoinAgreeInfo").submit();
						});

			});
</script>

<!-- container : s -->

<div class="container" style = "margin-bottom : 40px">
	<h2 class="mt-4 mb-3">AirFresh 회원가입</h2>
	<hr>
	<div class="row justify-content-center">
		<div class="col-lg-8">
			<div class="card shadow-lg border-0 rounded-lg mt-8">
				<div class="card-header">
					<h3 class="text-center font-weight-light my-4">개인 가입 약관 동의</h3>
				</div>
				<div class="card-body">
					

					<form id="frmJoinAgreeInfo"
						action="<%=request.getContextPath()%>/addmem" method="post">
						<input type="hidden" name="command" value="register">
						<div class="card  rounded-lg mt-5" style="padding:20px;">
							<div class="agree">
								<div class="checkbox">
									<input type="checkbox" id="agreeAirFreshMall" name="agree">
									<label for="agreeAirFreshMall"> <span class="badge badge-warning">필수</span> AirFresh몰
										이용약관</label>
										<a
									href="<%=request.getContextPath()%>/addmem?command=siteterms"
									class="link2" target="_blank">[전문보기]</a>
								</div>
								

							</div>
							<div class="agree">
								<div class="checkbox">
									<input type="checkbox" id="agreePersonalInfo" name="agree">
									<label for="agreePersonalInfo"> <span class="badge badge-warning">필수</span> 개인정보 수집 / 이용안내</label>
									<a
									href="<%=request.getContextPath()%>/addmem?command=infoterms"
									class="link2" target="_blank">[전문보기]</a>
								</div>
								
							</div>
							<div class="agree">
								<div class="checkbox">
									<input type="checkbox" id="agreePrivacyUse" name="agree">
									<label for="agreePrivacyUse"> <span class="badge badge-info">선택</span>
										개인 정보 수집 / 이용 동의</label>
										<a
									href="<%=request.getContextPath()%>/addmem?command=puseterms"
									class="link2" target="_blank">[전문보기]</a>
								</div>
								
							</div>
						</div>
						<input type="hidden" name="piUseYn" value="">
					</form>

					<p class="txtBtm validate" style="display: none;"
						id="txtErrAgreeMsg">AirFresh몰 이용약관, 개인정보 수집 및 이용안내는 필수로 동의하셔야
						합니다.</p>
					<div align = "center">
									
							<div class="checkbox">
								<input type="checkbox" id="agree14" name="agree"> <label
									for="agree14">14세 이상입니다. <span style="font-size:8pt; color : red;">(14세 미만은 회원가입 제한)</span></label>
							</div>
						
						<div class="agreeAllChk">
							<div class="checkbox">
								<input type="checkbox" id="agreeAll" name="agreeAll"> <label
									for="agreeAll">전체 약관에 동의합니다.</label>
							</div>
						</div>
					</div>
					<div align = "center">
						<a href="<%=request.getContextPath()%>/addmem" class="btn btn-primary"
							id="btnJoinNextStep"><span>다음</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="./../include/footer.jsp"%>