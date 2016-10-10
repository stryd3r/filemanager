angular.module('mainApp').controller(
		'addConsultCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance',
			function($scope, APPCONST, srv, $uibModalInstance) {
				$scope.ok = function(newPacient) {
					$uibModalInstance.close("OK");
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
