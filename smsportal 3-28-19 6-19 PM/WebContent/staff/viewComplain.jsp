<%@page import="java.util.List"%>
<%@page import="vo.ComplainVO"%>
<%@page import="vo.LoginVO"%>
<%@page import="dao.ComplainDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%
	String userType=(String)session.getAttribute("userType");
	int loginId=(Integer)session.getAttribute("loginId");
	
	ComplainDAO complainDAO=new ComplainDAO();

	LoginVO loginVO=new LoginVO();
	loginVO.setUserRoll(userType);
	loginVO.setId(loginId);
	
	List<ComplainVO> complainList=complainDAO.searchComplain(loginVO);
	
	session.setAttribute("complainList",complainList);
%>
<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>View Complain</title>
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
          <div class="card">
            <div class="card-body">
              <h4 class="card-title">View Complain</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                       		<th>Complain ID</th>
                            <th>Subject</th>
                            <th>Description</th>
							<th>View</th>
                            <th>Reply</th>
                            <th>Delete</th>
                        </tr>
                      </thead>
                   <c:forEach items="${sessionScope.complainList}" var="z">
						
						<tr>
							<td>${z.complainId}</td>
							<td>${z.complainSubject}</td>
							<td>${z.complainDescription}</td>
							<td>
								<c:set value="" var="test"></c:set>
								<c:if test="${z.complainFileName ne test}">
									<a href="<%=request.getContextPath()%>/doc/complain/${z.complainFileName}" 	target="_blank">View File</a>
								</c:if>
								<c:if test="${z.complainFileName eq test}">
									No File Uploaded
								</c:if>
							</td>
							<td>${z.complainReply}</td>
						    <td><a href="<%=request.getContextPath()%>/ComplainController?complainId=${z.complainId}&flag=deleteComplain">Delete</a></td>
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
