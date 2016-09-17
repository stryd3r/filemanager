(function() {
	angular
			.module('mainApp')
			.config(
					function($stateProvider, $urlRouterProvider) {

						$urlRouterProvider.otherwise('/home');
						$stateProvider
								.state(
										'login',
										{
											url : '/login',
											templateUrl : 'app/loginComponent/login.html',
											controller : 'loginCtrl'
										})
								.state(
										'createAccount',
										{
											url : '/createAccount',
											templateUrl : 'app/createAccountComponent/createAccount.html',
											controller : 'createAccountCtrl'
										}).state('calendar', {
									url : '/calendar',
									templateUrl : 'app/calendar/calendar.html',
									controller : 'calendarCtrl'
								}).state('home', {
									url : '/home',
									templateUrl : 'app/homePage/homePage.html'
								}).state('manage', {
									url : '/manage',
									templateUrl : 'app/manage/manage.html',
									controller : 'manageCtrl'
								}).state('testRest', {
									url : '/testRest',
									templateUrl : 'app/testRest/restTest.html',
									controller : 'testRestCtrl'
								});
					});
}());