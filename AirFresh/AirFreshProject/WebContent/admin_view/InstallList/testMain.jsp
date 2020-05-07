<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>testMain</title>
		<!-- jquery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		<style type="text/css">
			.container{
				margin-left: 10%
			}
			header{
				width: 800px;
				height: 150px;
				background-color: #111;
			}
			aside{
				width: 200px;
				height: 600px;
				float: left;
				background-color: gray; 
				
			}
			section{
				width: 600px;
				height: 600px;
				float: left;
				background-color: darkgray;
			}
			footer{
				width: 800px;
				height: 100px;
				background-color: gray;
				clear: both;
			}
			.로그인단{
				width: 200px;
				height: 200px;
				background-color: darkgray;
			}
			.메뉴단{
				width: 200px;
				height: 400px;
				
			}
			.menuSpan{
				width: 200px;
				height: 50px;
				align-content: center;
				background-color: black;
				color: #fff;
			}
			.Menu{
				width: 200px;
				height: 40px;
				padding-top: 10px;
				background-color: yellow;
			}
			span:hover{
				font-size: 10px;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
			<header><!-- 타이틀 -->
			</header>
			<aside><!-- 메뉴 & 로그인정보/로그아웃  -->
				<div class="로그인단"><!-- 로그인 관련 -->
					
				</div>
				<div class="메뉴단" align="center"><!-- 메뉴버튼 -->
					<div class="Menu"><span class="menuSpan" >Menu1</span></div>
					<div class="Menu"><span class="menuSpan">Menu2</span></div>
					<div class="Menu"><span class="menuSpan">Menu3</span></div>
					<div class="Menu"><span class="menuSpan">Menu4</span></div>
					<div class="Menu"><span class="menuSpan">Menu5</span></div>
					<div class="Menu"><span class="menuSpan">Menu6</span></div>
				</div>
			</aside>
			<section><!-- 기능  -->
				<div id="content">
				
				
				</div>
			</section>
			<footer>
				<!-- ? -->
			</footer>
		</div>
		
		
		<script type="text/javascript">
			$(document).ready(function () {
				
				$("span").click(function () {
					alert($(this).text());
				});
				
			});
		</script>
	</body>
</html>