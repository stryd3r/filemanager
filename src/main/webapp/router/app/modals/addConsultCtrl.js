angular.module('mainApp').controller(
		'addConsultCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance',
			function($scope, APPCONST, srv, $uibModalInstance) {
				$scope.addConsult = function(consult) {
					consult.price = consult.price.toString();
					$uibModalInstance.close(consult);
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
