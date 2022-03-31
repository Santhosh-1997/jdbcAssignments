package com.Masai.Mar30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertEmployeeWithourAddress {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		
		int id = input.nextInt();
		
		System.out.println("Enter employee name");
		
		String name = input.next();
		
		System.out.println("Enter employee salary");
		
		int salary = input.nextInt();
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn = DriverManager.getConnection(url,"root","santhosh")){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee (eid,name,salary) values (?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setInt(3, salary);
			
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
