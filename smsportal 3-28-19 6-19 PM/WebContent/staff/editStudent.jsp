
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- required="required" meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Edit Student</title>
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
          <div class="row grid-margin">
            <div class="col-12">
              			<div class="card">
                <div class="card-body">
                <c:forEach items="${sessionScope.studentList}" var="studentList">
                  <form action="<%=request.getContextPath()%>/StudentController" method="post" onsubmit="return validateform();">
                  <h4 class="card-title">Edit Student</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">First Name</label>
                    </div>
                    <div class="col-lg-8">
                      <input value="${studentList.studentFirstName}" required="required" class="form-control" name="studentFirstName" type="text" placeholder="Enter First Name">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Last Name</label>
                    </div>
                    <div class="col-lg-8">
                      <input value="${studentList.studentLastName}" required="required" class="form-control" name="studentLastName" type="text" placeholder="Enter Last Name">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Mobile no.</label>
                    </div>
                    <div class="col-lg-8">
                      <input value="${studentList.studentMobile}" required="required" class="form-control" maxlength="10" minlength="10" onkeypress="javascript:return isNumber(event)" name="studentMobile" type="text" placeholder="Enter Mobile no.">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Email</label>
                    </div>
                    <div class="col-lg-8">
                      <input value="${studentList.studentEmail}" required="required" class="form-control" name="studentEmail" type="email" placeholder="Enter Email">
                    </div>
                  </div>
                  
                  <c:if test="${studentList.studentGender eq 'male'}">
                  <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Gender</label>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="studentGender" id="membershipRadios1" checked="checked" value="male" required="required">
                                Male
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="studentGender" id="membershipRadios2" value="female" required="required">
                                Female
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                        </div>
                      </c:if> 
                      
                    <c:if test="${studentList.studentGender eq 'female'}">
                  <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Gender</label>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="studentGender" id="membershipRadios1" value="male" required="required">
                                Male
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                          <div class="col-sm-2">
                            <div class="form-check">
                              <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="studentGender" id="membershipRadios2" checked="checked" value="female" required="required">
                                Female
                              <i class="input-helper"></i></label>
                            </div>
                          </div>
                        </div>
                      </c:if>   
                        
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Enrollment no.</label>
                    </div>
                    <div class="col-lg-8">
                      <input value="${studentList.studentEnrollmentNumber}" required="required" id="enrollmentNumber" onkeypress="javascript:return isNumber(event)" class="form-control" maxlength="12" minlength="12" name="studentEnrollmentNumber" type="text" placeholder="Enter Enrollment No.">
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                  <div class="col-lg-3">
                      <label class="col-form-label">Shift</label>
                    </div>
                    <div class="col-lg-8">
                         <select required="required" class="form-control" id="selectShift" name="studentShift">
                           <option value="selectShift">Select Shift</option>
                          <c:if test="${studentList.studentShift eq 1}">
                         <option selected="selected">1</option>
                         <option>2</option>
                             </c:if>
                             <c:if test="${studentList.studentShift eq 2}">
                         <option >1</option>
                         <option selected="selected">2</option>
                             </c:if>
                         </select>
                     </div>
                  </div>
              
                  
                  <div class="form-group row">
                    
                    <div class="col-lg-3">
                      <label class="col-form-label">Branch</label>
                    </div>
                    <div class="col-lg-8">
                      <select required="required" class="form-control" id="selectBranch" name="studentBranchId">
                          <option value="selectBranch">Select Branch</option>
                        
                          <c:forEach items="${sessionScope.branchList}" var="x"> 
                        	
                        	<c:if test="${studentList.branchVO.branchId eq x.branchId}">
                        	  <option selected="selected" value="${x.branchId}">${x.branchName}</option>
                        	</c:if>
                        	<c:if test="${studentList.branchVO.branchId ne x.branchId}">
                        	  <option value="${x.branchId}">${x.branchName}</option>
                        	</c:if>
                        	
                          </c:forEach>
                        
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                <div class="col-lg-3">
                      <label class="col-form-label">Semester</label>
                    </div>
                    <div class="col-lg-8">
                      <select required="required" class="form-control" id="selectSemester" name="studentSemesterId">
                          <option value="selectSemester">Select Semester</option>
                        	<c:forEach items="${sessionScope.semesterList}" var="y"> 
                          
                          <c:if test="${studentList.semesterVO.semesterId eq y.semesterId}">
                          		<option value="${y.semesterId}" selected="selected">${y.semesterNumber}</option>
                          </c:if>
                          
                          <c:if test="${studentList.semesterVO.semesterId ne y.semesterId}">
                          		<option value="${y.semesterId}" >${y.semesterNumber}</option>
                          </c:if>
                          
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                  <div class="col-lg-3">
                      <label class="col-form-label">Class</label>
                    </div>
                    <div class="col-lg-8">
                      <select required="required" class="form-control" id="selectClass" name="studentClassId">
                          <option value="selectClass">Select Class</option>
                        	<c:forEach items="${sessionScope.classList}" var="z"> 
                          
                          <c:if test="${studentList.classVO.classId eq z.classId}">
                          		<option selected="selected" value="${z.classId}">${z.className}</option>
                          </c:if>
                          	<c:if test="${studentList.classVO.classId ne z.classId}">
                          		<option value="${z.classId}">${z.className}</option>
                          </c:if>
                          		 
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  
                  
                   <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="studentId" value="${studentList.studentId}">
                    		<input type="hidden" name="flag" value="updateStudent">
                           <input class="btn btn-primary" type="submit" value="Submit" >
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
                        <label for="cname">Name (required="required", at least 2 characters)</label>
                        <input id="cname" class="form-control" name="name" minlength="2" type="text" required="required">
                      </div>
                      <div class="form-group">
                        <label for="cemail">E-Mail (required="required")</label>
                        <input id="cemail" class="form-control" type="email" name="email" required="required">
                      </div>
                      <div class="form-group">
                        <label for="curl">URL (optional)</label>
                        <input id="curl" class="form-control" type="url" name="url">
                      </div>
                      <div class="form-group">
                        <label for="ccomment">Your comment (required="required")</label>
                        <textarea id="ccomment" class="form-control" name="comment" required="required"></textarea>
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
  
    <script type="text/javascript">
    

    
  function validateform() { 
	  
	  var selectClass = $("#selectClass").val();
	  var selectBranch = $("#selectBranch").val();
	  var selectSemester = $("#selectSemester").val();
	  var selectShift = $("#selectShift").val();
	  
	  if(selectShift == 'selectShift')
	  {
		  alert("Please Select a Shift.");
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
			  if(selectSemester == 'selectSemester')
			  {
				  alert("Please Select a Semester.");
				  return false;
			  }
			  else
			  {
				  if(selectClass == 'selectClass')
				  {
					  alert("Please Select a Class.");
					  return false;
				  }
				  else
				  {
					  return true;
				  }
			  }
		  }
	  }
	  
  }
	    function isNumber(evt) {
	        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
	        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
	            return false;
	       
	        return true;
	    }  
	    
  
  
  </script>
  
  <jsp:include page="livechat.jsp"></jsp:include>
  
</body>

</html>
