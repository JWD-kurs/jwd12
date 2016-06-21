var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.controller('MyController', function($scope) {
	
	$scope.tekst = 'Neki tekst';
	
	$scope.broj = 5;
	
	$scope.lista = [1, 2, '3'];
	
	$scope.objekat = { 'polje': 'vrednost' };
	
	$scope.funkcija = function(k) {
		alert(k);
	};
});

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/activities', {
            templateUrl : '/static/app/html/partial/activities.html'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);