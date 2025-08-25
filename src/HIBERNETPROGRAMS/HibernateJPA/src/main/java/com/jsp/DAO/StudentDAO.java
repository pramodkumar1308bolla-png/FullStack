package com.jsp.DAO;

import java.util.List;

import com.jsp.Entity.Course;
import com.jsp.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class StudentDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");

	public void save(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

	public Student findById(int id) {
		EntityManager em = emf.createEntityManager();
		Student student = null;
		try {
			student = em
					.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.id = :id", Student.class)
					.setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No student found with ID " + id);
		} finally {
			em.close();
		}
		return student;
	}

	public List<Student> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Student> list = em.createQuery("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courses", Student.class)
				.getResultList();
		em.close();
		return list;
	}

	public void update(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Student student = em.find(Student.class, id);
		if (student != null) {
			
			for (Course course : student.getCourses()) {
				course.getStudents().remove(student);
			}
			student.getCourses().clear();

			em.remove(student);
		}

		em.getTransaction().commit();
		em.close();
	}

	public void enrollStudentInCourse(int studentId, int courseId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);

		if (student != null && course != null) {
			student.getCourses().add(course);
			course.getStudents().add(student);
		}

		em.getTransaction().commit();
		em.close();
	}
}
