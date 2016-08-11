(function() {
	var mainApp = angular.module('mainApp', [ 'ui.bootstrap' ]);

	mainApp.controller('mainController', [ '$scope', 'serviceProvider', function($scope, serviceProvider) {

		function init() {

			serviceProvider.firstService().then(function(data) {
				alert("ok");

			}, function(error) {
				alert("not-ok");
			});
		}
		;

		$scope.getUserWithDtoInput = function() {
			var workDetails = new Object();
			workDetails.occupation = "Programmer";
			workDetails.experience = "2";

			serviceProvider.secondService(workDetails).then(function(data) {

				alert(data.data.surname);
			}, function(error) {
				alert("not-ok");
			});
		}

		$scope.getQuestions = function() {

			serviceProvider.getQuestions(true).then(function(data) {

				alert(data.data.surname);
			}, function(error) {
				alert("not-ok");
			});
		}

		$scope.insertQuestion = function() {

			var question = new Object();
			question.question = "merge bine?";
			question.answer = null;
			question.used = true;

			serviceProvider.insertQuestion(question).then(function(data) {

				alert(data.data.surname);
			}, function(error) {
				alert("not-ok");
			});
		}

		$scope.updateQuestion = function() {

			var question = new Object();
			question.answer = "updated";
			question.id = 2;

			serviceProvider.updateQuestion(question).then(function(data) {

				alert(data.data.surname);
			}, function(error) {
				alert("not-ok");
			});
		}
		
		$scope.removeQuestion = function() {

			var id = 2;

			serviceProvider.removeQuestion(id).then(function(data) {

				alert(data.data.surname);
			}, function(error) {
				alert("not-ok");
			});
		}

		init();
	} ]);
}());