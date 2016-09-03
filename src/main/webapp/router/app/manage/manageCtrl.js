angular.module('mainApp').controller('manageCtrl',
		[ '$scope', '$state', 'mainService', function($scope, $state, srv) {
			srv.getPacients().then(function(res) {
				angular.forEach(res.data, function(elem) {
					elem.editMode = false;
				});
				$scope.pacientsList = res.data;
			});
			
			$scope.editPacient = function(pacient){
				pacient.editMode = true;
			}
			
			$scope.undoEdit = function(pacient){
				pacient.editMode = false;
			}
			
			$scope.saveEdit = function(pacient, index){
				$scope.pacientsList[index].firstName = angular.copy(pacient.editPacient.firstName);
				$scope.pacientsList[index].lastName = angular.copy(pacient.editPacient.lastName);
				$scope.pacientsList[index].seria = angular.copy(pacient.editPacient.seria);
				pacient.editMode = false;
			}
			
			$scope.openInfo = function(pacient){
				alert('Va urma ...');
			}
		} ]);
