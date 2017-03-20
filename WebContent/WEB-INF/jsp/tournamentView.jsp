<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TMS</title>

    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<title>Turnieransicht</title>
</head>
<body>
	<h2>Turnierübersicht</h2>
	<table class="table table-striped">
		<tr>
			<th>Platz</th>
			<th>Name</th>
			<th>Gewonnen Matches</th>
			<th>Verlorene Matches</th>
			<th>Punkte</th>
		</tr>
		<c:forEach items="${teams}" var="entry">
			<tr>
				<td><c:out value="${entry.getPosition()}"></c:out></td>
	    		<td><c:out value="${entry.getName()}"></c:out></td>
	    		<td><c:out value="${entry.getMatchesWon()}"></c:out></td>
	    		<td><c:out value="${entry.getMatchesLost()}"></c:out></td>
	    		<td><c:out value="${entry.getScore()}"></c:out></td>
	    	</tr>
		</c:forEach>
	</table>
	<script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
	   <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</body>
</html>