package com.worker.servlet;

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
@WebServlet("/workerLogin")
public class WorkerLogin extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		WorkerDao dao = new WorkerDao(DBConnect.getConn());
		 Worker worker = dao.login(email, password);
		
		if(worker != null)
		{
			session.setAttribute("worObj",worker);
			resp.sendRedirect("worker/index.jsp");
		}else {
			session.setAttribute("Failed","Invalid email and Password");
			resp.sendRedirect("Worker_login.jsp");
			
		}
	}
	

}
