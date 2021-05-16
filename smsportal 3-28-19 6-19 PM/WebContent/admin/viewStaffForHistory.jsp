<%@page import="java.util.List"%>
<%@page import="dao.StaffDAO"%>
<%@page import="vo.StaffVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/admin/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Staff</title>
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

	StaffDAO staffDAO=new StaffDAO();
	
	List staffList=staffDAO.searchStaff();
	
	session.setAttribute("staffList",staffList);
	
	List loginList=staffDAO.searchLogin();
	
	session.setAttribute("loginList",loginList);
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
              <h4 class="card-title">Staffs</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                        	<th>User ID</th>
                            <th>Staff Name</th>
                            <th>Email</th>
                            <th>Mobile</th>
                            <th>Designation</th>  
                            <th>Branch</th>  
                            <th>View History</th>  
                            <th>Delete History</th>  
                        </tr>
                      </thead>
                      <tbody>
                    	<c:forEach items="${sessionScope.staffList}" var="z">
						<tr>

							<td>${z.staffId}</td>
							<td>${z.staffFirstName} ${z.staffLastName}</td>
							<td>${z.loginVO.email}</td>
							<td>${z.staffMobile}</td>
							<td>${z.staffDesignation}</td>
							<td>${z.staffBranch}</td>
							<td><a href="<%=request.getContextPath()%>/SmsHistoryController?loginId=${z.loginVO.id}&flag=searchSmsHistoryByAdmin">View</a></td>
							<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="<%=request.getContextPath()%>/SmsHistoryController?loginId=${z.loginVO.id}&flag=deleteSmsHistory">Delete</a></td>
						</tr>
					</c:forEach>
                      </tbody>
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
  <script src="adminResources/js/data-table.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
