<%@page import="java.util.List"%>
<%@page import="vo.StudentVO"%>
<%@page import="dao.StudentDAO"%>
<%@page import="vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>View Students</title>
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
          <div class="card">
            <div class="card-body">
              <h4 class="card-title">View Student</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                       		<th>Student ID</th>
                            <th>Student Firstname</th>
                            <th>Student Lastname</th>
                            <th>Student Mobile</th>
                            <th>Student Email</th>
                            <th>Student Gender</th>
                            <th>Student Enrollment no.</th>
                            <th>Student Shift</th>
                            <th>Student Branch</th>
                            <th>Student Semester</th>
                            <th>Student Class</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                      </thead>
                   <c:forEach items="${sessionScope.studentList}" var="z">
						
						<tr>
							<td>${z.studentId}</td>
							<td>${z.studentFirstName}</td>
							<td>${z.studentLastName}</td>
							<td>${z.studentMobile}</td>
							<td>${z.studentEmail}</td>
							<td>${z.studentGender}</td>
							<td>${z.studentEnrollmentNumber}</td>
							<td>${z.studentShift}</td>
							<td>${z.branchVO.branchName}</td>
							<td>${z.semesterVO.semesterNumber}</td>
							<td>${z.classVO.className}</td>
							<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="<%=request.getContextPath()%>/StudentController?studentId=${z.studentId}&flag=deleteStudent">Delete</a></td>
							<td><a href="<%=request.getContextPath()%>/StudentController?studentId=${z.studentId}&flag=editStudent"">Edit</a></td>
						</tr>
					</c:forEach>
                    </table>
                  </div>
                </div>
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
  <script src="../admin/adminResources/js/data-table.js"></script>
  <!-- End custom js for this page-->
  
  <jsp:include page="livechat.jsp"></jsp:include>
  
</body>

</html>
