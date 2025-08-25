package com.jsp.Servicelayer;

import java.util.List;

import com.jsp.DAO.TeacherDAO;
import com.jsp.Entity.Teacher;

public class OnetoManyServices {

    private TeacherDAO dao = new TeacherDAO();

    // Create and save teacher with courses
    public void registerTeacherWithCourses(Teacher teacher) {
        dao.saveTeacherWithCourses(teacher);
    }

    // Get teacher by ID
    public Teacher getTeacherById(int id) {
        return dao.getTeacherById(id);
    }

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return dao.getAllTeachers();
    }

    public void updateTeacher(int id, String name, String subject) {
        Teacher teacher = dao.getTeacherById(id);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setSubject(subject);
            dao.saveTeacherWithCourses(teacher);  
        }
    }

    public void deleteTeacher(int id) {
        dao.deleteTeacher(id);
    }
}

