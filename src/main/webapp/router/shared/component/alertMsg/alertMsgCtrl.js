angular.module('mainApp').controller(
		'alertMsgCtrl',
		[ '$scope', '$rootScope', '$interval',
			function($scope, $rootScope, $interval) {
			
			$scope.closeAlert = function(){
				$rootScope.alertIsOn = false;
			}
			
				$scope.$watch(function() {
					if($rootScope.alertIsOn){
						$interval($scope.closeAlert, 10000);
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
