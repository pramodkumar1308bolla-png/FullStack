package Constructor;
 
class Student{
	String sName;
	int age;
	int id;
	public Student() {
		System.out.println("there is no student with specific data");
	}
	
	public Student(String sName) {
		this.sName = sName;
	}

	public Student(int age) {
		this.age = age;
	}
	public Student(String sName, int age, int id) {
		this.sName = sName;
		this.age = age;
		this.id = id;
	}
	void displayDetails() {
		System.out.println("Student name is: "+sName);
		System.out.println("the age : "+age);
		System.out.println("the id : "+ id);
		System.out.println("-----------------------");
		
	}
	
	
}

public class demoo {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.displayDetails();
		Student s2=new Student("Pramod");
		s2.displayDetails();
		Student s3=new Student(10);
		s3.displayDetails();
		Student s4=new Student("Pramod",10,1);
		s4.displayDetails();
		

	}

}
