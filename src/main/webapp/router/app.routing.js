(function() {
	var mainApp = angular.module('mainApp', [ 'ui.bootstrap', 'ngRoute' ]);
	
    angular.module('mainApp').config([ '$routeProvider', function($routeProvider) {
      
    	$routeProvider.when('/login', {
            templateUrl : 'loginComponent/login.html',
            controller : 'loginController'
        }).otherwise({
            redirectTo : '/welcome'
        });
    } ]);
}());