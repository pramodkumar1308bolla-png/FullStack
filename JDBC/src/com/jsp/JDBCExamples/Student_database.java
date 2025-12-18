package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student_database {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "Pramod@987654321";

		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			while (true) {
				System.out.println("==========Student Data Application=============");
				System.out.println("1.Add new Student");
				System.out.println("2.Display all student result");
				System.out.println("3.Find the topper(student with highest marks)");
				System.out.println("4.Claculate average marks for a specific course");
				System.out.println("5.Update marks for a student based on roll number");
				System.out.println("6.Delete a student record");
				int select = sc.nextInt();
				switch (select) {
				case 1:
					sc.nextLine();
					System.out.print("Enter Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Course: ");
					String course = sc.nextLine();
					System.out.print("Enter Marks: ");
					int marks = sc.nextInt();

					String query = "INSERT INTO students (name, Course, marks) VALUES (?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, name);
					ps.setString(2, course);
					ps.setInt(3, marks);
					ps.executeUpdate();
					ResultSet generatedKeys = ps.getGeneratedKeys();
					if (generatedKeys.next()) {
						int newId = generatedKeys.getInt(1);
						System.out.println("Student added successfully "+ newId);
					}
					break;

				case 2:
					String displayQuery = "SELECT * FROM students";
					PreparedStatement displaySt = connection.prepareStatement(displayQuery);
					ResultSet rs = displaySt.executeQuery();
					while (rs.next()) {
						System.out.println("name: " + rs.getString("name") 
								+ "course:" + rs.getString("course") + " marks: " + rs.getInt("marks"));
					}
					break;
				case 3:
					String highestM = "SELECT * FROM students ORDER BY marks DESC LIMIT 1";
					PreparedStatement highestSt = connection.prepareStatement(highestM);
					ResultSet hs = highestSt.executeQuery();
					if (hs.next()) {
						System.out
								.println("Topper: " + hs.getString("name") + " with " + hs.getInt("marks") + " marks");
					} else {
						System.out.println("No records found.");
					}
					break;

				case 4:
					System.out.print("Enter Course Name: ");
					sc.nextLine();
					
					String ncourse = sc.nextLine();
					String specificQuery = "SELECT AVG(marks) AS avg_marks FROM students WHERE course = ?";
					PreparedStatement specificSt = connection.prepareStatement(specificQuery);
					specificSt.setString(1, ncourse);
					ResultSet result = specificSt.executeQuery();
					if (result.next()) {
						System.out.println("Average marks for " + ncourse+ ": "
								+ result.getDouble("avg_marks"));
					} else {
						System.out.println("No records found for that course.");
					}
					break;

				case 5:
					System.out.println("Enter new Marks");
					int newMarks = sc.nextInt();
					String updateQuery = "DELETE FROM students WHERE roll_no =?";
					PreparedStatement updateSt = connection.prepareStatement(updateQuery);
					updateSt.setInt(1, newMarks);
					int updated = updateSt.executeUpdate();
					if (updated > 0) {
						System.out.println("Student marks updated");
					} else {
						System.out.println("Student id not found");
					}
					break;
				case 6:
					System.out.println("Enter Student roll to delete");
					int deleteRoll = sc.nextInt();
					String deleteQuery = "DELETE FROM students WHERE roll_no =?";
					PreparedStatement deleteSt = connection.prepareStatement(deleteQuery);
					deleteSt.setInt(1, deleteRoll);
					int deleted = deleteSt.executeUpdate();
					if (deleted > 0) {
						System.out.println("Student ROLL HAS DELETED");
					} else {
						System.out.println("Student ROLL not found");
					}
					break;
				}
			}
//			sc.close();
//			connection.close();
//			System.exit(0);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
