angular.module('mainApp').controller('testRestCtrl',
		[ '$scope', '$http', function($scope, $http) {
			$scope.getPacienti = function() {
				$http.get('shared/mock/json/pacienti.json').then(function(res) {
					$scope.status1 = res.status;
				});
			}
		} ]);
