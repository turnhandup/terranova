<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="orderer_create">
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
    <script type="text/javascript" src="/resources/js/jquery.1.10.2.min.js"></script>
	<script type="text/javascript" src=""></script>
    
    <!--BOOTSTRAP-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <!--LESS-->
    <link rel="stylesheet/less" type="text/css" href="../../resources/css/register.less" />
    <!-- LESS JavaScript компілятор -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.5.3/less.min.js"></script>
    
    <!--ICONS-->

</head>
<body>
<script>
    var HEADERS = {
        <%--//'${_csrf.headerName}': '${_csrf.token}',--%>
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    };
</script>
<a href="/index.jsp" style="font-family: 'Poiret One'; text-decoration: none; color:white; font-size:20px;">GO BACK</a>
<div class="registerblock center col-sm-10 col-md-7">
    <p>REGISTRATION</p>
    <div ng-controller="orderer_create_controller">
        <form class="form-horizontal" ng-submit="ordererCreate()" >
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Nickname</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" required type="text"  ng-model="login" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Password</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" required type="password"  ng-model="password" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Fullname</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" required type="text" ng-model="pib" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Email</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" type="text" ng-model="email" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Phone number</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" type="text" ng-model="phone_number" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Company name</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" required type="text"  ng-model="company_name"class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Passport data</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" type="text"  ng-model="passport_data" class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Address</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput"  ng-model="address" type="text"class="form-control input-md">
                </div>
            </div>
            <div class="form-group">
                <label class=" col-xs-12 col-sm-4 control-label" for="textinput">Department id</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input id="textinput" name="textinput" required ng-model="id_department" type="text"class="form-control input-md">
                </div>
            </div>
            <div class="buttons">
                <button onclick="window.location.href='/login'" type="submit" >SUBMIT</button>
            </div>
        </form>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="../../resources/js/utils/parse_url.js"></script>
<script src="../../resources/js/admin/register.js"></script>
</body>
</html>