package com.jsp.JDBCExamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Project_JDBC_example6 {
	public static void main(String[] args) {
	
			// data-base details
			String url = "jdbc:mysql://localhost:3306/student_management_system";
			String user = "root";
			String password = "Pramod@987654321";

			Scanner scanner = new Scanner(System.in);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);
				while (true) {
					System.out.println("\n=====Student Management Menu=====");
					System.out.println("1.Add Student");
					System.out.println("2.View All Students");
					System.out.println("3.Update Student Marks");
					System.out.println("4.Delete Student");
					System.out.println("5.Exit");
					System.out.println("Choose an option");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter name");
						String name = scanner.nextLine();
						System.out.println("Enter course");
						String course = scanner.nextLine();
						System.out.println("Enter marks");
						int marks = scanner.nextInt();
						String insertQuery = "Insert INTO student(name,course,marks) VALUES(?,?,?)";
						PreparedStatement insertSt = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
						insertSt.setString(1, name);
						insertSt.setString(2, course);
						insertSt.setInt(3, marks);
						insertSt.executeUpdate();
						ResultSet generatedKeys = insertSt.getGeneratedKeys();
						if (generatedKeys.next()) {
							int newId = generatedKeys.getInt(1);
							System.out.println("Student added with Id : " + newId);
						}
						break;
					case 2:
						String selectQuery = "SELECT * FROM student";
						PreparedStatement selectSt = con.prepareStatement(selectQuery);
						ResultSet rs = selectSt.executeQuery();
						System.out.println("\n---student list---");
						while (rs.next()) {
							System.out.println("ID:" + rs.getInt("id") + ",Name:" + rs.getString("name") + ",Course:"
									+ rs.getString("course") + ",Marks:" + rs.getInt("marks"));
						}
						break;
//					case 3:
//						System.out.println("Enter Student Id to update");
//						int updatedId = scanner.nextInt();
//						System.out.println("Enter new Marks");
//						int newMarks = scanner.nextInt();
//						String updateQuery = "UPDATE student SET marks=? WHERE id =?";
//						PreparedStatement updateSt = con.prepareStatement(updateQuery);
//						updateSt.setInt(1, newMarks);
//						updateSt.setInt(2, updatedId);
//						int updated = updateSt.executeUpdate();
//						if (updated > 0) {
//							System.out.println("Student marks updated");
//						} else {
//							System.out.println("Student id not found");
//						}
//						break;
//					case 4:
//						System.out.println("Enter student ID to delete");
//						int deleteId = scanner.nextInt();
//						String deleteQuery = "DELETE FROM student WHERE id=?";
//						PreparedStatement deleteSt = con.prepareStatement(deleteQuery);
//						deleteSt.setInt(1, deleteId);
//						int deleted = deleteSt.executeUpdate();
//						if (deleted > 0) {
//							System.out.println("Student deleted");
//						} else {
//							System.out.println("Student ID not found");
//						}
//						break;
//					case 5:
//						System.out.println("Exiting Application......");
//						con.close();
//						scanner.close();
//						System.exit(0);
//						break;
//					default:
//						System.out.println("Invalid Option!! Try again");
					}

				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

	}
