package com.jsp.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.Entity.Learner;

public class LearnerDAO {
	
	//Hibernate SessionFactory(used to create session for DB operations)
	private SessionFactory sessionFactory;
	/**
	 * Constructor- Initilizes the SessionFactory Loads Hibernate Configuration from hibernate.cfg.xml
	 * 
	 */
	public LearnerDAO() {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
		
	/**
	 * CREATE operations - Save a new learner to the database
	 * 
	 */
	public void saveLearner(Learner learner) {
		Transaction tx= null;
		try(Session session =sessionFactory.openSession()){
			tx=session.beginTransaction();
			session.save(learner);
			tx.commit();
			}catch(Exception e) {
				if(tx != null) {
					tx.rollback();
					e.printStackTrace();
				}
				
			}
	}
		public Learner getLearnerById(int id) {
			try(Session session = sessionFactory.openSession()){
				return session.get(Learner.class,id);
			}
			
		}
		
		
		public List<Learner> getAllLearners() {
			try (Session session = sessionFactory.openSession()) {
				return session.createQuery("FROM Learner").list();
			}
		}
		
		
		public void updateLearner(Learner learner) {
			Transaction tx=null;
			try(Session session=sessionFactory.openSession()){
				tx=session.beginTransaction();
				session.update(learner);
				tx.commit();
			}catch(Exception e) {
				if(tx!=null) {
					tx.rollback();
					e.printStackTrace();
				}
			}
		}
		public void deleteLearner(int id) {
			Transaction tx= null;
			try(Session session=sessionFactory.openSession()){
				tx=session.beginTransaction();
				Learner learner=session.get(Learner.class, id);
				if(learner != null) {
					session.delete(learner);
				}
				tx.commit();
			}catch(Exception e) {
				if(tx!=null) {
					tx.rollback();
					e.printStackTrace();
				}
			}
		}
			public void closeFactory() {
				if(sessionFactory != null) {
					sessionFactory.close();
				}
			}
		
}