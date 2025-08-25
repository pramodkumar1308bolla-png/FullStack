package comjsp.layerdprograms;

import java.util.List;
import java.util.Scanner;

import com.jsp.Entity.Learner;
import com.jsp.Services.LearnerService;

public class HibernateTesApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LearnerService service = new LearnerService();

		System.out.println("=== Learner Management System ===");

		while (true) {
			System.out.println("\nSelect an option:");
			System.out.println("1. Add Learner");
			System.out.println("2. View Learner by ID");
			System.out.println("3. View All Learners");
			System.out.println("4. Update Learner");
			System.out.println("5. Delete Learner");
			System.out.println("6. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {

			case 1:
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Course: ");
				String course = sc.nextLine();
				System.out.print("Enter marks: ");
				int marks = sc.nextInt();
				service.registerLearner(name, course, marks);
				System.out.println("Learner added Successfully...");
				break;

			case 2:
				System.out.print("Enter Learner ID: ");
				int id = sc.nextInt();
				Learner learner = service.fetchLearner(id);
				if (learner != null) {
					System.out.println("Learner ID: " + learner.getId());
					System.out.println("Name: " + learner.getName());
				} else {
					System.out.println("Learner not found.");
				}
				break;

			case 3:
				List<Learner> learners = service.fetchAllLearners();
				if (learners.isEmpty()) {
					System.out.println("No learners found.");
				} else {
					for (Learner l : learners) {
						System.out.println(l.getId() + " | " + l.getName());
					}
				}
				break;

			case 4:
				System.out.print("Enter Learner ID to update: ");
				int updateId = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter New Name: ");
				String newName = sc.nextLine();
				System.out.println("Enter New Course: ");
				String newCourse = sc.nextLine();
				System.out.println("Enter New Name: ");
				int newMarks = sc.nextInt();
				service.updateLearner(updateId, newName, newCourse, newMarks);

				System.out.println("Learner added successfully...");
				break;

			case 5:
				System.out.print("Enter Learner ID to delete: ");
				int deleteId = sc.nextInt();
				service.deleteLearner(deleteId);
				System.out.println("Learner deleted successfully!");
				break;

			case 6:
				service.shutDown();
				sc.close();
				
				System.out.println("Exiting... Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
