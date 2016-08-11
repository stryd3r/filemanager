(function() {
	angular.module('mainApp').service('serviceProvider', [ '$http', 'globalVariables', function($http, globalVariables) {

		this.firstService = function() {
			return $http.post(globalVariables.hostName + "filemanager/getUserDetails");
		}

		this.loginService = function() {
			return $http.post(globalVariables.hostName + "filemanager/loginService");
		}

		this.getQuestions = function(input) {
			return $http.post(globalVariables.hostName + "filemanager/getQuestions", input);
		}

		this.insertQuestion = function(input) {
			return $http.post(globalVariables.hostName + "filemanager/insertQuestion", input);
		}

		this.updateQuestion = function(input) {
			return $http.post(globalVariables.hostName + "filemanager/updateQuestion", input);
		}

		this.removeQuestion = function(input) {
			return $http.post(globalVariables.hostName + "filemanager/removeQuestion", input);
		}

		this.login = function(input) {

			return $http.post(globalVariables.hostName + "filemanager/login", input);
		}
	} ]);
}());