package com.jsp.DAO;

import java.util.List;

import com.jsp.Entity.Employee;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");

	public void save(Employee emp) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}

	public Employee findById(int id) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;
	}

	public List<Employee> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Employee> list = em.createQuery("FROM Employee", Employee.class).getResultList();
		em.close();
		return list;
	}

	public void update(Employee emp) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(emp);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			em.remove(emp);
		}
		em.getTransaction().commit();
		em.close();
	}
}
