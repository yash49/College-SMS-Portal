<%@page import="java.util.List"%>
<%@page import="dao.StudentDAO"%>
<%@page import="vo.StudentVO"%>
<%@page import="vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- 	<link href="../admin/adminResources/css/bootstrap.min.css" rel="stylesheet" />  -->
      <script src="../admin/adminResources/js/jquery.min.js"></script>
      <link href="../admin/adminResources/cssselect2.min.css" rel="stylesheet" />
      <script src="../admin/adminResources/js/select2.min.js"></script>

  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Create Group</title>
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
  
  <script type="text/javascript">
  
  $(document).ready(function() {
      $('.js-example-basic-multiple').select2();
  });
  
 
  	
  </script>
  
</head>
<%
	int loginId=(Integer)session.getAttribute("loginId");
	
	LoginVO loginVO=new LoginVO();
	loginVO.setId(loginId);
	
	StudentDAO studentDAO=new StudentDAO();
	
	List<StudentVO> studentList=studentDAO.searchStudent(loginVO);
	
	session.setAttribute("studentList",studentList);
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
               <form action="<%=request.getContextPath() %>/GroupSmsController" method="post">
                  <h4 class="card-title">Create Group</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Group Name</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" name="groupName" type="text" placeholder="Type Something..">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Select Students</label>
                    </div>
                    <div class="col-lg-8">
                    
                    <div class="col-sm-12 col-md-12 col-lg-12">
       				  <div class="row">
       				    <select required="required" class="js-example-basic-multiple tagsinput" name="studentId" multiple="multiple" style="width: 100%; height: 75%;">
       				        <c:forEach var="studentList" items="${sessionScope.studentList}">
							<option value="${studentList.studentId}">${studentList.studentFirstName} ${studentList.studentEnrollmentNumber} ${studentList.classVO.className} ${studentList.branchVO.branchName}</option>
                      	 </c:forEach>
    			        </select>
      				   </div>
  				    </div>
                    </div>
                  </div>
            
                 
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="flag" value="insertGroup">
                               <input required="required" class="btn btn-primary" type="submit" value="Create Group">
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
  
  <jsp:include page="livechat.jsp"></jsp:include>
  
</body>

</html>
