package example;

import java.util.ArrayList;

//
public class Employee {
	public Employee(String string, String string2, int i, int j) {
		// TODO Auto-generated constructor stub
	}

//	
//	private int age;
//	private String name;
//	private String email;
//	private double sal;
//	
//	
//
//	
//	public Employee(int age, String name, String email, double sal) {
//		super();
//		this.age = age;
//		this.name = name;
//		this.email = email;
//		this.sal = sal;
//	}
//
//
//
//
	public static void main(String[] args) {
//		Employee[] emp=new Employee[5];
//		
//		emp[0]=new Employee(25, "asif", "asif@1234gmail.com", 45000.00);
//		emp[1]=new Employee(34, "sai vishnu", "saivishnu@gmail.com", 46000.00);
//		emp[2]=new Employee(41, "soumi", "soumi@gmail.com", 48000.00);
//		emp[3]=new Employee(46, "hari", "hari@gmail.com", 49000.00);
//		emp[4]=new Employee(72, "macha", "macha@gmail.com", 3000000.00);
//		
//		
//		
//		Employee lowest=emp[0];
//		Employee heighest=emp[0];
//		Employee youngest=emp[0];
//		Employee oldest=emp[0];
//		double totalsal=0;
//		
//		
//		for(int i=0;i<emp.length;i++) {
//			if(emp[i].sal<lowest.sal) {
//				lowest=emp[i];
//				
//			}
//			if(emp[i].sal>lowest.sal) {
//				lowest=emp[i];
//				
//			}
//			if(emp[i].age<lowest.age) {
//				oldest=emp[i];
//				
//			}
//			if(emp[i].age>lowest.age) {
//				youngest=emp[i];
//				
//			}
//			totalsal=totalsal+emp[i].sal;
//		}
//		double avgsal=totalsal/emp.length;
//		System.out.println("avg sal : "+avgsal);
//		System.out.println("youngest : "+youngest.age);
//		System.out.println("oldest : "+oldest.age);
//		System.out.println("lowest : "+lowest.sal);
//		System.out.println("heighest : "+heighest.sal);
//		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Yadav", "yadav@gmail.com", 22, 33));

		displayMaxsal(emp);
	}
//
//	
//

	private static void displayMaxsal(ArrayList<Employee> emp) {
		// TODO Auto-generated method stub
		Employee maxsal=emp.get(0);
		

	}
}
