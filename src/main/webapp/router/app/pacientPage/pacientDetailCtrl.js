angular.module('mainApp').controller(
		'pacientDetailCtrl',
		[
			'$scope',
			'$rootScope',
			'APPCONST',
			'mainService',
			'modalService',
			'$state',
			'$stateParams',
			'pacientName',
			function($scope, $rootScope, APPCONST, srv, modalSrv, $state,
					$stateParams, pacientName) {
				console.log(pacientName);
				$scope.pacientN = $stateParams.name;
			} ]);
