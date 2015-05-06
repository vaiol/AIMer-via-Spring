var myApp = angular.module('myApp',[]);
myApp.controller('add', ['$scope', '$http', function($scope, $http) {
    $http.post('http://localhost:8081/example').
        success(function(data) {
            $scope.example = data;
        }).error(function(data, status, headers, config){
            console.log(status);
        });
}]);

myApp.controller('update', ['$scope', '$http', function($scope, $http) {
    dat = {message: 'Hello, Апдейт'};
    $http.put('http://localhost:8081/example/1', dat).
        success(function(data) {
            $scope.example = data;
        });
}]);