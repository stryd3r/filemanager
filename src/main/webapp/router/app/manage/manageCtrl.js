angular.module('mainApp').controller('manageCtrl',
		[ '$scope', 'APPCONST', 'mainService','modalService', function($scope, APPCONST, srv, modalSrv) {
			
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
			
			$scope.saveEdit = function(pacient, index){
				//TODO create saving pacient object
				$scope.pacientsList[index].original.firstName = angular.copy(pacient.editPacient.firstName);
				$scope.pacientsList[index].original.lastName = angular.copy(pacient.editPacient.lastName);
				$scope.pacientsList[index].original.seria = angular.copy(pacient.editPacient.seria);
				pacient.editMode = false;
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
