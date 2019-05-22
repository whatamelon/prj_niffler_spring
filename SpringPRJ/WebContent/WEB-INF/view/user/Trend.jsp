<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--  ------------------------------헤드 시작-------------------------------- -->

<head>
<meta charset="utf-8" />

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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Prism CDN -->
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/themes/prism.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/themes/prism-coy.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/line-numbers/prism-line-numbers.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/prism.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/autoloader/prism-autoloader.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/plugins/line-numbers/prism-line-numbers.min.js"></script>
<script> Prism.plugins.autoloader.languages_path = "https://cdnjs.cloudflare.com/ajax/libs/prism/1.13.0/components/"; Prism.plugins.autoloader.use_minified = true; </script>

<!-- D3 chart -->
<script src="https://d3js.org/d3.v4.min.js"></script>

<style>

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

</style>

<script> 
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
								
										if ($("#serviceAPIDatalabSearchTable > tbody > tr").length < 5) { 
											
											$(this).closest("tr").after($(this).closest("tr").clone().wrapAll("<div/>").parent().html()); } });
							
							$(document).on("click", ".serviceAPIDatalabSearchMinus", function (eventObject) {
								
								if ($(this).parents().find("#serviceAPIDatalabSearchTable > tbody > tr").length == 1) {
									
									$("#serviceAPIDatalabSearchTable > tbody > tr input").val(""); } else { $(this).closest("tr").remove(); } });
							
							$.serviceAPIDatalabSearch = function () { $("#serviceAPIDatalabSearchTable > tbody > tr").each(function (index, element) {
								
								$(this).find("input[name$='][groupName]']").each(function (index2, element2) {
									
									if ("" == $.trim($(this).val())) { $(this).val("주제어" + (index + 1)); } });
								
								$(this).find("input[name^='keywordGroups[']").each(function (index2, element2) 
										
									{
									var inputName = $(this).attr("name");
										
								$(this).attr("name", "keywordGroups[" + index + inputName.substring(inputName.indexOf("]")));
										if ("" == $.trim($(this).val())) { $(this).prop("disabled", true); } });
								
								if ("" == $.trim($(this).find("input[name='keywordGroups[" + index + "][keywords][]']:first").val())) {
									$(this).find("input[name='keywordGroups[" + index + "][keywords][]']:first").val("검색어" + (index + 1)).prop("disabled", false);
									} });
							
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
								data: JSON.stringify($("#serviceAPIDatalabSearchForm").serializeObject()),
								beforeSend: function (jqXHR, settings) {
									jqXHR.setRequestHeader("x-requested-with", "*");
									},
								success: function (data, textStatus, jqXHR) {
									if (data != null) {
										var serviceAPIDatalabSearchResponseCode = JSON.stringify(data, null, "\t");
										
										var serviceAPIDatalabSearchResponsePrismCode = "";
										
									serviceAPIDatalabSearchResponsePrismCode += "<pre class=\"line-numbers\"><code class=\"language-json\">";
									serviceAPIDatalabSearchResponsePrismCode += serviceAPIDatalabSearchResponseCode.replace(/[&]/g, "&amp;").replace(/[<]/g, "&lt;").replace(/[>]/g, "&gt;");
									serviceAPIDatalabSearchResponsePrismCode += "</code></pre>";
									
									$("#serviceAPIDatalabSearchResponseCode").val(serviceAPIDatalabSearchResponseCode);
									
									$("#serviceAPIDatalabSearchResponsePrismCode").html(serviceAPIDatalabSearchResponsePrismCode);
									
									Prism.highlightAll(); 

										var width = 500;
										var height = 300;
										var margin = 50;
										var duration = 250;

										var lineOpacity = "0.25";
										var lineOpacityHover = "0.85";
										var otherLinesOpacityHover = "0.1";
										var lineStroke = "1.5px";
										var lineStrokeHover = "2.5px";

										var circleOpacity = '0.85';
										var circleOpacityOnLineHover = "0.25"
										var circleRadius = 3;
										var circleRadiusHover = 6;


										/* Format Data */
										var parseDate = d3.timeParse("%Y");
										data.forEach(function(d) { 
										  d.results[0].data[0].forEach(function(d) {
										    d.results[0].data[0].period = parseDate(d.results[0].data[0].period);
										    d.ratio = +d.ratio;    
										  });
										});


										/* Scale */
										var xScale = d3.scaleTime()
										  .domain(d3.extent(data.results[0].data[0], d => d.period))
										  .range([0, width-margin]);

										var yScale = d3.scaleLinear()
										  .domain([0, d3.max(data.results[0].data[0], d => d.ratio)])
										  .range([height-margin, 0]);

										var color = d3.scaleOrdinal(d3.schemeCategory10);

										/* Add SVG */
										var svg = d3.select("#chart").append("svg")
										  .attr("width", (width+margin)+"px")
										  .attr("height", (height+margin)+"px")
										  .append('g')
										  .attr("transform", `translate(${margin}, ${margin})`);


										/* Add line into SVG */
										var line = d3.line()
										  .x(d => xScale(d.results[0].data[0].period))
										  .y(d => yScale(d.results[0].data[0].ratio));

										let lines = svg.append('g')
										  .attr('class', 'lines');

										lines.selectAll('.line-group')
										  .data(data).enter()
										  .append('g')
										  .attr('class', 'line-group')  
										  .on("mouseover", function(d, i) {
										      svg.append("text")
										        .attr("class", "title-text")
										        .style("fill", color(i))        
										        .text(d.results.title)
										        .attr("text-anchor", "middle")
										        .attr("x", (width-margin)/2)
										        .attr("y", 5);
										    })
										  .on("mouseout", function(d) {
										      svg.select(".title-text").remove();
										    })
										  .append('path')
										  .attr('class', 'line')  
										  .attr('d', d => line(d.results[0].data[0]))
										  .style('stroke', (d, i) => color(i))
										  .style('opacity', lineOpacity)
										  .on("mouseover", function(d) {
										      d3.selectAll('.line')
															.style('opacity', otherLinesOpacityHover);
										      d3.selectAll('.circle')
															.style('opacity', circleOpacityOnLineHover);
										      d3.select(this)
										        .style('opacity', lineOpacityHover)
										        .style("stroke-width", lineStrokeHover)
										        .style("cursor", "pointer");
										    })
										  .on("mouseout", function(d) {
										      d3.selectAll(".line")
															.style('opacity', lineOpacity);
										      d3.selectAll('.circle')
															.style('opacity', circleOpacity);
										      d3.select(this)
										        .style("stroke-width", lineStroke)
										        .style("cursor", "none");
										    });


										/* Add circles in the line */
										lines.selectAll("circle-group")
										  .data(data).enter()
										  .append("g")
										  .style("fill", (d, i) => color(i))
										  .selectAll("circle")
										  .data(d => d.results[0].data[0]).enter()
										  .append("g")
										  .attr("class", "circle")  
										  .on("mouseover", function(d) {
										      d3.select(this)     
										        .style("cursor", "pointer")
										        .append("text")
										        .attr("class", "text")
										        .text(`${d.ratio}`)
										        .attr("x", d => xScale(d.results[0].data[0].period) + 5)
										        .attr("y", d => yScale(d.results[0].data[0].ratio) - 10);
										    })
										  .on("mouseout", function(d) {
										      d3.select(this)
										        .style("cursor", "none")  
										        .transition()
										        .duration(duration)
										        .selectAll(".text").remove();
										    })
										  .append("circle")
										  .attr("cx", d => xScale(d.results[0].data[0].period))
										  .attr("cy", d => yScale(d.results[0].data[0].ratio))
										  .attr("r", circleRadius)
										  .style('opacity', circleOpacity)
										  .on("mouseover", function(d) {
										        d3.select(this)
										          .transition()
										          .duration(duration)
										          .attr("r", circleRadiusHover);
										      })
										    .on("mouseout", function(d) {
										        d3.select(this) 
										          .transition()
										          .duration(duration)
										          .attr("r", circleRadius);  
										      });


										/* Add Axis into SVG */
										var xAxis = d3.axisBottom(xScale).ticks(5);
										var yAxis = d3.axisLeft(yScale).ticks(5);

										svg.append("g")
										  .attr("class", "x axis")
										  .attr("transform", `translate(0, ${height-margin})`)
										  .call(xAxis);

										svg.append("g")
										  .attr("class", "y axis")
										  .call(yAxis)
										  .append('text')
										  .attr("y", 15)
										  .attr("transform", "rotate(-90)")
										  .attr("fill", "#000")
										  .text("Total values");
									
									
									
									}
									},
									
									error: function (jqXHR, textStatus, errorThrown)
									{
										var errorResponseCode = ""; errorResponseCode += "readyState : "; errorResponseCode += jqXHR.readyState;
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
<body style="padding: 50px 50px 50px 50px;">
	<h1>1. 요청 설정</h1>
	<form name="serviceAPIDatalabSearchForm"
		id="serviceAPIDatalabSearchForm" method="post" action=""
		onsubmit="return false;">
		<h2>조회 시작 일자 선택</h2>
		<p>
			<input class="form-control" type="text"
				id="serviceAPIDatalabSearchStartDate" name="startDate"
				placeholder="조회 시작 기간 선택" value="" readonly="readonly" />
		</p>
		<p>&nbsp;</p>
		<h2>조회 종료 일자 선택</h2>
		<p>
			<input class="form-control" type="text"
				id="serviceAPIDatalabSearchEndDate" name="endDate"
				placeholder="조회 종료 기간 선택" value="" readonly="readonly" />
		</p>
		<p>&nbsp;</p>
		<h2>구간 단위 선택</h2>
		<p>
			<select class="form-control" id="timeUnit" name="timeUnit">
				<option value="date">일간</option>
				<option value="week">주간</option>
				<option value="month">월간</option>
			</select>
		</p>
		<h2>검색어 입력</h2>
		<table class="table table-bordered" id="serviceAPIDatalabSearchTable">
			<thead>
				<tr>
					<th style="text-align: center;">주제어</th>
					<th style="text-align: center;">검색어</th>
					<th style="text-align: center; width: 140px;">추가/삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input class="form-control" type="text"
						name="keywordGroups[][groupName]" placeholder="주제어 입력" value="" />
					</td>
					<td><input class="form-control"
						style="margin: 0px 0px 10px 0px;" type="text"
						name="keywordGroups[][keywords][]" placeholder="검색어1 입력" value="" />
						<input class="form-control" style="margin: 0px 0px 10px 0px;"
						type="text" name="keywordGroups[][keywords][]"
						placeholder="검색어2 입력" value="" />
					</td>
					<td style="text-align: center;">
						<button class="btn btn-primary serviceAPIDatalabSearchPlus"
							type="button">추가</button>&nbsp;
						<button class="btn btn-primary serviceAPIDatalabSearchMinus"
							type="button">삭제</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<p>&nbsp;</p>
	<p>
		<button class="btn btn-primary" type="button"
			onclick="$.serviceAPIDatalabSearch();">통합 검색어 트렌드</button>
	</p>
	<P>&nbsp;</P>
	<p>&nbsp;</p>
	<h1>2. 응답 결과</h1>
	<p>
		<textarea class="form-control" style="width: 100%" rows="10"
			id="serviceAPIDatalabSearchResponseCode"
			name="serviceAPIDatalabSearchResponseCode"></textarea>
	</p>
	<p>&nbsp;</p>
	<div id="serviceAPIDatalabSearchResponsePrismCode"></div>
	<p>&nbsp;</p>
	<div id="chart"></div>
</body>

</html>