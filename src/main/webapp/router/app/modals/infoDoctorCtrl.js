angular.module('mainApp').controller(
		'infoDoctorCtrl',
		[
			'$scope',
			'$rootScope',
			'APPCONST',
			'mainService',
			'$uibModalInstance',
			'item',
			function($scope, $rootScope, APPCONST, srv, $uibModalInstance, item) {
				console.log(item);
				$scope.pacientsList = new Array();
				$scope.doctor = item;

				init();
				function init() {
					srv.getDoctorsPacients($scope.doctor.edit.doctorId, true).then(
							function(resp) {
								$scope.pacientsList = resp.data.pacients;
							},
							function(err) {
								$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
								$rootScope.alertMsg = "Info doctor modal problem: "
										+ err.statusText;
							});
				}

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
