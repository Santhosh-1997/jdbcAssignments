package com.Masai.Mar30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProvideBonus {
	
	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn = DriverManager.getConnection(url,"root","santhosh")){
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary = salary +500");
			
			int row = ps.executeUpdate();
			
		    if(row>0)
		    	System.out.println(row + " rows affected");
		    else
		    	System.out.println("No row affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
