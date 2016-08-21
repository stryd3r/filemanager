(function() {
	angular.module('mainApp', [ 'mwl.calendar', 'ui.bootstrap', 'ui.router', 'ngAnimate', 'angularMoment', 'colorpicker.module' ]).controller(
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