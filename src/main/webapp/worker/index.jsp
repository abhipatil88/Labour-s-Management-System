<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.WorkerDao"%>
<%@page import="com.entity.Worker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="../component/allcss.jsp" %>
</head>
<body>
<c:if test="${empty worObj }">
<c:redirect url ="../Worker_login.jsp"></c:redirect>
</c:if>
		<%@include file="navbar.jsp" %>
		
		<p class="text-center fs-3">Worker Dashboard</p>

	<%
	Worker w = (Worker) session.getAttribute("worObj");
	WorkerDao dao = new WorkerDao(DBConnect.getConn());
	%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Worker <br><%=dao.countWorker()%>
						</p>
					</div>
				</div>
			</div>


			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br><%=dao.countAppointmentByWorkerId(w.getId()) %>
							
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
</body>
</html>