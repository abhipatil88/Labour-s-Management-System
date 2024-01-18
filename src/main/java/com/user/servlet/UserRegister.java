package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String fullName=req.getParameter("fullname");
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			User u = new User(fullName, email, password);
			
			UserDao dao = new UserDao(DBConnect.getConn());
			
			HttpSession session=req.getSession();
			
			
			boolean f=dao.register(u);
			
			if(f) {
			session.setAttribute("sucMsg", "Register Succesfully");
			resp.sendRedirect("Signup.jsp");
			}else 
			{
				session.setAttribute("Failed", "somethingWrong on Server..please try again");
				resp.sendRedirect("Signup.jsp");
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	

}
