/**
 * Created by PANNA on 07.04.2017.
 */
var app = angular.module('all_architectors',[]);
FIELDS='fields=id_architector,id_user, login, password, pib,email,hours,work_experience,phone_number';
FIELDS2='fields=id_orderer,Users_id_user,login,enabled,departmentaddress,departmentphonenumber,departmentemail,Department_id_department,pib,company_name,phone_number,passport_date,email,address';

LIMIT = 20;
app.controller('all_architectors_control',function($scope,$http){
    getUsers();
    function  getUsers() {
        var query='/api/architectors/?';
        var offset= 0;
        query+= 'limit=' + LIMIT+ '&offset='+offset+'&'+FIELDS;
        $scope.architectors=[];
        $http.get(query).then(function(response){
            var data=response.data;
            if(data.result) {
                $scope.architectors = data.result;
            }
        });
    }
});
app.controller('all_orderers_control',function($scope,$http){
    getOrderers();
    function  getOrderers() {
        var query='/api/orderers/?';
        var offset= 0;
        query+= 'limit=' + LIMIT+ '&offset='+offset+'&'+FIELDS2;
        $scope.orderers=[];
        $http.get(query).then(function(response){
            var data=response.data;
            if(data.result) {
                $scope.orderers = data.result;
            }
        });
    }
});