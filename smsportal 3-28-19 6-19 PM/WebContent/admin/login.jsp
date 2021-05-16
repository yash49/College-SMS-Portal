<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <base href="${pageContext.request.contextPath}/admin/">  
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Login</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="adminResources/css/themify-icons.css">
  <link rel="stylesheet" href="adminResources/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="adminResources/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="adminResources/images/favicon.png"/>
  
  
  <style type="text/css">
  .loader {
  position: fixed;
  left: 0px;
  top: 0px;
  width: 100%;
  height: 100%;
  z-index: 9999!important;
  background: url('adminResources/images/loader.gif') 50% 30% no-repeat rgba(245,245,245,0.89);
  background-size: 55px 55px;
}
  
  </style>
  
  
  
</head>
<%
	try{
		String userType=(String)session.getAttribute("userType");
		if (userType.equalsIgnoreCase("admin")) {
			session.setAttribute("goHome", "admin");
			response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		} 
		else if(userType.equalsIgnoreCase("staff")) {
			session.setAttribute("goHome", "staff");
			response.sendRedirect(request.getContextPath()+"/staff/index.jsp");

		} 
	}
	catch(Exception e)
	{ }

%>
<body>


    <div class="loader" style="display: none;" id="myLoader"></div>

  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
          <div class="col-lg-4 mx-auto">
          
            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
              <div class="brand-logo">
                <center>
                <img src="adminResources/images/vpmplogo.png" alt="logo">
              	</center>
              </div>
              <center>
              <h4>VPMP SMS Portal</h4>
              <h6 class="font-weight-light">Sign in to continue.</h6>
              </center>
              
              
              <form class="pt-3" action="<%=request.getContextPath() %>/LoginController" method="post">
	                <div class="form-group">
	                  <input required="required" type="email" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username" name="username">
	                </div>
	                <div class="form-group">
	                  <input required="required" type="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password" name="password">
	                	 <br>
                      <p class="card-description">
                      <%
                      
        				String isPasswordCorrect = (String) session.getAttribute("isPasswordCorrect");
        				
        				if(isPasswordCorrect != null)
        					out.print("The Entered Password is not Valid.");
                    	
                    	%>
                    	</p>
	                </div>
	                <div class="mt-3">
					<input type="hidden" name="flag" value="login">           
	                  <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="SIGN IN">
	                </div>
	                <div class="my-2 d-flex justify-content-between align-items-center">
	                  <div class="form-check">
	  
	                  </div>
	                 <a href="#" class="auth-link text-black" data-toggle="modal" data-target="#forgotPassword">Forgot password?</a>
	                </div>
	          </form>
            
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
 
                  <div class="modal fade" id="forgotPassword" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-2" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Enter Your Email Id</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                        	<label>EmailId</label>
                          <input type="email" name="email" id="email" class="form-control" >
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn  btn-primary" onclick="checkEmail()">Submit</button>
                          <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  <div class="modal fade" id="OTP" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-2" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Enter OTP received in your mail</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <form action="<%=request.getContextPath() %>/ForgotPasswordController" method="post">
                        <div class="modal-body">
                        	<label>OTP</label>
                          <input type="text" name="otp" id="otp" class="form-control" >
                          <input type="hidden" name="flag" value="checkOTP">
                        </div>
                        <div class="modal-footer">
                          <button type="submit" class="btn  btn-primary" onclick="checkOTP()">Submit</button>
                          <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                        </div>
                        </form>
                      </div>
                    </div>
                  </div>
 
 
 <script type="text/javascript">
 function checkEmail(){
	 
	 $('#myLoader').show();
	 
	 var email = document.getElementById("email").value;
	
	 var htp = new XMLHttpRequest();
	
	 htp.onreadystatechange = function()	
		{
			if(htp.readyState==4)
				{	
// 				 $('#myLoader').css('display','');

					$("#myLoader").fadeOut("slow");
					
					if(htp.responseText == 'true'){
						$('#forgotPassword').modal('hide');
						$('#OTP').modal('show');
					}else{
						alert("Sorry '" + email + "' is not register with us.");
						location.reload();
					}
					
				}
		}
		
		htp.open("Get","<%=request.getContextPath()%>/ForgotPasswordController?email="+email,true);
		
		htp.send();
 }
 

 </script>
 
  		
	  <!-- plugins:js -->
  <script src="adminResources/js/vendor.bundle.base.js"></script> 
  <script src="adminResources/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="adminResources/js/off-canvas.js"></script>
  <script src="adminResources/js/hoverable-collapse.js"></script>
  <script src="adminResources/js/template.js"></script>
  <script src="adminResources/js/settings.js"></script>
  <script src="adminResources/js/todolist.js"></script>
  <!-- endinject -->
</body>

</html>
