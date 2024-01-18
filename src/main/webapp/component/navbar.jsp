<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-hospital">  </i>Labour's-HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      
      <c:if test="${empty userObj }">
      			<li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Admin_login.jsp"><i class="fa-solid fa-right-to-bracket"></i>Admin</a></li>
         
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Worker_login.jsp">Worker</a></li>
         
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="User_appointment.jsp">Appointment</a></li>
         
          <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user_login.jsp">User</a>
        </li>
      
      </c:if>
        
        <c:if test="${not empty userObj }">
         	 <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="User_appointment.jsp">Appointment</a></li>
          		 <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="view_appointment.jsp">View Appointment</a></li>
        	
        	
        	<div class="dropdown">
  <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    <i class="fa-solid fa-circle-user"></i> ${userObj.fullName }
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="change_password.jsp">Change Password</a></li>
    <li><a class="dropdown-item" href="userLogout">Logout</a></li>
    
  </ul>
</div>
      </c:if>
      </ul>
      
    </div>
  </div>
</nav>