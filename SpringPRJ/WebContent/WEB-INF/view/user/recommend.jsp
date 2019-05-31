<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
       padding-bottom: 5px;
       padding-top: 5px;
       border-top-width: 5px;
      
   }
   .card{
      margin : 5px 50px 60px 50px;
      width : 75%;
      height : 150px;
   }
   #link{
      height:220px;
   }
   p{
       margin: 10px 0px 0px 40px;
       font-weight:bold;
       font-size: 1.0em;
   }
   .weekWeather{
      font-size : 15px;
   }
   div#feel.card{
      margin-bottom:30px;
   }
    .dates p{
      margin-left:33px;
      margin-right:35px;
      margin-top:20px;
      margin-bottom:25px;
    }
    .temps p{
      margin-left:54px;
      margin-right:36px;
      margin-top:20px;
      margin-bottom:25px;
    }
    @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,300,600);	

html {
  border-top: 5px solid #fff;
}

html, body {
  margin: 0;
  padding: 0;
  font-family: 'Open Sans';
}

h1 {
  color: #fff;
  text-align: center;
  font-weight: 300;
}

#slider {
  width : 300px !important;
  position: relative;
  overflow: hidden;
  margin: 20px auto 0 auto;
  border-radius: 4px;
}

#slider ul {
  position: relative;
  margin: 0;
  padding: 0;
  height: 200px;
  list-style: none;
  margin-left:-360px !important;
}

#slider ul li {
  position: relative;
  display: block;
  float: left;
  margin: 0;
  padding: 0;
  width: 360px !important;
  height: 300px;
  background: #FFF8E1;
  text-align: center;
}

a.control_prev, a.control_next {
  position: absolute;
  top: 37.5%;
  z-index: 1;
  display: block;
  padding: 4% 3%;
  width: 20px;
  height: 20px;
  background: #FFECB3;
  color: #fff;
  text-decoration: none;
  font-weight: 600;
  font-size: 18px;
  opacity: 0.5;
  cursor: pointer;
}

a.control_prev:hover, a.control_next:hover {
  opacity: 0.3;
  -webkit-transition: all 0.2s ease;
}

a.control_prev {
  border-radius: 0 2px 2px 0;
}

a.control_next {
  right: 0;
  border-radius: 2px 0 0 2px;
}

.slider_option {
  position: relative;
  margin: 10px auto;
  width: 160px;
  font-size: 18px;
}
h5{
    width: 300px;
    padding-left: 20px;
}

a#url1.button1, a#url2.button2, a#url3.button3 {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	display: block;
	margin: 50px auto 0px auto;
	text-decoration: none;
	border-radius: 4px;
	padding: 10px 50px;
	color: rgba(30, 22, 54, 0.6);
	box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
    bottom: 0px;
    position: absolute;
    left: 20px;
	width:200px;
}

a#url1.button1:hover, a#url2.button2:hover, a#url3.button3:hover  {
	color: rgba(255, 255, 255, 0.85);
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}

#preview1, #preview2, #preview3 {
		max-width:300px;
		min-width:300px;
		max-height:150px;
		min-height:150px
}
.blinking{
	-webkit-animation:blink 1.5s ease-in-out infinite alternate;
    -moz-animation:blink 1.5s ease-in-out infinite alternate;
    animation:blink 1.5s ease-in-out infinite alternate;
}
@-webkit-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@-moz-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
</style>

</head>

