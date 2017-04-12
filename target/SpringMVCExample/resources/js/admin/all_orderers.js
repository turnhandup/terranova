/**
 * Created by PANNA on 09.04.2017.
 */
var app = angular.module('all_orderers',[]);
FIELDS='fields=id_orderer,Users_id_user,login,enabled,departmentaddress,departmentphonenumber,departmentemail,Department_id_department,pib,company_name,phone_number,passport_date,email,address';
LIMIT = 20;
app.controller('all_orderers_control',function($scope,$http){
    getOrderers();
    function  getOrderers() {
        var query='/api/orderers/?';
        var offset= 0;
        query+= 'limit=' + LIMIT+ '&offset='+offset+'&'+FIELDS;
        $scope.orderers=[];
        $http.get(query).then(function(response){
            var data=response.data;
            if(data.result) {
                $scope.orderers = data.result;
                alert(JSON.stringify($scope.orderers));
            }
        });
    }
});