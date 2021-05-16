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
  <title>Edit Staff</title>
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
                  <c:forEach items="${sessionScope.staffList}" var="z">
                  <form action="<%=request.getContextPath()%>/StaffController" method="post" onsubmit="return validateform();">
                  <h4 class="card-title">Edit Staff</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">First Name</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" value="${z.staffFirstName}" required="required" name="staffFirstName" id="defaultconfig" type="text" placeholder="Enter First Name">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Last Name</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" value="${z.staffLastName}" required="required" name="staffLastName" id="defaultconfig-2" type="text" placeholder="Enter Last Name">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Mobile no.</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" min="10" value="${z.staffMobile}" maxlength="10" name="staffMobile" id="defaultconfig-3" type="number" required="required" placeholder="Enter Mobile no.">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Email</label>
                    </div>
                    <div class="col-lg-8">
                      <input class="form-control" value="${z.loginVO.email}" name="staffEmail" id="defaultconfig-3" type="email" required="required" placeholder="Enter Email">
                    </div>
                  </div>
                  
                  
                  
                  <c:if test="${z.staffGender eq 'male'}">
                  <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Gender</label>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="staffGender" id="membershipRadios1" value="male" checked="checked" required="required">
                                Male
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="staffGender" id="membershipRadios2" value="female" required="required">
                                Female
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                        </div>
                     </c:if>
                     
                     
                      <c:if test="${z.staffGender eq 'female'}">
                  <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Gender</label>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="staffGender" id="membershipRadios1" value="male" required="required">
                                Male
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="staffGender" id="membershipRadios2" value="female" checked="checked" required="required">
                                Female
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                        </div>
                     </c:if>
                     
                     
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Designation</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" id="selectDesignation" name="staffDesignation">
                        <option value="selectDesignation">Select Designation</option>
                        <c:forEach items="${sessionScope.designationList}" var="designationList">
                        <c:if test="${z.staffDesignation eq designationList.designationName}">
                          <option selected="selected">${designationList.designationName }</option>
                         </c:if>
                          <c:if test="${z.staffDesignation ne designationList.designationName}">
                          <option >${designationList.designationName }</option>
                         </c:if>
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Branch</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" id="selectBranch" name="staffBranch">
                          <option value="selectBranch">Select Branch</option>
                          <c:forEach items="${sessionScope.branchList}" var="branchList"> 
                          	<c:if test="${z.staffBranch eq branchList.branchName}">
                          <option selected="selected">${branchList.branchName}</option>
                         </c:if>
                          		<c:if test="${z.staffBranch ne branchList.branchName}">
                          <option>${branchList.branchName}</option>
                         </c:if>
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Address</label>
                    </div>
                    <div class="col-lg-8">
                      <textarea name="staffAddress" id="maxlength-textarea" class="form-control" required="required" rows="2" placeholder="Enter Address">${z.staffAddress}</textarea>
                    </div>
                  </div>
                     <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="staffId" value="${z.staffId}">
                    		<input type="hidden" name="loginId" value="${z.loginVO.id}">
                    		<input type="hidden" name="loginPassword" value="${z.loginVO.password}">
                    		<input type="hidden" name="flag" value="updateStaff">
                           <input class="btn btn-primary" type="submit" value="Submit">
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
              <!-- 		 <div class="card-body">
                  <h4 class="card-title">Basic form validation</h4>
                  <form class="cmxform" id="commentForm" method="get" action="#">
                    <fieldset>
                      <div class="form-group">
                        <label for="cname">Name (required, at least 2 characters)</label>
                        <input id="cname" class="form-control" name="name" minlength="2" type="text" required>
                      </div>
                      <div class="form-group">
                        <label for="cemail">E-Mail (required)</label>
                        <input id="cemail" class="form-control" type="email" name="email" required>
                      </div>
                      <div class="form-group">
                        <label for="curl">URL (optional)</label>
                        <input id="curl" class="form-control" type="url" name="url">
                      </div>
                      <div class="form-group">
                        <label for="ccomment">Your comment (required)</label>
                        <textarea id="ccomment" class="form-control" name="comment" required></textarea>
                      </div>
                      <input class="btn btn-primary" type="submit" value="Submit">
                    </fieldset>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-12">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Complete form validation</h4>
                  <form class="cmxform" id="signupForm" method="get" action="#">
                    <fieldset>
                      <div class="form-group">
                        <label for="firstname">Firstname</label>
                        <input id="firstname" class="form-control" name="firstname" type="text">
                      </div>
                      <div class="form-group">
                        <label for="lastname">Lastname</label>
                        <input id="lastname" class="form-control" name="lastname" type="text">
                      </div>
                      <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" class="form-control" name="username" type="text">
                      </div>
                      <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" class="form-control" name="password" type="password">
                      </div>
                      <div class="form-group">
                        <label for="confirm_password">Confirm password</label>
                        <input id="confirm_password" class="form-control" name="confirm_password" type="password">
                      </div>
                      <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" class="form-control" name="email" type="email">
                      </div>
                      <input class="btn btn-primary" type="submit" value="Submit">
                    </fieldset>
                  </form>
                </div>-->
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

	  var selectDesignation = $("#selectDesignation").val();
	  var selectBranch = $("#selectBranch").val();
	  
	  if(selectDesignation == 'selectDesignation')
	  {
		  alert("Please Select a Designation.");
		  return false;
	  }
	  else
	  {
		  if(selectBranch == 'selectBranch')
		  {
			  alert("Please Select a Branch.");
			  return false;
		  }
		  else
		  {
			  return true;
		  }
	  }
  }
  
  </script>
  
  
  
</body>

</html>
