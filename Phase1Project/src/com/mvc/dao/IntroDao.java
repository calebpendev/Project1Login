package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.IntroductionBean;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class IntroDao{
	public String inputIntro(RegisterBean registerBean, IntroductionBean introBean) {
		
	    PreparedStatement prepStatementIntro = null;
	    PreparedStatement prepStatement = null;
	    Connection con = null;   
	    
	    String userName = registerBean.getUserName();	    
	    String introduction = introBean.getIntroduction();
	    String hobby = introBean.getHobby();
	    
		try {
			con = DBConnection.createConnection();
			
			 String queryIntro = "select * from [User_Registration] where userName=?";
					 prepStatementIntro = con.prepareStatement(queryIntro);
					 prepStatementIntro.setString(1, userName);
					 ResultSet rs = prepStatementIntro.executeQuery();					 
					 int selectId;					 
						 
					selectId = rs.getInt("ID");
					System.out.println(selectId);					 
						 
				
				String query = "Insert into user_introduction(ID, introduction, hobby) values(?,?,?)";
					   prepStatement = con.prepareStatement(query);
					   prepStatement.setInt(1, selectId);
					   prepStatement.setString(2, introduction);
					   prepStatement.setString(3, hobby);
					   ResultSet result = prepStatement.executeQuery();	
					   
					   int i= prepStatement.executeUpdate();
					   
						if(i!=0) {
							return "Success";
						}
						else {
							return "Fail";
						}
								 
					
		}
					catch(SQLException e) {
						e.printStackTrace();
					}
					return "Something went wrong";
					 
	}



}
