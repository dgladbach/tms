<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>TMS</title>
	
	    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
	    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
		<div class="container">
	        <div class="card card-container">
	            <p>Melde dich als Turnierleiter an.</p>
	            <form class="form-signin" method="post" action="<c:url value='/manage/auth'/>">
	                <input type="text" class="form-control" name="user" placeholder="Benutzername" required autofocus>
	                <input type="password" class="form-control" name="password" placeholder="Passwort" required>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
	            </form>
	            <hr>
	            <p>Oder gib einen Turnier-Code ein um zur Turnierübersicht zu gelangen.</p>
	            <form class="form-signin" method="post" action="<c:url value='/view/auth'/>">
	                <input type="text" class="form-control" name="code" placeholder="Turnier-Code" required>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Zum Turnier</button>
	            </form>
	        </div>
	    </div>
	    <script src="<c:url value='/js/jquery-3.1.1.min.js'/>"></script>
	    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
  	</body>
</html>