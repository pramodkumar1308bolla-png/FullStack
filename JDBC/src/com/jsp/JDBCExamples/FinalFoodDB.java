package com.jsp.JDBCExamples;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalFoodDB {

    // Utility: Get category table
    public static String getTableNameFromChoice(int choice) {
        switch (choice) {
            case 1: return "breakfast_table";
            case 2: return "lunch_table";
            case 3: return "snacks_table";
            case 4: return "dinner_table";
            default: return null;
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
                        System.out.println("⚠️ Password must be at least 6 characters and include a number + special character.");
                        continue;
                    }

                    if (!authenticate(con, email, userPassword, role)) {
                        System.out.println("❌ Invalid credentials.");
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

                    if (catChoice == 5) break; // back to restaurants
                    if (catChoice == 6) continue; // back to main menu

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
                            System.out.println("7. Set Discounts"); // === NEW ===
                            System.out.println("8. Back");
                            System.out.println("9. Logout");
                            System.out.print("Enter your choice: ");
                            int choice = safeIntInput(scanner);

                            try {
                                switch (choice) {
                                    // existing cases...

                                    case 7: { // === NEW DISCOUNT SETTING ===
                                        System.out.print("Enter minimum amount for discount: ");
                                        double minAmt = scanner.nextDouble();
                                        System.out.print("Enter discount %: ");
                                        double perc = scanner.nextDouble();

                                        String insert = "INSERT INTO discounts (min_amount, discount_percent) VALUES (?, ?)";
                                        try (PreparedStatement pst = con.prepareStatement(insert)) {
                                            pst.setDouble(1, minAmt);
                                            pst.setDouble(2, perc);
                                            pst.executeUpdate();
                                            System.out.println("✅ Discount rule added.");
                                        }
                                        break;
                                    }
                                    case 8: break;
                                    case 9: return;
                                }
                                if (choice == 8) break;
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

                                                // === APPLY DISCOUNTS ===
                                                double discountPercent = 0;
                                                String dq = "SELECT * FROM discounts ORDER BY min_amount ASC";
                                                try (Statement ds = con.createStatement();
                                                     ResultSet drs = ds.executeQuery(dq)) {
                                                    while (drs.next()) {
                                                        double minAmt = drs.getDouble("min_amount");
                                                        double perc = drs.getDouble("discount_percent");
                                                        if (total > minAmt) discountPercent = perc;
                                                    }
                                                }
                                                double discountAmt = (total * discountPercent) / 100;
                                                double finalTotal = total - discountAmt;

                                                System.out.println("\n=== ORDER SUMMARY ===");
                                                System.out.println("Food: " + foodName);
                                                System.out.println("Qty: " + qty);
                                                System.out.println("Total: " + total);
                                                if (discountPercent > 0) {
                                                    System.out.println("Discount Applied: " + discountPercent + "% (-" + discountAmt + ")");
                                                }
                                                System.out.println("Final Payable: " + finalTotal);

                                                // Insert order
                                                String insert = "INSERT INTO orders_table (customer_name, category, food_id, food_name, quantity, total_price, order_date) VALUES (?, ?, ?, ?, ?, ?, CURDATE())";
                                                try (PreparedStatement orderPst = con.prepareStatement(insert)) {
                                                    orderPst.setString(1, customerName);
                                                    orderPst.setString(2, tableName);
                                                    orderPst.setInt(3, foodId);
                                                    orderPst.setString(4, foodName);
                                                    orderPst.setInt(5, qty);
                                                    orderPst.setDouble(6, finalTotal);
                                                    orderPst.executeUpdate();

                                                    System.out.println("\n✅ Order Placed!");
                                                    System.out.println("🍳 Preparing order...");
                                                    Thread.sleep(3000);
                                                    System.out.println("🚴 Delivery partner will meet you soon.");

                                                    // Feedback
                                                    System.out.print("\n💬 Would you like to give feedback? (yes/no): ");
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
                                            }
                                        }
                                        break;
                                    }
                                    // other user cases unchanged...
                                }
                                if (choice == 5) break;
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
