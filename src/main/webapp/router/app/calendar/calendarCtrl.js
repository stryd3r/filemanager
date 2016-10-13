/*var angular = require('angular');*/
angular
		.module('mainApp')
		.controller(
				'calendarCtrl',
				function($scope, alert, moment, calendarConfig, modalService) {

					var vm = this;
					var modalInstance = null;

					// These variables MUST be set as a minimum for the calendar
					// to work
					$scope.calendarView = 'month';
					$scope.viewDate = new Date();
					calendarConfig.dateFormatter = 'moment'; // use moment instead of angular for formatting dates
					calendarConfig.i18nStrings.weekNumber = 'Săpt {week}';
					moment.locale('ro');
					var actions = [ {
						label : '<i class=\'glyphicon glyphicon-pencil\'></i>',
						onClick : function(args) {
							$scope.eventEdited(args.calendarEvent);
						}
					}, {
						label : '<i class=\'glyphicon glyphicon-remove\'></i>',
						onClick : function(args) {
							// alert.show('Deleted', args.calendarEvent);
							// if (res.resultContext.operationPerformed != 'ABORTED')
							$scope.eventDeleted(args.calendarEvent);
						}
					} ];
					$scope.events = [];
					$scope.events = [ {
						title : 'programare',
						color : calendarConfig.colorTypes.warning,
						startsAt : moment().startOf('week').subtract(2, 'days').add(8,
								'hours').toDate(),
						endsAt : moment().startOf('week').subtract(2, 'days').add(9, 'hours')
								.toDate(),
						draggable : true,
						resizable : true,
						doctorName : 'Mirionescu Ioana',
						pacientName : 'Nastasa Radu',
						actions : actions
					}
					// {
					// title : '<i class="glyphicon glyphicon-asterisk"></i> <span
					// class="text-primary">Another event</span>, with a <i>html</i>
					// title',
					// color : calendarConfig.colorTypes.info,
					// startsAt : moment().subtract(1, 'day').toDate(),
					// endsAt : moment().add(5, 'days').toDate(),
					// draggable : true,
					// resizable : true,
					// actions : actions
					// },
					// {
					// title : 'This is a really long event title that occurs on every
					// year',
					// color : calendarConfig.colorTypes.important,
					// startsAt : moment().startOf('day').add(7,
					// 'hours').toDate(),
					// endsAt : moment().startOf('day').add(19,
					// 'hours').toDate(),
					// recursOn : 'year',
					// draggable : true,
					// resizable : true,
					// actions : actions
					// }
					];

					$scope.isCellOpen = true;

					$scope.addEvent = function() {
						modalService.openModal("addNewEvent").then(function(res) {
							console.log(res);
							if (res.operationPerformed == 'SUCCESS') {
								var newEv = res.resultContext;
								newEv.actions = actions;
								newEv.draggable = true;
								newEv.resizable = true;
								if(angular.isUndefined(newEv.endsAt)){
									var endTime = angular.copy(newEv.startsAt);
									endTime.setMinutes(endTime.getMinutes() + 30)
									newEv.endsAt = endTime;
								}else{
									var minutes = angular.copy(newEv.endsAt.getMinutes());
									var hours = angular.copy(newEv.endsAt.getHours());
									newEv.endsAt = angular.copy(newEv.startsAt);
									newEv.endsAt.setMinutes(minutes);
									newEv.endsAt.setHours(hours);
								}
								$scope.events.push(res.resultContext);
							}
						});

						/*
						 * $scope.events.push({ title : 'New event', startsAt :
						 * moment().startOf('day').toDate(), endsAt :
						 * moment().endOf('day').toDate(), color :
						 * calendarConfig.colorTypes.important, draggable : true, resizable :
						 * true });
						 */
					};

					$scope.eventClicked = function(event) {
						// alert.show('Clicked', event);
						modalService
								.openModal("editEv", event, 'lg')
								.then(
										function(res) {
											console.log(res);
											if (res.operationPerformed == 'SUCCESS')
												$scope.events[$scope.events.indexOf(event)] = res.resultContext;
										});
					};

					$scope.eventEdited = function(calendarEv) {
						// alert.show('Edited', event);
						modalService
								.openModal("editEv", calendarEv, 'lg')
								.then(
										function(res) {
											console.log(res);
											if (res.operationPerformed == 'SUCCESS')
												$scope.events[$scope.events.indexOf(calendarEv)] = res.resultContext;
										});
					};

					$scope.eventDeleted = function(calendarEv) {
						// alert.show('Deleted', event);
						modalService.openModal('confirmation').then(function(resp) {
							if ("OK" === resp.resultContext) {
								$scope.events.splice($scope.events.indexOf(calendarEv), 1);
							}

						});
					};

					$scope.eventTimesChanged = function(event) {
						console.log(event);
						modalService.openModal('confirmation').then(function(resp) {
							if ("OK" === resp.resultContext) {
								event.startsAt = $scope.newEvStart;
								event.endsAt = $scope.newEvEnd;
							}

						});
						// alert.show('Dropped or resized', event);
					};

					$scope.toggle = function($event, field, event) {
						$event.preventDefault();
						$event.stopPropagation();
						event[field] = !event[field];
					};

				});
