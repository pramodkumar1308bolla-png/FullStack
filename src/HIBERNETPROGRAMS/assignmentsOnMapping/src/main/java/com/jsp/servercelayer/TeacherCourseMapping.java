package com.jsp.servercelayer;


import java.util.List;

import com.jsp.Entityies.Course;
import com.jsp.Entityies.Teacher;
import com.jsp.OnetoOneDAO.TeacherDAO;


public class TeacherCourseMapping {

    private TeacherDAO dao = new TeacherDAO();

    public void registerTeacherWithCourse(String teacherName, String subject, int experience,
                                          String courseName, String duration) {

        Course course = new Course();
        course.setName(courseName);
        course.setDuration(duration);

        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        teacher.setSubject(subject);
        teacher.setExperience(experience);
        teacher.setCourse(course);

        dao.saveTeacher(teacher);
    }

    public void registerCourseOnly(String courseName, String duration) {
        Course course = new Course();
        course.setName(courseName);
        course.setDuration(duration);

        dao.saveCourse(course);
    }

  
    public Teacher fetchTeacherById(int id) {
        return dao.getTeacherById(id);
    }

  
    public Course fetchCourseById(int id) {
        return dao.getCourseById(id);
    }

   
    public List<Teacher> fetchAllTeachers() {
        return dao.getAllTeachers();
    }

    
    public List<Course> fetchAllCourses() {
        return dao.getAllCourses();
    }

    public void updateTeacher(int id, String name, String subject, int experience,
                              String courseName, String duration) {
        Teacher teacher = dao.getTeacherById(id);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setSubject(subject);
            teacher.setExperience(experience);

            Course course = teacher.getCourse();
            if (course != null) {
                course.setName(courseName);
                course.setDuration(duration);
            }

            dao.updateTeacher(teacher);
        } else {
            System.out.println("Teacher with ID " + id + " not found.");
        }
    }


    public void deleteTeacher(int id) {
        dao.deleteTeacher(id);
    }

  
    public void deleteCourse(int id) {
        dao.deleteCourse(id);
    }
     
        public void closeFactory1() {
            if (dao != null) {
                dao.close();
            }
}
}

