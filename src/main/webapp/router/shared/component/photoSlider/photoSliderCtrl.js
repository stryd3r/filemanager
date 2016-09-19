angular
		.module('mainApp')
		.controller(
				'photoSliderCtrl',
				[
						'$scope', '$interval',
						function($scope, $interval) {
							$scope.slides = [
									{
										image : 'shared/component/photoSlider/images/img00.jpg',
										description : 'Image 00'
									},
									{
										image : 'shared/component/photoSlider/images/img01.jpg',
										description : 'Image 01'
									},
									{
										image : 'shared/component/photoSlider/images/img02.jpg',
										description : 'Image 02'
									},
									{
										image : 'shared/component/photoSlider/images/img03.jpg',
										description : 'Image 03'
									},
									{
										image : 'shared/component/photoSlider/images/img04.jpg',
										description : 'Image 04'
									} ];
							$scope.direction = 'left';
							$scope.currentIndex = 0;

							$scope.setCurrentSlideIndex = function(index) {
								$scope.direction = (index > $scope.currentIndex) ? 'left'
										: 'right';
								$scope.currentIndex = index;
							};

							$scope.isCurrentSlideIndex = function(index) {
								return $scope.currentIndex === index;
							};

							$scope.prevSlide = function() {
								$scope.direction = 'left';
								$scope.currentIndex = ($scope.currentIndex < $scope.slides.length - 1) ? ++$scope.currentIndex
										: 0;
							};
							$interval($scope.prevSlide, 4000);
							$scope.nextSlide = function() {
								$scope.direction = 'right';
								$scope.currentIndex = ($scope.currentIndex > 0) ? --$scope.currentIndex
										: $scope.slides.length - 1;
							};
						} ]).animation('.slide-animation', function() {
			return {
				beforeAddClass : function(element, className, done) {
					var scope = element.scope();

					if (className == 'ng-hide') {
						var finishPoint = element.parent().length;
						if (scope.direction !== 'right') {
							finishPoint = -finishPoint;
						}
						TweenMax.to(element, 0.5, {
							left : finishPoint,
							onComplete : done
						});
					} else {
						done();
					}
				},
				removeClass : function(element, className, done) {
					var scope = element.scope();

					if (className == 'ng-hide') {
						element.removeClass('ng-hide');

						var startPoint = element.parent().length;
						if (scope.direction === 'right') {
							startPoint = -startPoint;
						}

						TweenMax.fromTo(element, 0.5, {
							left : startPoint
						}, {
							left : 0,
							onComplete : done
						});
					} else {
						done();
					}
				}
			};
		}).directive('photoSlider', function() {
			return {
				templateUrl : 'shared/component/photoSlider/photoSlider.html'
			};
		});
