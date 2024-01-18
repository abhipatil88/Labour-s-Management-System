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
@WebServlet("/deleteWorker")
public class DeleteWorker extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		WorkerDao dao = new WorkerDao(DBConnect.getConn());
		HttpSession session=req.getSession();
		
		if(dao.deleteWorker(id))
		{
			session.setAttribute("sucMsg","Worker Delete Sucessfully");
			resp.sendRedirect("admin/view_worker.jsp");
			
		}else {
			session.setAttribute("failed","Something went Wrong");
			resp.sendRedirect("admin/view_worker.jsp");
		}
			
	
	}
	
	
	
	

}
