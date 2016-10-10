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
					'$q',
					function($scope, $rootScope, APPCONST, srv, modalSrv, $state,
							$stateParams, pacientDetResp, $q) {
						// var declarations
						var originalO = angular.copy(pacientDetResp.data);
						$scope.originalO = originalO;
						var pacientObj = {};
						var originalCopy;
						var delConsultIds = new Array();
						var newConsutations = new Array();
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
								address : object.pacientDetailsDto != null ? object.pacientDetailsDto.address
										: null,
								zipCode : object.pacientDetailsDto != null ? object.pacientDetailsDto.zipCode
										: null,
								phone : object.pacientDetailsDto != null ? object.pacientDetailsDto.phone
										: null,
								sex : object.pacientDetailsDto != null ? object.pacientDetailsDto.sex
										: null,
								birthdate : object.pacientDetailsDto != null ? object.pacientDetailsDto.birthdate
										: null,
								cnp : object.pacientDetailsDto != null ? object.pacientDetailsDto.cnp
										: null,
								consultations : object.consultations

							};
							pacientObj.edit = angular.copy(pacientObj.original);
							$scope.pacient = pacientObj;
							originalCopy = angular.copy($scope.pacient.original);
						}
						// others
						$scope.saveConsult = function(index) {
							// var index = $scope.pacient.edit.consultations.indexOf(cons);
							delete $scope.pacient.edit.consultations[index].editMode;
							checkForChanges();
							$scope.pacient.original.consultations[index].original = $scope.pacient.edit.consultations[index].edit;
							$scope.pacient.edit.consultations[index].original = $scope.pacient.edit.consultations[index].edit;
						}

						$scope.deleteConsult = function(indx) {
							// var index =
							// $scope.pacient.original.consultations.indexOf(cons);
							$scope.pacient.edit.consultations.splice(indx, 1);
							delConsultIds.push(indx);
							checkForChanges();
						}

						function checkForChanges() {
							$scope.hasChanged = !angular.equals(originalCopy,
									$scope.pacient.edit);
							$scope.changesInConsultations = !angular
									.equals(originalCopy.consultations,
											$scope.pacient.edit.consultations);
						}

						$scope.saveEditPacient = function(pacient) {
							checkForChanges();
							$scope.pacient.original = pacient.edit;
							pacient.editMode = false;
						}

						$scope.resetDefault = function() {
							init(angular.copy(originalO));
							checkForChanges();
							delConsultIds = [];
						}

						function deleteConsults() {
							var q = $q.defer();
							if (delConsultIds.length > 0) {
								srv.deleteConsults(delConsultIds).then(function(resp) {
									q.resolve();
								}, function(err) {
									// $scope.resetDefault();
									$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									$rootScope.alertMsg = "problema in consultatii";
									$q.reject();
								});
							} else {
								q.resolve();
							}
							return q.promise;
						}

						function insertConsults() {
							var q = $q.defer();
							if (newConsutations.length > 0) {
								angular.forEach(newConsutations, function(newConsult) {
									srv.insertConsult(newConsult).then(function(resp) {
										if(newConsutations.indexOf(newConsult) == newConsutations.length - 1){
											q.resolve();
										}
									}, function(err) {
										// $scope.resetDefault();
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
										$rootScope.alertMsg = "problema in consultatii";
										$q.reject();
										});
												});
							} else {
								q.resolve();
							}
							return q.promise;
						}

						$scope.saveChangesDb = function(pacient) {
							modalSrv.openModal('confirmation').then(
									function(resp) {
										if ("OK" === resp.resultContext) {
											var toUpdate = createSavePacientObj(pacient);
											var withConsultations = !angular.equals(
													toUpdate.consultations, originalO.consultations);
											var withDetail = $scope.hasChanged;
											$q.all([ deleteConsults(), insertConsults() ]).then(
													function() {
														srv.saveAllPacientInDb(toUpdate, withConsultations,
																withDetail).then(function(response) {
															originalO = angular.copy(toUpdate);
															$scope.originalO = originalO;
															$scope.resetDefault();
															$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
														}, function(err) {
															// $scope.resetDefault();
															$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
														});
													});
										}
									}), function(err) {
								console.log(err);
							};
						}

						function createSavePacientObj(pacient) {
							var pacientObj = {};
							var pacientDetObj = {};
							// var doctorObj = {};
							pacientObj.name = pacient.original.name;
							pacientObj.surname = pacient.original.surname;
							pacientObj.pacientId = originalO.pacientId;
							pacientObj.doctorId = originalO.doctorId;
							var consArray = [];
							angular.forEach(pacient.original.consultations,
									function(consult) {
										consArray.push(consult.original);
									});
							pacientObj.consultations = consArray;
							pacientDetObj.pacientId = originalO.pacientId;
							pacientDetObj.zipCode = pacient.original.zipCode;
							pacientDetObj.phone = pacient.original.phone;
							pacientDetObj.sex = pacient.original.sex;
							pacientDetObj.address = pacient.original.address;
							pacientDetObj.cnp = pacient.original.cnp;
							pacientDetObj.birthdate = pacient.original.birthdate;
							pacientObj.pacientDetailsDto = pacientDetObj;
							return pacientObj;
						}

						$scope.addConsult = function() {
							modalSrv.openModal('addConsult').then(function(resp) {
								console.log(resp);
								if (resp.operationPerformed === 'SUCCESS') {
									var consultObj = resp.resultContext;
									consultObj.pacientId = originalO.pacientId;
									consultObj.doctorId = originalO.doctorId;
									consultObj.consultationTime = new Date().getTime();
									$scope.pacient.edit.consultations.push({
										edit : consultObj,
										original : consultObj
									});
									$scope.pacient.original.consultations.push({
										edit : consultObj,
										original : consultObj
									});
									newConsutations.push(consultObj);
									checkForChanges();
								}
							});
						}
					} ]);
