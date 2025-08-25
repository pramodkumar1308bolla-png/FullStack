package com.jsp.UtilizationLayer;


import java.util.List;
import java.util.Scanner;

import com.jsp.Entityies.Passport;
import com.jsp.Entityies.Person;
import com.jsp.servercelayer.PersonPassportService;


public class OnetoOneUtilization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonPassportService service = new PersonPassportService();
        boolean running = true;

        while (running) {
            System.out.println("\n===== PERSON & PASSPORT MENU =====");
            System.out.println("1. Register Person with Passport");
            System.out.println("2. Register Passport Only");
            System.out.println("3. View Person by ID");
            System.out.println("4. View All Persons");
            System.out.println("5. View Passport by ID");
            System.out.println("6. Update Person and Passport");
            System.out.println("7. Delete Person (Cascade Passport)");
            System.out.println("8. Delete Passport Only");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Pincode: ");
                    int pincode = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Passport Type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter Number of Countries Eligible: ");
                    int countries = sc.nextInt();

                    service.registerPersonWithPassport(name, city, pincode, type, countries);
                    break;

                case 2:
                    System.out.print("Enter Passport Type: ");
                    String typeOnly = sc.nextLine();
                    System.out.print("Enter Number of Countries Eligible: ");
                    int countriesOnly = sc.nextInt();

                    service.registerPassportOnly(typeOnly, countriesOnly);
                    break;

                case 3:
                    System.out.print("Enter Person ID: ");
                    int pid = sc.nextInt();
                    Person person = service.fetchPersonById(pid);
                    if (person != null) {
                        System.out.println("Person: " + person);
                        System.out.println("Passport: " + person.getPassport());
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 4:
                    List<Person> all = service.fetchAllPersons();
                    if (all.isEmpty()) {
                        System.out.println("No persons found.");
                    } else {
                        for (Person p : all) {
                            System.out.println("Person: " + p);
                            System.out.println("Passport: " + p.getPassport());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Passport ID: ");
                    int passId = sc.nextInt();
                    Passport passport = service.fetchPassportById(passId);
                    if (passport != null) {
                        System.out.println("Passport: " + passport);
                        System.out.println("Linked Person: " + passport.getPerson());
                    } else {
                        System.out.println("Passport not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Person ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Updated Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter Updated City: ");
                    String newCity = sc.nextLine();
                    System.out.print("Enter Updated Pincode: ");
                    int newPincode = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Updated Passport Type: ");
                    String newType = sc.nextLine();
                    System.out.print("Enter Updated Number of Countries: ");
                    int newCountries = sc.nextInt();

                    service.updatePerson(updateId, newName, newCity, newPincode, newType, newCountries);
                    break;

                case 7:
                    System.out.print("Enter Person ID to delete: ");
                    int delId = sc.nextInt();
                    service.deletePerson(delId);
                    break;

                case 8:
                    System.out.print("Enter Passport ID to delete: ");
                    int passDelId = sc.nextInt();
                    service.deletePassport(passDelId);
                    break;

                case 9:
                    service.shutDown();
                    running = false;
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
