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
  <title>JustDo Admin</title>
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
  
</head>
<%
	try{
		String userType=(String)session.getAttribute("userType");
		if (userType.equalsIgnoreCase("admin")) {
			session.setAttribute("goHome", "admin");
		} 
		else if(userType.equalsIgnoreCase("staff")) {
			session.setAttribute("goHome", "staff");
		} 
	}
	catch(Exception e)
	{ }

%>
<body>

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
              <h6 class="font-weight-light">Enter your new Password & Confirm it.</h6>
              </center>
              <form class="pt-3" action="<%=request.getContextPath() %>/ForgotPasswordController" method="post" onsubmit="return validatepwd();">
                <div class="form-group">
                  <input minlength="6" required="required" type="text" class="form-control form-control-lg" id="newPassword" placeholder="New Password" name="newPassword">
                </div>
                <div class="form-group">
                  <input minlength="6" required="required" type="text" class="form-control form-control-lg" id="confirmNewPassword" placeholder="Confirm New Password" name="confirmNewPassword">
                </div>
                <div class="mt-3">
                <input type="hidden" name="flag" value="checkResetPassword"> 
                  <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" id="checkPassword" value="Change Password">
                </div>
                <div class="my-2 d-flex justify-content-between align-items-center">
                  <div class="form-check">
  
                  </div>
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
  
  <script type="text/javascript">
  function validatepwd() {

	  var newPassword = $("#newPassword").val();
	  var confirmNewPassword = $("#confirmNewPassword").val();
	  
	  if(newPassword != confirmNewPassword)
	  {
		  alert("New Password and Confirm Password should be same");
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  }
  
  </script>
  <!-- endinject -->
</body>

</html>
