angular
		.module('mainApp')
		.controller(
				'addNewEventCtrl',
				[
					'$scope',
					'APPCONST',
					'mainService',
					'$uibModalInstance',
					'modalService',
					'$filter',
					function($scope, APPCONST, srv, $uibModalInstance, modalService,
							$filter) {
						var originalPacients;
						var originalDoctors;
						$scope.selectedDoctor;
						$scope.selectedPacient;
						$scope.dropBtnPac = "Pacient: ";
						$scope.dropBtnDoc = "Doctor: ";
						init();
						function init() {
							srv.getPacients().then(function(resp) {
								$scope.pacientsList = resp.data;
								originalPacients = angular.copy($scope.pacientsList);
							});

							srv.getDoctors().then(function(resp) {
								$scope.doctorsList = resp.data;
								originalDoctors = angular.copy($scope.doctorsList);
							});
						}

						$scope.ok = function(event) {
							modalService.openModal('confirmation').then(function(resp) {
								if ("OK" === resp.resultContext) {
									normalizeEdit(event);
									$uibModalInstance.close(event);
								} else {
									$uibModalInstance.dismiss('cancel');
								}

							});
						}

						function normalizeEdit(event) {
							var color = {
								primary : $scope.selectedDoctor.color,
								secondary : $scope.selectedDoctor.color
							}
							event.color = color;
							event.doctorName = $scope.selectedDoctor.name + ' '
									+ $scope.selectedDoctor.surname;
							event.doctor = $scope.selectedDoctor;
							if (!angular.isUndefined($scope.selectedPacient)) {
								event.pacient = $scope.selectedPacient;
								event.pacientName = $scope.selectedPacient.name + ' '
										+ $scope.selectedPacient.surname;
							}
							event.title = (!angular.isUndefined(event.pacient) ? event.pacientName
									: '')
									+ ' '
									+ (!angular.isUndefined(event.descr) && event.descr != '' ? '('
											+ event.descr + ')'
											: '');
						}

						$scope.change = function(model, type) {
							var name = model.name + ' ' + model.surname;
							if (type == 'pac') {
								$scope.dropBtnPac = name;
								$scope.selectedPacient = model;
								$scope.isOpenPac = false;
							} else if (type == 'doc') {
								$scope.dropBtnDoc = name;
								$scope.selectedDoctor = model;
								$scope.isOpenDoc = false;
							}
						}

						$scope.search = function(searchItem, type) {
							if (type == 'pac') {
								$scope.pacientsList = $filter('filter')(
										angular.copy(originalPacients), searchItem);
							} else if (type == 'doc') {
								$scope.doctorsList = $filter('filter')(
										angular.copy(originalDoctors), searchItem);
							}
						}

						$scope.cancel = function() {
							$uibModalInstance.dismiss('cancel');
						};

						$scope.toggle = function($event, field, event) {
							$event.preventDefault();
							$event.stopPropagation();
							event[field] = !event[field];
						};
					} ]);
