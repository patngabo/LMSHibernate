function showAddAuthor() {
	if ($("#addNewAuthor").css('display') == 'none')
		$("#addNewAuthor").css('display', 'block');
	else
		$("#addNewAuthor").css('display', 'none');
}

function showAllAuthors($scope, $http) {
	$http.get(restURL + 'authors/getAll').success(function(data) {
		$scope.authors = data;
	});
}

var nileModule = angular.module('nileApp', [ 'ngRoute' ]);

nileModule.config([ "$routeProvider", function($routeProvider) {
	return $routeProvider.when("/", {
		redirectTo : "/home"
	}).when("/home", {
		templateUrl : "home.html"
	}).when("/listAuthors", {
		templateUrl : "listAuthors.html"
	})
} ]);

var restURL = "http://localhost:8080/training/";

nileModule.controller('authorsCtrl', function($scope, $http) {
	// get all authors and display initially
	showAllAuthors($scope, $http);
	
	$scope.addAuthor = function() {
		if($scope.addAuthorFrm.$valid){
		 $http.post(restURL + 'author/add', {authorName: $scope.authorName}).
		  success(function(data) {
			  alert('Author Added');
			  showAllAuthors($scope, $http);
			  showAddAuthor();
		    });
		}
	};
});
