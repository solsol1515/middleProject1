<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<link href="resources/css/tiny-slider.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/signin.css" rel="stylesheet">

<title>회원가입</title>
</head>
<body>

	<!-- Start Header/Navigation -->
	<nav
		class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark"
		arial-label="Furni navigation bar">

		<div class="container">
			<a class="navbar-brand" href="index.html">Furni<span>.</span></a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsFurni"
				aria-controls="navbarsFurni" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsFurni">
				<ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
					<li class="nav-item active"><a class="nav-link"
						href="index.html">Home</a></li>
					<li><a class="nav-link" href="about.html">소개하기</a></li>
					<li><a class="nav-link" href="shop.html">구매하기</a></li>
					<li><a class="nav-link" href="services.html">Services</a></li>
					<li><a class="nav-link" href="blog.html">Blog</a></li>
					<li><a class="nav-link" href="contact.html">Contact us</a></li>
				</ul>

				<ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
					<li><a class="nav-link" href="#"><img
							src="images/user.svg"></a></li>
					<li><a class="nav-link" href="cart.html"><img
							src="images/cart.svg"></a></li>
				</ul>
			</div>
		</div>

	</nav>
	<!-- End Header/Navigation -->
	
	
	<section class="bg-light">
        <div class="container py-4">
        
            <div class="row align-items-center justify-content-between">
                <a class="navbar-brand h1 text-center" href="index.do">
                    <span class="text-dark h4">회원</span> <span class="text-primary h4">가입</span>                 
                </a>
            </div>
            
            <div class="row">
            	<div class="col-md-4"></div>
            	<div class="col-md-4">
            		<form action="joinSuccess.do" method='post'>
		                <div class="form-group">
		               		<label for="member_id" class="form-label mt-4">아이디</label>
		                    <input type="text" class="form-control" id="member_id" style="background-color:#918F8F;" name="member_id">
		                </div>
						<div class="form-group has-success">
							<label class="form-label mt-4" for="password">비밀번호</label>
							<input type="password" class="form-control is-valid" id="password" name="password">
							<div class="valid-feedback"></div>
						</div>
		
						<div class="form-group has-danger">
							<label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label> 
							<input type="password" class="form-control is-invalid" id="inputInvalid">
							<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
						</div>
		                <div class="form-group">
		               		<label for="name" class="form-label mt-4">이름</label>
		                    <input type="text" class="form-control" id="name" name="name">
		                </div>
		                <div class ="form-group row">
		                	<label class="form-label mt-4">생년월일</label>
		                	<div class="col" id="bir_yy">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="yy" placeholder="년(4자)" maxlength="4" name="yy">
		                		</span>
		                	</div>
		                	<div class="col" id="bir_mm">
		                		<span class="ps_box focus">
					                <select class="form-select" id="mm" name="mm">
								        <option>월</option>
								        <option>1</option>
								        <option>2</option>
								        <option>3</option>
								        <option>4</option>
								        <option>5</option>
								        <option>6</option>
								        <option>7</option>
								        <option>8</option>
								        <option>9</option>
								        <option>10</option>
								        <option>11</option>
								        <option>12</option>
								     </select>
		                		</span>
		                	</div>
		                	<div class="col" id="bir_dd">
		                		<span class="ps_box">
		                			<input type ="text" class="form-control" id ="dd" placeholder="일" maxlength="2" name="dd">
		                		</span>
		                	</div>
		                </div>
					    <div class="form-group">
					      <label for="gender" class="form-label mt-4">성별</label>
					      <select class="form-select" id="gender" name="gender">
					        <option>남자</option>
					        <option>여자</option>
					        <option>거북</option>
					      </select>
					    </div>                
					    <div class ="form-group row">
					    	<label class="form-label mt-4">휴대폰 번호</label>
					    	<div class="col">
		                		<span class="ps_box focus">
					                <select class="form-select" id="phone_num1" name="phone_num1">
								        <option>010</option>
								        <option>070</option>
								        <option>02</option>
								     </select>
		                		</span>
		                	</div>
		                	<div class="col">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="phone_num2" maxlength="4" name="phone_num2">
		                		</span>
		                	</div>
		                	<div class="col">
		                		<span class="ps_box">
		                			<input type="text" class="form-control" id="phone_num3" maxlength="4" name="phone_num3">
		                		</span>
		                	</div>
					    </div>
					    
					    <div class="d-grid gap-5">
						    <div class="form-group">
				                <div class="form-group">
				               		<label for="email" class="form-label mt-4">이메일</label>
				                    <input type="email" class="form-control" id="email" placeholder="*****@***.com" name="email">
				                </div>
			                </div>
		                
			                <div class="form-group">
		                		<label>마케팅 수신 동의 (선택)</label>
		                		<hr/>
		                		<input type="checkbox" name="agree_email"> 이메일&nbsp;&nbsp;&nbsp;&nbsp;
		                		<input type="checkbox" name="agree_sns"> SNS <br/>
		                		<span>* 본 동의 사항은 선택사항으로 거부 할 수 있으며, 거부하시더라도 서비스 이용에 제한은 없습니다. 단, 이벤트 정보, 신제품 출시 등 맞춤형 서비스를 제공 받으실 수 없습니다.</span>
			                </div>
			                
			                <div class="text-center">
				            	<button class="btn btn-lg" type="button" background-color:#918F8F>가입하기</button>
				            </div>
		                </div>
		
		            </form>
            	</div>
            	<div class="col-md-4"></div>
            </div>
        </div>
    </section>
    
    
	<!-- Start Footer Section -->
	<footer class="footer-section">
		<div class="container relative">

			<div class="sofa-img">
				<img src="resources/images/sofa.png" alt="Image" class="img-fluid">
			</div>

			<div class="row">
				<div class="col-lg-8">
					<div class="subscription-form">
						<h3 class="d-flex align-items-center"></h3>
					</div>
				</div>
			</div>

			<div class="row g-5 mb-5">
				<div class="col-lg-4">
					<div class="mb-4 footer-logo-wrap">
						<a href="#" class="footer-logo">Furni<span>.</span></a>
					</div>
					<p class="mb-4">Donec facilisis quam ut purus rutrum lobortis.
						Donec vitae odio quis nisl dapibus malesuada. Nullam ac aliquet
						velit. Aliquam vulputate velit imperdiet dolor tempor tristique.
						Pellentesque habitant</p>

					<ul class="list-unstyled custom-social">
						<li><a href="#"><span class="fa fa-brands fa-facebook-f"></span></a></li>
						<li><a href="#"><span class="fa fa-brands fa-twitter"></span></a></li>
						<li><a href="#"><span class="fa fa-brands fa-instagram"></span></a></li>
						<li><a href="#"><span class="fa fa-brands fa-linkedin"></span></a></li>
					</ul>
				</div>

				<div class="col-lg-8">
					<div class="row links-wrap">
						<div class="col-6 col-sm-6 col-md-3">
							<ul class="list-unstyled">
								<li><a href="#">About us</a></li>
								<li><a href="#">Services</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</div>

						<div class="col-6 col-sm-6 col-md-3">
							<ul class="list-unstyled">
								<li><a href="#">Support</a></li>
								<li><a href="#">Knowledge base</a></li>
								<li><a href="#">Live chat</a></li>
							</ul>
						</div>

						<div class="col-6 col-sm-6 col-md-3">
							<ul class="list-unstyled">
								<li><a href="#">Jobs</a></li>
								<li><a href="#">Our team</a></li>
								<li><a href="#">Leadership</a></li>
								<li><a href="#">Privacy Policy</a></li>
							</ul>
						</div>

						<div class="col-6 col-sm-6 col-md-3">
							<ul class="list-unstyled">
								<li><a href="#">Nordic Chair</a></li>
								<li><a href="#">Kruzo Aero</a></li>
								<li><a href="#">Ergonomic Chair</a></li>
							</ul>
						</div>
					</div>
				</div>

			</div>

			<div class="border-top copyright">
				<div class="row pt-4">
					<div class="col-lg-6">
						<p class="mb-2 text-center text-lg-start">
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							. All Rights Reserved. &mdash; Designed with love by <a
								href="https://untree.co">Untree.co</a>
							<!-- License information: https://untree.co/license/ -->
						</p>
					</div>

					<div class="col-lg-6 text-center text-lg-end">
						<ul class="list-unstyled d-inline-flex ms-auto">
							<li class="me-4"><a href="#">Terms &amp; Conditions</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</div>

				</div>
			</div>

		</div>
	</footer>
	<!-- End Footer Section -->

	<!-- JavaScript -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/tiny-slider.js"></script>
	<script src="resources/js/custom.js"></script>
	<script src="resources/js/join.js"></script>

</body>
</html>