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
@WebServlet("/userChangePassword")
public class changePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid = Integer.parseInt(req.getParameter("uid"));
		String oldpassword=req.getParameter("oldpassword");
		String newpassword=req.getParameter("newpassword");
		
		UserDao dao = new UserDao(DBConnect.getConn());
		HttpSession session= req.getSession();
		
		if(dao.checkOldPassword(uid, oldpassword))
		{
			if(dao.changePassword(uid, newpassword))
			{
				session.setAttribute("sucMsg", "Password Change Succesfully");
				resp.sendRedirect("change_password.jsp");
			}else {
				session.setAttribute("Failed", "Something Wrong On Server");
				resp.sendRedirect("change_password.jsp");
			}
			
			
		}else {
			session.setAttribute("Failed","old password Incorrect");
			resp.sendRedirect("change_password.jsp");
		}
	}
	

}
