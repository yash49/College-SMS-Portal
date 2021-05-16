<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/admin/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Edit Semester</title>
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
  <link rel="shortcut icon" href="adminResources/images/favicon.png" />
</head>
<%
	String userType=(String)session.getAttribute("userType");

	
	if(userType != null){
	if(!userType.equals("admin")){
		response.sendRedirect("../staff/index.jsp");
	}}

%>
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
               <c:forEach items="${sessionScope.list}" var="z"> 
               <form action="<%=request.getContextPath() %>/SemesterController" method="post" onsubmit="return validateform();">
                  <h4 class="card-title">Update Semester</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Semester Number</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" maxlength="1" required="required" id="semesterNumber" name="semesterNumber" type="number" placeholder="Enter Semester Name" value="${z.semesterNumber}">
                    </div>
                  </div>
            
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="flag" value="updateSemester">
                    		<input type="hidden" name="semesterId" value=${z.semesterId}>
                               <input class="btn btn-primary" type="submit" value="Submit">
                    </div>
                    </div>
                    </form>
                    </c:forEach>
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
  <!-- Custom js for this page-->
  <script src="adminResources/js/form-validation.js"></script>
  <script src="adminResources/js/bt-maxLength.js"></script>
  <!-- End custom js for this page-->
  
  <script type="text/javascript">
  function validateform() {

	  var semesterNumber = $("#semesterNumber").val();
	 
	  if(semesterNumber <= 0)
	  {
		  alert("Please Select a Proper Semester.");
		  return false;
	  }
	  else
	  {
			  return true;
	  }
  }
  
  </script>
  
  
  
</body>

</html>
