
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<!-- base href="${pageContext.request.contextPath}/staff/">   -->
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Add Complain</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../admin/adminResources/css/themify-icons.css">
  <link rel="stylesheet" href="../admin/adminResources/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="../admin/adminResources/css/vendor.bundle.addons.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../admin/adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../admin/adminResources/images/favicon.png" />
</head>

<body>
  <div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    
    <jsp:include page="header.jsp"></jsp:include>
    
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_settings-panel.html -->
      
      
      <!-- partial -->
      <!-- partial:../../partials/_sidebar.html -->
      
      <jsp:include page="menu.jsp"></jsp:include>
      
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row grid-margin">
            <div class="col-12">
              			<div class="card">
                <div class="card-body">
               <form action="<%=request.getContextPath() %>/ComplainController" onsubmit="return validateform();" id="form" method="post" enctype="multipart/form-data">
                  <h4 class="card-title">Add Complain</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Subject</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" name="complainSubject" type="text" placeholder="Enter Complain Subject">
                    </div>
                  </div>
            
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Description</label>
                    </div>
                    <div class="col-lg-8">
                      <textarea name="complainDescription" required="required" class="form-control" rows="4" placeholder="Enter Complain Description"></textarea>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Upload File</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" id="input_file" maxlength="" name="fileName" type="file" accept="image/*">
                    </div>
                  </div>
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="flag" value="insertComplain">
                               <input class="btn btn-primary" type="submit" value="Submit">
                    </div>
                    </div>
                    </form>
                </div>
              </div>
            </div> 
          </div>
          <div class="row grid-margin">
            <div class="col-lg-12">
              <div class="card">
          
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
       
       <jsp:include page="footer.jsp"></jsp:include>
       
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../admin/adminResources/js/vendor.bundle.base.js"></script>
  <script src="../admin/adminResources/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="../admin/adminResources/js/off-canvas.js"></script>
  <script src="../admin/adminResources/js/hoverable-collapse.js"></script>
  <script src="../admin/adminResources/js/template.js"></script>
  <script src="../admin/adminResources/js/settings.js"></script>
  <script src="../admin/adminResources/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="../admin/adminResources/js/form-validation.js"></script>
  <script src="../admin/adminResources/js/bt-maxLength.js"></script>
  <!-- End custom js for this page-->
  
    <script type="text/javascript">
    
/*   function validateform() { 
	  
	  if(form.input_file.value.toLowerCase().lastIndexOf(".png")==-1 || form.input_file.value.toLowerCase().lastIndexOf(".jpg")==-1 || form.input_file.value.toLowerCase().lastIndexOf(".jpeg")==-1 || form.input_file.value.toLowerCase().lastIndexOf(".tiff")==-1 ||form.input_file.value.toLowerCase().lastIndexOf(".bmp")==-1 || form.input_file.value.toLowerCase().lastIndexOf(".svg")==-1) 
		 {
			alert("Please only upload image file");
			form.input_file.focus(); 
			return false;
		}
  } */
	 </script>
  <jsp:include page="livechat.jsp"></jsp:include>
</body>

</html>
