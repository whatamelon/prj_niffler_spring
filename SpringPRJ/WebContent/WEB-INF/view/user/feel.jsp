<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="poly.dto.FeelDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   FeelDTO fDTO = (FeelDTO) request.getAttribute("fDTO");
%>
<html>

<!--  ------------------------------헤드 시작-------------------------------- -->

 <head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="/resources/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/resources/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  
  <title>
    오늘의 기분
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
		margin : 10px 50px 40px 50px;
		width : 75%;
		height : 150px;
		text-align: center;
    	border: 1px solid #FFFFFF;
    	border-radius:30px;
		
	}
	p{
    margin: 10px 0px 0px 40px;
    font-weight:bold;
    font-size: 1.0em;
    color:#000;
	}
	i#today{
		margin-top:50px;
		padding :0px 5px 0px 5px;
	}
	.btn.btn-primary{
	box-shadow : 0 6px #999 !important;
	cursor : pointer;
	}
	.btn.btn-primary:hover{
	background-color:#536DFE;
	}
	.btn.btn-primary:active{
	box-shadow : 0 3px #999 !important;
	transform: translateY(3px) !important;
	background-color:#536DFE;
	}

input{
	margin-left:15px;
	margin-right:15px;
}
.checkboxdiv{
	margin-top:20px;
}



input[type="radio"] {
	border: 0;
	clip: rect(0 0 0 0);
	height: 1px;
	margin: -1px;
	overflow: hidden;
	padding: 0;
	position: absolute;
	width: 1px;
}

input[type="radio"]:focus + label:before,
input[type="radio"]:hover + label:before {
	border-color: black;
}

input[type="radio"]:active + label:before {
	-webkit-transition-duration: 0;
	transition-duration: 0;
	-webkit-filter: brightness(0.2);
	filter: brightness(0.2);
}

