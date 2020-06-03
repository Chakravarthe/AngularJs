var Courses = angular.module('CoursesModule', []);
Courses.controller('CourseController',['$scope','$http',function($scope,$http)
{
	
	var a=[Andromeda.getSessionValue('email'),Andromeda.getSessionValue('regid')];
	a[0] = Andromeda.getSessionValue('email');
	a[1] = Andromeda.getSessionValue('regid');
$http.post('/exploretech/course/getCourses', a).then(function(response){
		$scope.data61 = response.data;
		if($scope.data61.successful)
		{
			$scope.regdetails = $scope.data61.responseObject;
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
}]);