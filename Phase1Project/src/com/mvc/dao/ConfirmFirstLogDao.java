package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;


public class ConfirmFirstLogDao {
	public String checkFirstLog (LoginBean loginBean) {
		
		String userName = loginBean.getUserName();
		
		Connection con = null;
		PreparedStatement prepStatement = null;
		
		try {
			con = DBConnection.createConnection();
			
			System.out.println(userName);
			
			String query = "Select firstLog from [USER_REGISTRATION] where userName = ?"; //check if firstLog has a value
			prepStatement = con.prepareStatement(query);
			prepStatement.setString(1, userName);
			ResultSet rs = prepStatement.executeQuery();			
			
			String find;
			
			if(rs.next()) {
				find = rs.getString("firstLog");
				if (rs.wasNull()) { //if it is null then flag does not exist and redirects to introduction input
					return "FirstLog";
					
				}
				else {
					
					return "ReturnLog";
				}
			}		

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Something went wrong";
	}
}
