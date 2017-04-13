/**
 * Created by PANNA on 12.04.2017.
 */

var app = angular.module('all_objects',[]);
FIELDS='fields=id_architector,id_object,status,detalisation,software,hours';

LIMIT = 20;
app.controller('all_objects_control',function($scope,$http){
    getObjects();
    function getObjects() {
        var params = UrlUtil.parse(angular.element('#loader').attr('src'));
        params.id = parseInt(params.id);
        if (params.id) {
            var query = '/api/objects/' + params.id + '/architector/?' + FIELDS;
            // alert(query);
            var offset = 0;
            // query += 'limit=' + LIMIT + '&offset=' + offset + '&' + FIELDS;
            $scope.objects = [];
            $http.get(query).then(function (response) {
                var data = response.data;
                if (data.result) {
                    $scope.objects = data.result;
                }
            });
        }
    }
});
