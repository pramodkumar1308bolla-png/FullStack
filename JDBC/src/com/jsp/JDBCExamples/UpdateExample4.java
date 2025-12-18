package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample4 {
	public static void main(String[] args) {
		// data-base details
		String url = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String password = "Pramod@987654321";
		// sql update query updates user name based on id
		String sql = "UPDATE student SET name = ? WHERE id = ?";
		try {
			// 1.load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.establish the connection
			Connection connection = DriverManager.getConnection(url, user, password);
			// 3.create statement
			PreparedStatement statement = connection.prepareStatement(sql);
			// 4.set parameters(update name for a specific id)

			statement.setString(1, "ROMIT");
			statement.setInt(2, 105);

			// 5.execute update
			int rowsUpdated = statement.executeUpdate();
			// 6.print the result
			if (rowsUpdated > 0) {
				System.out.println("User updated successfully");
			} else {
				System.out.println("No user found with the given id");
			}

			// 7.close
			statement.close();
			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}