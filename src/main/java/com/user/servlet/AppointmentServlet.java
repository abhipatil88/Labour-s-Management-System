package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;
@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String requirement = req.getParameter("requirement");
		int worker_id = Integer.parseInt(req.getParameter("work"));
		String address = req.getParameter("address");
		
		Appointment ap = new Appointment(userId, fullname, gender, age, appoint_date, email, phno, requirement, worker_id, address,"pending");
		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		
		if(dao.addAppointment(ap))
		{
			session.setAttribute("sucMsg", "Appointment succesfully");
			resp.sendRedirect("User_appointment.jsp");
			
		}else {
			session.setAttribute("Failed", "Something Wrong On Server");
			resp.sendRedirect("User_appointment.jsp");
			
		}
		
	}
	
	

}
