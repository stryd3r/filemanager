(function() {
	
	angular.module('mainApp').controller('routerController', [ '$scope', 'serviceProvider', function($scope, serviceProvider) {

		$scope.name = "Adrian";
		$scope.showPage = true;
	} ]);
}());