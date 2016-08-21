angular.module('mainApp').factory('alert', function($uibModal) {

	function show(action, event) {
		var modal = null
		if (action === 'Edited') {
			modal = 'editEvent';
		}
		var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'app/calendar/' + modal + '.html',
			controller : modal + 'Ctrl',
			size : 'lg',
			resolve : {
				data : function() {
					return {
						'ev' : event
					};
				}
			}
		});
		modalInstance.result.then(function (selectedItem) {
		    scope.selected = selectedItem;
		  }, function () {
		    $log.info('Modal dismissed at: ' + new Date());
		  });
		return modalInstance;
	}

	return {
		show : show
	};

});
