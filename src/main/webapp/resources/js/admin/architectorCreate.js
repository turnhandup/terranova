/**
 * Created by PANNA on 11.04.2017.
 */
var app = angular.module('architector_create',[]);

app.controller('architector_create_controller',function($scope,$http){
    $scope.ordererCreate=function() {
        var _method = ($scope ? $http.put : $http.put);
        var architector=processData($scope);
        _method('/api/architectors/create', JSON.stringify(architector), {headers: HEADERS}).then(function(response){
            var data=response.data;
            //     alert(JSON.stringify(orderer));
            //     alert(data);
            //     alert((data.result));
            if(data.result){
                if(!architector.id_architector){
                    setTimeout(function() {
                        location.href = '/admin';
                    },1000);

                }
            }
        },function(xhr){console.log(xhr);});
        window.location.reload();
    };
});
function processData($scope){
    var obj={};
    obj["pib"]=$scope.pib;
    obj["email"]=$scope.email;
    obj["phone_number"]=$scope.phone_number;
    obj["work_experience"]=$scope.work_experience;
    obj["hours"]=$scope.hours;
    obj["id_architector"]=null;
    var user={};
    user["id_user"]=null;
    user["login"]=$scope.login;
    user["password"]=$scope.password;
    obj["user"]=user;
    return obj;
}