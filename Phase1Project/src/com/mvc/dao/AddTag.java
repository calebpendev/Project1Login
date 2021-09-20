package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class AddTag {
	public void addTag(RegisterBean registerBean) {
		
		String userName = registerBean.getUserName();
		PreparedStatement prepStatementAdd = null;
		Connection con = null;
		con = DBConnection.createConnection();
		
		try {
			String queryAdd = "update user_registration set firstLog = 'y' where userName = ? "; //need to find proper SQL syntax for adding a flag to table
			prepStatementAdd = con.prepareStatement(queryAdd);
			prepStatementAdd.setString(1, userName);
			prepStatementAdd.executeQuery();
			
		}
		catch(SQLException e){
			e.printStackTrace();			
		}
		
		

		
	}


}
