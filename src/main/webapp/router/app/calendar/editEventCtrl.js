/*var angular = require('angular');*/
angular.module('mainApp').controller('editEventCtrl', function($scope, $uibModalInstance, data ) {
	$scope.action = 'Edited';
	$scope.event = data.ev;
	var yourData = 'aaa';
	$scope.test = function() {
		alert('edit');
	}
	
	$scope.ok = function(){
		$uibModalInstance.close(yourData);
	}
	
	 $scope.cancel = function () {
		 $uibModalInstance.dismiss('cancel');
     };
});
