angular
		.module('mainApp')
		.controller(
				'manageCtrl',
				[
					'$scope',
					'APPCONST',
					'mainService',
					'modalService',
					'$state',
					'$filter',
					function($scope, APPCONST, srv, modalSrv, $state, $filter) {
						var filteredList = null
						var initPagination = function() {
							$scope.currentPage = 1;
							$scope.itemsPerPage = 10;
							$scope.maxNumPage = 1;
							$scope.maxSize = 10;
						};
						initPagination();
						// init list of pacients
						srv.getPacients().then(function(res) {
							angular.forEach(res.data, function(elem) {
								elem.editMode = false;
								elem.original = {};
								elem.original.firstName = elem.name;
								elem.original.lastName = elem.surname;
								//elem.original.seria = elem.seria;
								delete elem.name;
								delete elem.surname;
								//delete elem.seria;
							});
							$scope.pacientsList = res.data;
							$scope.paginatedPacientsList = res.data;
							$scope.totalItems = res.data.length;
							performPagination($scope.paginatedPacientsList);
						});
						$scope.saveEdit = function(pacient) {
							// TODO create saving pacient object
							var index = $scope.paginatedPacientsList.indexOf(pacient);
							$scope.paginatedPacientsList[index].original = angular
									.copy(pacient.editPacient);
							// $scope.pacientsList =
							// $filter('filter')($scope.pacientsList,$scope.searchPacient);
							pacient.editMode = false;
							// $scope.pageChanged();
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
										if (res.resultContext.operationPerformed != 'ABORTED') {
											$scope.pacientsList.push(newPacient);
											$scope.pageChanged();
										}
									});
						}
						$scope.goToPacientPage = function(pacient) {
							$state.go('pacient',
									{
										'name' : pacient.original.firstName
												+ '_' + pacient.original.lastName,
										'idPacient' : pacient.pacientId
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
							filteredList = $filter('orderBy')(filteredList,
									'original.firstName');
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
