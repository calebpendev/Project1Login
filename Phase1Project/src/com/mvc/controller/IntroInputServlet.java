package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.IntroductionBean;
import com.mvc.bean.LoginBean;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.ConfirmFirstLogDao;
import com.mvc.dao.IntroDao;
import com.mvc.dao.LoginDao;
import com.mvc.dao.AddTag;
import com.mvc.dao.RegisterDao;


@WebServlet("/IntroInputServlet")
public class IntroInputServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public IntroInputServlet() {}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String introduction = request.getParameter("introduction");
		String hobby = request.getParameter("hobby");
		String userName = (String)request.getParameter("userName");
		
		RegisterBean registerBean = new RegisterBean();
		IntroductionBean introbean = new IntroductionBean();
		IntroDao introDao = new IntroDao();
		AddTag addTag = new AddTag();
		
		introbean.setIntroduction(introduction);
		introbean.setHobby(hobby);			
		introbean.setUserName(userName);
		
		//calls the IntroDuctionDao method to place the users Introduction and Hobby
		String introInput = introDao.inputIntro(registerBean, introbean);
		
		if(introInput.equals("Success")) {
			//After successful Introduction input a method is called to place a flag in the User_Registration Table
			//That way the user won't have to input this information on subsequent log ins
			addTag.addTag(registerBean);
			request.setAttribute("introduction", introduction);
			request.getRequestDispatcher("/UserIntro.jsp").forward(request, response);
		}
		else {
            request.setAttribute("errMessage", introInput);
            request.getRequestDispatcher("/UserIntroductionForm.jsp").forward(request, response);
			
		}
		
		
	}	
	


}
