var Student = angular.module('StudentModule', []);
Student.controller('StudentController',['$scope','$http',function($scope,$http)
{
	
	/*var a=[Andromeda.getSessionValue('email'),Andromeda.getSessionValue('regid')];
	a[0] = Andromeda.getSessionValue('email');
	a[1] = Andromeda.getSessionValue('regid');*/
	email = Andromeda.getSessionValue('email');
		$http.post('/exploretech/student/getAll', email).then(function(response) {
			$scope.data1 = response.data;
			if ($scope.data1.successful) {
				$scope.studetails = $scope.data1.responseObject;
			} else {
				alert("Can't view the Data");    
			}
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});
		
	     
		$scope.save = function(){         
			var courseid = Andromeda.getSessionValue('courseid');
			$http.post('/payment/payment/home',courseid).then(function(response) {
						$scope.data = response.data;
						if($scope.data.successful) {
							//alert("Check your mail!");   
							jQuery("#mainDiv").html($scope.data.responseObject.responseObject);
						} else{    
							alert("Link expired!");
						}
			});
		};

		
}]);