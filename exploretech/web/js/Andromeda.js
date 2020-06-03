var Andromeda = {

	showPage : function(path, targetDiv) {
		var jqxhr = jQuery.post(path, function(data) {
			jQuery("#" + targetDiv).html(data);
		});
	},   
	Register : function() {  
		var path = "/exploretech/html/Register.html";
		Andromeda.showPage(path, "mainDiv");
	},      	
	showHomePage : function() {  
		var path = "/exploretech/html/home.html";
		Andromeda.showPage(path, "mainDiv");
	},      	
	showShowPage : function() {  
		var path = "/exploretech/html/side.html";
		Andromeda.showPage(path, "mainDiv");
	},
	showLoginPage : function(){
		var path = "/exploretech/html/login.html";   
		Andromeda.showPage(path, "mainDiv");	
	},
	
	showAboutPage : function() {  
		var path = "/exploretech/html/about.html";               
		Andromeda.showPage(path, "mainDiv");
	},
	showStudentPage : function() {  
		var path = "/exploretech/html/Student.html";               
		Andromeda.showPage(path, "mainDiv");
	},
	showGraduateePage : function() {             
		var path = "/exploretech/html/Graduatee.html";               
		Andromeda.showPage(path, "mainDiv");
	},
	showOthersPage : function() {              
		var path = "/exploretech/html/Others.html";               
		Andromeda.showPage(path, "mainDiv");   
	},     
	showEditPage : function() {                 
		var path = "/exploretech/html/editprofile.html";                  
		Andromeda.showPage(path, "main");
	},                                                                                                   
	
	showFeedbackPage : function() {  
		var path = "/exploretech/html/formpage.html";               
		Andromeda.showPage(path, "replacediv");
	},
	showAdminPage : function() {  
		var path = "/exploretech/html/admin.html";               
		Andromeda.showPage(path, "mainDiv");
	},
	showMentorPage : function() {  
		var path = "/exploretech/html/mentor.html";               
		Andromeda.showPage(path, "mainDiv");
	},
	showProgramsPage : function() {              
		var path = "/exploretech/html/addprograms.html";               
		Andromeda.showPage(path, "replacediv");    
	},
	showLoginsPage : function() {              
		var path = "/exploretech/html/addlogins.html";               
		Andromeda.showPage(path, "replacediv");
	},
	showFeedbackReportPage : function() {  
		var path = "/exploretech/html/feedbackreport.html";               
		Andromeda.showPage(path, "mainDiv");
	},

	/*showAboutPage : function() {      
		var path = "/ccic/html/about.html";               
		Andromeda.showPage(path, "subHome");
	},
	       
	     
	
	showLoginHome : function(){
		var path = "/ccic/html/home.html";
		Andromeda.showPage(path, "mainDiv");	
	},	
	
	showlogincredentialsPage: function() {               
		var path = "/ccic/html/LoginCreation.html";
		Andromeda.showPage(path, "subHome");
	},
	
	showContactPage : function() {    
		var path = "/ccic/html/contact.html";
		Andromeda.showPage(path, "subHome");
	},
	
	
	showAddStudentDetails : function() {    
		var path = "/ccic/html/AddStudent.html";
		Andromeda.showPage(path, "replaceDiv"); 
	},   
	
	showGetStudentDetails : function() {    
		var path = "/ccic/html/GetStudent.html";
		Andromeda.showPage(path, "replaceDiv");
	},   
	
	showPayStudentDetails : function() {    
		var path = "/ccic/html/PayStudent.html";
		Andromeda.showPage(path, "replaceDiv");
	},      
	
	showFeedbackForm: function() {
		var path = "/ccic/html/feedback_form.html";  
		Andromeda.showPage(path, "subHome");
	},

	showLogin: function() {  
		var path = "/ccic/html/login.html";
		Andromeda.showPage(path, "subHome");
	},
	
	
	home : function() {
		window.location.reload();             
	},
	
	          
	
	
	
	   
	showPayment: function() {
		var path = "/ccic/html/payment.html";      
		Andromeda.showPage(path, "replaceDiv");
	},      
*/

	setSessionValue : function(key, value) {
		sessionStorage.setItem(key, value);
	},

	getSessionValue : function(key) {
		return sessionStorage.getItem(key);
	},

	removeSessionValue : function(key) {
		sessionStorage.removeItem(key);
	},

	showError : function(errorMessage) {
		var message = "<div class=\"alert alert-danger\"><strong>Error: </strong>"
				+ errorMessage + "</div>";
		jQuery("#errorDiv").html(message);
	},                       
                                                         
	logout : function() {
		
		var email = Andromeda.getSessionValue("email") || "";
		Andromeda.setSessionValue("email", null);
		Andromeda.setSessionValue("password", null);
		Andromeda.setSessionValue("qualification", null);
		var data = {
				email : email
		};  
		Andromeda.post('/exploretech/login/logout', data);
		Andromeda.showHomePage();
	},

	post : function(url, data) {
		var responseData = null;

		jQuery.ajax({
			url : url,
			type : 'post',
			data : JSON.stringify(data), // Stringified Json Object
			dataType : 'json',
			async : false, // Cross-domain requests and dataType: "jsonp"
			// requests do not support synchronous operation
			cache : false, // This will force requested pages not to be cached
			// by the browser
			processData : false, // To avoid making query String instead of
			// JSON
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				responseData = data;
			}
		});

		return responseData;
	},

	isUserLoggedIn : function() {
		
		var email = Andromeda.getSessionValue("email") || "";
		var password = Andromeda.getSessionValue("password") || "";
		var qualification = Andromeda.getSessionValue("qualification") || "";
		var regid = Andromeda.getSessionValue("regid") || "";
		
		var login = {
			email : email,
			password : password,
			qualification : qualification,
			regid : regid
		};    
   
		return Andromeda.post('/exploretech/login/loggedin', login) || false;
	}  	
};
