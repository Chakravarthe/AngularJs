var edit = angular.module('EditModule', []);
edit.controller('editController', ['$http','$scope', function($http, $scope) {
	$scope.updateProfile = function(UserData){
		/*alert(UserData.username);*/
		$http.post('/exploretech/Reg/updateProfile', UserData).then(
				function(response) {
					$scope.data = response.data;
					if ($scope.data.successful) {
						alert("user data Successfully updated");
					} else {
						alert("user data not updated");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
	};
	
			
			//Get Data from Database based on Name     
	    email=Andromeda.getSessionValue("email")
		$http.post('/exploretech/Reg/getById', email).then(   
				function(response) {
					$scope.data = response.data;
					if ($scope.data.successful) {
						$scope.data={object:$scope.data.responseObject};
					} else {
						alert("Error while getting data");
					}
				}, function(errResponse) {
					console.error('Error while fetching notes');
				});
} ]);   
