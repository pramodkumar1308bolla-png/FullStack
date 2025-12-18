package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample5 {

	public static void main(String[] args) {
		// data-base details
		String url = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String password = "Pramod@987654321";
		// SQL DELETE query
		String sql = "DELETE FROM student where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.establish the connection
			Connection connection = DriverManager.getConnection(url, user, password);
			// 3.create statement
			PreparedStatement statement = connection.prepareStatement(sql);
			// 4.set parameters(delete for a specific id)

			statement.setInt(1, 105);
			// 5.execute update
			int rows = statement.executeUpdate();
			// 6.print the result
			if (rows > 0) {
				System.out.println("Deleted user with id");
			} else {
				System.out.println("No user found with id");
			}

			// 7.close
			statement.close();
			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
