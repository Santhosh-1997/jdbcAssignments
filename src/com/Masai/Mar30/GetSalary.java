package com.Masai.Mar30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetSalary {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the employee id");
		
		int id = input.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn = DriverManager.getConnection(url, "root", "santhosh")){
			
			PreparedStatement ps = conn.prepareStatement("select salary from employee where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Salary is :" + rs.getInt("salary"));
			}else {
				System.out.println("Employee id not found");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
