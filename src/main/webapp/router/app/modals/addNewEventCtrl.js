angular.module('mainApp')
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
						var selectedDoctor;
						var selectedPacient;
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
									var color = {primary:selectedDoctor.color, secondary:selectedDoctor.color}
									event.color = color;
									event.doctorName = selectedDoctor.name + ' ' + selectedDoctor.surname
									//event.pacientName = selectedPacient.name + ' ' + selectedPacient.surname
									$uibModalInstance.close(event);
								} else {
									$uibModalInstance.dismiss('cancel');
								}

							});
						}
						$scope.change = function(model, type) {
							var name = model.name + ' ' + model.surname;
							if (type == 'pac') {
								$scope.dropBtnPac = name;
								selectedPacient = model;
								$scope.isOpenPac = false;
							} else if (type == 'doc') {
								$scope.dropBtnDoc = name;
								selectedDoctor = model;
								$scope.isOpenDoc = false;
							}
						}

						$scope.search = function(searchItem, type) {
							if(type == 'pac'){
								$scope.pacientsList = $filter('filter')(
										angular.copy(originalPacients), searchItem);
							}else if (type == 'doc'){
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
