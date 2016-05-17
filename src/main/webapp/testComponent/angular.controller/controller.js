(function() {
	var mainApp = angular.module('mainApp', ['ui.bootstrap']);
	
	
	mainApp.controller('mainController', [ '$scope','serviceProvider', function($scope, serviceProvider) {

		function init(){
			 
			 var workDetails = new Object();
			 workDetails.occupation = "Programmer";
			 workDetails.experience = "2";
	            
			serviceProvider.secondService(workDetails).then(function(data) {
		            
						alert(data.data.surname);
		            }, function(error) {
		            	alert("not-ok");
		            });
		};
		
		init();
    } ]);
}());