package com.jsp.JDBCExamples;

import java.sql.*;
import java.util.Scanner;

public class Hotel_Reservation_example7 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/example";
		String user = "root";
		String password = "Pramod@987654321";

		Scanner scanner = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			while (true) {
				System.out.println("\n===== Hotel Reservation System =====");
				System.out.println("1. Book a Room");// create
				System.out.println("2. View Reservations");// read
				System.out.println("3. Get Room Number");// get ??
				System.out.println("4. Update Reservation");// update
				System.out.println("5. Cancel Reservation");// delete
				System.out.println("6. Exit");// exit
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();

				switch (choice) {

				case 1:
					scanner.nextLine();

					System.out.print("Enter Name: ");
					String name = scanner.nextLine();

					System.out.print("Enter Room Number: ");
					int roomNumber = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Enter Contact: ");
					String contact = scanner.nextLine();

					System.out.print("Enter Payment: ");
					double payment = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
					String dateStr = scanner.nextLine();

					String insertQuery = "INSERT INTO reservations (name, room_number, contact, payment, reservation_date) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement insertSt = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
					insertSt.setString(1, name);
					insertSt.setInt(2, roomNumber);
					insertSt.setString(3, contact);
					insertSt.setDouble(4, payment);
					insertSt.setDate(5, Date.valueOf(dateStr));
					insertSt.executeUpdate();

					ResultSet generatedKeys = insertSt.getGeneratedKeys();
					if (generatedKeys.next()) {
						int newId = generatedKeys.getInt(1);
						System.out.println("Room booked successfully! Reservation ID: " + newId);
					}
					break;

				case 2:
					String selectQuery = "SELECT * FROM reservations";
					Statement selectSt = con.createStatement();
					ResultSet rs = selectSt.executeQuery(selectQuery);

					System.out.println("\n--- Reservation List ---");
					while (rs.next()) {
						System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Room: "
								+ rs.getInt("room_number") + ", Contact: " + rs.getString("contact") + ", Payment: "
								+ rs.getDouble("payment") + ", Date: " + rs.getDate("reservation_date"));
					}
					break;

				case 3:
					scanner.nextLine();
					System.out.print("Enter Guest Name: ");
					String guestName = scanner.nextLine();

					String roomQuery = "SELECT room_number FROM reservations WHERE name = ?";
					PreparedStatement roomSt = con.prepareStatement(roomQuery);
					roomSt.setString(1, guestName);
					ResultSet rsRoom = roomSt.executeQuery();

					if (rsRoom.next()) {
						System.out.println("Room Number for " + guestName + ": " + rsRoom.getInt("room_number"));
					} else {
						System.out.println("No reservation found for " + guestName);
					}
					break;

				case 4:
					System.out.print("Enter Reservation ID to update: ");
					int idToUpdate = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Enter new Reservation Date (YYYY-MM-DD): ");
					String newDate = scanner.nextLine();

					System.out.print("Enter new Payment amount: ");
					double newPayment = scanner.nextDouble();

					String updateQuery = "UPDATE reservations SET reservation_date = ?, payment = ? WHERE id = ?";
					PreparedStatement updateSt = con.prepareStatement(updateQuery);
					updateSt.setDate(1, Date.valueOf(newDate));
					updateSt.setDouble(2, newPayment);
					updateSt.setInt(3, idToUpdate);

					int updated = updateSt.executeUpdate();
					if (updated > 0) {
						System.out.println("Reservation updated successfully.");
					} else {
						System.out.println("Reservation ID not found.");
					}
					break;

				case 5:
					System.out.print("Enter Reservation ID to cancel: ");
					int idToDelete = scanner.nextInt();

					String deleteQuery = "DELETE FROM reservations WHERE id = ?";
					PreparedStatement deleteSt = con.prepareStatement(deleteQuery);
					deleteSt.setInt(1, idToDelete);

					int deleted = deleteSt.executeUpdate();
					if (deleted > 0) {
						System.out.println("Reservation cancelled.");
					} else {
						System.out.println("Reservation ID not found.");
					}
					break;

				case 6:
					System.out.println("Exiting...");
					con.close();
					scanner.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice! Try again.");
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}