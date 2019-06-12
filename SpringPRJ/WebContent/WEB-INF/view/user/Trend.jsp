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
  
  
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  
  
  <!--     Fonts and icons     -->
  
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  
  <!-- CSS Files -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link href="/resources/css/vendorprefixes.css" rel="stylesheet" />
  
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="/resources/demo/demo.css" rel="stylesheet" />
  

  <script src="/resources/js/jquery-3.4.0.min.js"></script>
  <script src="/resources/js/core/popper.min.js"></script>
  <script src="/resources/js/core/bootstrap.min.js"></script>
  

    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="/resources/css/style3.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">


<!-- jQuery CDN -->
<link rel="stylesheet"	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.70/jquery.blockUI.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js"></script>
<script> $(function () { $.ajaxPrefilter(function (options, originalOptions, jqXHR) 
		{
			if (options.crossDomain && jQuery.support.cors) 
			{ options.url = "https://cors-anywhere.herokuapp.com/" + options.url; } }); 
			$(document).ajaxStart(function() 
					{ $.blockUI({ message: "<h1 style=\"color: #1ab394;\">LOADING</h1>",
					css: { backgroundColor: "rgba(0, 0, 0, 0.0)", color: "#000000", border: "0px solid #000000", width: "150px",
						top: ($(window).height() - 150) / 2 + "px", left: ($(window).width() - 150) / 2 + "px" } }); }); 
			$(document).ajaxStop(function() { $.unblockUI(); }); });
</script>

<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Prism CDN -->
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/themes/prism.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/themes/prism-coy.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/line-numbers/prism-line-numbers.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/prism.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/autoloader/prism-autoloader.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/line-numbers/prism-line-numbers.min.js"></script>
<script> Prism.plugins.autoloader.languages_path = "https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/components/"; Prism.plugins.autoloader.use_minified = true; </script>


<!--  <script src="https://d3js.org/d3.v5.min.js"></script>  -->

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
	
	a:hover {
		text-decoration : none;
	}
	
svg {
    font-family: Sans-Serif, Arial;
}
.line {
  stroke-width: 2;
  fill: none;
}

.axis path {
  stroke: black;
}

.text {
  font-size: 12px;
}

.title-text {
  font-size: 12px;
}
.btn-primary{
border-color : #D1C4E9 !important;
background-color:#D1C4E9 !important;
}
.btn.btn-primary{
	box-shadow : 0 3px #4527A0 !important;
	cursor : pointer;
	}
	.btn.btn-primary:hover{
	background-color:#536DFE;
	}
	.btn.btn-primary:active{
	box-shadow : 0 1px #999 !important;
	transform: translateY(2px) !important;
	background-color:#536DFE;
	}

</style>

