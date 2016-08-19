// Please note that $modalInstance represents a modal window (instance)
// dependency.
// It is not the same as the $uibModal service used above.
angular.module('mainModule').controller('modalAddCtrl', ['APPCONST', '$scope', '$uibModalInstance','mainService', 'absenceType',
		function(appConst, $scope, $uibModalInstance, service, absenceType) {

			$scope.absenceType = absenceType;
			
			switch (absenceType) {
			case "C":
				$scope.modalName = appConst.MODAL_NAME.MODAL_CONCEDIU_ADD;
				service.setAddAbsenceType(absenceType);
				break;
			case "M":
				$scope.modalName = appConst.MODAL_NAME.MODAL_MEDICAL_ADD;
				break;
			case "EVS":
				$scope.modalName = appConst.MODAL_NAME.EVS_ADD;
				break;
			case "P":
				$scope.modalName = appConst.MODAL_NAME.MODAL_PERMESO_ADD;
				service.setAddAbsenceType(absenceType);
				break;
			case "D":
				$scope.modalName = appConst.MODAL_NAME.MODAL_DELEGATII_ADD;
				break;
			case "O":
				$scope.modalName = appConst.MODAL_NAME.MODAL_OVERTIME_ADD;
				service.setAddAbsenceType(absenceType);
				break;
			}
			
			

/*			$scope.ok = function() {
				$uibModalInstance.close($scope.item);
			};*/

			$scope.close = function() {
				$uibModalInstance.dismiss('cancel');
			};
		}]);