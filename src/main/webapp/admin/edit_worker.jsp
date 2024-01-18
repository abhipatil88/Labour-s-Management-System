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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Worker Details</p>
						<c:if test="${not empty failed}">
							<p class="fs-3 text-center text-danger">${failed}</p>
							<c:remove var="failed" scope="session" />
						</c:if>
						<c:if test="${not empty sucMsg}">
							<div class="fs-3 text-center text-success" role="alert">${sucMsg}</div>
							<c:remove var="sucMsg" scope="session" />
						</c:if>
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						WorkerDao dao2 = new WorkerDao(DBConnect.getConn());
						Worker w = dao2.getWorkerById(id);
						%>
						
						
						<form action="../updateWorker" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control"
									value=" <%=w.getFullName()  %>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control"
									value="<%=w.getDob() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control"
									value="<%=w.getQualification() %>">
							</div>
							<div class="mb-3">
								<label class="form-label">Working Specialist</label> <select name="specialist"
									required class="form-control">
									<option><%=w.getSpecialist() %></option>

									<%
									specialistDao dao = new specialistDao(DBConnect.getConn());
									List<Specialist> list = dao.getAllSpecialists();
									for (Specialist s : list){
									%>
									<option><%=s.getSpecialistName() %></option>
									<%
									}
									%>


								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									value="<%=w.getEmail() %>" required name="email" 
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									value="<%=w.getMobno() %>" required name="mobno" 
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									value="<%=w.getPassword() %>" name="password" type="text" class="form-control">
							</div>
							<input type="hidden" name="id" value="<%=w.getId() %>">

							<button type="submit" class="btn btn-primary COL-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
			
			
			</div>
	</div>
</body>
</html>