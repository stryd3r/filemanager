// Please note that $modalInstance represents a modal window (instance)
// dependency.
// It is not the same as the $uibModal service used above.
angular.module('mainModule').controller('datePickerFilterCtrl', ['APPCONST', '$scope', 'mainService','$rootScope',
		function(appConst, $scope, service, $rootScope) {
	 // datePicker
	  //Disable weekend selection
	  $scope.disabled = function(date, mode) {
	    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	  };

	  $scope.open = function($event, status, absence) {
		  if(status ==="absenceFrom"){
			  absence.calendarFromOpened=true;
		  }else if(status ==="absenceTo"){
			  absence.calendarToOpened=true;  
		  }else if(status === 'statusFrom'){
			  $scope.status.openedFrom = true;
			  $scope.status.openedTo = false; 
		  }else{
			  $scope.status.openedFrom = false;
			  $scope.status.openedTo = true;   
		  } 
	  };

	  $scope.status = {
	    openedFrom: false,
	    openedTo: false,
	    openedInput: false
	  };
	  
	  $scope.setDateValues = function(){
		  /*service.setDateFrom($scope.dateFrom);
		  service.setDateTo($scope.dateTo);*/
		  $rootScope.$broadcast('populatedDates',$scope.dateFrom, $scope.dateTo);
	  }
	  //end of datePicker
		}]).directive('datePickerFilter', function(){
			return{
				scope:{
	                /* NOTE: Normally I would set my attributes and bindings
	                to be the same name but I wanted to delineate between 
	                parent and isolated scope.                 
	                isolatedAttributeFoo:'@attributeFoo',
	                isolatedBindingFoo:'=bindingFoo',
	                isolatedExpressionFoo:'&',*/
	                isolatedDateFrom:'=dateFrom',
	                isolatedDateTo:'=dateTo'
	            },
				templateUrl: 'app/components/directives/datePickerFilter.html'
			};
		});