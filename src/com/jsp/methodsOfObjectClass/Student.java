//package com.jsp.methodsOfObjectClass;
//
//import java.util.Scanner;
//
//class StudentDb{
//	int id;
//	String name;
//	double fees;
//	public StudentDb(int id, String name, double fees) {
//		this.id = id;
//		this.name = name;
//		this.fees = fees;
//	}
//	@Override
//	public int hashCode() {
//		return id;
//	}
//	@Override
//	public String toString() {
//		return "StudentDb [id=" + id + ", name=" + name + ", fees=" + fees + "]";
//	}
//	
//}
//
//public class Student {
//
//	public static void main(String[] args) {
//		int numberofStudents=2;
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter Student Details............");
//		StudentDb[] students=new StudentDb[numberofStudents];
//		for(int i=1;i<=numberofStudents;i++) {
//			
//			System.out.println("Enter Student Id : ");
//			int id=scanner.nextInt();
//			System.out.println("Enter Student Name : ");
//			String name=scanner.next();
//			System.out.println("Enter Student fees : ");
//			double fees=scanner.nextDouble();
//			StudentDb student=new StudentDb(id, name, fees);
//			System.out.println(student.hashCode());
//			System.out.println(student.toString());
//				
//		}
//		
//		
//		
//
//	}
//
//}
//
package com.jsp.methodsOfObjectClass;

import java.util.Scanner;

class StudentDb {
    int id;
    String name;
    double fees;

    public StudentDb(int id, String name, double fees) {
        this.id = id;
        this.name = name;
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "StudentDb [id=" + id + ", name=" + name + ", fees=" + fees + "]";
    }
}

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        StudentDb students[] = new StudentDb[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter details for Student : " + (i + 1));
            System.out.print("Enter Student Id: ");
            int id = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            String name = scanner.next();
            System.out.print("Enter Student Fees: ");
            double fees = scanner.nextDouble();
            students[i] = new StudentDb(id, name, fees);
        }
        System.out.println("------All Student Details in Order ---");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println(students[i]);
            System.out.println();
        }

        
    }
}
