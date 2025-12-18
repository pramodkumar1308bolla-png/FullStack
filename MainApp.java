package com.jspiders.App;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jspiders.onetoOne.entity.Employee;
import com.jspiders.onetoOne.entity.EmployeeDetails;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        // Create objects
        Employee emp = new Employee();
        EmployeeDetails details = new EmployeeDetails("pramod@example.com", "Bangalore");

        emp.setDetails(details);

        // Save the data
        session.persist(emp);

        session.getTransaction().commit();
        session.close();
        factory.close();

        System.out.println(" Data saved successfully!");
    }
}
