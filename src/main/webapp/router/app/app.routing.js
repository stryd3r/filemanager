(function() {
	angular.module('mainApp').config(
			function($stateProvider, $urlRouterProvider) {

				$urlRouterProvider.otherwise('/home');
				$stateProvider.state('login', {
					url : '/login',
					templateUrl : 'app/loginComponent/login.html',
					controller : 'loginCtrl'
				}).state('createAccount', {
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
				}).state('pacients', {
					url : '/pacienti',
					templateUrl : 'app/mngPacients/mngPacients.html',
					controller : 'mngPacientsCtrl'
				}).state(
						'pacient',
						{
							url : '/pacient/:idPacient/:name',
							templateUrl : 'app/pacientPage/pacientDetail.html',
							controller : 'pacientDetailCtrl',
							resolve : {
								pacientDetResp : [
									'$stateParams',
									'$rootScope',
									'APPCONST',
									'mainService',
									function($stateParams, $rootScope, APPCONST, srv) {
										var retVal = srv.getPacientById($stateParams.idPacient);
										retVal.then(function(r) {

										}, function(err) {
											console.log(err);
											$rootScope.alertIsOn = APPCONST.ALERT.ERROR;
											$rootScope.alertMsg = "Pacient detail problem: "
													+ err.statusText;
										});
										return retVal;
									} ]
							}
						}).state('doctors', {
					url : '/doctori',
					templateUrl : 'app/mngDoctors/mngDoctors.html',
					controller : 'mngDoctorsCtrl'
				}).state('testRest', {
					url : '/testRest',
					templateUrl : 'app/testRest/restTest.html',
					controller : 'testRestCtrl'
				});
			});
}());