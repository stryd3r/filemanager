;
(function() {
    angular.module('mainApp').controller(
		'homePageCtrl',['$scope','$http','$location','$uibModal', '$log', 'mainService', '$filter',
		function($scope, $http, $location,$uibModal, $log, service, $filter) {
			$scope.currentDate = $filter('date')(new Date(), "yyyy/MM/dd");
			//set default active page
			$scope.isActiveClass = "home";
			$scope.currentUser = service.getCurrentUser();
			
			$scope.goHome = function(){
				$location.path("/homePage");
				//$scope.currentPage = "homePage";
			};
			
			//init dashboard
			service.getSumar().success(function(res){
				$scope.sumar = res;
				
/*				$scope.sumar.medical.ramase = $scope.sumar.medical.total - $scope.sumar.medical.luate;
				$scope.sumar.evSpeciale.ramase = $scope.sumar.evSpeciale.total - $scope.sumar.evSpeciale.luate;
				$scope.sumar.delegatie.ramase = $scope.sumar.delegatie.total - $scope.sumar.delegatie.luate;*/
				$scope.sumar.holiday.ramase = parseFloat($scope.sumar.holiday.total) - (parseFloat($scope.sumar.holiday.luate) + parseFloat($scope.sumar.holiday.programate));
				$scope.sumar.permeso.ramase = parseFloat($scope.sumar.permeso.total) - (parseFloat($scope.sumar.permeso.luate) + parseFloat($scope.sumar.permeso.programate));
				$scope.sumar.overtime.total = parseFloat($scope.sumar.overtime.plata) + parseFloat($scope.sumar.overtime.permeso);
				
				//chart
				$scope.dataConcediu = [$scope.sumar.holiday.programate, $scope.sumar.holiday.luate, $scope.sumar.holiday.ramase];
				$scope.dataPermeso = [$scope.sumar.permeso.programate, $scope.sumar.permeso.luate, $scope.sumar.permeso.ramase];
				$scope.dataOvertime = [$scope.sumar.overtime.plata, $scope.sumar.overtime.permeso];
				
				//get all absences 
				service.getAllAbsences().success(function(res){
					$scope.allAbsences = [];
					for(var i=0;i<res.length;i++){
						res[i].day = $filter('date')(new Date(res[i].day), "yyyy/MM/dd");
						$scope.allAbsences.push(res[i]);
						}
				});
			});
			
			$scope.open = function(size, modalType) {
				if(modalType)
				var modalInstance = $uibModal.open({
					animation : true,
					templateUrl : 'app/components/directives/modal.html',
					controller : 'modalCtrl',
					size : size,
					resolve : {
						modalType : function() {
							return modalType;
						}
					}
				});

				modalInstance.result.then(function(selectedItem) {
					$scope.selected = selectedItem;
				}, function() {
					$log.info('Modal dismissed at: ' + new Date());
				});
			};
			
			//chart
			$scope.labels = ["Programate", "Luate", "Ramase"];
			$scope.labelsOv = ["Plata", "Permeso"];
			  //$scope.data = [300, 500, 100];
			
			$scope.checkClass = function(absence){
				if(absence.status === "pending"){
					return "danger";
				}else if(absence.status === "aproved"){
					return "info";
				}
			};
			
			$scope.openAddAbsence = function(size, absenceType){
				var modalInstance = $uibModal.open({
					animation : true,
					templateUrl : 'app/components/directives/modalAdd.html',
					controller : 'modalAddCtrl',
					size : size,
					resolve : {
						absenceType : function() {
							return absenceType;
						}
					}
				});

				modalInstance.result.then(function(selectedItem) {
					$scope.selected = selectedItem;
				}, function() {
					$log.info('Modal dismissed at: ' + new Date());
				});
			
			
			
			switch(absenceType){
			case 'C':
				
			}
		}
			
		}]);
}()); 
