
var servicesModule = angular.module('MentorsServiceModule', []);
servicesModule.controller('MentorsController',['$scope','$http',function($scope,$http)
{


	$scope.createLogin = function(totalObj)
	{
		jQuery("#glyphiconid").show();
		/*if(totalObj == null || totalObj == undefined || totalObj == "")
		{
			alert("Fill all details!");
		}
		else if(totalObj.districtid == null || totalObj.districtid == undefined || totalObj.districtid == "")
		{
			alert("Select district");
		}
		else if(totalObj.institutioncode == null || totalObj.institutioncode == undefined || totalObj.institutioncode == "")
		{
			alert("Select college");
		}
		else
		{*/
			$http.post('/exploretech/mentorsservice/createLogin', totalObj).then(function(response)
			{
				$scope.data = response.data;
				if($scope.data.successful)
				{       
					$scope.mentors = $scope.data.responseObject;
					if($scope.mentors.userStatus == null || $scope.mentors.userStatus == undefined
							|| $scope.mentors.userStatus == "")
					{
						$("#loginsDiv").show();
						alert("Login credentials created successfully!!!");   
					}        
					else
					{
						alert($scope.mentors.userStatus);
						$("#msgDiv").show();
					}
					jQuery("#glyphiconid").hide();
					$scope.data = {object : totalObj};
				}        
				else
				{    
					console.log("Client error while getting data");
					jQuery("#glyphiconid").hide();
				}
			},
			function(response)
			{
				alert("User already exist");
				console.log("Server error while getting data");  
				jQuery("#glyphiconid").hide();
			});
		}
	
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
 
	/*};*/
	
	
}]);