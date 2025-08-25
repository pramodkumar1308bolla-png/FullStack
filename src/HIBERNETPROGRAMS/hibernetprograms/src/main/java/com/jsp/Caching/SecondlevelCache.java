package com.jsp.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondlevelCache {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		int courseId;
		// save course {run only once or check if it exists}
		Session s1 = factory.openSession();
		s1.beginTransaction();
		Courses course = new Courses("Java Backend development", "Mr. Smith", 50);
		s1.save(course);
		s1.getTransaction().commit();
		courseId = course.getId();
		s1.close();

		// first fetch which will hit database
		Session s2 = factory.openSession();
		s2.beginTransaction();
		System.out.println("Fetching from Session1");
		Courses c1 = s2.get(Courses.class, courseId);
		System.out.println("Title: " + c1.getTitle());
		s2.getTransaction().commit();
		s2.close();

		// second fetch (should use second level cache
		Session s3 = factory.openSession();
		s3.beginTransaction();
		System.out.println("Fetching from Session2");
		Courses c2 = s3.get(Courses.class, courseId);
		System.out.println("Title: " + c2.getTitle());
		s3.getTransaction().commit();
		s3.close();

		factory.close();
	}

}