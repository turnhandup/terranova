<html>
<body>
     <head>
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
	<script type="text/javascript" src="../../resources/js/architector/architector.js"></script>
    
    <!--BOOTSTRAP-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <!--LESS-->
    <link rel="stylesheet/less" type="text/css" href="../../../resources/css/objectEdit.less" />
    <!-- LESS JavaScript компілятор -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.5.3/less.min.js"></script>
</head>
    <script>
    var HEADERS = {
        '${_csrf.headerName}': '${_csrf.token}',
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    };
</script>
<a href="/architector" style="font-family: 'Poiret One'; text-decoration: none; color:white; font-size:20px;">GO BACK</a>
<div class="registerblock center col-sm-10 col-md-7" ng-controller="architector_controller">
    <p>ORDER EDITOR</p>
   <div ng-controller="architector_edit_controller">
    <form class="form-horizontal" ng-submit="architectorSave()" >
        <div class="form-group">
            <label class=" col-xs-12 col-sm-4 control-label" for="textinput">STATUS</label>
            <div class="col-xs-12 col-sm-8 col-md-6">
                <input id="textinput" name="textinput" type="text"   class="form-control input-md">
            </div>
        </div>
         <div class="buttons">
            <button type="submit" >SUBMIT</button>
        </div>
    </form>
   </div>
</div>
</body>
</html>