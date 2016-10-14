angular.module('mainApp').controller(
		'addPacientCtrl',
		[
			'$scope',
			'APPCONST',
			'mainService',
			'$uibModalInstance',
			'$filter',
			'modalService',
			'item',
			function($scope, APPCONST, srv, $uibModalInstance, $filter, modalService,
					item) {
				console.log(item);
				var originalDoctors;
				var doc;
				$scope.addPacientObj = new Object();
				init();
				function init() {
					$scope.dropBtnDoc = "Doctor";
					srv.getDoctors().then(function(resp) {
						$scope.doctorsList = resp.data;
						originalDoctors = angular.copy($scope.doctorsList);
					});
				}

				$scope.search = function(searchItem) {
					$scope.doctorsList = $filter('filter')(angular.copy(originalDoctors),
							searchItem);
				}

				$scope.change = function(model) {
					doc = model;
					$scope.addPacientObj.doctorId = model.doctorId;
					var name = doc.name + ' ' + doc.surname;
					$scope.dropBtnDoc = name;
					$scope.isOpenDoc = false;
				}

				$scope.ok = function(newPacient) {
					modalService.openModal('confirmation').then(function(resp) {
						if ("OK" === resp.resultContext) {
							$uibModalInstance.close(newPacient);
						}
					});
				};

				$scope.cancel = function() {
					$uibModalInstance.dismiss('cancel');
				};
			} ]);
