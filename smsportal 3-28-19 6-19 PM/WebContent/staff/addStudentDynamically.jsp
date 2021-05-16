<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="vo.BranchVO"%>
<%@page import="vo.SemesterVO"%>
<%@page import="dao.ClassDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BranchDAO"%>
<%@page import="dao.SemesterDAO"%>
<%@page import="vo.ClassVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Add Student Dynamically</title>
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
	
	
	
	ClassDAO classDAO=new ClassDAO();
	List<ClassVO> classList=classDAO.searchClass();
	session.setAttribute("classList",classList);
	
	SemesterDAO semesterDAO=new SemesterDAO();
	List<SemesterVO> semesterList=semesterDAO.searchSemester();
	session.setAttribute("semesterList",semesterList);
	
	BranchDAO branchDAO=new BranchDAO();
	List<BranchVO> branchList=branchDAO.searchBranch();
	session.setAttribute("branchList",branchList);
	
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
                  <form action="<%=request.getContextPath()%>/StudentController" id="form" method="post" onsubmit="return validateform();" enctype="multipart/form-data">
                  <h4 class="card-title">Add Student Dynamically</h4>
                  
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Branch</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" id="selectBranch" name="studentBranch">
                          <option value="selectBranch">Select Branch</option>
                        	<c:forEach items="${sessionScope.branchList}" var="x"> 
                          <option value="${x.branchId}">${x.branchName}</option>
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                <div class="col-lg-3">
                      <label class="col-form-label">Semester</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" id="selectSemester" name="studentSemester">
                          <option value="selectSemester">Select Semester</option>
                        	<c:forEach items="${sessionScope.semesterList}" var="y"> 
                          <option value="${y.semesterId}">${y.semesterNumber}</option>
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                  <div class="col-lg-3">
                      <label class="col-form-label">Class</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" id="selectClass" name="studentClass">
                          <option value="selectClass">Select Class</option>
                        	<c:forEach items="${sessionScope.classList}" var="z"> 
                          <option value="${z.classId}">${z.className}</option>
                          </c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                  <div class="col-lg-3">
                      <label class="col-form-label">Shift</label>
                    </div>
                    <div class="col-lg-8">
                         <select required="required" class="form-control" id="selectShift" name="studentShift">
                          <option value="selectShift">Select Shift</option>
                         <option>1</option>
                         <option>2</option>
                         </select>
                     </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Upload Excel(.csv) File</label>
                      
                    </div>
                    <div class="col-lg-8">
                      <input accept=".csv" required="required" class="form-control ajax-upload-dragdrop" maxlength="" id="input_file" name="fileName" type="file" placeholder="Type Something..">
                    <br>
                    	<p class="card-description"> Only upload ' .csv ' file and use the format of given file and also don't forget to change to ' Number ' Format before saving your file. <a href="<%=request.getContextPath()%>/doc/samples/studentSampleFile.csv" target="_blank" download>Click here</a> to download that file.  </p>
                    </div>
                  </div>
                   <div class="col-12" align="center">
                    		<br/>
                 
                    		<input type="hidden" name="flag" value="insertStudentDynamically">
                           <input class="btn btn-primary" type="submit" value="Submit">
                    </div>
              </form>   
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
  <script src="../admin/adminResources/js/form-validation.js"></script>
  <script src="../admin/adminResources/js/bt-maxLength.js"></script>
  <!-- End custom js for this page-->
  
   <script type="text/javascript">
    
  function validateform() { 
	  
	  var selectClass = $("#selectClass").val();
	  var selectBranch = $("#selectBranch").val();
	  var selectSemester = $("#selectSemester").val();
	  var selectShift = $("#selectShift").val();
	  
	  
	  if(form.input_file.value.toLowerCase().lastIndexOf(".csv")==-1) 
		 {
			alert("Please only upload '.csv' extention file");
			form.input_file.focus(); 
			return false;
		}
	  
	  
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
  
  </script>
  
  <jsp:include page="livechat.jsp"></jsp:include>
</body>

</html>
