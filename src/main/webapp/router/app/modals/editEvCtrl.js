angular
		.module('mainApp')
		.controller(
				'editEvCtrl',
				[
					'$scope',
					'APPCONST',
					'mainService',
					'$uibModalInstance',
					'alert',
					'modalService',
					'item',
					function($scope, APPCONST, srv, $uibModalInstance, alert,
							modalService, item) {
						$scope.selectedDoctor;
						$scope.selectedPacient;
						console.log(item);
						// alert.show('EDIT EVENT', item.calendarItem);
						init();

						function init() {
							$scope.eventEdit = angular.copy(item);
							srv
									.getPacients()
									.then(
											function(resp) {
												$scope.pacientsList = resp.data;
												$scope.dropBtnPac = !angular
														.isUndefined($scope.eventEdit.pacientName) ? $scope.eventEdit.pacientName
														: 'Pacient';
												$scope.selectedPacient = $scope.eventEdit.pacient;
											});

							srv.getDoctors().then(function(resp) {
								$scope.doctorsList = resp.data;
								$scope.dropBtnDoc = $scope.eventEdit.doctorName;
								$scope.selectedDoctor = $scope.eventEdit.doctor;
							});
						}

						$scope.ok = function() {
							modalService.openModal('confirmation').then(function(resp) {
								if ("OK" === resp.resultContext) {
									normalizeEdit();
									$uibModalInstance.close($scope.eventEdit);
								} else {
									$uibModalInstance.dismiss('cancel');
								}
							});
						};

						function normalizeEdit() {
							var color = {
								primary : $scope.selectedDoctor.color,
								secondary : $scope.selectedDoctor.color
							}
							$scope.eventEdit.color = color;
							$scope.eventEdit.doctorName = $scope.selectedDoctor.name + ' '
									+ $scope.selectedDoctor.surname
							if (!angular.isUndefined($scope.selectedPacient)) {
								$scope.eventEdit.pacientName = $scope.selectedPacient.name
										+ ' ' + $scope.selectedPacient.surname;
							}
							$scope.eventEdit.title = (!angular
									.isUndefined($scope.eventEdit.pacientName) ? $scope.eventEdit.pacientName
									: '')
									+ ' '
									+ (!angular.isUndefined($scope.eventEdit.descr)
											&& $scope.eventEdit.descr != '' ? '('
											+ $scope.eventEdit.descr + ')' : '');
						}

						$scope.cancel = function() {
							$uibModalInstance.dismiss('cancel');
						};

						$scope.deleteEvent = function() {
							$uibModalInstance.close("DELETE");
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

						$scope.toggle = function($event, field, event) {
							$event.preventDefault();
							$event.stopPropagation();
							event[field] = !event[field];
						};
					} ]);
