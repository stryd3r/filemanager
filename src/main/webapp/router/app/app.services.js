angular.module('mainApp').service(
		'mainService',
		[
			'$http',
			'APPCONST',
			function($http, appConst) {

				/*
				 * this.getPacients = function(){ return
				 * $http.get('shared/mock/json/pacienti.json'); }
				 */

				this.getPacients = function() {
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.GET_PACIENTS, [{pName:'withDoctor',pValue:false}])
					return $http.get(url);
				}
				
				this.getDoctors = function(){
					return $http.get(appConst.ENDPOINT.PACIENTS.GET_DOCTORS);
				}
				
				this.getDoctorById = function(id){
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.GET_DOCTOR_BY_ID, [{pName:'doctorId',pValue:id}])
					return $http.get(url);
				}
				
				this.updatePacient = function(param){
					return $http.post(appConst.ENDPOINT.PACIENTS.UPDATE_PACIENT, param);
				}

				this.saveAllPacientInDb = function(param, withConsultations, withDetail) {
					var params = [ {
						pName : 'withConsultations',
						pValue : withConsultations
					}, {
						pName : 'withDetail',
						pValue : withDetail
					} ];
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.SAVE_PACIENT_IN_DB,
							params);
					return $http.post(url, param);
				}

				this.getPacientById = function(id) {
					var params = [ {
						pName : 'pacientId',
						pValue : id,
					}, {
						pName : 'withDetail',
						pValue : true
					}, {
						pName : 'withDoctor',
						pValue : true
					}, {
						pName : 'withConsultations',
						pValue : true
					} ];
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.GET_PACIENTS_BY_ID,
							params);
					return $http.get(url);
				}
				
				this.deleteConsults = function(ids){
					return $http.delete(appConst.ENDPOINT.PACIENTS.DELETE_CONSULTATIONS, ids);
				}
				
				this.insertConsult = function(param){
					return $http.post(appConst.ENDPOINT.PACIENTS.INSERT_CONSULTATION, param);
				}
				
				this.insertPacient = function(param){
					return $http.post(appConst.ENDPOINT.PACIENTS.INSERT_PACIENT, param);
				}
				
				this.removePacient = function(idPacient){
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.REMOVE_PACIENT, [{pName:'pacientId',pValue:idPacient}, {pName:'atomicDeletion',pValue:true}]);
					return $http.delete(url);
				}
				
				this.removeDoctor = function(idDoctor){
					var url = urlCreator(appConst.ENDPOINT.PACIENTS.REMOVE_DOCTOR, [{pName:'doctorId',pValue:idDoctor}]);
					return $http.delete(url);
				}
				
				this.insertDoctor = function(param){
					return $http.post(appConst.ENDPOINT.PACIENTS.INSERT_DOCTOR, param);
				}
				
				this.updateDoctor = function(param){
					return $http.post(appConst.ENDPOINT.PACIENTS.UPDATE_DOCTOR, param);
				}
				
				// utility to create query url
				var urlCreator = function(endpoint, params) {
					var urlRet = endpoint;
					for (var i = 0; i < params.length; i++) {
						urlRet += (i == 0 ? '?' : '&') + params[i].pName + '='
								+ params[i].pValue;
					}
					return urlRet;
				};
				
			} ]).service(
		'modalService',
		[
			'APPCONST',
			'$uibModal',
			'$q',
			function(APPCONST, $uibModal, $q) {
				this.openModal = function(modalName, modalContext, additiveStyle) {
					var deferred = $q.defer();
					var currentModalContext = modalContext || {};

					var modalInstance = $uibModal.open({
						animation : APPCONST.MODALS.PROPERTIES.ANIMATIONS_ENABLED,
						templateUrl : APPCONST.MODALS.PROPERTIES.RESOURCES_PATH + modalName
								+ '.html',
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
						// result.operationPerformed =
						// APPCONST.MODALS.RETURN_VALUES.SUCCESS;
						deferred.resolve({
							callContext : currentModalContext,
							operationPerformed : APPCONST.MODALS.RETURN_VALUES.SUCCESS,
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
