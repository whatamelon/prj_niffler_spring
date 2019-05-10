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
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  
  <!-- CSS Files -->
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
  <link href="/resources/css/vendorprefixes.css" rel="stylesheet" />
  
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/resources/demo/demo.css" rel="stylesheet" />
  
  <style>
  	li{
  		margin-top:30px;
  		margin-bottom : 30px;
  	}
  	
  	a{
  		color:white !important;
  	}
  </style>
</head>

<body class="" style="background-color : black;">

  <div class="wrapper ">
  
  	<center>
  		<p id=time-result style="color:white;"></p>
  	</center>
  	
  	<div>
  		<center>
  		<h5 style="color:white; margin-top:80px;">
  			ThisIsWhoAmI
  		</h5>
  		</center>
  	</div>
  	
  	<div style="margin-top:80px;">
  	<center>
  		<ul style="list-style: none; color:white; padding-left:0px;">
  			<li >
  				<a href="#modal fade" data-toggle="modal" data-target="#myModal">Login</a>
  			</li>
  			<li>
  				<a href="faq.do">FAQ</a>
  			</li>
  			<li>
  				<a href="createaccount.do">Join</a>
  			</li>
  		</ul>
  		
  		<a style="border:1px solid white; background-color:black; padding : 5px; margin-top:100px;">
  			<!-- <p style="color:white; margin-bottom:0px;">what is it?</p> --> what is it?
  		</a>
  		</center>
  	</div>
		<form>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" style="top: 100px;">
						<div class="modal-header" style="border-bottom: 0px solid;">
							<h4 class="modal-title" id="myModalLabel"
								style="margin-left: 120px;">로그인</h4>
						</div>
						<div class="modal-body">
							<div class="col">
								<div class="md-form mt-0">
									<input type="text" class="form-control" placeholder="ID">
								</div>
							</div>

							<div class="col">
								<div class="md-form mt-0">
									<input type="text" class="form-control" placeholder="Password">
								</div>
							</div>

						</div>
						<div class="modal-footer" style="border-top: 0px solid;">
							<center>
								<button type="button" class="btn btn-primary" id="myButtons1"
									style="margin-right: 120px;">로그인</button>
							</center>
						</div>
					</div>
				</div>
			</div>
		</form>


	</div>
 
      <!-- End Navbar -->
<script type="text/javascript">
        var d = new Date();
        var currentDate = d.getFullYear() + "/ " + ( d.getMonth() + 1 ) + "/ " + d.getDate() ;
        var currentTime = d.getHours() + " : " + d.getMinutes() + "  " ;
        var result = document.getElementById("time-result");
        result.innerHTML =  currentDate + "  " + currentTime + "  " + "seoul";
</script>

<script type="text/javascript">
         $("#myButtons1").click(function(){
           alert('AJAX로 처리하고 정상 응답이면.. hide 해 준다.');
     $('#myModal').modal('hide')
        });
    </script>

       
  <!--   Core JS Files   -->
  <script src="/resources/js/core/jquery.min.js"></script>
  <script src="/resources/js/core/popper.min.js"></script>
  <script src="/resources/js/core/bootstrap.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="/resources/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="/resources/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/resources/js/now-ui-dashboard.min.js?v=1.2.0" type="text/javascript"></script>
  <!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
  <script src="/resources/demo/demo.js"></script>

</body>
</html>