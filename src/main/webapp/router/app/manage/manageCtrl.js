angular.module('mainApp').controller('manageCtrl',
		[ '$scope', '$state', 'mainService', function($scope, $state, srv) {
			srv.getPacients().then(function(res) {
				angular.forEach(res.data, function(elem) {
					elem.editMode = false;
				});
				$scope.pacientsList = res.data;
			});
		} ]);
