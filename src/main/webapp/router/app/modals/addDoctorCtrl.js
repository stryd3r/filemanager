angular.module('mainApp').controller(
		'addDoctorCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance', '$filter',
			'modalService',
			function($scope, APPCONST, srv, $uibModalInstance, $filter, modalService) {
				$scope.addDoctorObj = new Object();

				$scope.ok = function(newDoctor) {
					modalService.openModal('confirmation').then(function(resp) {
						if ("OK" === resp.resultContext) {
							if (angular.isUndefined(newDoctor.color)) {
								newDoctor.color = '#585858';
							}
							$uibModalInstance.close(newDoctor);
						} else {
							$uibModalInstance.dismiss('cancel');
						}
					});
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
