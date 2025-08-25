package Has_A_Relation;
 
class Engine{
	String engine_type;
	int hp;
	
	public Engine(String engine_type, int hp) {
		
		this.engine_type = engine_type;
		this.hp= hp;
	}
	public void displayEngineDetails() {
		System.out.println("engine type : " + engine_type);
		System.out.println("hp is : " + hp + " hp");
		
	}
}



class  car{
     String name;
     double price;
     Engine engine;
     
public car(String name, double price, Engine engine) {
	this.name = name;
	this.price = price;
	this.engine = engine;
    }
public void displaycarDetails() {
	System.out.println("car name : " + name);
	System.out.println("car price : " + price);
   }
}
public class cardetails {
	
	public static void main(String[] args) {
		Engine engine=new Engine("Petrol", 1500);
		car Car=new car("BMW",5000000.0, engine);
		Car.displaycarDetails();
		engine.displayEngineDetails();
	}
}
