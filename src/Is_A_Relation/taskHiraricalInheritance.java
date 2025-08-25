package Is_A_Relation;

class Animal{
	String name;
	String feeding;
	public Animal(String name, String feeding) {
		super();
		this.name = name;
		this.feeding = feeding;
	}
	public void eat() {
		System.out.println("Animal name : " + name);
		System.out.println("Animal eats : "+ feeding);
		System.out.println("----------------------------");
	}
	
	
}
class Dog extends Animal{

	public Dog(String name, String feeding) {
		super(name, feeding);
	}
	public void barks() {
		System.out.println("Dog barks");
	}
	
	
	
}
class Cat extends Animal{
	

	public Cat(String name, String feeding, double height) {
		super(name, feeding);
		
	}
	public void mewo() {
		System.out.println("cat sounds meow");
	}

		
	}
	
	

public class taskHiraricalInheritance {

	public static void main(String[] args) {
		Dog dog=new Dog(null, null);
		dog.barks();
		dog.eat();
		Cat cat=new Cat(null, null, 0);
		cat.mewo();
		cat.eat();

	}

}
