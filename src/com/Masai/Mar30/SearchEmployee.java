package com.Masai.Mar30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchEmployee {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		
		int id = input.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn = DriverManager.getConnection(url,"root","santhosh")){
		
			PreparedStatement ps =  conn.prepareStatement(" select * from employee where eid = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("Employee id :" + rs.getInt("eid"));
				System.out.println("Employee name :" + rs.getString("name"));
				System.out.println("Employee salary :" + rs.getInt("salary"));
				
			}else
				System.out.println("Employee id not fount");
			
			
		
	     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
}
