package MethodOverRiding;

class Employee{
	
	public void displaydetails(String department) {
		if(department.equals("IT")) {
			System.out.println("Employee works in IT");
		}
		else {
			System.out.println("Employee works in " + department);
		}
		
	}
	
}
class Manager extends Employee{
	@Override          //it is mandatory to give Override Statement in the program Otherwise it is not the Overriding method
	public void displaydetails(String department) {
		if(department.equals("HR")) {
			System.out.println("Manager works in HR department !!!");
		}
		else {
			System.out.println("Manager works in " + department);
		}
	}
}


public class task {

	public static void main(String[] args) {
		Manager manager=new Manager();
		manager.displaydetails("IT");
		Employee employee=new Employee();
		employee.displaydetails("HR");
		

	}

}
