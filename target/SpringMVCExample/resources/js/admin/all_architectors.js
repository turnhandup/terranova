/**
 * Created by PANNA on 07.04.2017.
 */
var app = angular.module('all_architectors',[]);
FIELDS='fields=id_architector,pib,email,hours,work_experience';
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
                alert(JSON.stringify($scope.architectors));s
            }
        });
    }
});