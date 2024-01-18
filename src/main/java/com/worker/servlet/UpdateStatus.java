package com.worker.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int wid=Integer.parseInt(req.getParameter("wid"));
			String comm=req.getParameter("comm");
			
			AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
			
			HttpSession session=req.getSession();
			
			if(dao.updateCommentStatus(id, wid, comm))
			{
				session.setAttribute("sucMSg", "Comment Updated");
				resp.sendRedirect("worker/Client.jsp");
			}else {
				session.setAttribute("errorMsg", "Something Wrong On Server");
				resp.sendRedirect("worker/Client.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
