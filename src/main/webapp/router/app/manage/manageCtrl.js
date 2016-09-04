angular.module('mainApp').controller('manageCtrl',
		[ '$scope', 'APPCONST', 'mainService','modalService','$filter', function($scope, APPCONST, srv, modalSrv,$filter) {
			
			//init list of pacients
			srv.getPacients().then(function(res) {
				angular.forEach(res.data, function(elem) {
					elem.editMode = false;
					elem.original = {};
					elem.original.firstName = elem.firstName;
					elem.original.lastName = elem.lastName;
					elem.original.seria = elem.seria;
					delete elem.firstName;
					delete elem.lastName;
					delete elem.seria;
				});
				$scope.pacientsList = res.data;
			});
			
			$scope.saveEdit = function(pacient){
				//TODO create saving pacient object
				var index = $scope.pacientsList.indexOf(pacient);
				$scope.pacientsList[index].original = angular.copy(pacient.editPacient);
				//$scope.pacientsList = $filter('filter')($scope.pacientsList,$scope.searchPacient);
				pacient.editMode = false;
			}
			
			$scope.deletePacient = function(pacient){
				var index = $scope.pacientsList.indexOf(pacient);
				$scope.pacientsList.splice(index, 1);
			}
			
			$scope.openAddPacientModal = function(){
				console.log(APPCONST.MODALS);
				modalSrv.openModal("addPacient",$scope.pacientsList).then(function(res){
					console.log(res);
					var newPacient = {editMode: false, original: res.resultContext};
					if(res.resultContext.operationPerformed != 'ABORTED')
					$scope.pacientsList.push(newPacient);
				});
			}
			
			$scope.openInfoPacientModal = function(pacient){
				modalSrv.openModal("infoPacient",pacient).then(function(res){
					console.log(res);
				});
			}
		} ]);
