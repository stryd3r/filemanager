(function() {
	angular.module('mainApp').service('serviceProvider', [ '$http',  function($http) {
		
		 this.firstService = function(){
	            return $http.post("http://localhost:8080/filemanager/getUserDetails");
	     }
		 
		 this.secondService = function(input){
	            return $http.post("http://localhost:8080/filemanager/getUserById",input);
	     }
	}]);
}());