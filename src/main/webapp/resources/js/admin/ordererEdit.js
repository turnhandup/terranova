/**
 * Created by PANNA on 09.04.2017.
 */
/**
 * Created by PANNA on 08.04.2017.
 */
var app = angular.module('orderer_edit',[]);
// FIELDS2='fields=id_orderer,Users_id_user,Department_id_department,pib,company_name,phone_number,passport_date,email,address';
FIELDS='fields=id_orderer,id_department,login,password,pib,company_name,phone_number,passport_data,email,address, id_user';
LIMIT = 20;
app.controller('architector_controller',function($scope,$http){
    var params = UrlUtil.parse(angular.element('#loader').attr('src'));
    params.id = parseInt(params.id);
    if(params.id){
        $http.get('/api/orderers/'+params.id+ '/?'+FIELDS).then(function(response){
            if(response.data.result){
                $scope.architectors=response.data.result;
                alert(JSON.stringify($scope.architectors));

            }
        })
    }else{
        $scope.architectors={ };
    }
});
app.controller('architector_edit_controller',function($scope,$http){
    $scope.architectorSave=function() {
        var _method = ($scope.architectors.id_orderer ? $http.post : $http.put);
        var orderer=processData($scope.architectors);
        _method('/api/orderers/update', JSON.stringify(orderer), {headers: HEADERS}).then(function(response){
            var data=response.data;
            if(data.result){
                if(!$scope.architectors.id_orderer){
                    setTimeout(function() {
                        location.href = '/web/admin/' + data.result+"/editorderer";
                    },2000);

                }
            }
        },function(xhr){console.log(xhr);});
        // window.location.reload();

    };
});

function processData(architectors){
    var obj={};
    obj["pib"]=architectors.pib;
    obj["company_name"]=architectors.company_name;
    obj["email"]=architectors.email;
    obj["address"]=architectors.address;
    obj["passport_data"]=architectors.passport_data;
    obj["phone_number"]=architectors.phone_number;
    obj["id_orderer"]=architectors.id_orderer;
    obj["id_department"]=architectors.id_department;
    var user={};
    user["id_user"]=architectors.id_user;
    user["login"]=architectors.login;
    user["password"]=architectors.password;
    obj["user"]=user;
    return obj;
}