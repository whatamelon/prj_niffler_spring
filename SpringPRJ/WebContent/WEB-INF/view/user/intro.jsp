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

<body style="background:linear-gradient( #BBDEFB, #FFF9C4);">

  <div class="wrapper " style="height:640px;">
  
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
  				<a href="#modal fade" data-toggle="modal" data-target="#myModal" style="
    border: 1px solid;
    border-radius: 30px;
    padding: 5px 15px 7px 15px;
">Login</a>
  			</li>
  			<li>
  				<a href="faq.do"style="
    border: 1px solid;
    border-radius: 30px;
    padding: 5px 15px 7px 15px;
">FAQ</a>
  			</li>
  			<li>
  				<a href="createaccount.do"style="
    border: 1px solid;
    border-radius: 30px;
    padding: 5px 15px 7px 15px;
">Join</a>
  			</li>
  			
  		</ul>
  		
 <!--  		<a href="#" style="border:1px solid white; background-color:black; padding : 5px; margin-top:100px;">
  			what is it?
  		</a> -->
  		</center>
  	</div>
		<form action="/user/loginProc.do" method="post" id="submitForm">
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
									<input type="text" name="usr_id" class="form-control" placeholder="ID">
								</div>
							</div>

							<div class="col">
								<div class="md-form mt-0">
									<input type="text" name="usr_password" class="form-control" placeholder="Password">
								</div>
							</div>

						</div>
						<div class="modal-footer" style="border-top: 0px solid;">
							<center>
								<button type="submit" class="btn btn-primary" id="myButtons1"
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
    
<script type="text/javascript">
function check(){ 
	 var usr_id = document.getElementById('usr_id');
	 var usr_password = document.getElementById('usr_password');
	 
	 $('#submitForm').submit();
  
}
  
  </script>

        <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    
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

</body>
</html>
