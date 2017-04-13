/**
 * Created by PANNA on 13.04.2017.
 */

var app = angular.module('all_orders',[]);
FIELDS='fields=id_order,hours,objects,workers,salary,id_orderer,orderer_id_department';

LIMIT = 20;
app.controller('all_orders_control',function($scope,$http){
    getObjects();
    function getObjects() {
        var params = UrlUtil.parse(angular.element('#loader').attr('src'));
        params.id = parseInt(params.id);
        if (params.id) {
            var query = '/api/orders/' + params.id + '/orderer/?' + FIELDS;
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