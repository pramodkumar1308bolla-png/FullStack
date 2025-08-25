package Is_A_Relation;

class Employee{
	int id;
	String name;
	

	public Employee(int id, String name) {
		
		this.id = id;
		this.name = name;
	}


	public void displaydetails() {
		System.out.println("Name of the EMployee : " + name);
		System.out.println("Employee Id : " + id );
	}
}
class FullTimeEmployee extends Employee{
	double salary;
	
	public FullTimeEmployee(int id, String name, double salary) {
		super(id, name);
		this.salary = salary;
	}


	public void displayFullTimeEmployee() {
		System.out.println("Salary : " + salary);
	}
}
class Developer extends FullTimeEmployee{
	String language;


	public Developer(int id, String name, double salary, String language) {
		super(id, name, salary);
		this.language = language;
	}


	public void displayDeveloperdetails() {
		System.out.println("Language : " + language);
	}
	
}

public class task {

	public static void main(String[] args) {
		Developer deve=new Developer(123, "ytezxrt", 42502690.0, "java");
		deve.displayDeveloperdetails();
		deve.displayFullTimeEmployee();
		deve.displaydetails();

	}

}
