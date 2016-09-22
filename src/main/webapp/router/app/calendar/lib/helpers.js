angular.module('mainApp').factory('alert', function($uibModal, modalService) {

	function show(action, event) {
		var modal = null
		if (action === 'Edited') {
			modal = 'editEv';
		}
		/*modalService.openModal("editEv",event,'lg').then(function(res){
			console.log(res);
			return res;
		});*/
		var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'app/modals/' + modal + '.html',
			controller : modal + 'Ctrl',
			size : 'lg',
			resolve : {
				item : function() {
					return {
						'ev' : event
					};
				}
			}
		});
		modalInstance.result.then(function (selectedItem) {
		    //scope.selected = selectedItem;
		  }, function () {
		    $log.info('Modal dismissed at: ' + new Date());
		  });
		return modalInstance;
	}

	return {
		show : show
	};

});
