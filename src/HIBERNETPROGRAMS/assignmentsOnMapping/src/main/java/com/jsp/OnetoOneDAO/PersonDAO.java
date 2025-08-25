package com.jsp.OnetoOneDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.Entityies.Person;
import com.jsp.Entityies.Passport;

public class PersonDAO {

    private SessionFactory sessionFactory;

    public PersonDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void savePersonWithPassport(Person person) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
            System.out.println("Person and Passport saved successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    
    public void savePassport(Passport passport) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(passport);
            tx.commit();
            System.out.println("Passport saved independently.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Person getPersonById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }

    public List<Person> getAllPersons() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Person", Person.class).list();
        }
    }

   
    public void updatePerson(Person person) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(person);
            tx.commit();
            System.out.println("Person updated successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deletePerson(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                session.delete(person);
                System.out.println(" Person deleted.");
            } else {
                System.out.println(" Person not found.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Passport getPassportById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Passport.class, id);
        }
    }

    public void updatePassport(Passport passport) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.update(passport);
            tx.commit();
            System.out.println(" Passport updated successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deletePassport(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Passport passport = session.get(Passport.class, id);
            if (passport != null) {
                session.delete(passport);
                System.out.println("Passport deleted.");
            } else {
                System.out.println(" Passport not found.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void closeFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
