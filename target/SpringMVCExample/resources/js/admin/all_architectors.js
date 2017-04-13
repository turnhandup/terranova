/**
 * Created by PANNA on 07.04.2017.
 */
var app = angular.module('all_architectors',[]);
FIELDS='fields=id_architector,id_user, login, password, pib,email,hours,work_experience,phone_number';
FIELDS2='fields=id_orderer,Users_id_user,login,enabled,departmentaddress,departmentphonenumber,departmentemail,Department_id_department,pib,company_name,phone_number,passport_date,email,address';
FIELDS3='fields=id_architector,id_object,status,detalisation,software,hours';

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
app.controller('all_objects_control',function($scope,$http){
    getObjects();
    function  getObjects() {
        var query='/api/objects/?';
        var offset= 0;
        query+= 'limit=' + LIMIT+ '&offset='+offset+'&'+FIELDS3;
        $scope.objects=[];
        $http.get(query).then(function(response){
            var data=response.data;
            if(data.result) {
                $scope.objects = data.result;
            }
        });
    }
});
FIELDS4='fields=id_architector,id_object,status,detalisation,software,hours';
app.controller('object_controller',function($scope,$http){
    var params = UrlUtil.parse(angular.element('#loader').attr('src'));
    params.id = parseInt(params.id);
    if(params.id){
        $http.get('/api/objects/'+params.id+ '/?'+FIELDS4).then(function(response){
            if(response.data.result){
                $scope.objects=response.data.result;
                $scope.items=
                    [
                        {name:'Done',value:true},
                        {name:'Undone',value:false}
                    ]
            }
        })
    }else{
        $scope.objects={ };
    }
});
app.controller('object_edit_control', function($scope,$http){
    $scope.objectSave=function() {
        var _method = ($scope.objects.id_object ? $http.post : $http.put);
        var object=$scope.objects;
        _method('/api/objects/update', JSON.stringify(object), {headers: HEADERS}).then(function(response){
            var data=response.data;

            // if(data.result){
            //     if(!$scope.obje.id_orderer){
            //         setTimeout(function() {
            //             location.href = '/web/admin/' + data.result+"/editorderer";
            //         },2000);
            //
            //     }
            // }
        },function(xhr){console.log(xhr);});
        window.location.reload();

    };
})
