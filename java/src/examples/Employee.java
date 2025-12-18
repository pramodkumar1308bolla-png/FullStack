package examples;

public class Employee {
	String name;
	int eid;
	int sal;
	public Employee(String name, int eid, int sal) {
		super();
		this.name = name;
		this.eid = eid;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", sal=" + sal + "]";
	}
	

}
