angular.module('mainApp').controller('testRestCtrl',
		[ '$scope', '$http', function($scope, $http) {
			$scope.getPacienti = function() {
				$http.get('https://httpbin.org/get').then(function(res) {
					$scope.status1 = res.status;
				});
			}
			$scope.getPacientiPost = function() {
				$http.post('https://httpbin.org/post').then(function(res) {
					$scope.status2 = res.status;
				});
			}
		} ]);
