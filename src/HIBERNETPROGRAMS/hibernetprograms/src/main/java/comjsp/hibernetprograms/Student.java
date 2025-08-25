package comjsp.hibernetprograms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Student {

	public static void main(String[] args) {

		System.out.println("Program starts...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		createStudent(factory, new Studentapp(101, "Ankur", "Patna"));

		readStudent(factory, 101);

		updateStudent(factory, 101, "Ravi", "Delhi");

		readStudent(factory, 101);

		deleteStudent(factory, 101);

		readStudent(factory, 101);

		factory.close();
	}

	public static void createStudent(SessionFactory factory, Studentapp student) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		System.out.println("Student created: " + student);
	}

	public static void readStudent(SessionFactory factory, int id) {
		Session session = factory.openSession();
		Studentapp student = session.get(Studentapp.class, id);
		if (student != null) {
			System.out.println("Student found: " + student);
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
		session.close();
	}

	public static void updateStudent(SessionFactory factory, int id, String newName, String newCity) {
		Session session = factory.openSession();
		session.beginTransaction();
		Studentapp student = session.get(Studentapp.class, id);
		if (student != null) {
			student.setName(newName);
			student.setCity(newCity);
			session.update(student);
			System.out.println("Student updated: " + student);
		} else {
			System.out.println("Student with ID " + id + " not found.");
			session.getTransaction().commit();
		}
		session.close();
	}

	public static void deleteStudent(SessionFactory factory, int id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Studentapp student = session.get(Studentapp.class, id);
		if (student != null) {
			session.delete(student);
			System.out.println("Student deleted: ID " + student);
		} else {
			System.out.println("No Student found with ID " + id);
			session.getTransaction().commit();
		}
		session.close();

	}
}