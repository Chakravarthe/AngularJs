var Programs = angular.module('AddProgramsModule', []);
Programs.controller('ProgramController',['$scope','$http',function($scope,$http)
{
	$http.post('/exploretech/program/getBranches').then(function(response){
		$scope.data61 = response.data;
		if($scope.data61.successful)
		{
			$scope.branches = $scope.data61.responseObject;
		}
		else
		{
			console.log("Client error while getting data");
		}
	},
	function(response)  
	{	
		console.log("Server error while getting data");
	});
	
	$scope.save = function(userData) {
				$http.post('/exploretech/program/add', userData).then(
						function(response) {
							$scope.data3 = response.data;
							if ($scope.data3.successful) {
								
								swal("Success","Data Inserted Successfully","info");
								 Andromeda.showLibrary();  
							} else {             
								swal("Failed","Data Not Inserted","info");   
							}
						}, function(errResponse) {
							console.error('Error while fetching notes');
						});
	  
	    }
	
}]);                       