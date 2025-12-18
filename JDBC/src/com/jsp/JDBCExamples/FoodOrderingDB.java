package com.jsp.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodOrderingDB {

	// Utility: Get category table
	public static String getTableNameFromChoice(int choice) {
		switch (choice) {
		case 1:
			return "breakfast_table";
		case 2:
			return "lunch_table";
		case 3:
			return "snacks_table";
		case 4:
			return "dinner_table";
		default:
			return null;
		}
	}

	// Utility: OTP generator
	public static int generateOTP() {
		return (int) (Math.random() * 9000) + 1000;
	}

	// Utility: email validation
	public static boolean isEmailValid(String email) {
		return email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
	}

	// Utility: password validation
	public static boolean isPasswordValid(String password) {
		return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{6,}$");
	}

	// Authenticate user/admin
	public static boolean authenticate(Connection con, String email, String password, String role) throws Exception {
		String query = "SELECT * FROM " + role + " WHERE email = ? AND password = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			return rs.next();
		}
	}

	// Register user/admin
	public static boolean registerUser(Connection con, String email, String password, String role) throws Exception {
		String insert = "INSERT INTO " + role + " (email, password) VALUES (?, ?)";
		try (PreparedStatement pst = con.prepareStatement(insert)) {
			pst.setString(1, email);
			pst.setString(2, password);
			pst.executeUpdate();
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("⚠️ Email already registered.");
			return false;
		}
	}

	// Safe integer input (avoids InputMismatchException)
	public static int safeIntInput(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("⚠️ Invalid input. Enter a number: ");
				scanner.nextLine(); // clear buffer
			}
		}
	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/food_odering_db";
		String user = "root";
		String password = "Pramod@987654321";

		try (Connection con = DriverManager.getConnection(url, user, password);
				Scanner scanner = new Scanner(System.in)) {

			Class.forName("com.mysql.cj.jdbc.Driver");

			while (true) {
				System.out.println("\n===== 🍴 Food Ordering System =====");
				System.out.println("1. Admin Login");
				System.out.println("2. User Login");
				System.out.println("3. Register New Admin");
				System.out.println("4. Register New User");
				System.out.println("5. Exit");
				System.out.print("Select your option: ");
				int option = safeIntInput(scanner);
				scanner.nextLine(); // consume newline

				if (option == 5) {
					System.out.println("👋 Thank you for using the system. Goodbye!");
					break;
				}

				String role = null, email, userPassword;

				if (option == 1 || option == 2) {
					role = option == 1 ? "admin" : "user";
					System.out.print("Enter Gmail ID: ");
					email = scanner.nextLine();
					System.out.print("Enter Password: ");
					userPassword = scanner.nextLine();

					if (!isEmailValid(email)) {
						System.out.println("⚠️ Invalid email format. Must be @gmail.com");
						continue;
					}
					if (!isPasswordValid(userPassword)) {
						System.out.println(
								"⚠️ Password must be at least 6 characters and include a number  special character.");
						continue;
					}

					if (!authenticate(con, email, userPassword, role)) {
						System.out.println("❌ User not Found /Invalid credentials.");
						continue;
					}

					System.out.println("✅ Login successful. Welcome, " + email + "!");

				} else if (option == 3 || option == 4) {
					role = option == 3 ? "admin" : "user";
					System.out.print("Enter Gmail ID: ");
					email = scanner.nextLine();
					System.out.print("Create Password: ");
					userPassword = scanner.nextLine();

					if (!isEmailValid(email) || !isPasswordValid(userPassword)) {
						System.out.println("⚠️ Invalid email or password format.");
						continue;
					}

					if (registerUser(con, email, userPassword, role)) {
						System.out.println("🎉 Registration successful! You can now log in.");
					}
					continue;
				} else {
					System.out.println("⚠️ Invalid option.");
					continue;
				}

				int restaurantId = 0;

				// Admin: add restaurant
				if (role.equals("admin")) {
					System.out.print("Do you want to add a new restaurant? (yes/no): ");
					String answer = scanner.nextLine();
					if (answer.equalsIgnoreCase("yes")) {
						System.out.print("Enter new restaurant name: ");
						String restName = scanner.nextLine();
						String insertRest = "INSERT INTO restaurants (name) VALUES (?)";
						try (PreparedStatement pst = con.prepareStatement(insertRest)) {
							pst.setString(1, restName);
							pst.executeUpdate();
							System.out.println("🏢 Restaurant added.");
						} catch (SQLIntegrityConstraintViolationException e) {
							System.out.println("⚠️ Restaurant already exists.");
						}
					}
				}

				// Show available restaurants (ordered)
				System.out.println("\n📋 Available Restaurants:");
				try (Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM restaurants ORDER BY restaurant_id ASC")) {
					while (rs.next()) {
						System.out.println(rs.getInt("restaurant_id") + ". " + rs.getString("name"));
					}
				}

				System.out.print("Select restaurant by ID: ");
				restaurantId = safeIntInput(scanner);
				scanner.nextLine();

				// Food Category
				while (true) {
					System.out.println("\nSelect Food Category:");
					System.out.println("1. Breakfast");
					System.out.println("2. Lunch");
					System.out.println("3. Snacks");
					System.out.println("4. Dinner");
					System.out.println("5. Back");
					System.out.println("6. Logout");
					System.out.print("Enter your choice: ");
					int catChoice = safeIntInput(scanner);
					scanner.nextLine();

					if (catChoice == 5)
						break; // back to restaurants
					if (catChoice == 6)
						continue; // back to main menu

					String tableName = getTableNameFromChoice(catChoice);
					if (tableName == null) {
						System.out.println("⚠️ Invalid category.");
						continue;
					}

					// ---------------- ADMIN MENU ----------------
					if (role.equals("admin")) {
						while (true) {
							System.out.println("\n=== 👨‍💼 Admin Menu [" + tableName + "] ===");
							System.out.println("1. View Menu");
							System.out.println("2. Add Food Item");
							System.out.println("3. Update Food Item");
							System.out.println("4. Delete Food Item");
							System.out.println("5. View Feedback");
							System.out.println("6. Delete Feedback");
							System.out.println("7. Back");
							System.out.println("8. Logout");
							System.out.print("Enter your choice: ");
							int choice = safeIntInput(scanner);

							try {
								switch (choice) {
								case 1: {
									String query = "SELECT * FROM " + tableName + " WHERE restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(query)) {
										pst.setInt(1, restaurantId);
										ResultSet rs = pst.executeQuery();
										System.out.println("\n--- Menu ---");
										while (rs.next()) {
											System.out.println("ID: " + rs.getInt("food_id") + ", "
													+ rs.getString("name") + " - $" + rs.getDouble("price"));
										}
									}
									break;
								}
								case 2: {
									scanner.nextLine();
									System.out.print("Food name: ");
									String name = scanner.nextLine();
									System.out.print("Price: ");
									double priceVal = scanner.nextDouble();

									String insert = "INSERT INTO " + tableName
											+ " (name, price, restaurant_id) VALUES (?, ?, ?)";
									try (PreparedStatement pst = con.prepareStatement(insert)) {
										pst.setString(1, name);
										pst.setDouble(2, priceVal);
										pst.setInt(3, restaurantId);
										pst.executeUpdate();
										System.out.println("✅ Item added.");
									}
									break;
								}
								case 3: {
									System.out.print("Food ID to update: ");
									int foodId = safeIntInput(scanner);
									scanner.nextLine();
									System.out.print("New name: ");
									String newName = scanner.nextLine();
									System.out.print("New price: ");
									double newPrice = scanner.nextDouble();

									String update = "UPDATE " + tableName
											+ " SET name = ?, price = ? WHERE food_id = ? AND restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(update)) {
										pst.setString(1, newName);
										pst.setDouble(2, newPrice);
										pst.setInt(3, foodId);
										pst.setInt(4, restaurantId);
										int rows = pst.executeUpdate();
										System.out.println(rows > 0 ? "✅ Updated." : "⚠️ Food ID not found.");
									}
									break;
								}
								case 4: {
									System.out.print("Food ID to delete: ");
									int foodId = safeIntInput(scanner);
									String delete = "DELETE FROM " + tableName
											+ " WHERE food_id = ? AND restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(delete)) {
										pst.setInt(1, foodId);
										pst.setInt(2, restaurantId);
										int rows = pst.executeUpdate();
										System.out.println(rows > 0 ? "🗑️ Deleted." : "⚠️ Food ID not found.");
									}
									break;
								}
								case 5: {
									String query = "SELECT * FROM feedback_table WHERE restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(query)) {
										pst.setInt(1, restaurantId);
										ResultSet rs = pst.executeQuery();
										System.out.println("\n--- Feedbacks ---");
										while (rs.next()) {
											System.out.println("ID: " + rs.getInt("feedback_id") + ", User: "
													+ rs.getString("customer_name") + ", Review: "
													+ rs.getString("feedback_text") + ", Date: "
													+ rs.getTimestamp("feedback_date"));
										}
									}
									break;
								}
								case 6: {
									System.out.print("Enter Feedback ID to delete: ");
									int fid = safeIntInput(scanner);
									String delete = "DELETE FROM feedback_table WHERE feedback_id = ?";
									try (PreparedStatement pst = con.prepareStatement(delete)) {
										pst.setInt(1, fid);
										int rows = pst.executeUpdate();
										System.out.println(
												rows > 0 ? "🗑️ Feedback deleted." : "⚠️ Feedback ID not found.");
									}
									break;
								}
								case 7:
									break;
								case 8:
									return;
								default:
									System.out.println("⚠️ Invalid choice.");
								}
								if (choice == 7)
									break;
							} catch (Exception e) {
								System.out.println("⚠️ Error: " + e.getMessage());
								scanner.nextLine();
							}
						}

						// ---------------- USER MENU ----------------
					} else {
						while (true) {
							System.out.println("\n=== 👤 User Menu [" + tableName + "] ===");
							System.out.println("1. View Menu");
							System.out.println("2. Place Order");
							System.out.println("3. Cancel Order");
							System.out.println("4. View Orders");
							System.out.println("5. Back");
							System.out.println("6. Logout");
							System.out.print("Enter your choice: ");
							int choice = safeIntInput(scanner);

							try {
								switch (choice) {
								case 1: {
									String query = "SELECT * FROM " + tableName + " WHERE restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(query)) {
										pst.setInt(1, restaurantId);
										ResultSet rs = pst.executeQuery();
										System.out.println("\n--- Menu ---");
										while (rs.next()) {
											System.out.println("ID: " + rs.getInt("food_id") + ", "
													+ rs.getString("name") + " - $" + rs.getDouble("price"));
										}
									}
									break;
								}
								case 2: {
									scanner.nextLine();
									System.out.print("Your Name: ");
									String customerName = scanner.nextLine();
									System.out.print("Food ID: ");
									int foodId = safeIntInput(scanner);
									System.out.print("Quantity: ");
									int qty = safeIntInput(scanner);

									int otp = generateOTP();
									System.out.println("🔐 Your OTP: " + otp);
									System.out.print("Enter OTP: ");
									int enteredOtp = safeIntInput(scanner);
									if (enteredOtp != otp) {
										System.out.println("❌ Incorrect OTP. Order cancelled.");
										continue;
									}

									String fetch = "SELECT name, price FROM " + tableName
											+ " WHERE food_id = ? AND restaurant_id = ?";
									try (PreparedStatement pst = con.prepareStatement(fetch)) {
										pst.setInt(1, foodId);
										pst.setInt(2, restaurantId);
										ResultSet rs = pst.executeQuery();
										if (rs.next()) {
											String foodName = rs.getString("name");
											double price = rs.getDouble("price");
											double total = qty * price;

											// Payment selection
											System.out.println("\nSelect Payment Mode:");
											System.out.println("1. Cash");
											System.out.println("2. UPI");
											int payChoice = safeIntInput(scanner);

											if (payChoice == 2) {
												System.out.println("⚠️ Currently UPI is not available.");
												System.out.println("💵 Please pay cash to our delivery partner.");
											}

											String insert = "INSERT INTO orders_table (customer_name, category, food_id, food_name, quantity, total_price, order_date) VALUES (?, ?, ?, ?, ?, ?, CURDATE())";
											try (PreparedStatement orderPst = con.prepareStatement(insert)) {
												orderPst.setString(1, customerName);
												orderPst.setString(2, tableName);
												orderPst.setInt(3, foodId);
												orderPst.setString(4, foodName);
												orderPst.setInt(5, qty);
												orderPst.setDouble(6, total);
												orderPst.executeUpdate();

												System.out.println("\n✅ Order Placed!");
												System.out.println("Food: " + foodName);
												System.out.println("Quantity: " + qty);
												System.out.println("Price per item: $" + price);
												System.out.println("TOTAL: $" + total);

												// Order status
												System.out.println("\n🍳 Your food is preparing...");
												System.out.println(
														"🚴 Our delivery partner will reach you soon. Thank you!");

												// Feedback option after 1 min
												Thread.sleep(60000);
												System.out.println(
														"🚴 Order reached to your Location .  Please Collect your Order and Please give us Your Feedback........Thank you!!!");
												System.out.print("\n💬 Would you like to give feedback? (yes/no): ");
												scanner.nextLine();
												String fbChoice = scanner.nextLine();
												if (fbChoice.equalsIgnoreCase("yes")) {
													System.out.print("Enter your feedback: ");
													String feedback = scanner.nextLine();
													String fbInsert = "INSERT INTO feedback_table (restaurant_id, customer_name, feedback_text, feedback_date) VALUES (?, ?, ?, NOW())";
													try (PreparedStatement fbPst = con.prepareStatement(fbInsert)) {
														fbPst.setInt(1, restaurantId);
														fbPst.setString(2, customerName);
														fbPst.setString(3, feedback);
														fbPst.executeUpdate();
														System.out.println("🙏 Thank you for your feedback!");
													}
												}

											}
										} else {
											System.out.println("⚠️ Invalid Food ID.");
										}
									}
									break;
								}
								case 3: {
									System.out.print("Enter Order ID to cancel: ");
									int oid = safeIntInput(scanner);
									String delete = "DELETE FROM orders_table WHERE order_id = ?";
									try (PreparedStatement pst = con.prepareStatement(delete)) {
										pst.setInt(1, oid);
										int rows = pst.executeUpdate();
										System.out
												.println(rows > 0 ? "🗑️ Order cancelled." : "⚠️ Order ID not found.");
									}
									break;
								}
								case 4: {
									scanner.nextLine();
									System.out.print("Enter your name: ");
									String cname = scanner.nextLine();
									String query = "SELECT * FROM orders_table WHERE customer_name = ?";
									try (PreparedStatement pst = con.prepareStatement(query)) {
										pst.setString(1, cname);
										ResultSet rs = pst.executeQuery();
										System.out.println("\n--- Your Orders ---");
										while (rs.next()) {
											System.out.println("Order ID: " + rs.getInt("order_id") + ", Food: "
													+ rs.getString("food_name") + ", Qty: " + rs.getInt("quantity")
													+ ", Total: $" + rs.getDouble("total_price") + ", Date: "
													+ rs.getDate("order_date"));
										}
									}
									break;
								}
								case 5:
									break;
								case 6:
									return;
								default:
									System.out.println("⚠️ Invalid choice.");
								}
								if (choice == 5)
									break;
							} catch (Exception e) {
								System.out.println("⚠️ Error: " + e.getMessage());
								scanner.nextLine();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("❌ Connection Error: " + e.getMessage());
		}
	}
}
