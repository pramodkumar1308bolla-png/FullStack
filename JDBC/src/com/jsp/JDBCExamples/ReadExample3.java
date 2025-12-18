package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadExample3 {
	public static void main(String[] args) {
		//data-base details
		String url="jdbc:mysql://localhost:3306/example";
		String user = "root";
		String password = "Pramod@987654321";
		
//		sql select query
		
		String sql = "SELECT id,name,age FROM student";
		try {
//			1.Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2.establish statement
			Connection connection = DriverManager.getConnection(url,user,password);
//			3.create Statement
			PreparedStatement statement=connection.prepareStatement(sql);
//			4.execute Query
			ResultSet resultset= statement.executeQuery();
//			5.process result
			System.out.println("User list");
			System.out.println("ID\tName\t\tAge");
			System.out.println("-------------------------");
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				String age = resultset.getString("age");
				System.out.println(id + "\t" + name + "\t\t" + age );
			}
//			6.close the resource
			resultset.close();
			statement.close();
			connection.close();	
		} catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
