<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html ng-app="all_architectors">
    <head>
    <!---METADATA--->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale = 1.0">
	<meta name="description" content="Great resource which will help you to find your best sport team to play with" />
	<title>Teaspo.com</title> 
    
    <!---FONTS--->
	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display|Roboto+Condensed|Ubuntu+Condensed" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC" rel="stylesheet">
    
    <!---CSS--->
    <link rel="stylesheet" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <!--JAVASCRIPT-->
    <script type="text/javascript" src="../../resources/js/jquery.1.10.2.min.js"></script>
	<script type="text/javascript" src="../../resources/js/admin/admin.js"></script>
    
    <!--BOOTSTRAP-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <!--LESS-->
    <link rel="stylesheet/less" type="text/css" href="../../resources/css/admin.less" />
    <!-- LESS JavaScript компілятор -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.5.3/less.min.js"></script>
    
    <!--ICONS-->

</head>
<body>
    <nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="row">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/index.html">Terranova</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Architectors <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="" onclick="showArchitectors()">Show all</a></li>
                            <li><a href="web/admin/createarchitector">Add new</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Clients <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="" onclick="showOrderers()">Show all</a></li>
                            <li><a href="web/admin/createorderer">Add new</a></li>
                        </ul>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:if test="${pageContext.request.userPrincipal.name != null}">
                            ${pageContext.request.userPrincipal.name}
                        </c:if><span class="caret"></span></a></li>
                            <li><a href="javascript:formSubmit()"> Logout</a></li>

                </ul>
            </div>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<c:url value="/j_spring_security_logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='core' uri='http://java.sun.com/jsp/jstl/core' %>

<div id="allArchitectors" style="display:none">
<div class="container">
<h2 class="usersTable" style="font-family:'Poiret One'">ARCHITECTORS TABLE</h2>
        <table class="table" ng-controller="all_architectors_control">
            <thead>
            <tr class="tableHeader"  style="font-family:'Poiret One'">
                <th>ID</th>
                <th>LOGIN</th>
                <th>PIB</th>
                <th>EMAIL</th>
                <th>HOURS</th>
                <th>WORK EXPERIENCE</th>
                <th>EDIT</th>
            </tr>
            </thead>
            <tbody>

            <tr ng-repeat="architector in architectors">

                <td>{{architector.id_architector}}</td>
                <td>{{architector.login}}</td>
                <td>{{architector.pib}}</td>
                <td>{{architector.email}}</td>
                <td>{{architector.hours}}</td>
                <td>{{architector.work_experience}}</td>
                <td><a href="/web/admin/{{architector.id_architector}}/edit" style="text-decoration: none; color:white;
" class="glyphicon glyphicon-pencil"></a></td>            </tr>
            </tbody>
        </table>
    </div>
    </div>
    <div id="allOrderers" style="display:none">
        <div class="container">
            <h2 class="usersTable" style="font-family:'Poiret One'">ORDERERS TABLE</h2>
            <table class="table" ng-controller="all_orderers_control">
                <thead>
                <tr class="tableHeader"  style="font-family:'Poiret One'">
                    <th>ID</th>
                    <th>DEPARTMENT</th>
                    <th>NICKNAME</th>
                    <th>COMPANY NAME</th>
                    <th>PIB</th>
                    <th>PHONE NUMBER</th>
                    <th>EMAIL</th>
                    <th>EDIT</th>
                </tr>
                </thead>
                <tbody>

                <tr ng-repeat="orderer in orderers">
                    <td>{{orderer.id_orderer}}</td>
                    <td>{{orderer.departmentadress}}</td>
                    <td>{{orderer.login}}</td>
                    <td>{{orderer.company_name}}</td>
                    <td>{{orderer.pib}}</td>
                    <td>{{orderer.phone_number}}</td>
                    <td>{{orderer.email}}</td>
                    <td><a href="/web/admin/{{orderer.id_orderer}}/editorderer" style="text-decoration: none; color:white;
" class="glyphicon glyphicon-pencil"></a></td>            </tr>
                </tbody>
            </table>
        </div>
    </div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="/resources/js/admin/all_architectors.js"></script>
</body>
</html>