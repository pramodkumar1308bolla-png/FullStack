package com.jsp.DAO;

import java.util.List;

import com.jsp.Entity.Course;
import com.jsp.Entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TeacherDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void saveTeacherWithCourses(Teacher teacher) {
        et.begin();
        for (Course course : teacher.getCourses()) {
            course.setTeacher(teacher);  // Set the relationship
        }
        em.persist(teacher);
        et.commit();
    }

    public Teacher getTeacherById(int id) {
        return em.find(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public void deleteTeacher(int id) {
        Teacher teacher = em.find(Teacher.class, id);
        if (teacher != null) {
            et.begin();
            em.remove(teacher);
            et.commit();
        }
    }
}

