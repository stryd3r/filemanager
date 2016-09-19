angular.module('mainApp').controller(
		'addNewEventCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance', 'item',
				function($scope, APPCONST, srv, $uibModalInstance, item) {
					console.log(item);
					$scope.ok = function(event) {
						$uibModalInstance.close(event);
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};

					$scope.toggle = function($event, field, event) {
						$event.preventDefault();
						$event.stopPropagation();
						event[field] = !event[field];
					};
				} ]);
