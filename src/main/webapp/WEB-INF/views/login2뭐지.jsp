<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />

<!-- Bootstrap CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="resources/css/tiny-slider.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<title> KOSMO [2조] Middle Project </title>
</head>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/tiny-slider.js"></script>
	<script src="resources/js/custom.js"></script>

<body>

	<!-- Start Header/Navigation -->
	<nav
		class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark"
		arial-label="Furni navigation bar">

		<div class="container">
			<a class="navbar-brand" href="index.html">酒 다<span>.</span></a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsFurni"
				aria-controls="navbarsFurni" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsFurni">
				<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
					<!-- <li class="nav-item active"><a class="nav-link"
						href="index.html">메인</a></li> -->
					<li><a class="nav-link" href="about.html"><b>소개하기</b></a></li>
					<li><a class="nav-link" href="shop.html"><b>구매하기</b></a></li>
					<li><a class="nav-link" href="services.html"><b>우리들의 공간</b></a></li>
<!-- 					<li><a class="nav-link" href="blog.html">Blog</a></li> -->
<!-- 					<li><a class="nav-link" href="contact.html">Contact us</a></li> -->
				</ul>

				<ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
					<li><a class="nav-link" href="login.html">들어가기</a></li>
					<li><a class="nav-link" href="join.html">함께하기</a></li>
					<li><a class="nav-link" href="cart.html">장바구니</a></li>
					<li><a class="nav-link" href="myPage.html">나만의 공간</a></li>
				</ul>
			</div>
		</div>

	</nav>
	<!-- End Header/Navigation -->

	<!-- Start Hero Section -->
	<div class="hero">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-5">
					<div class="intro-excerpt">
						<h1>
							<span clsas="d-block">현재와 과거를 함께하다</span>
						</h1>
						<p class="mb-4">2조 전통주 프로젝트 酒다입니다. </p>
						<p>
							<a href="" class="btn btn-secondary me-2">주문하러 가기</a><a href="#"
								class="btn btn-white-outline">구경하기</a>
						</p>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="hero-img-wrap">
						<img src="resources/" class="img-fluid">
					</div><!-- hero_img -->
				</div><!-- col-lg -->
			</div><!-- row justify-content -->
		</div><!-- container -->
	</div><!-- hero -->
	<!-- End Hero Section -->
	
<!-- start 로그인 -->
	<div id='login'>
	<tr></tr><tr></tr><tr></tr>
		<h3><b>로 &nbsp;그 &nbsp;인</b></h3>
	<form name="form" action="login.do" method="post">
  		<table width="1850" height="120" >
    
   			 <tr> 
      			<td class='log_id'><input type="text" name="userId" placeholder="아이디" ></td>
    		</tr>
    		
			<tr>
				<td class='log_id'><input type="password" name="userPass" placeholder="비밀번호"></td>
    		</tr>
 
 			<tr>
  				<td colspan=2>
    			<input type="button" name="in_btn" id="in_btn" value="들    어    가    기">
				</td>
 			</tr>
 
  			<tr>
  				<td colspan=2>
    			<a href=''><b>아이디 찾기</b></a>
    			<a href=''><b>비밀번호 찾기</b></a>
    			<a href=''><b>회원 가입</b></a>
				</td>
 			</tr>
 	
  		</table>
  </form>
  </div>
<!-- end 로그인 -->




</body>

</html>
