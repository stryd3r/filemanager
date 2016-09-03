angular.module('mainApp')
.service('mainService', [ '$http', function($http) {
	
	var username = "";
	//var dateF = "";
	//var dateT = "";
	var addAbsenceType = null;
	
	this.getPacients = function(){
		return $http.get('shared/mock/json/pacienti.json');
	}
	
	this.getAllAbsences = function(){
		return $http.get('asset/json/allAbsences.json');
	}
	
	this.getHolidayDetails = function() {
		return $http.get('asset/json/odihna.json');
	}
	
	this.getMedicalDetails = function() {
		return $http.get('asset/json/medical.json');
	}
	
	this.getPermesoDetails = function(){
		return $http.get('asset/json/permeso.json');
	}
	
	this.getSumar = function(){
		return $http.get('asset/json/sumar.json');
	}
	
	this.setCurrentUser = function(user){
		username = user;
	}
	
	this.getCurrentUser = function(){
		return username;
	}
	
/*	this.setDateFrom = function(dateFrom){
		dateF = dateFrom;
	}*/
	
/*	this.setDateTo = function(dateTo){
		dateT = dateTo;
	}*/
	
/*	this.getDateFrom = function(){
		return dateF;
	}*/
	
/*	this.getDateTo = function(){
		return dateT;
	}*/
	
	this.setAddAbsenceType = function(absenceType){
		addAbsenceType = absenceType;
	}
	
	this.getAddAbsenceType = function(){
		return addAbsenceType;
	}
	
} ])
.service('modalService', [ 'APPCONST', '$modal', '$q', function(APPCONST, $modal, $q) {
        this.openModal = function(modalName, modalContext, additiveStyle) {
            var deferred = $q.defer();
            var currentModalContext = modalContext || {};

            var modalInstance = $modal.open({
                animation : APPCONST.MODALS.PROPERTIES.ANIMATIONS_ENABLED,
                templateUrl : APPCONST.MODALS.PROPERTIES.RESOURCES_PATH + modalName + '.html',
                controller : modalName + 'Ctrl',
                backdrop : 'static',
                size : additiveStyle || '',
                resolve : {
                    item : function() {
                        // copy to decouple models
                        return angular.copy(currentModalContext);
                    }
                }
            });

            modalInstance.result.then(function(result) {
                deferred.resolve({
                    callContext : currentModalContext,
                    resultContext : result
                });
            }, function() {
                deferred.resolve({
                    callContext : currentModalContext,
                    resultContext : {
                        operationPerformed : APPCONST.MODALS.RETURN_VALUES.ABORTED
                    }
                });
            });

            return deferred.promise;
        };
    } ]);
