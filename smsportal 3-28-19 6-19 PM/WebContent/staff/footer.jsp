<%@page import="java.time.Year"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
          <%
          int year = Year.now().getValue();
          %>
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">© <%=year%> , All Rights Reserved by Yash Shah .</span>
           
          </div>
        </footer>