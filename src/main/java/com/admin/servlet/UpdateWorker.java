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
@WebServlet("/updateWorker")
public class UpdateWorker extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			
			int id=Integer.parseInt(req.getParameter("id"));
			
		Worker w = new Worker(id,fullName, dob, qualification, specialist, email, mobno, password);
		WorkerDao dao = new WorkerDao(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		if(dao.updateWorker(w))
		{
			session.setAttribute("sucMsg","Worker Update Sucessfully");
			resp.sendRedirect("admin/view_worker.jsp");
			
		}else {
			session.setAttribute("failed","Something went Wrong");
			resp.sendRedirect("admin/view_worker.jsp");
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		
		
	}


