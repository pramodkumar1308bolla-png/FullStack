package com.jsp.OnetoOneDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.Entityies.Course;
import com.jsp.Entityies.Teacher;

public class TeacherDAO {

	private SessionFactory sessionFactory;

	public TeacherDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	
	public void saveTeacher(Teacher teacher) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
			System.out.println("Teacher saved successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	
	public void saveCourse(Course course) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.save(course);
			tx.commit();
			System.out.println("Course saved successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	
	public Teacher getTeacherById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Teacher.class, id);
		}
	}

	public Course getCourseById(int id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(Course.class, id);
		}
	}

	public List<Teacher> getAllTeachers() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Teacher", Teacher.class).list();
		}
	}

	public List<Course> getAllCourses() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM Course", Course.class).list();
		}
	}

	public void updateTeacher(Teacher teacher) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.update(teacher);
			tx.commit();
			System.out.println("Teacher updated successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public void updateCourse(Course course) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			session.update(course);
			tx.commit();
			System.out.println("Course updated successfully.");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public void deleteTeacher(int id) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				session.delete(teacher);
				System.out.println("Teacher deleted.");
			} else {
				System.out.println("Teacher not found.");
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	
	public void deleteCourse(int id) {
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			Course course = session.get(Course.class, id);
			if (course != null) {
				session.delete(course);
			}
		}
	}


	public void close() {
		// TODO Auto-generated method stub
		
	}





	
}
