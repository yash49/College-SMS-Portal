<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
     	
     		  <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/index.jsp">
              <i class="ti-home menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
        
     
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="ti-user menu-icon"></i>
              <span class="menu-title">Manage Staff</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/admin/addStaff.jsp">Add Staff</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/admin/viewStaff.jsp">View Staff</a></li>
                
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-advanced" aria-expanded="false" aria-controls="ui-advanced">
              <i class="ti-view-list menu-icon"></i>
              <span class="menu-title">Manage Branches</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-advanced">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/addBranch.jsp">Add Branch</a></li>
                <li class="nav-item"> <a class="nav-link" href="../admin/viewBranch.jsp">View Branches</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui" aria-expanded="false" aria-controls="ui">
              <i class="ti-view-list menu-icon"></i>
              <span class="menu-title">Manage Semester</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/addSemester.jsp">Add Semester</a></li>
                <li class="nav-item"> <a class="nav-link" href="../admin/viewSemester.jsp">View Semester</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-ad" aria-expanded="false" aria-controls="ui-ad">
              <i class="ti-view-list menu-icon"></i>
              <span class="menu-title">Manage Class</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-ad">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/addClass.jsp">Add Class</a></li>
                <li class="nav-item"> <a class="nav-link" href="../admin/viewClass.jsp">View Classes</a></li>
              </ul>
            </div>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="ti-clipboard menu-icon"></i>
              <span class="menu-title">Manage Designation</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="../admin/addDesignation.jsp">Add Designation</a></li>                
                <li class="nav-item"><a class="nav-link" href="../admin/viewDesignation.jsp">View Designation</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#senderid" aria-expanded="false" aria-controls="senderid">
              <i class="ti-write menu-icon"></i>
              <span class="menu-title">Manage Sender ID</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="senderid">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/addSenderId.jsp">Add Sender Id</a></li>
                <li class="nav-item"> <a class="nav-link" href="../admin/viewSenderId.jsp">View Sender Id</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic22" aria-expanded="false" aria-controls="ui-basic">
              <i class="ti-harddrives menu-icon"></i>
              <span class="menu-title">Sms History</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic22">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/viewStaffForHistory.jsp">View History</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#editors" aria-expanded="false" aria-controls="editors">
              <i class="ti-comment menu-icon"></i>
              <span class="menu-title">Manage Complains</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="editors">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="../admin/viewComplain.jsp">View Complain</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
              <i class="ti-bar-chart-alt menu-icon"></i>
              <span class="menu-title">Manage Feedback</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="charts">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../admin/viewFeedback.jsp">View Feedback</a></li>
              </ul>
            </div>
          </li>
          
        </ul>
      </nav>