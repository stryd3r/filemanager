(function() {
	angular.module(
			'mainApp',
			[ 'mwl.calendar', 'ui.bootstrap', 'ui.router', 'ngAnimate',
					'angularMoment', 'colorpicker.module' ]).controller(
			'routerController', [ '$scope', '$state', function($scope, $state) {

				$scope.name = "Hbk";
				$scope.showPage = true;
				$scope.routePage = function(routeName) {
					switch (routeName) {
					case 'home':
						$state.go("home");
						$scope.activeClass = 'home'
						break;
					case 'calendar':
						$state.go("calendar");
						$scope.activeClass = 'calendar'
						break;
					default:
						$state.go("home");
					}
				}

				$scope.goToRegisterPage = function() {
					alert(1);
				}

			} ]);
}());