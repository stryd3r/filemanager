angular.module('mainApp').controller(
		'infoPacientCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance', 'item',
				function($scope, APPCONST, srv, $uibModalInstance, item) {
					console.log(item);
					$scope.pacient = item.original;
					$scope.pacient.doctorId = item.doctorId;
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				} ]);
