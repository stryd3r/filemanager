(function() {

	angular.module('mainApp').controller('loginController', [ '$scope', 'serviceProvider', 'globalVariables', function($scope, serviceProvider, globalVariables) {

		$scope.pageTitle = 'LogIn to your Account';

		$scope.login = function() {

			var credentials = new Object();
			credentials.user = $scope.user;
			credentials.password = $scope.password;

			serviceProvider.login(credentials).then(function(data) {

				alert(data.data);
			}, function(error) {
				alert("not-ok");
			});
		}

	} ]);
}());