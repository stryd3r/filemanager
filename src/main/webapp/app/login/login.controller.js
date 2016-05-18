(function() {
	var filemanagerApp = angular.module('filemanagerApp', ['ui.bootstrap']);

	angular.module('filemanagerApp').service('serviceProvider', ['$http',  function($http) {
		this.loginService = function() {
			return $http.post("http://localhost:8080/filemanager/login");
		}
	}]);

	filemanagerApp.controller('loginController', ['$scope', 'serviceProvider', function($scope, serviceProvider) {
//		function init()	{
//			serviceProvider.loginService().then(function(data) {
//				alert(data.data.name);
				
				$scope.pageTitle = 'LogIn to your Account';
//			}, function(error) {
//				alert("not-ok");
//			});
//		};

//		init();
    }]);
}());