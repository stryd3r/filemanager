angular.module('mainApp').controller(
		'alertMsgCtrl',
		[ '$scope', '$rootScope', '$interval',
			function($scope, $rootScope, $interval) {
				var promise;
				$scope.closeAlert = function() {
					$rootScope.alertIsOn = false;
				}
				function startIntrv() {
					stopIntrv();
					promise = $interval($scope.closeAlert, 10000);
				}
				function stopIntrv() {
					$interval.cancel(promise);
				}
				$scope.$watch(function() {
					if ($rootScope.alertIsOn) {
						$scope.errorMsg = $rootScope.alertMsg;
						startIntrv();
					}
					return $rootScope.alertIsOn;
				}, function() {
					$scope.alertIsOn = $rootScope.alertIsOn;
				}, true);

			} ]).directive('alertMsg', function() {
	return {
		templateUrl : 'shared/component/alertMsg/alertMsg.html'
	};
});
