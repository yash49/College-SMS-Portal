<%@page import="dao.SmsTemplateDAO"%>
<%@page import="vo.LoginVO"%>
<%@page import="vo.SmsTemplateVO"%>
<%@page import="controller.SmsTemplateController"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%
	int loginId=(Integer)session.getAttribute("loginId");
	LoginVO loginVO=new LoginVO();
	loginVO.setId(loginId);
	
	SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
	
	List<SmsTemplateVO> ls=smsTemplateDAO.searchSmsTemplate(loginVO);
	
	session.setAttribute("smsTemplateList",ls);
%>
<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>View SMS Templates</title>
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
              <h4 class="card-title">View SMS Template</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                       		<th>SMS Template ID</th>
                            <th>Template Name</th>
                            <th>Template Text</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                      </thead>						
						<c:forEach items="${sessionScope.smsTemplateList}" var="z">
						<tr>
							<td>${z.smsTemplateId}</td>
							<td>${z.smsTemplateName}</td>
							<td>${z.smsTemplateText}</td>
							<td><a onclick="return confirm('Are you sure you want to delete this item?');" href="<%=request.getContextPath()%>/SmsTemplateController?smsTemplateId=${z.smsTemplateId}&flag=deleteSmsTemplate">Delete</a></td>
							<td><a href="<%=request.getContextPath()%>/SmsTemplateController?smsTemplateId=${z.smsTemplateId}&flag=editSmsTemplate">Edit</a></td>
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
