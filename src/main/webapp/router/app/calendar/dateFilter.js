angular.module("mainModule").filter("dateFilter",['$filter', 'mainService',  function($filter, service) {
	return function(items, from, to) {
		var format = "yyyy/MM/dd";
		//var locale = window.navigator.userLanguage || window.navigator.language;
		if( typeof(from) !== 'undefined' && typeof(to) !== 'undefined'){
		var df = $filter('date')(from,format);
		var dt = $filter('date')(to,format);
		}else{
			var df = $filter('date')(new Date('1960/01/01'),format);
			var dt = $filter('date')(new Date('2080/01/01'),format);
		}
		var result = [];
		if(typeof(items) !== 'undefined'){
		for (var i = 0; i < items.length; i++) {
				if(items[i].type === "O" || items[i].type === "P"){
					if( items[i].day >= df && items[i].day <= dt){
					result.push(items[i])
					}
				}else{
					items[i].absenceFrom = $filter('date')(new Date(items[i].absenceFrom), format);
					items[i].absenceTo = $filter('date')(new Date(items[i].absenceTo), format);
					if(items[i].absenceFrom >= df &&items[i].absenceFrom <= dt){
					result.push(items[i])
					}else if(items[i].absenceTo >= df && items[i].absenceTo <= dt){
						result.push(items[i])
					}else if(dt >= items[i].absenceFrom && dt <= items[i].absenceTo){
						result.push(items[i])
					}else if(df >= items[i].absenceFrom && dt <= items[i].absenceTo){
						result.push(items[i])
					}
				}
			}
		}
		return result;
	};
}]);