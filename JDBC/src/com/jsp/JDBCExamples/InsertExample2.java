package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample2 {
	public static void main(String[] args) {
		// data-base details
		String url = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String password = "Pramod@987654321";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			String user1 = "Insert INTO student(id,name,age) values(104,'Rhea','25')";
			statement.executeUpdate(user1);
			String user2 = "Insert INTO student(id,name,age) values(105,'Ankur','39')";
			statement.executeUpdate(user2);
			String user3 = "Insert INTO student(id,name,age) values(106,'Pramodh','100')";
			statement.executeUpdate(user3);
			System.out.println("3 users added successfully");
			statement.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
