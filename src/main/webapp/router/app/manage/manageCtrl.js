angular
		.module('mainApp')
		.controller(
				'manageCtrl',
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
						init();
						function init() {
							initPagination();
							// init list of pacients
							srv.getPacients().then(function(res) {
								angular.forEach(res.data, function(elem) {
									elem.editMode = false;
									elem.original = {};
									elem.original.name = elem.name;
									elem.original.surname = elem.surname;
									delete elem.name;
									delete elem.surname;
									delete elem.doctorId;
									delete elem.consultations;
									delete elem.pacientDetailsDto;
									delete doctorId;
								});
								pacientsList = res.data;
								$scope.paginatedPacientsList = res.data;
								$scope.totalItems = res.data.length;
								// performPagination($scope.paginatedPacientsList);
								$scope.pageChanged();
							});
						}

						function initPagination() {
							$scope.currentPage = 1;
							$scope.itemsPerPage = 10;
							$scope.maxNumPage = 1;
							$scope.maxSize = 10;
						}
						;

						$scope.saveEdit = function(pacient) {
							var pacientToUp = angular.copy(pacient.edit);
							pacientToUp.doctorId = pacient.doctor.doctorId;
							pacientToUp.pacientId = pacient.pacientId;
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.updatePacient(pacientToUp).then(function(resp) {
										var index = $scope.paginatedPacientsList.indexOf(pacient);
										pacientsList[index].original.name = pacientToUp.name;
										pacientsList[index].original.surname = pacientToUp.surname;
										pacient.editMode = false;
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}

						$scope.deletePacient = function(pacient) {

							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.removePacient(pacient.pacientId).then(function(resp) {
										var index = pacientsList.indexOf(pacient);
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
							modalSrv.openModal("addPacient", pacientsList).then(
									function(res) {
										console.log(res);
										var newPacient = {
											editMode : false,
											original : res.resultContext
										};
										if (res.operationPerformed == 'SUCCESS') {
											srv.insertPacient(newPacient.original).then(
													function(resp) {
														newPacient.pacientId = resp.data;
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
							$state.go('pacient',
									{
										'name' : pacient.original.name + '_'
												+ pacient.original.surname,
										idPacient : pacient.pacientId
									});
						}

						$scope.openInfoPacientModal = function(pacient) {
							modalSrv.openModal("infoPacient", pacient).then(function(res) {
								console.log(res);
							});
						}

						$scope.pageChanged = function() {
							filteredList = $filter('filter')(pacientsList,
									$scope.searchPacient);
							filteredList = $filter('orderBy')(filteredList, 'original.name');
							pacientsList = $filter('orderBy')(pacientsList, 'original.name');
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

					} ]);
