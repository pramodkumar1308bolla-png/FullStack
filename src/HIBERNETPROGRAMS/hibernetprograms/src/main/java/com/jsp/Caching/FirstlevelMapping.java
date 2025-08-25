package com.jsp.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstlevelMapping {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		LibraryBook newBook = new LibraryBook("Effective java", 650.00);
		session.save(newBook);
		
		session.getTransaction().commit();
		 
		session.beginTransaction();
		System.out.println("Fetching book first time");
		LibraryBook book1 = session.get(LibraryBook.class, newBook.getId());

		System.out.println("Title:" + book1.getTitle());

		System.out.println("Fetching book second time");

		LibraryBook book2 = session.get(LibraryBook.class, newBook.getId());
		System.out.println("Title : " + book2.getTitle());

		
		System.out.println("same object:" + (book1 == book2));

		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
