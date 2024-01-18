<%@page import="com.entity.Worker"%>
<%@page import="com.dao.WorkerDao"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.db.specialistDao"%>
<%@page import="com.entity.Specialist"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	
	
	<%@include file="navbar.jsp" %>
			<div class="container-fluid p-3">
		<div class="row">
			
			<div class="col-md-12">
				<div class="card paint-card">
					<div class ="card-body">
						<p class="fs-3 text-centre">Worker Details</p>
						<c:if test="${not empty failed}">
							<p class="fs-3 text-center text-danger">${failed}</p>
							<c:remove var="failed" scope="session" />
						</c:if>
						<c:if test="${not empty sucMsg}">
							<div class="fs-3 text-center text-success" role="alert">${sucMsg}</div>
							<c:remove var="sucMsg" scope="session" />
						</c:if>
						
						
						
						<table class="table">
							<thead>
								<tr>
									<th scope="COL">Full Name</th>
									<th scope="COL">DOB</th>
									<th scope="COL">Qualification</th>
									<th scope="COL">Specialist</th>
									<th scope="COL">Email</th>
									<th scope="COL">Mob No</th>
									<th scope="COL">Action</th>
									</tr>
							
							</thead>
							<tbody>
							
								<%
								WorkerDao dao2=new WorkerDao(DBConnect.getConn());
								List<Worker> list2=dao2.getAllWorker();
								for(Worker w:list2)
								{%>
								<tr>
									<td><%=w.getFullName() %></td>
									<td><%=w.getDob() %></td>
									<td><%=w.getQualification() %></td>
									<td><%=w.getSpecialist() %></td>
									<td><%=w.getEmail() %></td>
									<td><%=w.getMobno() %></td>
									<td><a href= "edit_worker.jsp?id=<%=w.getId() %>"
									 class="btn btn-sm btn-primary">Edit</a> 
									 <a href= "../deleteWorker?id=<%=w.getId() %>"
									  class="btn btn-sm btn-danger">Delete</a></td> 						
							</tr>
							<%}
							
							%>
							
					  		</tbody>	
						</table>
					</div>
				</div>
			</div>
			</div>
	</div>
</body>
</html>
