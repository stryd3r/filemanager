angular.module('mainApp').controller(
		'addNewEventCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance', 'modalService',
			function($scope, APPCONST, srv, $uibModalInstance, modalService) {
				$scope.ok = function(event) {

					modalService.openModal('confirmation').then(function(resp) {
						if ("OK" === resp.resultContext) {
							$uibModalInstance.close(event);
						} else {
							$uibModalInstance.dismiss('cancel');
						}

					});
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
