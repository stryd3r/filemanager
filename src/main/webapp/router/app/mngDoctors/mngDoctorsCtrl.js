angular.module('mainApp').controller(
		'mngDoctorsCtrl',
		[ '$scope', '$rootScope', 'APPCONST', 'mainService', 'modalService',
			'$state', '$filter',
			function($scope, $rootScope, APPCONST, srv, modalSrv, $state, $filter) {
				init();
				function init() {
					$scope.doctorsActive = true;
				}
			} ]);
