var Report = angular.module('MentorsDataModule', []);
Report.controller('ReportController',['$scope','$http',function($scope,$http)
{
	
	/*var a=[Andromeda.getSessionValue('email'),Andromeda.getSessionValue('regid')];
	a[0] = Andromeda.getSessionValue('email');
	a[1] = Andromeda.getSessionValue('regid');*/
	email = Andromeda.getSessionValue('email');
		$http.post('/exploretech/report/getAll', email).then(
				function(response) {
			$scope.data1 = response.data;
			if ($scope.data1.successful) {
				$scope.data12 = {object:$scope.data1.responseObject};
			} else {
				alert("Can't view the Data");    
			}  
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});
		
	     var email = Andromeda.getSessionValue('email');
		$http.post('/exploretech/report/getBranches',email).then(
				function(response){
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

		$scope.getCourses = function(branchid) {
		$http.post('/exploretech/report/getCourses',branchid).then(function(response){
			$scope.data61 = response.data;  
			if($scope.data61.successful)      
			{
				$scope.courses = $scope.data61.responseObject;
			};
			        
		});
	 };        
	 

		
}]);