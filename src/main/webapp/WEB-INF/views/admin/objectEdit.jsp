<%--
  Created by IntelliJ IDEA.
  User: PANNA
  Date: 12.04.2017
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    <!--JAVASCRIPT-->
    <script type="text/javascript" src="../../../resources/js/jquery.1.10.2.min.js"></script>


    <!--BOOTSTRAP-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!--LESS-->
    <link rel="stylesheet/less" type="text/css" href="../../../../../resources/css/architectorEdit.less" />
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
<a href="/admin" style="font-family: 'Poiret One'; text-decoration: none; color:white; font-size:20px;">GO BACK</a>
<div class="registerblock center col-sm-10 col-md-7" ng-controller="all_architectors_control">
    <p>OBJECT EDITOR</p>
    <div ng-controller="object_controller">
        <form class="form-horizontal" ng-submit="objectSave()" ng-controller="object_edit_control" >
            <div class="form-group">
                <label class=" col-xs-2 col-sm-2 control-label" for="textinput">Architector</label>
                <div class="col-xs-6 col-sm-6 col-md-5">
                    <select class="form-control" ng-model="objects.id_architector" >
                        <option ng-selected="objects.id_architector==item.id_architector"
                                ng-repeat="item in architectors"
                                ng-value="item.id_architector">{{item.pib}}
                        </option>
                    </select>
                </div>
            </div>
            <div class="buttons">
                <button type="submit" >SUBMIT</button>
            </div>
        </form>
    </div>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="../../../resources/js/utils/parse_url.js"></script>
<script src="../../../resources/js/admin/all_architectors.js?id=${id}" id="loader"></script>

</body>
</html>