<script> 
//  객체로들어가는 전역변수
	var globaltmp;
	var x;
	var x1;
	var x2;
	
	// 각 data.results.data 의 object로 들어가는 전역변수
	var object1;
	var object2;
	var object3;
	var object4;
	var object5;
	var object6;
	var object7;
	var object8;
	var object9;
	var object10;
	var object11;
	var object12;
	var object13;
	var object14;
	
	// title꺼내는 전역변수
	var subject1;
	var subject2;
	
	// 날짜꺼내는 전역변수
	var date1;
	var date2;
	var date3;
	var date4;
	var date5;
	var date6;
	var date7;
	
	// 비율 꺼내는 전역변수
	var ratio1;
	var ratio2;
	var ratio3;
	var ratio4;
	var ratio5;
	var ratio6;
	var ratio7;
	var ratio8;
	var ratio9;
	var ratio10;
	var ratio11;
	var ratio12;
	var ratio13;
	var ratio14;
	
	
	$(function () {
		var XNaverClientId = "v05bZlQfeJ5_HKwzHAh8";
		var XNaverClientSecret = "ZYa6od5gqF";
		
		$("#serviceAPIDatalabSearchStartDate, #serviceAPIDatalabSearchEndDate").datepicker({ dateFormat: "yy-mm-dd",
			maxDate: new Date(), showButtonPanel: true });
		$("#serviceAPIDatalabSearchStartDate, #serviceAPIDatalabSearchEndDate").datepicker("setDate", new Date());
		$("#serviceAPIDatalabSearchStartDate").on("change", 
				function () { 
				$("#serviceAPIDatalabSearchEndDate").datepicker("option", "minDate", 
						$.datepicker.parseDate("yy-mm-dd", $(this).val())); });
				$("#serviceAPIDatalabSearchEndDate").on("change", 
						function () { 
							$("#serviceAPIDatalabSearchStartDate").datepicker("option", "maxDate", $.datepicker.parseDate("yy-mm-dd", $(this).val()));
							}); 
							$.serviceAPIDatalabSearchAllAgesCheck =function () { $("input[name='ages[]']").prop("checked", false); };
							
							$.serviceAPIDatalabSearchAgesCheck = function () { $("#allAges").prop("checked", false); };
							
							$(document).on("click", ".serviceAPIDatalabSearchPlus",
									
									function (eventObject) { 
								
										if ($("#serviceAPIDatalabSearchDiv > #line").length < 2) { 
											
											$(this).closest("#line").after($(this).closest("#line").clone().wrapAll("<div/>").parent().html()); } });
							
							$(document).on("click", ".serviceAPIDatalabSearchMinus", function (eventObject) {
								
								if ($(this).parents().find("#serviceAPIDatalabSearchDiv > #line").length == 1) {
									
									$("#serviceAPIDatalabSearchDiv > #line input").val(""); } else { $(this).closest("#line").remove(); } }); 
							
							$.serviceAPIDatalabSearch = function () {
										$("#serviceAPIDatalabSearchDiv > #line").each(function (index, element) {
								
								$(this).find("input[name$='][groupName]']").each(function (index2, element2) {
									
									if ("" == $.trim($(this).val())) { $(this).val("주제어" + (index + 1)); }
									}
								);
								
								$(this).find("input[name^='keywordGroups[']").each(function (index2, element2) 
									{
									var inputName = $(this).attr("name");
										
								$(this).attr("name", "keywordGroups[" + index + inputName.substring(inputName.indexOf("]")));
										if ("" == $.trim($(this).val())) { $(this).prop("disabled", true); } 
										}
								);
								
								if ("" == $.trim($(this).find("input[name='keywordGroups[" + index + "][keywords][]']:first").val())) {
									$(this).find("input[name='keywordGroups[" + index + "][keywords][]']:first").val("검색어" + (index + 1)).prop("disabled", false);
									} 
								}
										);
							
							$.ajax({ crossDomain: true, context: this, traditional: true,
								url: "https://openapi.naver.com/v1/datalab/search", 
								method: "POST",
								type: "POST", 
								dataType: "json",
								contentType: "application/json; charset=UTF-8",
								async: true, 
								cache: true,
								timeout : 0,
								headers: { 
									"X-Naver-Client-Id": XNaverClientId, 
									"X-Naver-Client-Secret": XNaverClientSecret 
									},
								data:  JSON.stringify($("#serviceAPIDatalabSearchForm").serializeObject()) ,
								beforeSend: function (jqXHR, settings) {
									jqXHR.setRequestHeader("x-requested-with", "*");
									},
								success: function (data) {
									
									// 전역 변수 설정
									globaltmp =  data;
									x = data.results;
									x1 = data.results[0];
									x2 = data.results[1];
									
									object1 = data.results[0].data[0];
									object2 = data.results[0].data[1];
									object3 = data.results[0].data[2];
									object4 = data.results[0].data[3];
									object5 = data.results[0].data[4];
									object6 = data.results[0].data[5];
									object7 = data.results[0].data[6];
									object8 = data.results[1].data[0];
									object9 = data.results[1].data[1];
									object10 = data.results[1].data[2];
									object11 = data.results[1].data[3];
									object12 = data.results[1].data[4];
									object13 = data.results[1].data[5];
									object14 = data.results[1].data[6];
									
									// 코드 미리보여주기
									if (data != null) {
										var serviceAPIDatalabSearchResponseCode = JSON.stringify(data, null, "\t");
									
									$("#serviceAPIDatalabSearchResponseCode").val(serviceAPIDatalabSearchResponseCode);
									
									// 여기부터 data parsing 시작
								
									//  data 꺼내기 시작 
								
									// 노가다 시작한다 꽉잡아!
									
									//title
									subject1 = x1[Object.keys(x1)[0]];
									subject2 = x2[Object.keys(x2)[0]];
									
									// date
									date1 = object1[Object.keys(object1)[0]]; 
									date2 = object2[Object.keys(object2)[0]]; 
									date3 = object3[Object.keys(object3)[0]]; 
									date4 = object4[Object.keys(object4)[0]]; 
									date5 = object5[Object.keys(object5)[0]]; 
									date6 = object6[Object.keys(object6)[0]]; 
									date7 = object7[Object.keys(object7)[0]]; 

									//ratio
									ratio1 = object1[Object.keys(object1)[1]]; 
									ratio2 = object2[Object.keys(object2)[1]]; 
									ratio3 = object3[Object.keys(object3)[1]]; 
									ratio4 = object4[Object.keys(object4)[1]]; 
									ratio5 = object5[Object.keys(object5)[1]]; 
									ratio6 = object6[Object.keys(object6)[1]]; 
									ratio7 = object7[Object.keys(object7)[1]]; 
									ratio8 = object8[Object.keys(object8)[1]]; 
									ratio9 = object9[Object.keys(object9)[1]]; 
									ratio10 = object10[Object.keys(object10)[1]]; 
									ratio11 = object11[Object.keys(object11)[1]]; 
									ratio12 = object12[Object.keys(object12)[1]]; 
									ratio13 = object13[Object.keys(object13)[1]]; 
									ratio14 = object14[Object.keys(object14)[1]]; 
									
									
									
									// console
									
									console.log(subject1);
									console.log(subject2);
									
									console.log(date1); 
									console.log(date2); 
									console.log(date3); 
									console.log(date4); 
									console.log(date5); 
									console.log(date6); 
									console.log(date7); 
									
									console.log(ratio1); 
									console.log(ratio2); 
									console.log(ratio3); 
									console.log(ratio4); 
									console.log(ratio5); 
									console.log(ratio6); 
									console.log(ratio7); 
									console.log(ratio8); 
									console.log(ratio9); 
									console.log(ratio10); 
									console.log(ratio11); 
									console.log(ratio12); 
									console.log(ratio13); 
									console.log(ratio14); 
									 
									// data 꺼내기 끝 
									
									
									
									// data push 시작 
								
									
									//여기 부터는 그래프 
									
									
									
new Chart(document.getElementById("line-chart"), {
  type: 'line',
  data: {
    labels: [date1,date2,date3,date4,date5,date6,date7],
    datasets: [{ 
        data: [ratio1,ratio2,ratio3,ratio4,ratio5,ratio6,ratio7],
        label: subject1,
        borderColor: "#3e95cd",
        fill: false
      }, { 
        data: [ratio8,ratio9,ratio10,ratio11,ratio12,ratio13,ratio14],
        label: subject2,
        borderColor: "#8e5ea2",
        fill: false
      }
    ]
  }
});
									}
									},
									
									error: function (jqXHR, textStatus, errorThrown)
									{
										var errorResponseCode = ""; errorResponseCode += "readyState : ";
										errorResponseCode += jqXHR.readyState;
									if ("0" == jqXHR.readyState) { errorResponseCode += "-UNSENT"; }
									if ("1" == jqXHR.readyState) { errorResponseCode += "-OPENED"; }
									if ("2" == jqXHR.readyState) { errorResponseCode += "-HEADERS_RECEIVED"; }
									if ("3" == jqXHR.readyState) { errorResponseCode += "-LOADING"; }
									if ("4" == jqXHR.readyState) { errorResponseCode += "-DONE"; }
									errorResponseCode += "\n";
									errorResponseCode += "status : ";
									errorResponseCode += jqXHR.status;
									errorResponseCode += "\n";
									errorResponseCode += "statusText : ";
									errorResponseCode += jqXHR.statusText;
									errorResponseCode += "\n";
									errorResponseCode += "textStatus : ";
									errorResponseCode += textStatus;
									errorResponseCode += "\n";
									errorResponseCode += "errorThrown : ";
									errorResponseCode += errorThrown;
									errorResponseCode += "\n";
									errorResponseCode += "responseText : ";
									errorResponseCode += (jqXHR.responseText == null ? "" : jqXHR.responseText.replace(/\r/g, "").replace(/\n/g, ""));
									alert(errorResponseCode);
									},
									complete: function (jqXHR, textStatus) { 
										$("input[name^='keywordGroups[']").each(function (index, element) { 
											if ("" == $.trim($(this).val())) { $(this).prop("disabled", false); } }); } }); }; });
