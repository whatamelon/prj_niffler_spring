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
       padding-bottom: 5px;
       padding-top: 5px;
       border-top-width: 5px;
      
   }
   .card{
      margin : 5px 50px 60px 50px;
      width : 75%;
      height : 150px;
      border-radius : 80px;
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
      margin-left:49px;
      margin-right:36px;
      margin-top:20px;
      margin-bottom:25px;
    }
    #subWeather p{
    	font-size:15px;
    	margin-left:10px;
    }
    #subWeather{
    	margin-top:10px;
    	margin-left:10px;
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
      <p style="margin-top:20px;">현재 날씨!</p>
      <div class="card" id="feel" style="background-color:#F1F8E9; display:inherit;">
         <div style=" float: left;margin-left: 0px;margin-top: 20px;"><p id="main"style="font-style: italic;font-size: 30px;
         text-shadow: 2px 8px 6px rgba(0,0,0,0.2), 0px -3px 20px rgba(255,255,255,0.4);"></p></div>
         <div style="float: right;margin-right: 20px;margin-top: 20px;"><p id="location"></p></div>
         <div style="display: inline-grid;">
         <div id="subWeather"style="display:flex">
         <p>현재 날씨 : </p><p id="temp"></p>
         <p>현재 습도 : </p><p id="humidity"></p>
         </div>
         </div>
      </div>
         
      <!-- 이번주 날씨! -->
      <p>이번주 날씨!</p>
      <div class="card" id="link">
      <div class="dates" style="float:left; border-right-style:inset; background-color : #E8F5E9">
         <p id="weekDate1" class="weekWeather"></p>
         <p id="weekDate2" class="weekWeather"></p>
         <p id="weekDate3" class="weekWeather"></p>
         <p id="weekDate4" class="weekWeather"></p>
      </div>
      <div class="temps" style="float:right; background-color :#C5CAE9;">
         <p id="weekTemp1" class="weekWeather"></p>
         <p id="weekTemp2" class="weekWeather"></p>
         <p id="weekTemp3" class="weekWeather"></p>
         <p id="weekTemp4" class="weekWeather"></p>
      </div>
      </div>
      
      </div>
      
   </div>

    <div class="overlay"></div>

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
     var celcius = Math.round(parseFloat(d.list[4].main.temp)-273.15);
     var humidity = d.list[4].main.humidity;
     var location = d.city.name.slice(0,5);
     var main = d.list[4].weather[0].main;
     
     document.getElementById("temp").innerHTML = celcius + '&deg;';
     document.getElementById('location').innerHTML = location;
     document.getElementById('main').innerHTML = main;
     document.getElementById('humidity').innerHTML = humidity + '%';
     
      //이번주 날씨
     var weekTemp1 = Math.round(parseFloat(d.list[10].main.temp)-273.15);
     var weekDate1 = d.list[10].dt_txt.slice(0,10);
     var weekTemp2 = Math.round(parseFloat(d.list[18].main.temp)-273.15);
     var weekDate2 = d.list[18].dt_txt.slice(0,10);
     var weekTemp3 = Math.round(parseFloat(d.list[26].main.temp)-273.15);
     var weekDate3 = d.list[26].dt_txt.slice(0,10);
     var weekTemp4 = Math.round(parseFloat(d.list[34].main.temp)-273.15);
     var weekDate4 = d.list[34].dt_txt.slice(0,10);
     
     
     document.getElementById("weekTemp1").innerHTML = weekTemp1 + '&deg;';
     document.getElementById("weekDate1").innerHTML = weekDate1;
     document.getElementById("weekTemp2").innerHTML = weekTemp2 + '&deg;';
     document.getElementById("weekDate2").innerHTML = weekDate2;
     document.getElementById("weekTemp3").innerHTML = weekTemp3 + '&deg;';
     document.getElementById("weekDate3").innerHTML = weekDate3;
     document.getElementById("weekTemp4").innerHTML = weekTemp4 + '&deg;';
     document.getElementById("weekDate4").innerHTML = weekDate4;
     
   }
    if(location=='Seoul-teukbyeolsi') document.getElementById("location").innerHTML = ('서울'); 

   
   window.onload = function() {
      weatherBallon( 1835847 );
   }
   </script>
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