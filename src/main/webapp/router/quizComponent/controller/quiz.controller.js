(function() {
	var mainApp = angular.module('mainApp', [ 'ui.bootstrap' ]);
	
	mainApp.controller('routerController', [ '$scope', 'serviceProvider', function($scope, serviceProvider) {

		$scope.name = "Adrian";
		$scope.showPage = true;
	} ]);
}());