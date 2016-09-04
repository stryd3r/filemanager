angular.module('mainApp').controller(
		'addPacientCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance',
				function($scope, APPCONST, srv, $uibModalInstance) {
					$scope.ok = function() {
						$uibModalInstance.close("CLOSED");
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				} ]);
