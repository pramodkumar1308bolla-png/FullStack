package Java8Features;
class Student{
	int id;
	String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	void show() {
		System.out.println(id+" "+name);
	}
	

}
@FunctionalInterface
interface studentfactory{
	Student create(int id,String name);
	
}

public class ConstructorWithagrs {
	public static void main(String[] args) {
		studentfactory f1=Student::new;
		Student s1=f1.create(1, "Ankur");
		s1.show();
		
	}
	
}
	


	


