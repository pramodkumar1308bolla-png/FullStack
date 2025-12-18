package com.jsp.JDBCExamples;

import java.sql.*;
import java.util.Scanner;

public class food_odering_db {

    public static String getTableNameFromChoice(int choice) {
        return switch (choice) {
            case 1 -> "breakfast_table";
            case 2 -> "lunch_table";
            case 3 -> "snacks_table";
            case 4 -> "dinner_table";
            default -> null;
        };
    }

    public static int generateOTP() {
        return (int)(Math.random() * 9000) + 1000;
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/food_odering_db";
        String user = "root";
        String password = "Pramod@987654321";

        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            while (true) {
                System.out.println("\n===== Food Ordering System =====");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Exit");
                System.out.print("Select your role: ");
                int role = scanner.nextInt();

                if (role == 3) {
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                }

                scanner.nextLine(); // consume newline
                String email, userPassword;

                // Login validation for both Admin and User
                System.out.print("Enter Gmail ID: ");
                email = scanner.nextLine();

                System.out.print("Enter Password: ");
                userPassword = scanner.nextLine();

                // Email validation
                if (!email.matches("^[a-z-0-9._%+-]+@gmail\\.com$")) {
                    System.out.println("Invalid email. Must be a valid @gmail.com address.");
                    continue;
                }

                // Password validation
                if (!userPassword.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/]).{6,}$") || userPassword.contains(" ")) {
                    System.out.println("Invalid password. It must contain letters, numbers, and special characters (no spaces).");
                    continue;
                }

                String loginQuery = role == 1 ?
                        "SELECT * FROM admin WHERE email = ? AND password = ?" :
                        "SELECT * FROM user WHERE email = ? AND password = ?";

                PreparedStatement loginStmt = con.prepareStatement(loginQuery);
                loginStmt.setString(1, email);
                loginStmt.setString(2, userPassword);
                ResultSet loginRs = loginStmt.executeQuery();

                if (!loginRs.next()) {
                    System.out.println("Login failed. Invalid credentials.");
                    continue;
                }

                System.out.println("Login successful. Welcome, " + email + "!");

                System.out.println("\nSelect Food Category:");
                System.out.println("1. Breakfast");
                System.out.println("2. Lunch");
                System.out.println("3. Snacks");
                System.out.println("4. Dinner");
                System.out.print("Enter your choice: ");
                int catChoice = scanner.nextInt();

                String tableName = getTableNameFromChoice(catChoice);
                if (tableName == null) {
                    System.out.println("Invalid category. Returning to main menu.");
                    continue;
                }