input[type="radio"] + label {
	position: relative;
	padding: 10px;
	margin:0px 10px 0px 11px !important;
	vertical-align: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
input[type="radio"] + label:before {
	box-sizing: content-box;
	content: '';
	color: #81C784;
	position: absolute;
	top: 50%;
	left: 0;
	width: 14px;
	height: 14px;
	margin-top: -9px;
	border: 2px solid #fff;
	text-align: center;
}
input[type="radio"] + label:after {
	box-sizing: content-box;
	content: '';
	background-color: #81C784;
	position: absolute;
	top: 50%;
	left: 4px;
	width: 10px;
	height: 10px;
	margin-top: -5px;
	-webkit-transform: scale(0);
	transform: scale(0);
	-webkit-transform-origin: 50%;
	transform-origin: 50%;
	-webkit-transition: -webkit-transform 200ms ease-out;
	transition: -webkit-transform 200ms ease-out;
	transition: transform 200ms ease-out;
	transition: transform 200ms ease-out, -webkit-transform 200ms ease-out;
}

input[type="radio"]:checked + label:before {
	-webkit-animation: borderscale 300ms ease-in;
	animation: borderscale 300ms ease-in;
	background-color: transparent;
}

input[type="radio"]:checked + label:after {
	-webkit-transform: scale(1);
	transform: scale(1);
}

input[type="radio"] + label:before,
input[type="radio"] + label:after {
	border-radius: 50%;
}

@-webkit-keyframes borderscale {
	50% {
		box-shadow: 0 0 0 2px #81C784;
	}
}

@keyframes borderscale {
	50% {
		box-shadow: 0 0 0 2px #81C784;
	}
}
input:focus {
	border: 1px solid #fff;
}

input:not(:focus):invalid {
	border: 1px solid red;
	outline: none;
}

input:not(:focus):valid {
	border: 1px solid green;
}
label {
	cursor: pointer;
	display: inline-block;
}



</style>

</head>

<body>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar" style="color:#FFFFFF; background-color:#B3E5FC !important" >
            <ul class="list-unstyled components">
                <li>
                    <a href="weather.do"> <i class="fas fa-sun"></i> 날씨</a>
                </li>
                <li>
                    <a href="Trend.do"> <i class="fas fa-chart-line"></i> 트렌드 검색</a>
                </li>
                <li>
                    <a href="recommend.do"> <i class="fas fa-check"></i> 오늘의 추천</a>
                </li>
                <li>
                    <a href="feel.do"> <i class="fas fa-smile"></i> 오늘의 기분</a>
                </li>
            </ul>
        </nav>

		<!-- 메인 -->
		<div id="content" style="padding: 0px !important; width:100%; background:linear-gradient( #BBDEFB, #FFF9C4);">
		<!-- 헤드바 -->
			<nav class="navbar navbar-light" style="color:#FFFFFF;">
			<button type="button" id="sidebarCollapse" class="btn btn-info" style="background-color:#FFFFFF !important; border-color:#FFFFFF !important;">
				<i class="fas fa-align-justify" style="color:#4FC3F7;"></i>
			</button>
			<a href="/main.do" style="margin-right:15px;"><i class="fas fa-angle-right" style="color:#4FC3F7;"></i></a>
			</nav>
		
		<form action="/user/sendFeel.do" method="post" id="submitForm">
		
		<p>오늘의 기분을 알려주세요!</p>
		
		<span style="display:flex;"><p>오늘은</p><p id=time-result style="margin-left:20px;"></p><p style="margin-left:20px;">입니다.</p></span>
		
		<%
		Date from = new Date();

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String to = transFormat.format(from);
		
		if(fDTO.getFeel_date().equals(to)){
			
		%>
		
		<div>
		
		<p>오늘은 기분을 저장했습니다!</p>
		
		</div> 
		
		<%} else { %> 
		
		
		
		<div class="card" id="feel">
			<a href="#" style="color:#EF5350;" class="1"><i class="far fa-dizzy fa-2x "  id="today"></i></a>
			<a href="#"  style="color:#FFD54F;" class="2"><i class="far fa-frown fa-2x "  id="today"></i></a>
			<a href="#"  style="color:#81C784;" class="3"><i class="far fa-meh fa-2x " id="today"></i></a>
			<a href="#"  style="color:#64B5F6;" class="4"><i class="far fa-smile fa-2x " id="today"></i></a>
			<a href="#" style="color:#9575CD;" class="5"><i class="far fa-laugh-squint fa-2x " id="today"></i></a>
		
			<div class="checkboxdiv">
				<input type="radio" id="radio1" name="feelcheck" value="1"  class="check1">
				<label for="radio1"></label>
				<input type="radio" id="radio2" name="feelcheck" value="2"  class="check2">
				<label for="radio2"></label>
				<input type="radio" id="radio3" name="feelcheck" value="3"  class="check3">
				<label for="radio3"></label>
				<input type="radio"id="radio4"  name="feelcheck" value="4"  class="check4">
				<label for="radio4"></label>
				<input type="radio" id="radio5" name="feelcheck" value="5"  class="check5">
				<label for="radio5"></label>
				
				<input type="hidden" name="feel_weather" id="main"  />
				
			</div>		
		
		</div>
		
		<button class="btn btn-primary" type="button" style="width:300px; margin-left:40px; border-radius:30px;background-color: transparent !important;
		border: 1px solid #fff;color: #fff;"onclick="check()">확인!</button>
		
		
		
		</form>
		<% } %>
	</div>
	</div>
    <div class="overlay"></div>
    
    <script type="text/javascript">

    function check(){ 

    var feel_weather = $( 'input#main' ).text();
 
    $('#main').val(feel_weather);
   
   	 $('#submitForm').submit();
   }

   	 
    </script>
    
    
    <script type="text/javascript">
        var d = new Date();
        var currentDate = d.getFullYear() + "년 " + ( d.getMonth() + 1 ) + "월 " + d.getDate() + "일 ";
        var result = document.getElementById("time-result");
        result.innerHTML =  currentDate;
</script>
    
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
   const key = '3d31ad55e3b04dcdfb1d42ff1af32638';
   function weatherBallon( cityID ) {
      fetch('https://api.openweathermap.org/data/2.5/forecast?id=' + cityID+ '&appid=' + key)  
      .then(function(resp) { return resp.json() }) // Convert data to json
      .then(function(data) {
         drawWeather(data);
      })
      .catch(function() {
      // catch any errors
   });;
   }
   function drawWeather( d ) {
      
      // 오늘 날씨
     var main = d.list[4].weather[0].main;
     
     document.getElementById('main').innerHTML = main;

   }
    if(location=='Seoul-teukbyeolsi') document.getElementById("location").innerHTML = ('서울'); 

   
   window.onload = function() {
      weatherBallon( 1835847 );
   }
   </script>


</body>
</html>
