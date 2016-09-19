angular.module('mainApp').controller(
		'addPacientCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance','item',
				function($scope, APPCONST, srv, $uibModalInstance, item) {
					console.log(item);
					$scope.ok = function(newPacient) {
						$uibModalInstance.close(newPacient);
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				} ]);
