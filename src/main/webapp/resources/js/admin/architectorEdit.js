/**
 * Created by PANNA on 08.04.2017.
 */
var app = angular.module('architector_edit',[]);
FIELDS='fields=id_architector,id_user, login, password, pib,email,hours,work_experience,phone_number';
LIMIT = 20;
app.controller('architector_controller',function($scope,$http){
    var params = UrlUtil.parse(angular.element('#loader').attr('src'));
    params.id = parseInt(params.id);
    if(params.id){
        $http.get('/api/architectors/'+params.id+ '/?'+FIELDS).then(function(response){
            if(response.data.result){
                $scope.architectors=response.data.result;
            }
        })
    }else{
        $scope.architectors={ };
    }
});
app.controller('architector_edit_controller',function($scope,$http){
    $scope.architectorSave=function() {
        var _method = ($scope.architectors.id_architector ? $http.post : $http.put);
        var architector=processData($scope.architectors);
        _method('/api/architectors/update', JSON.stringify(architector), {headers: HEADERS}).then(function(response){
            var data=response.data;
            if(data.result){
                if(!$scope.architectors.id){
                    setTimeout(function() {
                        location.href = '/web/admin/' + data.result;
                    },2000);
                }
            }
        },function(xhr){console.log(xhr);});
        window.location.reload();
    };
});
function processData(architectors){
    var obj={};
    obj["pib"]=architectors.pib;
    obj["email"]=architectors.email;
    obj["phone_number"]=architectors.phone_number;
    obj["work_experience"]=architectors.work_experience;
    obj["hours"]=architectors.hours;
    obj["id_architector"]=architectors.id_architector;
    var user={};
    user["id_user"]=architectors.id_user;
    user["login"]=architectors.login;
    user["password"]=architectors.password;
    obj["user"]=user;
    return obj;
}