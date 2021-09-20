package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.LoginBean;
import com.mvc.dao.ConfirmFirstLogDao;
import com.mvc.dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("inputUserName");
		String userPassword = request.getParameter("inputPassword");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUserName(userName);
		loginBean.setPassword(userPassword);
		
		LoginDao loginDao = new LoginDao();
		ConfirmFirstLogDao firstLog = new ConfirmFirstLogDao();
		
		String loginSuccess = loginDao.checkLogin(loginBean);
		
		if (loginSuccess.equals("Success")) {
			//calls a method that checks for the tag in the User_Registration table
			String logCount = firstLog.checkFirstLog(loginBean);
			 
			//if firstLog returns FirstLog then user is redirected to a page to fill out Introduction form
			if (logCount.equals("FirstLog")) {
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("/UserIntroductionForm.jsp").forward(request, response);
			//if flag is found then the user is redirected to the User Introduction page to view their introduction info	
			}
			else {
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("/UserIntro.jsp").forward(request, response);				
			}
			
		}
		else {
			request.setAttribute("errMessage", loginSuccess);
            request.getRequestDispatcher("/Login.jsp").forward(request, response);			
		}
		
		
		
				

	}
	
}
