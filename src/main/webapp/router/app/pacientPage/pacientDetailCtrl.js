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
					checkForChanges();
				}

				$scope.deleteConsult = function(cons) {
					var index = $scope.pacient.original.consultations.indexOf(cons);
					$scope.pacient.original.consultations.splice(index, 1);
					checkForChanges();
				}

				function checkForChanges() {
					$scope.hasChanged = !angular.equals($scope.pacient.original,
							$scope.pacient.edit);
				}

				$scope.saveEditPacient = function(pacient) {
					checkForChanges();
					$scope.pacient.original = pacient.edit;
					pacient.editMode = false;
				}

				$scope.resetDefault = function() {
					init(angular.copy(originalO));
					$scope.status.openDet = true;
					checkForChanges();
				}

				$scope.saveChangesDb = function(pacient) {
					modalSrv.openModal('confirmation').then(function(resp) {
						if ("OK" === resp.resultContext) {
							
							srv.saveAllPacientInDb(createSavePacientObj(pacient)).then(function(response) {
								$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
							},function(err){
								$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
							});
						}
					}), function(err) {
						console.log(err);
					};
				}
				
				function createSavePacientObj(pacient){
					var pacientObj = {};
					var pacientDetObj = {};
					pacientObj.name = pacient.original.name;
					pacientObj.surname = pacient.original.surname;
					pacientObj.id = originalO.pacientId;
					var consArray = [];
					angular.forEach(pacient.original.consultations, function(consult){
						consArray.push(consult.original);
					});
					pacientObj.consultations = consArray;
					//pacientDet
					//pacientDetObj.pacient = pacientObj;
					pacientDetObj.zipCode = pacient.original.zipCode;
					pacientDetObj.phone = pacient.original.phone;
					pacientDetObj.age = pacient.original.age;
					pacientDetObj.sex = pacient.original.sex;
					pacientObj.pacientDetail = pacientDetObj;
					return pacientObj;
				}
				/*
				 * $scope.hideShow = function(domId){ var elem =
				 * document.getElementById(domId); elem.hide(); }
				 */
			} ]);
