angular.module('mainApp').constant('APPCONST', (function() {
	// Define your variable
	var defEndpoint = '';
	//var defEndpoint = 'http://localhost:8080/filemanager/';
	// Use the variable in your constants
	return {
		MODALS : {
			PROPERTIES : {
				ANIMATIONS_ENABLED : true,
				RESOURCES_PATH : 'app/modals/'
			},
			RETURN_VALUES : {
				ABORTED : 'ABORTED',
				SUCCESS : 'SUCCESS'
			}
		},
		ENDPOINT : {
			PACIENTS : {
				GET_PACIENTS : defEndpoint + 'getPacients',
				GET_DOCTORS : defEndpoint + 'getDoctors',
				GET_PACIENTS_BY_ID : defEndpoint + 'getPacientById',
				SAVE_PACIENT_IN_DB : defEndpoint + 'updatePacientWithDetails',
				DELETE_CONSULTATIONS : defEndpoint + 'removeConsultations',
				INSERT_CONSULTATION : defEndpoint + 'insertConsultation',
				UPDATE_PACIENT : defEndpoint + 'updatePacient',
				INSERT_PACIENT : defEndpoint + 'insertPacient',
				REMOVE_PACIENT : defEndpoint + 'removePacient',
				GET_DOCTOR_BY_ID : defEndpoint + 'getDoctorById',
				INSERT_DOCTOR : defEndpoint + 'insertDoctor',
				UPDATE_DOCTOR : defEndpoint + 'updateDoctor',
				REMOVE_DOCTOR : defEndpoint + 'removeDoctor',
				DELETE_CONSULT : defEndpoint + 'removeConsultation',
				GET_DOCTOR_PACIENTS : defEndpoint + 'getDoctorbyIdWithDetails'
			}
		},
		ALERT : {
			SUCCESS : 'success',
			WARNING : 'warning',
			ERROR : 'error'
		}
	}
})());