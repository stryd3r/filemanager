angular.module('mainApp').controller('manageCtrl',
		[ '$scope', '$state', 'mainService', function($scope, $state, srv) {
			srv.getPacients().then(function(res) {
				$scope.pacientsList = res.data;
			});
		} ]);
