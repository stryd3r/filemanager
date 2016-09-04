angular.module('mainApp')
.service('mainService', [ '$http', function($http) {

	this.getPacients = function(){
		return $http.get('shared/mock/json/pacienti.json');
	}
	
} ])
.service('modalService', [ 'APPCONST', '$uibModal', '$q', function(APPCONST, $uibModal, $q) {
        this.openModal = function(modalName, modalContext, additiveStyle) {
            var deferred = $q.defer();
            var currentModalContext = modalContext || {};

            var modalInstance = $uibModal.open({
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