</script>


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
	
	<div id="main" style="margin:20px 20px 20px 20px;">
	<form name="serviceAPIDatalabSearchForm"
		id="serviceAPIDatalabSearchForm" method="post" action=""
		onsubmit="return false;">
		<h4>조회시작 날짜</h4>
		<p>
			<input class="form-control" type="text"
				id="serviceAPIDatalabSearchStartDate" name="startDate"
				placeholder="조회 시작 기간 선택" value="" readonly="readonly" />
		</p>
		<h5>조회 종료 일자(시작일로부터 8일) / 조회 종료일로부터 2일전까지 값을 볼 수 있어요!</h5>
		<p>
			<input class="form-control" type="text"
				id="serviceAPIDatalabSearchEndDate" name="endDate"
				placeholder="조회 종료 기간 선택" value="" readonly="readonly" />
		</p>
		<p>
			<select class="form-control" id="timeUnit" name="timeUnit" style="display:none;">
				<option value="date">일간</option>
				<option value="week">주간</option>
				<option value="month">월간</option>
			</select>
		</p>
		<h4>검색어(2개를 선택해주세요!)</h4>
		
		<div id="serviceAPIDatalabSearchDiv">
		
		<div style="display:flex;" id="line">
		
		<input class="form-control" type="text"style="margin: 3px 0px 0px 0px;"
						name="keywordGroups[][groupName]" placeholder="주제어 입력" value="" />
		
		<input class="form-control"
						style="margin: 3px 0px 0px 0px;" type="text"
						name="keywordGroups[][keywords][]" placeholder="주제어 동일" value="" />
		
		<button class="btn btn-primary serviceAPIDatalabSearchPlus"
							type="button" style="background-color: transparent !important;
		border: 1px solid;color: #000000;">추가</button>
		
		<button class="btn btn-primary serviceAPIDatalabSearchMinus"
							type="button" style="background-color: transparent !important;
		border: 1px solid;color: #000000;">삭제</button>
		
		</div>
		
		</div>
		
		<!-- <table class="table table-bordered" id="serviceAPIDatalabSearchTable">
		
				<tr>
					<td><input class="form-control" type="text"style="margin: 3px 0px 0px 0px;"
						name="keywordGroups[][groupName]" placeholder="주제어 입력" value="" />
					</td>
					<td><input class="form-control"
						style="margin: 3px 0px 0px 0px;" type="text"
						name="keywordGroups[][keywords][]" placeholder="주제어와 동일" value="" />
					</td>
					<td style="text-align: center; display:flex; padding-top:3px;">
						<button class="btn btn-primary serviceAPIDatalabSearchPlus"
							type="button">추가</button>&nbsp;
						<button class="btn btn-primary serviceAPIDatalabSearchMinus"
							type="button">삭제</button>
					</td>
				</tr>
		</table> -->
	</form>
	<p>
		<button class="btn btn-primary" type="button" style="width:100%; border-radius:30px; background-color: transparent !important; margin-top:10px;
		border: 1px solid;color: #000000;"
			onclick="$.serviceAPIDatalabSearch();">검색</button>
	</p>
	<canvas id="line-chart" style="width:300px; height:300px;"></canvas>
	</div>
	    <div class="overlay"></div>
</div>
</div>

   <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/resources/js/d3.v3.min.js"></script> 
  <script type="text/javascript"> // 사이드바 스크립트
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


    </body>
      
</html>