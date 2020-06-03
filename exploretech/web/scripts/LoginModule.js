var LoginModule = angular.module('LoginModule', [])
LoginModule.controller('LoginController', [ '$http', '$scope', function($http, $scope) {
		var self = this;
		$scope.login = function(user) {
		//	 $("#glyphiconid").show();
			    
	        $http.post('/exploretech/login/login',user).then(function(response) {
				$scope.data = response.data;    
				if($scope.data.successful) {
					Andromeda.setSessionValue("email", $scope.data.responseObject.email.replace(/\s+/g, ''));
					Andromeda.setSessionValue("password", $scope.data.responseObject.password);
					Andromeda.setSessionValue("qualification", $scope.data.responseObject.qualification);
					Andromeda.setSessionValue("courseid", $scope.data.responseObject.courseid);
					Andromeda.setSessionValue("regid", $scope.data.responseObject.regid);
							if ((Andromeda.getSessionValue("qualification") == "ENGSTU")) {
				    			//console.log("Student");
								Andromeda.showStudentPage();
		  		    		} 
							else if ((Andromeda.getSessionValue("qualification") == "POLYSTU")) {
				    			//console.log("Student");
								Andromeda.showStudentPage();
		  		    		} 
				    		else if ((Andromeda.getSessionValue("qualification") == "GRADUATEES")) {
				    			//console.log("Graduatee");
								Andromeda.showGraduateePage();
				    		}    
				    		else if ((Andromeda.getSessionValue("qualification") == "OTHERS")) {
				    			//console.log("Others");
								Andromeda.showOthersPage();
				    		}
				    		else if ((Andromeda.getSessionValue("qualification") == "ADMIN")) {
				    			//console.log("Others");
								Andromeda.showAdminPage();
				    		}
				    		else if ((Andromeda.getSessionValue("qualification") == "Mentor")) {
				    			//console.log("Others");
								Andromeda.showMentorPage();
				    		}
				    		else {
				    			//console.log("Nothing");
								 Andromeda.showHomePage();     
				    		}                     
				             				
					/*	Andromeda.setSessionValue("institutioncode",$scope.data.responseObject.institutioncode);*/
				/*	   
				      if(Andromeda.getSessionValue('role')=="admin")
						{
							Andromeda.showLoginHome();                                            
						}                                          
					else if(Andromeda.getSessionValue('role')=="principal"){
						Andromeda.setSessionValue("institutioncode", $scope.data.responseObject.institutioncode);
						Andromeda.showPrincipalHome();                         
						
					}  
				      
					else if(Andromeda.getSessionValue('role')=="principal" && Andromeda.getSessionValue('feestatus')== 0 ){
						Andromeda.setSessionValue("institutioncode", $scope.data.responseObject.institutioncode);
						Andromeda.showPayPrincipalHome();                         
						
					}  
				      
					else if(Andromeda.getSessionValue('role')=="inspection1"){
						Andromeda.showInspection1Home();
						 
					}
					else if(Andromeda.getSessionValue('role')=="inspection2"){
						Andromeda.showInspection2Home();
						 
					}
					else if(Andromeda.getSessionValue('role')=="inspection3"){
						Andromeda.showInspection3Home();
						 
					}   
					else if(Andromeda.getSessionValue('role')=="inspection4"){     
						Andromeda.showInspection4Home();
						 
					}   
					else if(Andromeda.getSessionValue('role')=="inspection5"){
						Andromeda.showInspection5Home();
						 
					}
					else if(Andromeda.getSessionValue('role')=="super admin"){
						Andromeda.showSuperAdminHome();
						 
					}   
					else{
						Andromeda.showLoginHome();   
					} */
	    
				} else {
				//	$("#glyphiconid").hide();
					//alert($scope.data.errorMessage);
					Andromeda.showError($scope.data.errorMessage);    
					var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>"+ $scope.data.errorMessage + "</div>";
				   jQuery("#errorDiv").html(message);
					$("#errorDiv").show();
					$("#errorDiv").html("<b style='margin-left: 28%;font-size: medium;color:blue'>Note:</b> Invalid login credentials");
				//	console.log('Error while validating user');
				} 
			},function(errResponse) {
				console.error('Error while fetching notes');
			});
	    };
	   
	    $scope.forgotPassword = function(email)
		{
			if(email != null)   
			{
				jQuery("#spinner").addClass("glyphicon glyphicon-refresh glyphicon-refresh-animate");
			//	alert(email);
				$http.post('/exploretech/user/forg', email).then(function(response) 
				{
					$scope.data = response.data;
					if($scope.data.successful) 
					{
						jQuery("#spinner").removeClass("glyphicon glyphicon-refresh glyphicon-refresh-animate");
				alert("Your password is sent to your mail so,please check your mail");
						Andromeda.showLoginPage();
					}
					else 
					{
						jQuery("#spinner").removeClass("glyphicon glyphicon-refresh glyphicon-refresh-animate");
					//	alert($scope.data.errorMessage);
					}
				},
				function(errResponse) 
				{
				//	console.error('Error while fetching notes');
				});
			}
			else
			{
				//alert("Please enter email-Id");
			}
	    };
} ]);