angular.module(
		'mainApp',
		[ 'mwl.calendar', 'ui.bootstrap', 'ui.router', 'ngAnimate',
			'angularMoment', 'colorpicker.module', 'angular-loading-bar' ]).controller(
		'routerController',
		[
			'$scope',
			'$rootScope',
			'$state',
			function($scope, $rootScope, $state) {

				$scope.name = "Hbk";
				var fromState = null;
				var toState = null
				var params = null;
				$scope.stateHasChanged = false;
				// $scope.showPage = true;
				$scope.goToRegisterPage = function() {
					alert(1);
				}

				$scope.goBack = function() {
					$state.go(fromState.name, params);
				}

				$rootScope.$on('$stateChangeSuccess', function(ev, to, toParams, from,
						fromParams) {
					// assign the "from" parameter to something
					fromState = from;
					if (to.name != from.name && from.name != "") {
						$scope.stateHasChanged = true;
						if (toParams.name) {
							params = toParams;
						} else if (fromParams.name) {
							params = fromParams;
						}
					} else {
						$scope.stateHasChanged = false;
					}
				});
			} ]);
