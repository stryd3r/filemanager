angular
		.module('mainApp')
		.controller(
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
						$scope.originalO = originalO;
						var pacientObj = {};
						var originalCopy;
						init(pacientDetResp.data);

						function init(object) {
							// accordion
							$scope.oneAtATime = false;
							$scope.status = {
								isCustomHeaderOpen : false,
								isFirstOpen : true,
								isFirstDisabled : false,
								open : true,
								openDet : !(angular.isUndefined($scope.status)) ? $scope.status.openDet
										: false,
								openCh : !(angular.isUndefined($scope.status)) ? $scope.status.openCh
										: false
							};
							pacientObj.editMode = false;
							angular.forEach(object.consultations, function(cons) {
								cons.original = angular.copy(cons);
								cons.edit = angular.copy(cons.original);
								delete cons.consultationId;
								delete cons.pacientId;
								delete cons.doctorId;
								delete cons.diagnostic;
								delete cons.observation;
								delete cons.price;
								delete cons.consultationTime;
							});
							pacientObj.original = {
								name : object.name,
								surname : object.surname,
								address : object.pacientDetailsDto!=null?object.pacientDetailsDto.address:null,
								zipCode : object.pacientDetailsDto!=null?object.pacientDetailsDto.zipCode:null,
								phone : object.pacientDetailsDto!=null?object.pacientDetailsDto.phone:null,
								age : object.pacientDetailsDto!=null?object.pacientDetailsDto.age:null,
								sex : object.pacientDetailsDto!=null?object.pacientDetailsDto.sex:null,
								consultations : object.consultations

							};
							pacientObj.edit = angular.copy(pacientObj.original);
							$scope.pacient = pacientObj;
							originalCopy = angular.copy($scope.pacient.original);
						}
						// others
						$scope.saveConsult = function(index) {
							//var index = $scope.pacient.edit.consultations.indexOf(cons);
							delete $scope.pacient.edit.consultations[index].editMode;
							checkForChanges();
							$scope.pacient.original.consultations[index].original = $scope.pacient.edit.consultations[index].edit;
							$scope.pacient.edit.consultations[index].original = $scope.pacient.edit.consultations[index].edit;
						}

						$scope.deleteConsult = function(cons) {
							var index = $scope.pacient.original.consultations.indexOf(cons);
							$scope.pacient.original.consultations.splice(index, 1);
							checkForChanges();
						}

						function checkForChanges() {
							$scope.hasChanged = !angular.equals(originalCopy,
									$scope.pacient.edit);
						}

						$scope.saveEditPacient = function(pacient) {
							checkForChanges();
							$scope.pacient.original = pacient.edit;
							pacient.editMode = false;
						}

						$scope.resetDefault = function() {
							init(angular.copy(originalO));
							checkForChanges();
						}

						$scope.saveChangesDb = function(pacient) {
							modalSrv.openModal('confirmation').then(function(resp) {
								if ("OK" === resp.resultContext) {
									var toUpdate = createSavePacientObj(pacient);
									var withConsultations = !angular.equals(toUpdate.consultations, originalO.consultations);
									var withDetail = $scope.hasChanged;
									srv.saveAllPacientInDb(toUpdate, withConsultations, withDetail).then(function(response) {
										originalO = angular.copy(toUpdate);
										$scope.originalO = originalO;
										$scope.resetDefault();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							}), function(err) {
								console.log(err);
							};
						}

						function createSavePacientObj(pacient) {
							var pacientObj = {};
							var pacientDetObj = {};
							//var doctorObj = {};
							pacientObj.name = pacient.original.name;
							pacientObj.surname = pacient.original.surname;
							pacientObj.pacientId = originalO.pacientId;
							pacientObj.doctorId = originalO.doctorId;
							//doctorObj.doctorId = originalO.doctorId;
							var consArray = [];
							angular.forEach(pacient.original.consultations,
									function(consult) {
										consArray.push(consult.original);
									});
							pacientObj.consultations = consArray;
							//pacientObj.doctor = doctorObj;
							// pacientDet
							// pacientDetObj.pacient = pacientObj;
							pacientDetObj.pacientId = originalO.pacientId;
							pacientDetObj.zipCode = pacient.original.zipCode;
							pacientDetObj.phone = pacient.original.phone;
							pacientDetObj.age = pacient.original.age;
							pacientDetObj.sex = pacient.original.sex;
							pacientDetObj.address = pacient.original.address;
							pacientObj.pacientDetailsDto = pacientDetObj;
							return pacientObj;
						}
						/*
						 * $scope.hideShow = function(domId){ var elem =
						 * document.getElementById(domId); elem.hide(); }
						 */
					} ]);