<body>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
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
            </ul>
        </nav>

      <!-- 메인 -->
      <div id="content" style="padding: 0px !important; width:100%;">
      <!-- 헤드바 -->
         <nav class="navbar navbar-light amber darken-3">
         <button type="button" id="sidebarCollapse" class="btn btn-info" style="background-color:#FF8F00 !important; border-color:#FF8F00 !important;">
            <i class="fas fa-align-justify"></i>
         </button>
         <a href="/main.do" style="margin-right:15px;"><i class="fas fa-angle-right" style="color:white;"></i></a>
         </nav>
      
      <!-- 현재 날씨! -->
         <p style="margin-top:20px;">당신을 위한 추천!</p>
         
         <div class="card-carousel" style="height:500px !important;">

				<div id="slider">
					<a href="#" class="control_next blinking"><i class="fas fa-angle-right" style="color:white;"></i></a>
					<a href="#" class="control_prev blinking"><i class="fas fa-angle-left" style="color:white;"></i></a>
					<ul>
						<li style="width:340px !important; height:400px;">
							<div>
								  <img src="/resources/img/default-avatar.png" id="preview1" />
             					  <h2> <!-- id="title1"> -->Example</h2>
              					  <h5> <!-- id="description1"> -->너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다. 그리고
						무슨 일이 벌어져도 니 잘못이 아니다</h5>
							</div>
							<div>
									<a href=self id="url1" target="_blank" class="button1">바로가기</a>
							</div>
						</li>
						<li style="width: 340px !important;height:400px; ">
							<div class="my-card" id="card2">
								<img src="/resources/img/default-avatar.png" id="preview2" />
								<h2 id="title2"></h2>
								<h5 id="description2"></h5>
							</div>
							<div>
								<a href=self id="url2" target="_blank" class="button2">바로가기</a>
							</div>
						</li>
						<li style="width: 340px !important;height:400px;">
							<div class="my-card" id="card3">
								<img src="/resources/img/default-avatar.png" id="preview3" />
								<h2 id="title3"></h2>
								<h5 id="description3"></h5>
							</div>
							<div>
								<a href=self id="url3" target="_blank" class="button3">바로가기</a>
							</div>
						</li>

					</ul>
				</div>




				<!--   <div class="my-card" id="card1">
         	  <img src="/resources/img/default-avatar.png" id="preview1"/>
              <h2 id="title1"></h2>
              <h5 id="description1"></h5>
              <a href=self id="url1" target="_blank">바로가기</a>
          </div>
          
          <div class="my-card" id="card2">
         	  <img src="/resources/img/default-avatar.png" id="preview2"/>
              <h2 id="title2"></h2>
              <h5 id="description2"></h5>
              <a href=self id="url2" target="_blank">바로가기</a>
          </div>
          
          <div class="my-card" id="card3">
         	  <img src="/resources/img/default-avatar.png" id="preview3"/>
              <h2 id="title3"></h2>
              <h5 id="description3"></h5>
              <a href=self id="url3" target="_blank">바로가기</a>
          </div> -->
         <!--  
          <div class="my-card" id="card1">
          	<div>
         	  <img src="/resources/img/default-avatar.png"/>
              <h2>Example</h2>
					<h5>너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다. 그리고
						무슨 일이 벌어져도 니 잘못이 아니다.</h5>
			</div>
					<div><a href="#" target="_blank">바로가기</a></div>
          </div> -->
          

          
      </div>
      
     </div>
         
      </div>
      

    <div class="overlay"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript"> // sidebar 
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
    jQuery(document).ready(function ($) {

    	  $('#checkbox').change(function(){
    	    setInterval(function () {
    	        moveRight();
    	    }, 3000);
    	  });
    	  
    		var slideCount = $('#slider ul li').length;
    		var slideWidth = $('#slider ul li').width();
    		var slideHeight = $('#slider ul li').height();
    		var sliderUlWidth = slideCount * slideWidth;
    		
    		$('#slider').css({ width: slideWidth, height: slideHeight });
    		
    		$('#slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });
    		
    	    $('#slider ul li:last-child').prependTo('#slider ul');

    	    function moveLeft() {
    	        $('#slider ul').animate({
    	            left: + slideWidth
    	        }, 200, function () {
    	            $('#slider ul li:last-child').prependTo('#slider ul');
    	            $('#slider ul').css('left', '');
    	        });
    	    };

    	    function moveRight() {
    	        $('#slider ul').animate({
    	            left: - slideWidth
    	        }, 200, function () {
    	            $('#slider ul li:first-child').appendTo('#slider ul');
    	            $('#slider ul').css('left', '');
    	        });
    	    };

    	    $('a.control_prev').click(function () {
    	        moveLeft();
    	    });

    	    $('a.control_next').click(function () {
    	        moveRight();
    	    });

    	});    

    </script>

<!-- <script type="text/javascript">

	var target = 'https://www.google.com';
	
	$.ajax({
	    url: "http://api.linkpreview.net",
	    dataType: 'jsonp',
	    data: {q: target, key: '5cda3c57bc71709729b35b8a6a317c5abc37da67b880f'},
	    success: function (data) {
	    	console.log(data.title);
	    	console.log(data.description);
	    	console.log(data.image);
	    	console.log(data.url);
	    	
	    	$('#title1').append(data.title);
	    	$('#description1').append(data.description);
	    	$("#preview1").attr("src", data.image);
	    	$("#url1 a").prop("href", data.url);
	    },
	    error : function(e) {
	    	console.log(e.responseText);
	    }
	});
   </script>
   
   <script type="text/javascript">

	var target = 'https://www.naver.com/';
	
	$.ajax({
	    url: "http://api.linkpreview.net",
	    dataType: 'jsonp',
	    data: {q: target, key: '5cda3c57bc71709729b35b8a6a317c5abc37da67b880f'},
	    success: function (data) {
	    	console.log(data.title);
	    	console.log(data.description);
	    	console.log(data.image);
	    	console.log(data.url);
	    	
	    	$('#title2').append(data.title);
	    	$('#description2').append(data.description);
	    	$("#preview2").attr("src", data.image);
	    	$("#url2 a").prop("href", data.url);
	    },
	    error : function(e) {
	    	console.log(e.responseText);
	    }
	});
   </script>
   
   <script type="text/javascript">

	var target = 'https://www.youtube.com/';
	
	$.ajax({
	    url: "http://api.linkpreview.net",
	    dataType: 'jsonp',
	    data: {q: target, key: '5cda3c57bc71709729b35b8a6a317c5abc37da67b880f'},
	    success: function (data) {
	    	console.log(data.title);
	    	console.log(data.description);
	    	console.log(data.image);
	    	console.log(data.url);
	    	
	    	$('#title3').append(data.title);
	    	$('#description3').append(data.description);
	    	$("#preview3").attr("src", data.image);
	    	$("#url3 a").prop("href", data.url);
	    },
	    error : function(e) {
	    	console.log(e.responseText);
	    }
	});
   </script> -->
   
 <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
       <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

    
  <!-- Chart JS -->
  <script src="/resources/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/resources/js/plugins/bootstrap-notify.js"></script>

</body>
</html>