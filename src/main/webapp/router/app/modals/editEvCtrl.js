angular.module('mainApp').controller(
		'editEvCtrl',
		[ '$scope', 'APPCONST', 'mainService', '$uibModalInstance','alert', 'item',
				function($scope, APPCONST, srv, $uibModalInstance,alert, item) {
					console.log(item);
					//alert.show('EDIT EVENT', item.calendarItem);
					$scope.calendarEv = item.calendarEvent;
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