                if (role == 1) {
                    // Admin Menu
                    while (true) {
                        try {
                            System.out.println("\n=== Admin Menu [" + tableName + "] ===");
                            System.out.println("1. View Menu");
                            System.out.println("2. Add Food Item");
                            System.out.println("3. Update Food Item");
                            System.out.println("4. Delete Food Item");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Enter your choice: ");
                            int choice = scanner.nextInt();

                            switch (choice) {
                                case 1 -> {
                                    String query = "SELECT * FROM " + tableName;
                                    Statement stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery(query);
                                    System.out.println("\n--- " + tableName.toUpperCase() + " Menu ---");
                                    while (rs.next()) {
                                        System.out.println("ID: " + rs.getInt("food_id") + ", Name: " + rs.getString("name") + ", Price: $" + rs.getDouble("price"));
                                    }
                                }
                                case 2 -> {
                                    scanner.nextLine();
                                    System.out.print("Enter food name: ");
                                    String name = scanner.nextLine();
                                    System.out.print("Enter price: ");
                                    double priceVal = scanner.nextDouble();

                                    String insert = "INSERT INTO " + tableName + " (name, price) VALUES (?, ?)";
                                    PreparedStatement pst = con.prepareStatement(insert);
                                    pst.setString(1, name);
                                    pst.setDouble(2, priceVal);
                                    pst.executeUpdate();
                                    System.out.println("Item added to " + tableName);
                                }
                                case 3 -> {
                                    System.out.print("Enter food ID to update: ");
                                    int foodId = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Enter new name: ");
                                    String newName = scanner.nextLine();
                                    System.out.print("Enter new price: ");
                                    double newPrice = scanner.nextDouble();

                                    String update = "UPDATE " + tableName + " SET name = ?, price = ? WHERE food_id = ?";
                                    PreparedStatement pst = con.prepareStatement(update);
                                    pst.setString(1, newName);
                                    pst.setDouble(2, newPrice);
                                    pst.setInt(3, foodId);
                                    int updated = pst.executeUpdate();
                                    if (updated > 0)
                                        System.out.println("Food item updated.");
                                    else
                                        System.out.println("Food ID not found.");
                                }
                                case 4 -> {
                                    System.out.print("Enter food ID to delete: ");
                                    int foodId = scanner.nextInt();
                                    String delete = "DELETE FROM " + tableName + " WHERE food_id = ?";
                                    PreparedStatement pst = con.prepareStatement(delete);
                                    pst.setInt(1, foodId);
                                    int deleted = pst.executeUpdate();
                                    if (deleted > 0)
                                        System.out.println("Food item deleted.");
                                    else
                                        System.out.println("Food ID not found.");
                                }
                                case 5 -> {
                                    System.out.println("Returning to main menu...");
                                    break;
                                }
                                default -> System.out.println("Invalid choice. Try again.");
                            }

                            if (choice == 5) break;

                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }
                } else {
                    // User Menu
                    while (true) {
                        try {
                            System.out.println("\n=== User Menu [" + tableName + "] ===");
                            System.out.println("1. View Menu");
                            System.out.println("2. Place Order");
                            System.out.println("3. View Order History");
                            System.out.println("4. Cancel Order");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Enter your choice: ");
                            int choice = scanner.nextInt();

                            switch (choice) {
                                case 1 -> {
                                    String query = "SELECT * FROM " + tableName;
                                    Statement stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery(query);
                                    System.out.println("\n--- " + tableName.toUpperCase() + " Menu ---");
                                    while (rs.next()) {
                                        System.out.println("ID: " + rs.getInt("food_id") + ", Name: " + rs.getString("name") + ", Price: $" + rs.getDouble("price"));
                                    }
                                }
                                case 2 -> {
                                    scanner.nextLine();
                                    System.out.print("Enter your name: ");
                                    String customerName = scanner.nextLine();
                                    System.out.print("Enter Food ID to order: ");
                                    int foodId = scanner.nextInt();
                                    System.out.print("Enter quantity: ");
                                    int quantity = scanner.nextInt();

                                    int otp = generateOTP();
                                    System.out.println("\n[OTP] Your One-Time Password is: " + otp);
                                    System.out.print("Enter the OTP to confirm your order: ");
                                    int enteredOtp = scanner.nextInt();

                                    if (enteredOtp != otp) {
                                        System.out.println("Incorrect OTP. Order cancelled.");
                                        break;
                                    }

                                    String fetch = "SELECT name, price FROM " + tableName + " WHERE food_id = ?";
                                    PreparedStatement pst = con.prepareStatement(fetch);
                                    pst.setInt(1, foodId);
                                    ResultSet rs = pst.executeQuery();

                                    if (rs.next()) {
                                        String foodName = rs.getString("name");
                                        double priceVal = rs.getDouble("price");
                                        double total = priceVal * quantity;

                                        String orderInsert = "INSERT INTO orders_table (customer_name, category, food_id, food_name, quantity, total_price, order_date) VALUES (?, ?, ?, ?, ?, ?, CURDATE())";
                                        PreparedStatement orderSt = con.prepareStatement(orderInsert, Statement.RETURN_GENERATED_KEYS);
                                        orderSt.setString(1, customerName);
                                        orderSt.setString(2, tableName);
                                        orderSt.setInt(3, foodId);
                                        orderSt.setString(4, foodName);
                                        orderSt.setInt(5, quantity);
                                        orderSt.setDouble(6, total);
                                        orderSt.executeUpdate();

                                        ResultSet keys = orderSt.getGeneratedKeys();
                                        if (keys.next()) {
                                            System.out.println("Order placed! Order ID: " + keys.getInt(1));
                                        }

                                        System.out.println("Preparing your " + foodName + "...");
                                        System.out.println("Your " + foodName + " is prepared. Our delivery partner will reach you soon.");
                                    } else {
                                        System.out.println("Invalid Food ID.");
                                    }
                                }
                                case 3 -> {
                                    String history = """
                                            SELECT order_id, customer_name, food_name, quantity, total_price, order_date FROM orders_table WHERE category = ? ORDER BY order_date DESC
                                            """;
                                    PreparedStatement pst = con.prepareStatement(history);
                                    pst.setString(1, tableName);
                                    ResultSet rs = pst.executeQuery();

                                    System.out.println("\n--- Order History ---");
                                    while (rs.next()) {
                                        System.out.println("Order ID: " + rs.getInt("order_id") + ", Customer: " + rs.getString("customer_name") + ", Food: " + rs.getString("food_name") + ", Quantity: " + rs.getInt("quantity") + ", Total: $" + rs.getDouble("total_price") + ", Date: " + rs.getDate("order_date"));
                                    }
                                }
                                case 4 -> {
                                    System.out.print("Enter Order ID to cancel: ");
                                    int orderId = scanner.nextInt();
                                    String delete = "DELETE FROM orders_table WHERE order_id = ?";
                                    PreparedStatement pst = con.prepareStatement(delete);
                                    pst.setInt(1, orderId);
                                    int deleted = pst.executeUpdate();
                                    if (deleted > 0)
                                        System.out.println("Order cancelled successfully.");
                                    else
                                        System.out.println("Order ID not found.");
                                }
                                case 5 -> {
                                    System.out.println("Returning to main menu...");
                                    break;
                                }
                                default -> System.out.println("Invalid choice. Try again.");
                            }

                            if (choice == 5) break;

                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }
                }
            }

            scanner.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
