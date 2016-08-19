(function() {

	angular.module('mainApp').controller('createAccountCtrl', [ '$scope', function($scope) {

		$scope.pageTitle = 'LogIn to your Account';

		$scope.login = function() {

			var credentials = new Object();
			credentials.user = $scope.user;
			credentials.password = $scope.password;

			/*serviceProvider.login(credentials).then(function(data) {

				alert(data.data);
			}, function(error) {
				alert("not-ok");
			});*/
		}

	} ]);
}());