$(function() {
	 var email=$("#emailInput");
	 var emailC=email.closest(".control-group");
	 var emailMsg=email.parent().next(".validationErr");
	 
	 var pwd=$("#pwdInput");
	 var pwdC=pwd.closest(".control-group");
	 var pwdMsg=pwd.parent().next(".validationErr");
	 
     $("#signinBtn").click(function(e){
    	 console.dir(emailMsg)
    	 // e.preventDefault();
    	 var valid=true;
    	 //emailC.removeClass("error");
    	 emailMsg.empty();
    	 //pwdC.removeClass("error");
    	 pwdMsg.empty();
    	 //validate
    	 if ($.trim(email.val()).length<=0){
    		 emailC.addClass("error");
    		 emailMsg.html("Invalid email.");
    		 valid=false;
    	 }
    	 
    	 if ($.trim(pwd.val()).length<=0){
    		 pwdC.addClass("error");
    		 pwdMsg.html("Invalid password.");
    		 valid=false;
    	 }
    	 console.dir(valid);
    	 if (valid){
    		 $.ajax({
    			  type: "POST",
    			  url: '/signin',
    			  data: {email: email.val(),pwd:pwd.val()},
    			  success: function(){console.log('ok')},
    			  error: function(){console.log('error')},
    			  //dataType: 'json'
    			});
    	 }
    	 e.stopPropagation();
    	 
     });
});