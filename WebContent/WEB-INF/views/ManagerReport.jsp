<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
        <%@include file="/WEB-INF/views/css/style.css"%>
    </style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Manager Report</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
 	<h1> Manager Report </h1>
 	
 	<c:if test="${!empty NoPermission}">
 		${NoPermission}
 	</c:if>
 	
 	<c:if test="${empty NoPermission}">
 	<c:if test="${!empty customerRevenue}">
 	<h3>The customers who generated the most revenue are</h3>
 	<table class="tableStyle">
 		<tr> 
 			<th>Person</th>
 			<th>Revenue</th>
 		</tr>
 		
 		<c:forEach items="${customerRevenue}" var="report">
 		<tr>
			<td>${report[0]}</td>
			
			<td>${report[1]}</td>
		</tr>
		</c:forEach>
 		
 	</table>
 	
 	<h3>The customer representatives who generated the most revenue are</h3>
 	
 	<table class="tableStyle">
 		<tr> 
 			<th>Representative</th>
 			<th>Revenue</th>
 		</tr>
 		
 		<c:forEach items="${repRevenue}" var="report">
 		<tr>
			<td>${report[0]}</td>
			
			<td>${report[1]}</td>
		</tr>
		</c:forEach>
 		
 	</table>
 	
 	<h3>The most active flights are</h3>
 	
 	<table class="tableStyle">
 		<tr> 
 			<th>Airline Id</th>
 			<th>Flight No</th>
 			<th>Frequency</th>
 		</tr>
 		
 		<c:forEach items="${mostActiveFlight}" var="flight">
 		<tr>
			<td>${flight[0]}</td>
			<td>${flight[1]}</td>
			<td>${flight[2]}</td>
		</tr>
		</c:forEach>
 		
 	</table>
 	
 	
 	</c:if>
 	
 	
 	<h3>Sales report for a particular month</h3>
 	<c:if test="${!empty salesReportByMonth}">
 	<table class="tableStyle">
 		<tr>
 			<th> Account Number </th>
 			<th> Booking Fee </th>
 			<th> Date </th>
 		</tr>
 		<c:forEach items="${salesReportByMonth}" var="report">
 			<tr>
 			<td> ${report[0]} </td>
 			<td> ${report[1]} </td>
 			<td> ${report[2]} </td>
 			</tr>
 		</c:forEach>
 	</table>
 	</c:if>
 	
 	<form method="post">
 	
 	<input type="text" name="monthyear" placeholder="mm/yyyy"> 
 	<br>
 	<input type="submit" class="customButton" value="Generate"></div>
 	
 	
 	
 	
 	<h3> Summary listing by</h3>
	
	<c:if test="${!empty summaryListing}">
 	<table class="tableStyle">
 		<tr>
 			<th> Reservation Number </th>
 			<th> Booking Fee </th>
 			<th> Date </th>
 		</tr>
 		<c:forEach items="${summaryListing}" var="report">
 			<tr>
 			<td> ${report[0]} </td>
 			<td> ${report[1]} </td>
 			<td> ${report[2]} </td>
 			</tr>
 		</c:forEach>
 	</table>
 	</c:if>
 	
 	<table>
 		<tr>
 			<td> AirlineId + FlightNo</td>
 			<td> <input type="text" name="airlineflight" placeholder="AirlineID-FlightNo"> </td>
 		</tr>
 		
 		<tr> 
 			<td align="center" colspan=2> or </td>
 		</tr>
 		<tr>
 			<td> Destination City </td>
 			<td> <input type="text" name="destinationCity" placeholder="City"> </td>
 		</tr>
 		
 		<tr> 
 			<td align="center" colspan=2> or </td>
 		</tr>
 		
 		<tr>
 			<td> Customer </td>
 			<td> <input type="text" name="customer" placeholder="Account Number"> </td>
 		</tr>
 	</table>
 	
 	<input type="submit" class="customButton" value="Generate"></div>
 	</form>
 	</c:if>
</body>
</html>