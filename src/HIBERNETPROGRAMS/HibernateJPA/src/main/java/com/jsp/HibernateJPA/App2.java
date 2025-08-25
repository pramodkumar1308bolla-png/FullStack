package com.jsp.HibernateJPA;

import com.jsp.Entity.Course;
import com.jsp.Entity.Teacher;
import com.jsp.Servicelayer.OnetoManyServices;

import java.util.Arrays;

public class App2 {
    public static void main(String[] args) {

        Course course1 = new Course("Mathematics", null);
        Course course2 = new Course("Science", null);
        Course course3 = new Course("English", null);

        Teacher teacher = new Teacher();
        teacher.setName("Dr. Anil Sharma");
        teacher.setSubject("STEM");
        teacher.setCourses(Arrays.asList(course1, course2, course3));

        course1.setTeacher(teacher);
        course2.setTeacher(teacher);
        course3.setTeacher(teacher);

        OnetoManyServices service = new OnetoManyServices();

        service.registerTeacherWithCourses(teacher);

        System.out.println("Teacher and courses saved successfully.");
    }
}
