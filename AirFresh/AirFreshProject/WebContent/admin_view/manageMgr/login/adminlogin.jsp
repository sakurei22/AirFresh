<%@page import="Dto.ManagerMemberDto"%>
<%@page import="db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//ManagerMemberDto mem = request.getSession().setAttribute("managerLogin", key);
HttpSession adminlogincheck = request.getSession();
ManagerMemberDto mem = (ManagerMemberDto)session.getAttribute("managerLogin");
System.out.println(mem);

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
</head>
	 <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
            
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Air FRESH 관리자 로그인 페이지</h3></div>
                                    <div class="card-body">
                                        <!-- <form id="loginInfo" action="<%=request.getContextPath() %>/managerLogin" method="post"> -->
                                        <form id="loginInfo">
                                            <div class="form-group"><label class="small mb-1" for="inputId">ID</label>
                                            <input class="form-control py-4" type="email" placeholder="Enter ID" id="manager_id" name="manager_id"/></div>
                                            <div class="form-group"><label class="small mb-1" for="inputPw">Password</label>
                                            <input class="form-control py-4" type="password" placeholder="Enter password" id="manager_pw" name="manager_pw"/></div>
                                            <div class="form-group">
                                                <div><input type="checkbox" id="chk_save_id">
                                                	<label>ID 저장</label>
                                                </div>
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"><a class="small" href="password.html">비밀번호 찾기</a>
                                            	<button type="button" class="btn btn-primary" id="btnlogin">로그인</button>
                                            </div>
                                        </form>
                                    </div>
                                    <%--
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="<%=request.getContextPath() %>/addMrgMember?status=enter">회원가입</a></div>
                                    </div>
                                     --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; 2020 O-HapZiZol</div>
                            
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
	<%--/body>
		< div align="center">
			<div class="title">
				<h2>로그인</h2>
				<p>Air FRESH 관리자 로그인 페이지에 접속중 입니다.</p>
			</div>	
			<div class="login">
				<form id="loginInfo" action="<%=request.getContextPath() %>/managerLogin" method="post">			
					<div>
					<div>
						<input type="text" placeholder="아이디(이메일)을 입력해주세요." id="manager_id" name="manager_id">
					</div>
					<div>
						<input type="password" placeholder="비밀번호를 입력해주세요." id="manager_pw" name="manager_pw">	
					</div>
					<div class="idcheck">
						<input type="checkbox" id="chk_save_id">
						<label for="saveid">아이디 저장</label>
					</div>
					</div>
					<button type="button" id="btnlogin">로그인</button>
					<div>
						<!-- <a href="searchidpw.jsp">아이디·패스워드 찾기</a>	-->
						 <a href="<%=request.getContextPath() %>/addMrgMember?status=enter">관리자 회원가입</a>
					</div>		
				</form>
			</div>
		</div--%>
	<script type="text/javascript">
		
	$(document).ready(function(){
	

	
			$("#btnlogin").click(function () {
				if( $("#manager_id").val().trim() == "" ){
					alert("id를 입력해 주십시오");
					$("#manager_id").focus();
				}
				else if( $("#manager_pw").val().trim() == "" ){
					alert("password를 입력해 주십시오");
					$("#manager_pw").focus();
				}
				else{
					//전체 조건을 만족할 시에 전송시킨다. 
					//$("#btnlogin").submit();		//바로 전송을 시키는 방식.
					
					//===========================================================================================================================
					//저장하기 버튼 클릭시 이벤트 
						console.log(" 로그인 클릭됨 .");
						var input_id = $("input[name='manager_id']").val();
						var input_pw = $("input[name='manager_pw']").val();
						
						console.log("들어온 id값 : "+input_id);
						console.log("들어온 pw값 : "+input_pw);

					$.ajax({
						url:'<%=request.getContextPath() %>/managerLogin?command=checkID_PW',
						type:"post",
						datatype:"json",
						data:{
							manager_id:input_id,
							manager_pw:input_pw
						},
						datatype:"text",
						success: function ( data ) {
							console.log("통신성공");
							console.log(data);
							//location.replace("<%=request.getContextPath() %>"+data);
							if(data == "true"){
								alert("로그인성공");
								location.href="<%=request.getContextPath() %>/managerLogin?command=success";
							}else{
								alert("로그인실패");
							}
							//location.href(data);
						},
						error: function () {
							alert("통신 실패");
						}
					});//end ajax
					
			}//else		

			});//end btnlogin()
			
			var user_id = $.cookie("user_id");
			if(user_id != null){			
				$("#manager_id").val( user_id );
				$("#chk_save_id").attr("checked", "checked");
			}
			$("#chk_save_id").click(function() {
				if( $("#chk_save_id").is(":checked") ){			
					if( $("#manager_id").val().trim() == "" ){
						alert("ID를 입력해 주십시오");
						$("#chk_save_id").prop("checked", false);			
					}else{					
						$.cookie("user_id", $("#manager_id").val().trim(), {expires:7, path:'./'});
					}
				}
				else{
					$.removeCookie("user_id", {path:'./'});
				}
			});
	});//end of document.ready(function());
		</script>
	</body>
</html>