angular
		.module('mainApp')
		.controller(
				'mngDoctorsCtrl',
				[
					'$scope',
					'$rootScope',
					'APPCONST',
					'mainService',
					'modalService',
					'$state',
					'$filter',
					function($scope, $rootScope, APPCONST, srv, modalSrv, $state, $filter) {
						var doctorsList;
						var filteredList;
						init();
						initPagination();
						function init() {
							$scope.doctorsActive = true;
							srv.getDoctors().then(function(resp) {
								angular.forEach(resp.data, function(elem) {
									elem.editMode = false;
									elem.original = {};
									elem.original.name = elem.name;
									elem.original.surname = elem.surname;
									elem.original.color = elem.color;
									elem.edit = angular.copy(elem.original);
									delete elem.name;
									delete elem.surname;
									delete elem.color;
								});
								doctorsList = resp.data;
								$scope.paginatedPacientsList = resp.data;
								$scope.totalItems = resp.data.length;
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

						$scope.pageChanged = function() {
							filteredList = $filter('filter')
									(doctorsList, $scope.searchDoctor);
							filteredList = $filter('orderBy')(filteredList, 'original.name');
							doctorsList = $filter('orderBy')(doctorsList, 'original.name');
							performPagination(filteredList);
							$scope.totalItems = filteredList.length;
						}

						function getIndex(list, elem) {
							for (var i = 0; i < list.length; i++) {
								if (angular.equals(list[i].doctorId, elem.doctorId)) {
									return i;
								}
							}
						}

						$scope.saveEdit = function(doctor) {
							var doctorToUp = angular.copy(doctor.edit);
							doctorToUp.doctorId = doctor.doctorId;
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.updateDoctor(doctorToUp).then(function(resp) {
										var index = getIndex(doctorsList, doctor);
										doctorsList[index].original.name = doctorToUp.name;
										doctorsList[index].original.surname = doctorToUp.surname;
										doctorsList[index].original.color = doctorToUp.color;
										doctor.editMode = false;
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}

						$scope.openAddDoctorModal = function() {
							modalSrv.openModal("addDoctor").then(function(res) {
								console.log(res);
								var newDoctor = {
									editMode : false,
									original : res.resultContext
								};
								if (res.operationPerformed == 'SUCCESS') {
									srv.insertDoctor(newDoctor.original).then(function(resp) {
										newDoctor.doctorId = resp.data;
										doctorsList.push(newDoctor);
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}

						$scope.deleteDoctor = function(doctor) {
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.removeDoctor(doctor.doctorId).then(function(resp) {
										var index = getIndex(doctorsList, doctor);
										doctorsList.splice(index, 1);
										$scope.pageChanged();
										$rootScope.alertIsOn = APPCONST.ALERT.SUCCESS;
									}, function(err) {
										$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
									});
								}
							});
						}

						var performPagination = function(list) {
							if (list != null && list.length > 0) {
								var begin = (($scope.currentPage - 1) * $scope.itemsPerPage), end = begin
										+ $scope.itemsPerPage;
								$scope.paginatedDoctorsList = angular.copy(list.slice(begin,
										end));
							} else {
								$scope.paginatedDoctorsList = list;
							}
						};

					} ]);
