// Please note that $modalInstance represents a modal window (instance)
// dependency.
// It is not the same as the $uibModal service used above.
angular.module('mainModule').controller('modalCtrl', ['APPCONST', '$scope', '$uibModalInstance', 'modalType',
		function(appConst, $scope, $uibModalInstance, modalType) {

			$scope.modalType = modalType;
			
			switch (modalType) {
			case "C":
				$scope.modalName = appConst.MODAL_NAME.MODAL_CONCEDIU;
				break;
			case "M":
				$scope.modalName = appConst.MODAL_NAME.MODAL_MEDICAL;
				break;
			case "EVS":
				$scope.modalName = appConst.MODAL_NAME.EVS;
				break;
			case "P":
				$scope.modalName = appConst.MODAL_NAME.MODAL_PERMESO;
				break;
			case "D":
				$scope.modalName = appConst.MODAL_NAME.MODAL_DELEGATII;
				break;
			case "O":
				$scope.modalName = appConst.MODAL_NAME.MODAL_OVERTIME;
				break;
			}
			
			

/*			$scope.ok = function() {
				$uibModalInstance.close($scope.item);
			};*/

			$scope.close = function() {
				$uibModalInstance.dismiss('cancel');
			};
		}]);