package com.Masai.Mar30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn = DriverManager.getConnection(url, "root", "santhosh")) {
				
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("Employee id :" + rs.getInt("eid"));
				System.out.println("Employee name :" + rs.getString("name"));
				System.out.println("Employee salary :" + rs.getInt("salary"));
				
				System.out.println("==========================================");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
