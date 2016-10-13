angular.module('mainApp').controller(
		'confirmationCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance',
			function($scope, APPCONST, srv, $uibModalInstance) {
				$scope.ok = function() {
					$uibModalInstance.close("OK");
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
