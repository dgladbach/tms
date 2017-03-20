<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/font-awesome.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/select2.min.css'/>" rel="stylesheet">

    <style type="text/css">
        body {
            padding-top: 50px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="<c:url value='/js/select2.min.js'/>" type="text/javascript"></script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">TMS</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Turniere</a></li>
                <li><a href="#about">Teams</a></li>
                <li><a href="#logout">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h2>Turniere</h2>
        <div class="input-group">
            <label for="turnier">Bitte wählen Sie ein Turnier</label>
            <br>
            <select class="form-control" id="turnier">
                <c:forEach items="${view.getTournaments() }" var="tournament">
                	<option value="${tournament.uuid }"><c:out value="${tournament.name }">Kein Name</c:out></option>
                </c:forEach>
            </select>
            &nbsp;<button class="btn btn-sm btn-primary">Auswählen</button>
            &nbsp;<button class="btn btn-sm btn-success"><i class="fa fa-plus"></i> Turnier anlegen</button>
        </div>
        <script type="text/javascript">
            $("#turnier").select2({
                minimumResultsForSearch: 1
            });
        </script>
    </div>

</div><!-- /.container -->


</body>
</html>