
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
    color:#ddd;
    text-shadow:1px 1px #bbb, 2px 2px #666, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:before {
    content: ' ';
}

.rating > input:checked ~ label {
    color: #f70;
    text-shadow:1px 1px #c60, 2px 2px #940, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:hover,
.rating:not(:checked) > label:hover ~ label {
    color: gold;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > input:checked + label:hover,
.rating > input:checked + label:hover ~ label,
.rating > input:checked ~ label:hover,
.rating > input:checked ~ label:hover ~ label,
.rating > label:hover ~ input:checked ~ label {
    color: #ea0;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > label:active {
    position:relative;
    top:2px;
    left:2px;
}

</style>

<link rel="stylesheet" href="../admin/adminResources/css/star.css">

	<!-- base href="${pageContext.request.contextPath}/staff/">   -->
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Add Feedback</title>
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
               <form action="<%=request.getContextPath() %>/FeedbackController" method="post" onsubmit="return validateform();">
                  <h4 class="card-title">Give Feedback</h4>
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Subject</label>
                    </div>
                    <div class="col-lg-8">
                      <input required="required" class="form-control" maxlength="" name="feedbackSubject" type="text" placeholder="Enter Feedback Subject">
                    </div>
                  </div>
            
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Description</label>
                    </div>
                    <div class="col-lg-8">
                      <textarea name="feedbackDescription" required="required" id="" class="form-control" maxlength="" rows="2" placeholder="Enter Feedback Description"></textarea>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <div class="col-lg-3">
                      <label class="col-form-label">Description</label>
                    </div>
                    <div class="col-lg-8">
                    <div class="form-group "> 
					<div class="rating">
                        <input type="radio" id="star5" name="rating" value="5" /><label for="star5" title="Rocks!"><span class="fa fa-star checked"></span></label>
    					<input type="radio" id="star4" name="rating" value="4" /><label for="star4" title="Pretty good"><span class="fa fa-star checked"></span></label>
    					<input type="radio" id="star3" name="rating" value="3" /><label for="star3" title="Meh"><span class="fa fa-star checked"></span></label>
				    	<input type="radio" id="star2" name="rating" value="2" /><label for="star2" title="Kinda bad"><span class="fa fa-star checked"></span></label>
				    	<input type="radio" id="star1" name="rating" value="1" /><label for="star1" title="Sucks big time"><span class="fa fa-star checked"></span></label>    
                     </div>
                     </div>
                      </div>
                  </div>
                  
                  
                  <div class="form-group row">
                  <div class="col-12" align="center">
                    		<br/>
                    		<input type="hidden" name="flag" value="insertFeedback">
                               <input class="btn btn-primary" type="submit" value="Submit">
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
  	  
    	var radios = document.getElementsByName("rating");
        var formValid = false;

        var i = 0;
        while (!formValid && i < radios.length) {
            if (radios[i].checked) formValid = true;
            i++;        
        }

        if (!formValid) alert("You Must have select Star Rating !");
        return formValid;
    }
    
    </script>
  
  <jsp:include page="livechat.jsp"></jsp:include>

</body>


</html>
