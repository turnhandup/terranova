<%--
  Created by IntelliJ IDEA.
  User: PANNA
  Date: 13.04.2017
  Time: 6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="zvit"> <head>
    <!---METADATA--->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale = 1.0">
    <meta name="description" content="Great resource which will help you to find your best sport team to play with" />
    <title>TERRANOVA</title>

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
<style>
    button{
        padding:5px 30px 5px 30px;
        background: none;
        border: 2px solid white;
        color: white;
        font-size:30px;
        transition:.5s;
        margin-left:50px;
    }
    button:hover{
        background-color:white;
        color:darkslategray;
    }
</style>
<button onclick="window.print()">Друк</button>
<div id="allArchitectors">
    <div class="container">
        <h2 class="usersTable" style="font-family:'Poiret One'">ARCHITECTORS TABLE</h2>
        <table class="table" ng-controller="zvit_control">
            <thead>
            <tr class="tableHeader"  style="font-family:'Poiret One'">
                <th>PIB</th>
                <th>HOURS</th>
                <th>SALARY</th>
            </tr>
            </thead>
            <tbody>

            <tr ng-repeat="architector in architectors">
                <td>{{architector.pib}}</td>
                <td>{{architector.hours}}</td>
                <td>{{architector.hours*100}}</td>
            </tbody>
        </table>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="/resources/js/admin/zvit.js"></script>
</body>
</html>
