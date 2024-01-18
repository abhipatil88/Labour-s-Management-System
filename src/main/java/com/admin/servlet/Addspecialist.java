package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.db.specialistDao;
@WebServlet("/addspecialist")
public class Addspecialist extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName=req.getParameter("specName");
		
		specialistDao dao = new specialistDao(DBConnect.getConn());
		boolean f=dao.addspecialist(specName);
		
		HttpSession session=req.getSession();
	
		if(f)
		{
			session.setAttribute("sucMsg","specialist Added Succesfully");
			resp.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("Failed","Something went wrong!");
			resp.sendRedirect("admin/index.jsp");
			
		}
	}
}
