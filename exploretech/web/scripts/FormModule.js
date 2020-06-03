var Registration = angular.module('FormModule', []);
Registration.controller('FeedBackController', ['$http','$scope', function($http, $scope) {

	$scope.add = function(userData) {
		
		userData.courseid=Andromeda.getSessionValue('courseid');
				$http.post('/exploretech/form/add', userData).then(
						function(response) {
							$scope.data = response.data;
							if ($scope.data.successful) {
								
								swal("Success","Data Inserted Successfully","info");
								 Andromeda.showFeedBack();  
							} else {             
								swal("Failed","Data Not Inserted","info");   
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
	  
	    }
	
} ]);