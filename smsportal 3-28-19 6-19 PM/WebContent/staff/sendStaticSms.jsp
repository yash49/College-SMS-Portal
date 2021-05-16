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
  <title>Send Static SMS</title>
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
               <form action="<%=request.getContextPath() %>/StaticSmsController" id="form" onsubmit="return validateform();" method="post" enctype="multipart/form-data">
                  <h4 class="card-title">Send Static SMS</h4>
                  
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Enter column value for sending SMS</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" maxlength="" name="sendSms" type="text" placeholder="Enter column value for sending SMS">
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
                      <label class="col-form-label">Template</label>
                    </div>
                    <div class="col-lg-8">
                     <select class="form-control" id="template" name="smsTemplateName" onchange="fetchTemplate()">
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
                    <div class="col-lg-3">
                      <label class="col-form-label">Upload Excel(.csv) File</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control ajax-upload-dragdrop" id="input_file" name="file" type="file" style="" accept=".csv">
                    	  <br>
                    	<p class="card-description"> Only upload ' .csv ' file and use the format of given file and also don't forget to change to ' Number ' Format before saving your file. <a href="<%=request.getContextPath()%>/doc/samples/staticSmsSampleFile.csv" target="_blank" download>Click here</a> to download that file.  </p>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input required="required" type="hidden" name="flag" value="sendStaticSms">
                               <input required="required" class="btn btn-primary" type="submit" value="Send">
                    </div>
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
	  
	  if(form.input_file.value.toLowerCase().lastIndexOf(".csv")==-1) 
		 {
			alert("Please only upload '.csv' extention file");
			form.input_file.focus(); 
			return false;
		}
	  
	  var selectSenderId = $("#selectSenderId").val();
  	
	  	if(selectSenderId == 'selectSenderId')
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
