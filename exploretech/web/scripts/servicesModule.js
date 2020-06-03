var servicesModule = angular.module('servicesModule', []);
servicesModule.controller('servicesController',['$scope','$http',function($scope,$http)
{
	
	$http.get('/exploretech/service/getDistricts').then(function(response){
		$scope.data61 = response.data;
		if($scope.data61.successful)
		{
			$scope.districts = $scope.data61.responseObject;
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
	
	$scope.getColleges = function()
	{
		$http.post('/exploretech/service/getColleges').then(function(response){
			$scope.data62 = response.data;
			if($scope.data62.successful)
			{
				$scope.colleges = $scope.data62.responseObject;
				/*$scope.data = {object : totalObj};*/
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
	 $scope.getData = function(institutioncode) {
			$http.post('/exploretech/service/getData',institutioncode).then(function(response) {
				$scope.data60 = response.data;
				if($scope.data60.successful) {
					
					$scope.data1={object:$scope.data60.responseObject};
				};
			}); 				
		 };
	$scope.createLogin = function(totalObj,data1)
	{
		jQuery("#glyphiconid").show();
		if(totalObj == null || totalObj == undefined || totalObj == "")
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
		/*else if(totalObj.email == null || totalObj.email == undefined || totalObj.email == "")
		{
			alert("Enter valid email id");
		}
		else if(totalObj.phone == null || totalObj.phone == undefined || totalObj.phone == "")
		{
			alert("Enter mobile number start with 9 or 8 or 7 and should be 10 digits");
		}*/
		else
		{
			$http.post('/exploretech/service/createLogin', totalObj).then(function(response)
			{
				$scope.data = response.data;
				if($scope.data.successful)
				{    
					$scope.credentials = $scope.data.responseObject;
					if($scope.credentials.userStatus == null || $scope.credentials.userStatus == undefined
							|| $scope.credentials.userStatus == "")
					{
						$("#loginsDiv").show();
						alert("Login credentials created successfully!!!");
					}        
					else
					{
						alert($scope.credentials.userStatus);
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
				alert($scope.data.errorMessage);
				console.log("Server error while getting data");
				jQuery("#glyphiconid").hide();
			});
		}
	};
	
	$scope.getLogins = function(totalObj)
	{
		jQuery("#glyphiconid").show();
		if(totalObj == null || totalObj == undefined || totalObj == "")
		{
			alert("Fill all details!");
		}
		else if(totalObj.districtId == null || totalObj.districtId == undefined || totalObj.districtId == "")
		{
			alert("Select district");
		}
		else if(totalObj.institutioncode == null || totalObj.institutioncode == undefined || totalObj.institutioncode == "")
		{
			alert("Select college");
		}
		$http.post('/exploretech/service/getLogins', totalObj.institutioncode).then(function(response)
		{
			$scope.data = response.data;
			if($scope.data.successful)
			{
				$scope.users = $scope.data.responseObject;
				$scope.data = {object : totalObj};
				if($scope.users == null || $scope.users == undefined || $scope.users == "")
					$("#msgDiv").show();
				else
					$("#msgDiv").hide();
				$("#loginsDiv").show();
				$("#errorDiv").hide();
				jQuery("#glyphiconid").hide();
			}
			else
			{
				console.log("Client error while getting data");
				jQuery("#glyphiconid").hide();
			}
		},
		function(response)
		{
			$("#loginsDiv").hide();
			$("#errorDiv").show();
			$("#errorDiv").html("<b>" + $scope.data.errorMessage + "</b>");
			console.log("Server error while getting data");
			jQuery("#glyphiconid").hide();
		});
	};
	
/*	//Get link for selected program
	$scope.getLink = function(selection)
	{
		
		console.log(selection);
		
		$http.post('/admin/service/getLink', selection).then(function(response){
			$scope.data = response.data;
			if($scope.data.successful)
			{
				$scope.message = $scope.data.responseObject;
			}
			else
			{
				console.log("Client error while getting link");
			}
		},
		function(response)
		{
			console.log("Server error while getting link");
		});
	};
	
	//Get student details based on aadhaar
	$scope.getStudentDetails = function(aadhaar)
	{
		if(aadhaar == "" || aadhaar == undefined || aadhaar == "" || aadhaar == 123412341234 || aadhaar == 999999999999)
		{
			alert("Invalid aadhaar");
		}
		else
		{
			$http.post('/admin/service/checkAadhaar',aadhaar).then(function(response){
			  $scope.data  = response.data;
			  if($scope.data.successful)
			  {
				 Andromeda.setSessionValue("aadhaar", aadhaar);
				 $scope.student = $scope.data.responseObject;
				 Andromeda.setSessionValue("trainingBatchId",  $scope.student.trainingBatchId);
				 
				 $(".studentResultTableDiv").show();
				 
				$http.get('/admin/service/getCollegeDetails').then(function(response){
					$scope.data = response.data;
					if($scope.data.successful)
					{
						$scope.colleges = $scope.data.responseObject.colleges;
						$scope.trainingPrgms = $scope.data.responseObject.trainingPrgms;
						$scope.prgms = $scope.data.responseObject.prgms;
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
			  }
			  else
			  {
				  alert("Invalid aadhaar");
			  }
		   },
		   function(errResponse){
			  console.log("Error checking aadhaar validity");
		   });
		}
	};
	
	//Change student course
	$scope.changeCourse = function(student)
	{
		console.log(student);
		
		if(confirm("Are you sure want to change course?"))
		{
			var student = 
			{
				collegeId : student.collegeId,
				trainingBatchId : Andromeda.getSessionValue("trainingBatchId"),
				trainingProgramId : student.trainingProgramId,
				programId : student.programId,
				aadhaar : Andromeda.getSessionValue("aadhaar")
			};
			
		   $http.post('/admin/service/changeStudentCourse', student).then(function(response){
				$scope.data = response.data;
				if($scope.data.successful)
				{
					alert("Course changed successfully");
				}
				else
				{
					console.log("Client error while changing course");
				}
			},
			function(response)
			{
				console.log("Server error while changing course");
			});
		}
	};*/
	
}]);