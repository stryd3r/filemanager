(function() {
	var mainApp = angular.module('mainApp', ['ui.bootstrap']);
	
	angular.module('mainApp').service('serviceProvider', [ '$http',  function($http) {
		
		 this.firstService = function(){
	            return $http.post("http://localhost:8080/filemanager/getUserDetails");
	        }
	}]);

	mainApp.controller('mainController', [ '$scope','serviceProvider', function($scope, serviceProvider) {

		function init(){
			serviceProvider.firstService().then(function(data) {
		            
						alert(data.data.name);
		            }, function(error) {
		            	alert("not-ok");
		            });
		};
		
		init();
    } ]);
}());