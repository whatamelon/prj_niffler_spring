<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="poly.dto.UserDTO"%>
<%
    	UserDTO uDTO=(UserDTO)session.getAttribute("uDTO");
    %>
<html>

<!--  ------------------------------헤드 시작-------------------------------- -->

 <head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="/resources/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/resources/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  
  <title>
    Now UI Dashboard by Creative Tim
  </title>
  
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  
  <!-- material design -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/js/mdb.min.js"></script>
  
  <!--     Fonts and icons     -->
  
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  
  <!-- CSS Files -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link href="/resources/css/vendorprefixes.css" rel="stylesheet" />
  
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/resources/demo/demo.css" rel="stylesheet" />
  

     <!--   Core JS Files   -->
  <script src="/resources/js/jquery-3.4.0.min.js"></script>
  <script src="/resources/js/core/popper.min.js"></script>
  <script src="/resources/js/core/bootstrap.min.js"></script>
  
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="/resources/css/style3.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<style>
	#sidebar ul.components{
		border-bottom : 0px solid;
	}
	#sidebarCollapse.btn.btn-info{
		-webkit-box-shadow : none !important;
	}
	.btn{
		box-shadow : none !important;
	}
	#sidebar ul li a{
		padding-left:20px;
	}
	#sidebar{
		background:#FF8F00 !important;
		box-shadow:none !important;
	}
	.navbar{
		margin-bottom : 0px !important;
	}
	.card{
		margin : 5px 50px 60px 50px;
		width : 75%;
		height : 700px;
		border-radius:50px;
		border : 1px solid #FFFFFF;
	}
	p{
    margin: 10px 0px 0px 40px;
    font-weight:bold;
    font-size: 1.0em;
	}
</style>

</head>

<body>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar" style="color:#FFFFFF; background-color:#B3E5FC !important" >
            <ul class="list-unstyled components">
                <li>
                    <a href="user/weather.do"> <i class="fas fa-sun"></i> 날씨</a>
                </li>
                <li>
                    <a href="user/Trend.do"> <i class="fas fa-chart-line"></i> 트렌드 검색</a>
                </li>
                <li>
                    <a href="user/recommend.do"> <i class="fas fa-check"></i> 오늘의 추천</a>
                </li>
                <li>
                    <a href="user/feel.do"> <i class="fas fa-smile"></i> 오늘의 기분</a>
                </li>
            </ul>
        </nav>

		<!-- 메인 -->
		<div id="content" style="padding: 0px !important; width:100%; background:linear-gradient( #BBDEFB, #64FFDA);" >
		<!-- 헤드바 -->
			<nav class="navbar navbar-light" style="color:#FFFFFF;">
			<button type="button" id="sidebarCollapse" class="btn btn-info" style="background-color:#FFFFFF !important; border-color:#FFFFFF !important;">
				<i class="fas fa-align-justify" style="color:#4FC3F7;"></i>
			</button>
			
			
			<button onclick="location.href = 'user/logout.do'  " style="
    background-color: #D1C4E9;
    border-color: #D1C4E9;
    border: 0px solid;
    border-radius: 10px;
    width: 80px;
    height: 30px;
    margin-left: 140px;
    color: #FFFFFF;
">로그아웃</button>
			</nav>
		
		<!-- 핫 이슈! -->
		<p style="color:#FFFFFF">현재 핫 이슈!</p>
		<div class="card" id="feel">
		<p style="width: 100px; word-break: keep-all; margin-left: 80px; padding-top:20px; text-align: center; color:#FFFFFF;
		text-decoration-line: underline;text-decoration-style: wavy;">
		<%@include file = "crawling.jsp" %></p>
		</div>
		
		
		</div>
		
	</div>

    <div class="overlay"></div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>


    <script type="text/javascript">
        $(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });
            $('#dismiss, .overlay').on('click', function () {
                $('#sidebar').removeClass('active');
                $('.overlay').removeClass('active');
            });
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').addClass('active');
                $('.overlay').addClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>
    
    <script type="text/javascript">
      
    </script>

	<!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="/resources/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/resources/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/resources/js/now-ui-dashboard.min.js?v=1.2.0" type="text/javascript"></script>

</body>
</html>