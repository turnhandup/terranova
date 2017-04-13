/**
 * Created by PANNA on 13.04.2017.
 */
var app = angular.module('zvit',[]);
FIELDS="pib,hours";
LIMIT = 20;
app.controller('zvit_control',function($scope,$http){
    getUsers();
    function  getUsers() {
        var query='/api/cq/workdone/?'+FIELDS;
        $scope.architectors=[];
        $http.get(query).then(function(response){
            var data=response.data;
            if(data.result) {
                $scope.architectors = data.result;

            }
        });

    }
});