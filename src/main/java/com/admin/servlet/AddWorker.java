package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.WorkerDao;
import com.db.DBConnect;
import com.entity.Worker;
@SuppressWarnings("serial")
@WebServlet("/addWorker")
public class AddWorker extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String fullName=req.getParameter("fullname");
			String dob=req.getParameter("dob");
			String qualification=req.getParameter("qualification");
			String specialist=req.getParameter("specialist");
			String email=req.getParameter("email");
			String mobno=req.getParameter("mobno");
			String password=req.getParameter("password");
			
		Worker w = new Worker(fullName, dob, qualification, specialist, email, mobno, password);
		WorkerDao dao = new WorkerDao(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		if(dao.registerWorker(w))
		{
			session.setAttribute("sucMsg","Worker Added Sucessfully");
			resp.sendRedirect("admin/worker.jsp");
			
		}else {
			session.setAttribute("failed","Something went Wrong");
			resp.sendRedirect("admin/worker.jsp");
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
