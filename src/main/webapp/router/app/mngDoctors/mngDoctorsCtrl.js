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
						var tempUndoDoc;
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
									elem.original.doctorId = elem.doctorId;
									elem.edit = angular.copy(elem.original);
									delete elem.name;
									delete elem.surname;
									delete elem.color;
									delete elem.doctorId;
								});
								doctorsList = angular.copy(resp.data);
								$scope.paginatedPacientsList = angular.copy(resp.data);
								$scope.totalItems = angular.copy(resp.data.length);
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
							filteredList = $filter('orderBy')(filteredList, 'edit.name');
							doctorsList = $filter('orderBy')(doctorsList, 'edit.name');
							performPagination(filteredList);
							$scope.totalItems = filteredList.length;
						}

						function getIndex(list, elem) {
							for (var i = 0; i < list.length; i++) {
								if (angular.equals(list[i].edit.doctorId, elem.doctorId)) {
									return i;
								}
							}
						}

						$scope.saveEdit = function(doctor) {
							// var doctorToUp = angular.copy(doctor.edit);
							// doctorToUp.doctorId = doctor.doctorId;
							modalSrv.openModal("confirmation").then(function(resp) {
								if ("OK" === resp.resultContext) {
									srv.updateDoctor(doctor.edit).then(function(resp) {
										var index = getIndex(doctorsList, doctor.edit);
										doctorsList[index].edit = angular.copy(doctor.edit);
										doctorsList[index].original = angular.copy(doctor.edit);
										tempUndoDoc = angular.copy(doctor.edit);
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
									edit : angular.copy(res.resultContext),
									original : angular.copy(res.resultContext)
								};
								if (res.operationPerformed == 'SUCCESS') {
									srv.insertDoctor(newDoctor.edit).then(function(resp) {
										newDoctor.edit.doctorId = resp.data;
										newDoctor.original.doctorId = resp.data;
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
									srv.removeDoctor(doctor.edit.doctorId).then(function(resp) {
										var index = getIndex(doctorsList, doctor.edit);
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

						$scope.openInfoDoctorModal = function(doctor) {
							modalSrv.openModal("infoDoctor", doctor).then(function(resp) {
								console.log(resp.resultContext.operationPerformed);
							}, function(err) {
								$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
							});
						}

						$scope.undoDocChanges = function(doc) {
							if (angular.isUndefined(tempUndoDoc)) {
								tempUndoDoc = angular.copy(doc.original);
							}
							doc.edit = angular.copy(tempUndoDoc);
							tempUndoDoc = angular.copy(doc.edit);
						}

					} ]);
