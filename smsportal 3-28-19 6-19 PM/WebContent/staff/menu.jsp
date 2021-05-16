<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
        
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/staff/index.jsp">
              <i class="ti-home menu-icon"></i>
              <span class="menu-title">Dashboard</span>
            </a>
          </li>
        
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#charts" aria-expanded="false" aria-controls="charts">
              <i class="ti-user menu-icon"></i>
              <span class="menu-title">Manage Student</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="charts">
              <ul class="nav flex-column sub-menu">
                 <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/addStudentStatically.jsp">Add Statically</a></li>                
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/addStudentDynamically.jsp">Add Dynamically</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/viewStudent.jsp">View Students</a></li>
              </ul>
            </div>
          </li>
     
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="ti-email menu-icon"></i>
              <span class="menu-title">Quick SMS</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/sendQuickSms.jsp">Send normal SMS</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/sendQuickSmsViaPhonebook.jsp">Send via Phonebook</a></li>
                
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-advanced" aria-expanded="false" aria-controls="ui-advanced">
              <i class="ti-star menu-icon"></i>
              <span class="menu-title">Group SMS</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-advanced">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/sendGroupSms.jsp">Send Group SMS</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/addGroup.jsp">Create Groups</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/viewGroup.jsp"">View Groups</a></li>
              </ul>
            </div>
          </li>
         
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#form-elements" aria-expanded="false" aria-controls="form-elements">
              <i class="ti-alarm-clock menu-icon"></i>
              <span class="menu-title">Future SMS</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="form-elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/sendFutureSms.jsp">Send Future SMS</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/sendFutureSmsViaPhonebook.jsp">Send Via Phonebook</a></li>                
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/viewFutureSms.jsp">View Future SMS</a></li>
              </ul>
            </div>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui" aria-expanded="false" aria-controls="ui">
              <i class="ti-email menu-icon"></i>
              <span class="menu-title">Static SMS</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/sendStaticSms.jsp">Send Static SMS</a></li>
                
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#elements" aria-expanded="false" aria-controls="elements">
              <i class="ti-email menu-icon"></i>
              <span class="menu-title">Dynamic SMS</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="elements">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/sendDynamicSms.jsp">Send Dynamic SMS</a></li>
              </ul>
            </div>
          </li>          

          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#table" aria-expanded="false" aria-controls="table">
              <i class="ti-write menu-icon"></i>
              <span class="menu-title">SMS Template</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="table">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/addSmsTemplate.jsp">Create SMS Template</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/viewSmsTemplate.jsp">View SMS Templates</a></li>
           	  </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#tables" aria-expanded="false" aria-controls="tables">
              <i class="ti-harddrives menu-icon"></i>
              <span class="menu-title">SMS History</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="tables">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/viewSmsHistory.jsp">View SMS History</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#editors" aria-expanded="false" aria-controls="editors">
              <i class="ti-comment menu-icon"></i>
              <span class="menu-title">Complain</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="editors">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/addComplain.jsp">Add Complain</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/staff/viewComplain.jsp">View Complain</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#chart" aria-expanded="false" aria-controls="chart">
              <i class="ti-bar-chart-alt menu-icon"></i>
              <span class="menu-title">Feedback</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="chart">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/addFeedback.jsp">Add Feedback</a></li>
                <li class="nav-item"> <a class="nav-link" href="<%=request.getContextPath()%>/staff/viewFeedback.jsp">View Feedback</a></li>
              
              </ul>
            </div>
          </li>
          
          
        </ul>
      </nav>