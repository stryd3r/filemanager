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
								$scope.pacientsList = res.data;
								$scope.paginatedPacientsList = res.data;
								$scope.totalItems = res.data.length;
								performPagination($scope.paginatedPacientsList);
							});
						}
						
						function initPagination() {
							$scope.currentPage = 1;
							$scope.itemsPerPage = 10;
							$scope.maxNumPage = 1;
							$scope.maxSize = 10;
						};

						$scope.saveEdit = function(pacient) {
							var pacientToUp = angular.copy(pacient.edit);
							pacientToUp.doctorId = pacient.doctor.doctorId;
							pacientToUp.pacientId = pacient.pacientId;
							var index = $scope.paginatedPacientsList.indexOf(pacient);
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.updatePacient(pacientToUp).then(function(resp) {
										$scope.paginatedPacientsList[index].original = pacientToUp;
										pacient.editMode = false;
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
							$scope.pageChanged();
						}

						$scope.deletePacient = function(pacient) {
							var index = $scope.pacientsList.indexOf(pacient);
							$scope.pacientsList.splice(index, 1);
							$scope.pageChanged();
						}

						$scope.openAddPacientModal = function() {
							console.log(APPCONST.MODALS);
							modalSrv.openModal("addPacient", $scope.pacientsList).then(
									function(res) {
										console.log(res);
										var newPacient = {
											editMode : false,
											original : res.resultContext
										};
										if (res.operationPerformed == 'SUCCESS') {
											$scope.pacientsList.push(newPacient);
											$scope.pageChanged();
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
							filteredList = $filter('filter')($scope.pacientsList,
									$scope.searchPacient);
							filteredList = $filter('orderBy')(filteredList, 'original.name');
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
