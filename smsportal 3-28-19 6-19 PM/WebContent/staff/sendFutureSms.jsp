<%@page import="vo.StudentVO"%>
<%@page import="dao.StudentDAO"%>
<%@page import="vo.SmsTemplateVO"%>
<%@page import="dao.SmsTemplateDAO"%>
<%@page import="vo.LoginVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SenderIdDAO"%>
<%@page import="vo.SenderIdVO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <base href="${pageContext.request.contextPath}/staff/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Send Future Sms</title>
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
  
  function fetchTemplate(){
	  
	  document.getElementById("message").value = document.getElementById("template").value;
	
  }
  
  </script>


</head>
<%
	SenderIdDAO  senderIdDAO=new SenderIdDAO();
	
	List<SenderIdVO> senderIdList=senderIdDAO.searchSenderId();
	
	session.setAttribute("senderIdList",senderIdList);
	
	int loginId=(Integer)session.getAttribute("loginId");
	
	LoginVO loginVO=new LoginVO();
	loginVO.setId(loginId);

	SmsTemplateDAO smsTemplateDAO = new SmsTemplateDAO();
	
	List<SmsTemplateVO> smsTemplateList=smsTemplateDAO.searchSmsTemplate(loginVO);
	
	session.setAttribute("smsTemplateList",smsTemplateList);
	
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
               <form action="<%=request.getContextPath() %>/FutureSmsController" method="post" onsubmit="return validateform();">
                  <h4 class="card-title">Send Future Sms</h4>
                  
                  
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Phone number</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" onkeypress="javascript:return isNumber(event)" maxlength="10" minlength="10" name="mobileNumber" type="text" placeholder="Enter Mobile Number">
                    </div>
                  </div>
            
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Message</label>
                    </div>
                    <div class="col-lg-8">
                      <textarea required="required" name="message" id="message" class="form-control" maxlength="160" rows="4" placeholder="Message has a limit of 160 chars."></textarea>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Date and Time</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" maxlength="" name="dateTime" type="datetime-local" >
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Template</label>
                    </div>
                    <div class="col-lg-8">
                      <select class="form-control" name="smsTemplateName" id="template" onchange="fetchTemplate()">
                          	<option value=" ">Select Sms Template</option>
                          	<c:forEach items="${sessionScope.smsTemplateList}" var="z">
                          	<option value="${z.smsTemplateText}">${z.smsTemplateName}</option>
                          	</c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Sender ID</label>
                    </div>
                    <div class="col-lg-8">
                       <select class="form-control" id="selectSenderId" name="senderIdName">
                      <option value="selectSenderId">Select Sender Id</option>
                          <c:forEach items="${sessionScope.senderIdList}" var="z">
                          	<option value="${z.senderIdName}">${z.senderIdName}</option>
                          	</c:forEach>
                        </select>
                      </div>
                  </div>
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input required="required" type="hidden" name="flag" value="insertFutureSms">
                    		<input required="required" type="hidden" name="to" value="futureSms">
                               <input required="required" class="btn btn-primary" type="submit" value="Send">
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
              <!-- 		 <div class="card-body">
                  <h4 class="card-title">Basic form validation</h4>
                  <form class="cmxform" id="commentForm" method="get" action="#">
                    <fieldset>
                      <div class="form-group">
                        <label for="cname">Name (required, at least 2 characters)</label>
                        <input required="required" id="cname" class="form-control" name="name" minlength="2" type="text" required>
                      </div>
                      <div class="form-group">
                        <label for="cemail">E-Mail (required)</label>
                        <input required="required" id="cemail" class="form-control" type="email" name="email" required>
                      </div>
                      <div class="form-group">
                        <label for="curl">URL (optional)</label>
                        <input required="required" id="curl" class="form-control" type="url" name="url">
                      </div>
                      <div class="form-group">
                        <label for="ccomment">Your comment (required)</label>
                        <textarea id="ccomment" class="form-control" name="comment" required></textarea>
                      </div>
                      <input required="required" class="btn btn-primary" type="submit" value="Submit">
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
                        <input required="required" id="firstname" class="form-control" name="firstname" type="text">
                      </div>
                      <div class="form-group">
                        <label for="lastname">Lastname</label>
                        <input required="required" id="lastname" class="form-control" name="lastname" type="text">
                      </div>
                      <div class="form-group">
                        <label for="username">Username</label>
                        <input required="required" id="username" class="form-control" name="username" type="text">
                      </div>
                      <div class="form-group">
                        <label for="password">Password</label>
                        <input required="required" id="password" class="form-control" name="password" type="password">
                      </div>
                      <div class="form-group">
                        <label for="confirm_password">Confirm password</label>
                        <input required="required" id="confirm_password" class="form-control" name="confirm_password" type="password">
                      </div>
                      <div class="form-group">
                        <label for="email">Email</label>
                        <input required="required" id="email" class="form-control" name="email" type="email">
                      </div>
                      <input required="required" class="btn btn-primary" type="submit" value="Submit">
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
    
    function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
            return false;

        return true;
    }  
    
    function validateform() { 
  	  
  	  var selectClass = $("#selectSenderId").val();
    	
  	if(selectClass == 'selectSenderId')
	  {
		  alert("Please Select a Sender Id.");
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  	
    }
    
    </script>

	<jsp:include page="livechat.jsp"></jsp:include>

</body>

</html>
