var myApp = angular.module('myApp', [ 'ngRoute', 'spring-security-csrf-token-interceptor' ]);

myApp.config(function($routeProvider, $httpProvider) {
    $routeProvider.when('/', {
        templateUrl : 'partials/hello.html',
        controller : 'hello'
    }).when('/login', {
        templateUrl : 'partials/login.html',
        controller : 'navigation'
    }).when('/users', {
        templateUrl : 'partials/list.html',
        controller : 'list'
    }).when('/logout', {
        templateUrl : 'partials/logout.html'
    }).otherwise('/');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

});

myApp.controller('hello', ['$scope', '$http', function($scope, $http) {
    //$http.get("example/1").success(function(){console.log("TEST: 1")}).error(function(){console.log("TEST: 2")});
    $http.post('example').
        success(function(data) {
            $scope.example = data;
        }).error(function(data, status){
            console.log(status);
        });
}]);

myApp.controller('navigation', function($rootScope, $scope, $http, $location) {

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('user', {headers : headers}).success(function(data) {
            if (data.username) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }

            $rootScope.admin = false;
            for (i = 0; i < data.authorities.length; i++) {
                if (data.authorities[i].authority === 'ROLE_ADMIN') {
                    $rootScope.admin = true;
                    break;
                }
            }
            callback && callback();
        }).error(function(data, status) {
            console.log(status);
            $rootScope.authenticated = false;
            callback && callback();
        });

    }
    authenticate();
    $scope.credentials = {};
    $scope.login = function() {
        authenticate($scope.credentials, function() {
            console.log("try auth");
            if ($rootScope.authenticated) {
                $location.path("/");
                $scope.error = false;
            } else {
                $location.path("/login");
                $scope.error = true;
            }
        });
    };
    $scope.logout = function() {
        console.log("logout");
        $http.post('logout', {}).success(function() {
            $rootScope.authenticated = false;
            $rootScope.admin = false;
            $location.path("/");
        }).error(function(data, status) {
            console.log(data);
            console.log(status);
        });
    }

}
);

myApp.controller('list', ['$scope', '$http', function($scope, $http) {
    $http.get('users').
        success(function(data) {
            $scope.list = data;
        }).error(function(data, status){
            console.log(status);
        });
}]);


