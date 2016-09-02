(function() {
	angular.module(
			'mainApp',
			[ 'mwl.calendar', 'ui.bootstrap', 'ui.router', 'ngAnimate',
					'angularMoment', 'colorpicker.module' ]).controller(
			'routerController', [ '$scope', '$state', function($scope, $state) {

				$scope.name = "Hbk";
				//$scope.showPage = true;
				$scope.goToRegisterPage = function() {
					alert(1);
				}

			} ]);
}());