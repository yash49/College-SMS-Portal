<%@page import="java.util.List"%>
<%@page import="vo.FutureSmsVO"%>
<%@page import="dao.FutureSmsDAO"%>
<%@page import="vo.LoginVO"%>
<%@page import="controller.ConvertingDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%
	
	int loginId=(Integer)session.getAttribute("loginId");
	LoginVO loginVO=new LoginVO();
	loginVO.setId(loginId);
	
	FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
	
	List<FutureSmsVO> ls=futureSmsDAO.searchFutureSms(loginVO);
	
	session.setAttribute("futureSmsList",ls);
%>
<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>View Future SMS</title>
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
              <h4 class="card-title">View Future SMS</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                       		<th>Future SMS ID</th>
                            <th>Mobile</th>
                            <th>Message</th>
							<th>Sender ID</th>
							<th>Date and Time</th>
							<th>IS Sent?</th>
                            <th>Delete</th>
                        </tr>
                      </thead>
                   <c:forEach items="${sessionScope.futureSmsList}" var="z">
						
						<tr>
							<td>${z.futureSmsId}</td>
							<td>${z.mobile}</td>
							<td>${z.message}</td>
							<td>${z.senderId}</td>
							<td>
							<c:set var="timestamp" value="${z.timestamp}"></c:set>
							<%
								long timeStamp=(long)pageContext.getAttribute("timestamp");
								ConvertingDateTime convertingDateTime = new ConvertingDateTime();
								String dateTime=convertingDateTime.convertToDateTime(timeStamp);
								out.print(dateTime);
							%>
							</td>
							<td>${z.isSent}</td>
							<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="<%=request.getContextPath()%>/FutureSmsController?futureSmsId=${z.futureSmsId}&flag=deleteFutureSms">Delete</a></td>
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
