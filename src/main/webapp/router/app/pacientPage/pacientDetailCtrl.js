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
						var tempUndoCons = new Array();
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
								consultations : angular.isUndefined(object.consultations)
										|| object.consultations == null ? new Array() : angular
										.copy(object.consultations),
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

						function getIndex(list, elem) {
							for (var i = 0; i < list.length; i++) {
								if (angular.equals(list[i].edit.consultationId,
										elem.consultationId)) {
									return i;
								}
							}
						}

						// others
						$scope.saveConsult = function(cons) {
							var index = getIndex($scope.pacient.edit.consultations, cons.edit);
							tempUndoCons[index] = angular.copy(cons.edit);
							checkForChanges();
						}

						$scope.deleteConsult = function(cons) {
							if (!angular.isUndefined(cons.edit.consultationId)) {
								delConsultIds.push(cons.edit.consultationId);
							}
							$scope.pacient.edit.consultations.splice(
									$scope.pacient.edit.consultations.indexOf(cons), 1);
							newConsutations.splice(newConsutations.indexOf(cons), 1);
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
								angular
										.forEach(
												delConsultIds,
												function(cId) {
													srv
															.deleteConsult(cId)
															.then(
																	function(resp) {
																		if (delConsultIds.indexOf(cId) == delConsultIds.length - 1) {
																			q.resolve();
																		}
																	},
																	function(err) {
																		$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
																		$rootScope.alertMsg = "Consultation problem: "
																				+ err.statusText;
																		$q.reject();
																	});
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
													newConsult.toInsert.pacientId = angular
															.copy($scope.pacient.edit.pacientId);
													newConsult.toInsert.doctorId = angular
															.copy($scope.pacient.edit.doctor.doctorId);
													srv
															.insertConsult(newConsult.toInsert)
															.then(
																	function(resp) {
																		$scope.pacient.edit.consultations[newConsult.index].edit.consultationId = angular
																				.copy(resp.data);
																		if (newConsutations.indexOf(newConsult) == newConsutations.length - 1) {
																			q.resolve();
																		}
																	},
																	function(err) {
																		// $scope.resetDefault();
																		$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
																		$rootScope.alertMsg = "Consultation problem: "
																				+ err.statusText;
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
															var withDetail = !angular.equals(
																	pacient.edit.pacientDetailsDto,
																	pacient.original.pacientDetailsDto);
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
							if (angular.isUndefined(toRet.pacientDetailsDto)
									|| toRet.pacientDetailsDto == null) {
								toRet.pacientDetailsDto = new Object();
							}
							if (angular.isUndefined(toRet.pacientDetailsDto.pacientId)) {
								toRet.pacientDetailsDto.pacientId = toRet.pacientId;
							}
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
													.copy($scope.pacient.edit.pacientId);
											consultObj.doctorId = angular
													.copy($scope.pacient.edit.doctorId);
											consultObj.consultationTime = new Date().getTime();
											var toPush = {
												edit : angular.copy(consultObj),
												original : angular.copy(consultObj)
											};
											$scope.pacient.edit.consultations.push(toPush);
											checkForChanges();
											newConsutations.push({
												index : $scope.pacient.edit.consultations
														.indexOf(toPush),
												toInsert : consultObj
											});
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
							var index = getIndex($scope.pacient.edit.consultations,
									consult.edit);
							if (angular.isUndefined(tempUndoCons[index])) {
								tempUndoCons[index] = angular.copy(consult.original);
							}
							consult.edit = angular.copy(tempUndoCons[index]);
							tempUndoCons[index] = angular.copy(consult.edit);
							checkForChanges();
						}
					} ]);
