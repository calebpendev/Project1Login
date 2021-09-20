package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class LoginDao {
	public String checkLogin(LoginBean loginBean) {	
		
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			con = DBConnection.createConnection();			
			
			String query = 	"select * from [User_Registration] where userName = ? and password = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			System.out.println("Statement after generating : " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			System.out.println(userName);
			System.out.println(password);
			
			
						
		if (!rs.next()) {
			return "NotFound";
		}
		else {
			return "Success";
		}
		}		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return "Oops something went wrong";
		
		
	}
	}



