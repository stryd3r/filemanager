(function() {

	angular.module('mainApp').controller('loginCtrl', [ '$scope', '$state', function($scope, $state) {

		$scope.pageTitle = 'LogIn to your Account';
		$scope.goToRegisterPage = function(){
			$state.go('createAccount');
		}

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