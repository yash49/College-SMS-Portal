<%@page import="vo.FeedbackVO"%>
<%@page import="java.util.*"%>
<%@page import="vo.LoginVO"%>
<%@page import="dao.FeedbackDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>


<style type="text/css">

.rating {
    float:left;
}

/* :not(:checked) is a filter, so that browsers that don’t support :checked don’t 
   follow these rules. Every browser that supports :checked also supports :not(), so
   it doesn’t make the test unnecessarily selective */
.rating:not(:checked) > input {
    position:absolute;
    top:-9999px;
    clip:rect(0,0,0,0);
}

.rating:not(:checked) > label {
    float:right;
    width:1em;
    padding:0 .1em;
    overflow:hidden;
    white-space:nowrap;
    cursor:pointer;
    font-size:200%;
    line-height:1.2;
    color:gold;
    text-shadow:1px 1px #bbb, 2px 2px #666, .1em .1em .2em rgba(0,0,0,.5);
}
</style>

<link rel="stylesheet" href="../admin/adminResources/css/star.css">


  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/admin/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>View Feedback</title>
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

	int loginId=(Integer)session.getAttribute("loginId");
	
	FeedbackDAO feedbackDAO=new FeedbackDAO();
	
	LoginVO loginVO=new LoginVO();
	loginVO.setUserRoll(userType);
	loginVO.setId(loginId);
	
	List<FeedbackVO> feedbackList=feedbackDAO.searchFeedback(loginVO);
	
	session.setAttribute("feedbackList",feedbackList);
	
	int i=0;
	for(FeedbackVO feedbackVO : feedbackList)
	{
		i++;
		System.out.println("LLLLLLLL"+i);
	}


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
              <h4 class="card-title">View Feedback</h4>
              <div class="row">
                <div class="col-12">
                  <div class="table-responsive">
                    <table id="order-listing" class="table">
                      <thead>
                        <tr>
                       		<th>Feedback ID</th>
                            <th>Subject</th>
                            <th>Description</th>
                            <th>Stars</th>
                            
                        </tr>
                      </thead>
                   <c:forEach items="${sessionScope.feedbackList}" var="z">
						
						<tr>
							<td>${z.feedbackId}</td>
							<td>${z.feedbackSubject}</td>
							<td>${z.feedbackDescription}</td>
							<td>
								<div class="form-group " style="cursor: default;"> 
								<div class="rating" style="cursor: default;">
									<c:forEach begin="1" end="${z.starRating}">
                        				<label for="star5" style="cursor: default;"><span class="fa fa-star checked" style="cursor: default;"></span></label>
									</c:forEach>
    							</div>
                     			</div>
							</td>
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
  
  <jsp:include page="livechat.jsp"></jsp:include>
  
</body>

</html>
