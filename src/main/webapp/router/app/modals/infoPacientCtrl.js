angular.module('mainApp').controller(
		'infoPacientCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance', 'item',
				function($scope, APPCONST, srv, $uibModalInstance, item) {
					console.log(item);
					$scope.pacientDoc = item;
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				} ]);
