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
						var delConsultIds = new Array();
						var newConsutations = new Array();
						var tempUndoDet;
						var tempUndoCons;
						init(pacientDetResp.data);

						function init(object) {
							var pacientObj = new Object();
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
								cons.editMode = false;
								delete cons.consultationId;
								delete cons.pacientId;
								delete cons.doctorId;
								delete cons.diagnostic;
								delete cons.observation;
								delete cons.price;
								delete cons.consultationTime;
							});
							pacientObj.original = {
								name : angular.copy(object.name),
								surname : object.surname,
								doctorId : angular.copy(object.doctorId),
								pacientId : angular.copy(object.pacientId),
								doctor : angular.copy(object.doctor),
								consultations : angular.copy(object.consultations),
								pacientDetailsDto : angular.copy(object.pacientDetailsDto)

							};
							pacientObj.edit = angular.copy(pacientObj.original);
							$scope.pacient = angular.copy(pacientObj);
							getDoctorsList();
						}

						function getDoctorsList() {
							srv.getDoctors().then(function(resp) {
								$scope.doctorsList = resp.data;
							});
						}

						// others
						$scope.saveConsult = function(cons) {
							tempUndoCons = angular.copy(cons.edit);
							checkForChanges();
						}

						$scope.deleteConsult = function(indx) {
							$scope.pacient.edit.consultations.splice(indx, 1);
							delConsultIds.push(indx);
							checkForChanges();
						}

						function checkForChanges() {
							$scope.hasChanged = !angular.equals($scope.pacient.original,
									$scope.pacient.edit);
							$scope.changesInConsultations = !angular.equals(
									$scope.pacient.original.consultations,
									$scope.pacient.edit.consultations);
						}

						$scope.saveEditPacient = function(pacient) {
							tempUndoDet = angular.copy(pacient.edit);
							checkForChanges();
							pacient.editMode = false;
						}

						$scope.resetDefault = function() {
							$scope.pacient.edit = angular.copy($scope.pacient.original);
							checkForChanges();
							delConsultIds = new Array();
							newConsutations = new Array();
						}

						function deleteConsults() {
							var q = $q.defer();
							if (delConsultIds.length > 0) {
								srv.deleteConsults(delConsultIds).then(function(resp) {
									q.resolve();
								}, function(err) {
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
								angular
										.forEach(
												newConsutations,
												function(newConsult) {
													newConsult.pacientId = angular
															.copy($scope.pacient.edit.pacientId);
													newConsult.doctorId = angular
															.copy($scope.pacient.edit.doctor.doctorId);
													srv
															.insertConsult(newConsult)
															.then(
																	function(resp) {
																		if (newConsutations.indexOf(newConsult) == newConsutations.length - 1) {
																			q.resolve();
																		}
																	},
																	function(err) {
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
									modalSrv
											.openModal('confirmation')
											.then(
													function(resp) {
														if ("OK" === resp.resultContext) {
															var withConsultations = !angular.equals(
																	pacient.edit.consultations,
																	pacient.original.consultations);
															var withDetail = $scope.hasChanged;
															$q
																	.all([ deleteConsults(), insertConsults() ])
																	.then(
																			function() {
																				srv
																						.saveAllPacientInDb(
																								createSaveAllChangesObj(pacient.edit),
																								withConsultations, withDetail)
																						.then(
																								function(response) {
																									$scope.pacient.original = angular
																											.copy(pacient.edit);
																									$scope.resetDefault();
																									$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
																								},
																								function(err) {
																									// $scope.resetDefault();
																									$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
																								});
																			});
														}
													}), function(err) {
										console.log(err);
									};
						}

						function createSaveAllChangesObj(obj) {
							var toRet = angular.copy(obj);
							toRet.doctorId = toRet.doctor.doctorId;
							delete toRet.editMode;
							for (var i = 0; i < toRet.consultations.length; i++) {
								toRet.consultations[i] = angular
										.copy(toRet.consultations[i].edit);
							}
							return toRet;
						}

						$scope.addConsult = function() {
							modalSrv.openModal('addConsult').then(
									function(resp) {
										console.log(resp);
										if (resp.operationPerformed === 'SUCCESS') {
											var consultObj = resp.resultContext;
											consultObj.pacientId = angular
													.copy($scope.pacient.pacientId);
											consultObj.doctorId = angular
													.copy($scope.pacient.doctorId);
											consultObj.consultationTime = new Date().getTime();
											$scope.pacient.edit.consultations.push({
												edit : angular.copy(consultObj),
												original : angular.copy(consultObj)
											});
											newConsutations.push(consultObj);
											checkForChanges();
										}
									});
						}
						$scope.undoPacientDetailsChanges = function() {
							if (angular.isUndefined(tempUndoDet)) {
								tempUndoDet = angular.copy($scope.pacient.original);
							}
							$scope.pacient.edit.name = angular.copy(tempUndoDet.name);
							$scope.pacient.edit.surname = angular.copy(tempUndoDet.surname);
							$scope.pacient.edit.pacientDetailsDto = angular
									.copy(tempUndoDet.pacientDetailsDto);
							$scope.pacient.edit.doctor = angular.copy(tempUndoDet.doctor);
							tempUndoDet = angular.copy($scope.pacient.edit);
							checkForChanges();
						}

						$scope.undoPacientConsultChanges = function(consult) {
							if (angular.isUndefined(tempUndoCons)) {
								tempUndoCons = angular.copy(consult.original);
							}
							consult.edit = angular.copy(tempUndoCons);
							tempUndoCons = angular.copy(consult.edit);
							checkForChanges();
						}
					} ]);
