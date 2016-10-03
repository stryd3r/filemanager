angular.module('mainApp').constant('APPCONST', (function() {
	// Define your variable
	var defEndpoint = 'http://localhost:8080/filemanager/';
	// Use the variable in your constants
	return {
		MODALS : {
			PROPERTIES : {
				ANIMATIONS_ENABLED : true,
				RESOURCES_PATH : 'app/modals/'
			}
		},
		RETURN_VALUES : {
			ABORTED : 'ABORTED'
		},
		ENDPOINT : {
			PACIENTS : {
				GET_PACIENTS : defEndpoint + 'getPacients',
				GET_PACIENTS_BY_ID : defEndpoint + 'getPacientById'
			}
		}
	}
})());