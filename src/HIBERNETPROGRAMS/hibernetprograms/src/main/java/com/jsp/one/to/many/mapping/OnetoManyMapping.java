package com.jsp.one.to.many.mapping;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OnetoManyMapping {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		 Department d1=new Department();
		 d1.setName("IT");
		 Employee e1=new Employee();
		 e1.setEname("Pramod");
		 
		 Employee e2=new Employee();
		 e2.setEname("Chaitnaya");
		 d1.setEmployees(Arrays.asList(e1,e2));
		 
		 Session session = factory.openSession();
		 session.beginTransaction();
		 session.save(d1);
		 
		 session.getTransaction().commit();
		 session.close();
		 factory.close();
	}

}
