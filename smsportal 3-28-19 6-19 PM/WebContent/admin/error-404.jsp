<%@page import="java.time.Year"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Error 404</title>
   <!-- plugins:css -->
  <link rel="stylesheet" href=" <%=request.getContextPath()%>/admin/adminResources/css/themify-icons.css">
  <link rel="stylesheet" href=" <%=request.getContextPath()%>/admin/adminResources/css/vendor.bundle.base.css">
  <link rel="stylesheet" href=" <%=request.getContextPath()%>/admin/adminResources/css/vendor.bundle.addons.css">
  <!-- endinject -->
 
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href=" <%=request.getContextPath()%>/admin/adminResources/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href=" <%=request.getContextPath()%>/admin/adminResources/images/favicon.png" />
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center text-center error-page bg-primary">
        <div class="row flex-grow">
          <div class="col-lg-7 mx-auto text-white">
            <div class="row align-items-center d-flex flex-row">
              <div class="col-lg-6 text-lg-right pr-lg-4">
                <h1 class="display-1 mb-0">404</h1>
              </div>
              <div class="col-lg-6 error-page-divider text-lg-left pl-lg-4">
                <h2>SORRY!</h2>
                <h3 class="font-weight-light">The page you are looking for was not Found.</h3>
              </div>
            </div>
            <div class="row mt-5">
              <div class="col-12 text-center mt-xl-2">
                <a class="text-white font-weight-medium" href="<%=request.getContextPath() %>/admin/index.jsp">Back to home</a>
              </div>
            </div>
            <% int year = Year.now().getValue();%>
            <div class="row mt-5">
              <div class="col-12 mt-xl-2">
                <p class="text-white font-weight-medium text-center">Copyright &copy; <%=year%> All rights reserved by Yash Shah.</p>
              </div>
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
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/vendor.bundle.base.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/off-canvas.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/hoverable-collapse.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/template.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/settings.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/form-validation.js"></script>
  <script src=" <%=request.getContextPath()%>/admin/adminResources/js/bt-maxLength.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
