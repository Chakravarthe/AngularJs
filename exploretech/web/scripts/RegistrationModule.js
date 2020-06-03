var Register = angular.module('RegistrationModule', [])
Register.controller('RegisterController', [ '$http', '$scope', function($http, $scope) {
	$scope.save = function(UserData){
		 UserData.institutioncode = Andromeda.getSessionValue("institutioncode");
		 if(UserData.age <= 35){
		$http.post('/exploretech/Reg/save', UserData).then(function(response) {
					$scope.data = response.data;
					if($scope.data.successful) {
						swal("Success","Data Inserted Successfully","info");	
					} else{ 
						swal("Failed","Data Not Inserted","info");     
					}
		});
	}
	else{
		swal("You are not eligible to learn");
	}
	};	 
		 
	
	$scope.updateData = function(UserData){
		//alert(Data.branch);
		
		Data.qualification = Andromeda.getSessionValue("qualification");
		Data.branchid = Andromeda.getSessionValue("branchid");
		Data.courseid = Andromeda.getSessionValue("courseid");
		Data.age = Andromeda.getSessionValue("age");
		
		$http.post('/exploretech/Reg/updateData', UserData).then(
				function(response) {
					$scope.data2 = response.data;
					if ($scope.data2.successful) {
					  alert("User Details Successfully updated");
					
					} else {
					  alert("Data not updated");
					}
				}, function(errResponse) {
				console.error('Error while fetching notes');
				});
	};
	
	$http.post('/exploretech/course/getBranches').then(function(response){
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
	$http.post('/exploretech/course/getCourses',branchid).then(function(response){
		$scope.data61 = response.data;  
		if($scope.data61.successful)      
		{
			$scope.courses = $scope.data61.responseObject;
		};
		 
	});
 };        
 
 $http.post('/exploretech/course/getDistricts').then(function(response){
		$scope.data61 = response.data;
		if($scope.data61.successful)
		{
			$scope.districts= $scope.data61.responseObject;
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

	$scope.getColleges = function(districtid) {
	$http.post('/exploretech/course/getColleges',districtid).then(function(response){
		$scope.data61 = response.data;  
		if($scope.data61.successful)      
		{
			$scope.colleges = $scope.data61.responseObject;
		};
		 
	});
};       
   
$scope.getPolyColleges = function(districtid) {
	$http.post('/exploretech/course/getPolyColleges',districtid).then(function(response){
		$scope.data61 = response.data;  
		if($scope.data61.successful)      
		{
			$scope.colleges = $scope.data61.responseObject;
		};
		 
	});
};       


   
		
	$scope.getAmount = function(courseid)
	{
		$http.post('/exploretech/course/getAmount',courseid).then(function(response){
			$scope.data62 = response.data;
			if($scope.data62.successful)
			{
				$scope.data1={object:$scope.data62.responseObject};
				
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
	};
	 
}]);