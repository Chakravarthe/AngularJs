var Registration = angular.module('AddStudentModule', ['xlsx-model']);
Registration.controller('AddStudentController', ['$http','$scope', function($http, $scope) {

	
	$http.post('/exploretech/AddStudent/getYear').then(function(response) {
		$scope.data11 = response.data;
		if($scope.data11.successful) {
			/*$scope.aicterequiredone=$scope.data.responseObject;*/
			$scope.data={object:$scope.data11.responseObject};
		};   
		 
	});
	
	
	
	 var role=Andromeda.getSessionValue('role');
	 var circularsArr = [];
		$scope.filePathsA
		rr = [];
		
		 
	    $scope.uploadFile = function(el1,param) 
		 {
			console.log(el1);
			console.log(param);
			var employeeId=Andromeda.getSessionValue("role");
			console.log(employeeId);
		   var fileName = el1.files[0].name;
		   var fileDetails=fileName.split(".");
		   fileName=employeeId+"_"+param+"."+fileDetails[1];
		   console.log(fileName);
				
		   //  fileName=param+"_"+employeeId+"."+fileDetails[1];
				  
		   // var fielName=fileDetails.join(".");
		   
		   Andromeda.setSessionValue("fileFormat",fileDetails[1]);
		  console.log(Andromeda.getSessionValue("fileFormat"));
			var fileReader;
	       fileReader = new FileReader();
	       fileReader.onload = function(e) {
	       	binaryString =  e.target.result;
	       	base64 = btoa(binaryString);
	       	var str = base64.toString();
	       	
	       	var fileModel = {
	       		fileName : fileName,
	       		base64String : str,
	       		name:fileName,
	       		role:Andromeda.getSessionValue('role')
	       	};
	       	//console.log("fileModel"+fileModel);
				$http.post('/exploretech/AddStudent/upload',fileModel).then(function(response) {
					$scope.data1111 = response.data;
					if($scope.data1111.successful)
					{
						var name=$scope.data1111.responseObject.name;
						Andromeda.setSessionValue("filePath",name);
						
						
					}
					else {
						alert("File upload failed....please try again!!!!");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	       };       
	       fileReader.readAsBinaryString( el1.files[0]);	
	    };
	    

      
	  //Save excel data
	    $scope.save = function(excelData,yearobject)
	    {
	    	console.log(yearobject);
	    	
	    	if(yearobject == undefined)
			{
				swal("OOPS!","Fill all details","info");
			}
			else if(yearobject.year == null || yearobject.year == undefined || yearobject.year == "")
			{
				swal("Oops...","Select year","info");
			}
			else
				{
	    	
	    	/*console.log(excelData);*/
	        jQuery("#spinner1").show();
	        var student = [];
	        $scope.excelDetails = excelData.slice(1, excelData.length+1);
	        var excelLength =  $scope.excelDetails.length, keepOnGoing = true;
	       
	            for(var i = 0; i < $scope.excelDetails.length; i++)
	            {
	            	var studentsDetails = {};
	            		studentsDetails.name = $scope.excelDetails[i]['name'];
	            		studentsDetails.fname = $scope.excelDetails[i]['fathername'];
	            		studentsDetails.hno = $scope.excelDetails[i]['homeno'];
	            		studentsDetails.village = $scope.excelDetails[i]['village'];
	            		studentsDetails.mandal = $scope.excelDetails[i]['mandal'];
	            		studentsDetails.pincode = $scope.excelDetails[i]['pincode'];
	            		studentsDetails.mobileno = $scope.excelDetails[i]['mobileno'];
	            
	            	
	                studentsDetails.year = yearobject.year;
	                studentsDetails.courseid = yearobject.courseid;
	                studentsDetails.intake = yearobject.intake;
	            	studentsDetails.role = Andromeda.getSessionValue('role');
	                console.log(Andromeda.getSessionValue('filePath'));
	                studentsDetails.filePath = Andromeda.getSessionValue('filePath');
	                studentsDetails.fileExtension = Andromeda.getSessionValue('fileFormat');
	                studentsDetails.institutioncode = Andromeda.getSessionValue('institutioncode');
	                //studentsDetails.fileFormat = Andromeda.getSessionValue('fileFormat');
	                student.push(studentsDetails);

	            }
	            
	            $("#spinner1").show();
	            console.log('StData:'+student);
	            
	            $http.post('/exploretech/AddStudent/saveDetails',student).then(function(response) {
	                $scope.data1 = response.data;
	                if($scope.data1.successful) {
	                	
	                	$("#spinner1").hide();
	                    alert("Data saved successfully");

	                }
						 
						 else {
	                    alert("Data not inserted");
	                }
	            }, function(errResponse) {
	                console.error('Error while fetching notes');
	            });
	            
	            
				} 
	     
	           
	    };
		
		
	$http.post('/exploretech/AddStudent/getAll').then(function(response) {
		$scope.data = response.data;
    
		if ($scope.data.successful) {
			$scope.students =$scope.data.responseObject; 
		} else {
			alert("Can't view the Data");
		}      
	}, function(errResponse) {
		console.error('Error while viewing notes');
	});


    
//Get Data from Database based on Name
$scope.getById = function(email){
//alert(firstname);
$http.post('/exploretech/AddStudent/getById', email).then(
function(response) {
$scope.data = response.data;
if ($scope.data.successful) {
$scope.data={object:$scope.data.responseObject};
} else {
//alert("Error while getting data");
}
}, function(errResponse) {
//console.error('Error while fetching notes');
});
};

//Update User Details
$scope.updateData = function(UserData){
//alert(UserData.firstname);
$http.post('/exploretech/AddStudent/updateData', UserData).then(
function(response) {
$scope.data = response.data;
if ($scope.data.successful) {
//alert("Contact Details Successfully updated");
} else {
//alert("Data not updated");
}
}, function(errResponse) {
//console.error('Error while fetching notes');
});
};



// View Data from Database





// Delete UserData based on Name
$scope.removeData = function(email) {
$http.post('/exploretech/AddStudent/removeData', email).then(
function(response) {
$scope.data = response.data;
if ($scope.data.successful) {
location.reload();
//alert("Contact Data removed Successfully");
} else {
//alert("Data not Deleted");
}
}, function(errResponse) {
//console.error('Error while fetching notes');
});
};

} ]);


