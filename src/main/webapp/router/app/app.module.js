(function() {
	angular.module('mainApp', [ 'ui.bootstrap', 'ui.router','mwl.calendar', 'ngAnimate' ]).controller(
			'routerController',
			[ '$scope','$state', function($scope,$state) {

				$scope.name = "Adrian";
				$scope.showPage = true;
				$scope.goHome = function(){
					$state.go("login");
				}
				
				$scope.goToRegisterPage = function(){
					alert(1);
				}
				
			} ]);
}());