angular.module('mainApp').controller(
		'pacientDetailCtrl',
		[
			'$scope',
			'$rootScope',
			'APPCONST',
			'mainService',
			'modalService',
			'$state',
			'$stateParams',
			'pacientDetResp',
			function($scope, $rootScope, APPCONST, srv, modalSrv, $state,
					$stateParams, pacientDetResp) {
				// var declarations
				var originalO = angular.copy(pacientDetResp.data);
				var pacientObj = {};
				init(pacientDetResp.data);

				function init(object) {
					// accordion
					$scope.oneAtATime = false;
					$scope.status = {
						isCustomHeaderOpen : false,
						isFirstOpen : true,
						isFirstDisabled : false,
						open : true
					};
					pacientObj.editMode = false;
					angular.forEach(object.consultations, function(cons) {
						cons.original = angular.copy(cons);
						cons.edit = angular.copy(cons.original);
						delete cons.diagnostic;
						delete cons.observations;
						delete cons.price;
					});
					pacientObj.original = {
						name : object.name,
						surname : object.surname,
						address : object.pacientDetail.address,
						zipCode : object.pacientDetail.zipCode,
						phone : object.pacientDetail.phone,
						age : object.pacientDetail.age,
						sex : object.pacientDetail.sex,
						consultations : object.consultations
					};
					pacientObj.edit = angular.copy(pacientObj.original);
					$scope.pacient = pacientObj;
				}
				// others
				$scope.saveConsult = function(cons) {
					var index = $scope.pacient.original.consultations.indexOf(cons);
					$scope.pacient.original.consultations[index].original = cons.edit;
					cons.editMode = false;
				}
				
				$scope.deleteConsult = function(cons) {
					var index = $scope.pacient.original.consultations.indexOf(cons);
					$scope.pacient.original.consultations.splice(index, 1);
				}
				
				$scope.saveEditPacient = function(pacient){
					$scope.pacient.original = pacient.edit;
					pacient.editMode = false;
				}
				
				$scope.resetDefault = function() {
					init(angular.copy(originalO));
					$scope.status.openDet = true;
				}
				/*
				 * $scope.hideShow = function(domId){ var elem =
				 * document.getElementById(domId); elem.hide(); }
				 */
			} ]);
