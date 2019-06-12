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
  
  <!-- jQuery -->
  <link href="/WEB-INF/lib/jquery-3.3.1.min.js" rel="stylesheet" />
  
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

 </style>
</head>

<body class="">
  <div class="wrapper ">


		<div class="main-panel">
			<nav class="navbar navbar-light" style="background-color:#B3E5FC;">
			 <span class="navbar-brand" style="margin-left: 135px;">회원가입</span>
			  <a href="intro.do"><i class="fas fa-angle-right" style="color:#FFFFFF;"></i></a> 
			  </nav>
		</div>
		<!-- End Navbar -->
      
    		<div>
              <div class="card-body">
                <form  action="/user/createAccountProc.do" method="post" id="submitForm"> <!-- 자바스크립트의 값들을 받아서 post로 백단에 넘김 -->
                  <div class="row">
                    <div class="col-md-5 pr-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control" name="usr_id" id="usr_id" maxlength="10" placeholder="아이디(10자 이하로 입력해주세요.)"  required/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control" name="usr_password" id="pwd_ck" maxlength="20" placeholder="비밀번호(8자리~20자 사이)" required/>
                      </div>
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control"  name="pwdChk" id="pwdChk_id" maxlength="20" placeholder="비밀번호 확인" required/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control" name="usr_name" id="usr_name" placeholder="이름(한글로 입력해주세요.)" required/>
                      </div>
                    </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control" name="usr_job" id="usr_job" placeholder="직업" required/>
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="md-form mt-0">
                        <input type="number" class="form-control" name="usr_age" id="usr_age" placeholder="나이" required/>
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="md-form mt-0">
                        <input type="text" class="form-control" name="usr_hobby" id="usr_hobby" placeholder="취미" required/>
                      </div>
                    </div>
                  
                  <div class="row">
                  	<div class="col-md-12" style="margin-left:110px;">
                  	<button type="button" onclick="check()" value=회원가입 class="btn btn-deep-orange" style="background-color:#B3E5FC !important"> <p style="color:white; margin-bottom:0px;">회원가입</p></button>
                  	</div>
                  </div>
                </form>
                </div>
              </div>
            </div>

  </body>
    
              
       
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

<script>
 // button에서 받은 함수로 시작!
function check(){ 

	 var usr_password = document.getElementById('pwd_ck');
	 var pwdChk = document.getElementById('pwdChk_id');
	 var name=document.getElementById('usr_name');
	 var usr_age=document.getElementById('usr_age');
	 
	 if(usr_password.value.length<8) {  
		 alert('비밀번호는 8자 이상 20자 이하입니다.'); 
		 pwd.focus(); 
		 return false; 
	 }
	 if(pwdChk.value.length < 8) {
		 alert('비밀번호 확인은 8자 이상 20자 이하입니다.'); 
		 pwdChk.focus();
		 return false;
	 }
	 
	 if(usr_password.value != pwdChk.value){ 
		 alert('비밀번호가 다릅니다..'); 
		 pwdChk.focus();
		 return false;
		 }

	 if(usr_name.value.lengh<2){ 
		 alert('이름은 2자 이상입니다.'); 
		 name.focus(); 
		 return false; 
		 } 
	

	 if(!Number(usr_age.value)){ 
		 alert('생일은 숫자를 입력해야합니다'); 
		 return false; 
		 } 
	 
	 $('#submitForm').submit(); //form으로 보내기~
}

	 
 </script>

</html>