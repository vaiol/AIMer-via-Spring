function Hello($scope, $http) {
    $http.get('http://localhost:8080/hello').
        success(function(data) {
            $scope.greeting = data;
        });
}