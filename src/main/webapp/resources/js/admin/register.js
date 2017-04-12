/**
 * Created by PANNA on 11.04.2017.
 */
/**
 * Created by PANNA on 11.04.2017.
 */
var app = angular.module('orderer_create',[]);

FIELDS='fields=id_orderer,id_department,login,password,pib,company_name,phone_number,passport_data,email,address, id_user';
LIMIT = 20;
app.controller('orderer_create_controller',function($scope,$http){
    $scope.ordererCreate=function() {
        alert(JSON.stringify($scope.login));
        alert(JSON.stringify(processData($scope)));
        var _method = ($scope ? $http.put : $http.put);
        var orderer=processData($scope);
        // alert("SCOPE"+ $scope.architectors);
        // alert("ORDERER"     + JSON.stringify(orderer));
        _method('/api/orderers/create', JSON.stringify(orderer), {headers: HEADERS}).then(function(response){
            var data=response.data;
            //     alert(JSON.stringify(orderer));
            //     alert(data);
            //     alert((data.result));
            if(data.result){
                if(!orderer.id_orderer){
                    setTimeout(function() {
                        location.href = '/login';
                    },1000);

                }
            }
        },function(xhr){console.log(xhr);});
    };
});
function processData($scope){
    var obj={};
    obj["pib"]=$scope.pib;
    obj["company_name"]=$scope.company_name;
    obj["email"]=$scope.email;
    obj["address"]=$scope.address;
    obj["passport_data"]=$scope.passport_data;
    obj["phone_number"]=$scope.phone_number;
    obj["id_orderer"]=null;
    obj["id_department"]=$scope.id_department;
    var user={};
    user["id_user"]=null;
    user["login"]=$scope.login;
    user["password"]=$scope.password;
    obj["user"]=user;
    return obj;
}