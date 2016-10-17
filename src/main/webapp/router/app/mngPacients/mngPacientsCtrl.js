angular
		.module('mainApp')
		.controller(
				'mngPacientsCtrl',
				[
					'$scope',
					'$rootScope',
					'APPCONST',
					'mainService',
					'modalService',
					'$state',
					'$filter',
					function($scope, $rootScope, APPCONST, srv, modalSrv, $state, $filter) {
						var filteredList = null;
						var pacientsList;
						var tempUndoPac;
						init();
						function init() {
							$scope.pacientsActive = true;
							initPagination();
							// init list of pacients
							srv.getPacients().then(function(res) {
								angular.forEach(res.data, function(elem) {
									elem.editMode = false;
									elem.original = {};
									elem.original.name = elem.name;
									elem.original.surname = elem.surname;
									elem.original.doctorId = elem.doctorId;
									elem.original.pacientId = elem.pacientId;
									elem.edit = angular.copy(elem.original);
									delete elem.name;
									delete elem.surname;
									delete elem.doctorId;
									delete elem.pacientId;
									delete elem.consultations;
									delete elem.pacientDetailsDto;
									delete elem.doctor;
								});
								pacientsList = angular.copy(res.data);
								$scope.paginatedPacientsList = angular.copy(res.data);
								$scope.totalItems = angular.copy(res.data.length);
								$scope.pageChanged();
							});
						}

						function initPagination() {
							$scope.currentPage = 1;
							$scope.itemsPerPage = 10;
							$scope.maxNumPage = 1;
							$scope.maxSize = 10;
						}

						$scope.saveEdit = function(pacient) {
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.updatePacient(pacient.edit).then(function(resp) {
										var index = getIndex(pacientsList, pacient.edit);
										pacientsList[index].edit = angular.copy(pacient.edit);
										pacientsList[index].original = angular.copy(pacient.edit);
										pacient.editMode = false;
										tempUndoPac = angular.copy(pacient.edit);
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}

						function getIndex(list, elem) {
							for (var i = 0; i < list.length; i++) {
								if (angular.equals(list[i].edit.pacientId, elem.pacientId)) {
									return i;
								}
							}
						}

						$scope.deletePacient = function(pacient) {
							modalSrv.openModal("confirmation").then(
									function(resp) {
										if ("OK" === resp.resultContext) {
											srv.removePacient(pacient.edit.pacientId).then(
													function(resp) {
														var index = getIndex(pacientsList, pacient.edit); // pacientsList.indexOf(pacient);
														pacientsList.splice(index, 1);
														$scope.pageChanged();
														$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
													}, function(err) {
														$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
													});
										}
									});
						}

						$scope.openAddPacientModal = function() {
							console.log(APPCONST.MODALS);
							modalSrv.openModal("addPacient").then(function(res) {
								console.log(res);
								var newPacient = {
									editMode : false,
									original : angular.copy(res.resultContext),
									edit : angular.copy(res.resultContext)
								};
								if (res.operationPerformed == 'SUCCESS') {
									srv.insertPacient(newPacient.edit).then(function(resp) {
										newPacient.edit.pacientId = angular.copy(resp.data);
										newPacient.original.pacientId = angular.copy(resp.data);
										pacientsList.push(newPacient);
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}
						$scope.goToPacientPage = function(pacient) {
							$state.go('pacient', {
								'name' : pacient.edit.name + '_' + pacient.edit.surname,
								idPacient : pacient.edit.pacientId
							});
						}

						$scope.openInfoPacientModal = function(pacient) {
							srv.getDoctorById(pacient.edit.doctorId).then(function(resp) {
								console.log(resp);
								var doctor = resp.data;
								modalSrv.openModal("infoPacient", doctor).then(function(resp) {
									console.log(resp.resultContext.operationPerformed);
								}, function(err) {
									$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
								});
							}, function(err) {
								$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
								$rootScope.alertMsg = "Info pacient modal problem: " + err.statusText;
							});
						}

						$scope.pageChanged = function() {
							filteredList = $filter('filter')(pacientsList,
									$scope.searchPacient);
							filteredList = $filter('orderBy')(filteredList, 'edit.name');
							pacientsList = $filter('orderBy')(pacientsList, 'edit.name');
							performPagination(filteredList);
							$scope.totalItems = filteredList.length;
						}

						var performPagination = function(list) {
							if (list != null && list.length > 0) {
								var begin = (($scope.currentPage - 1) * $scope.itemsPerPage), end = begin
										+ $scope.itemsPerPage;
								$scope.paginatedPacientsList = angular.copy(list.slice(begin,
										end));
							} else {
								$scope.paginatedPacientsList = list;
							}
						};

						$scope.undoPacChanges = function(pac) {
							if (angular.isUndefined(tempUndoPac)) {
								tempUndoPac = angular.copy(pac.original);
							}
							pac.edit = angular.copy(tempUndoPac);
							tempUndoPac = angular.copy(pac.edit);
						}

					} ]);
