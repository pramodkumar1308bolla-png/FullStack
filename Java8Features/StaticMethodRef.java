package Java8Features;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class StaticMethodRef {
	
	static void print(int n) {
		System.out.println(n);
	}
	
	Void msg() {
		System.out.println("Hello from instance method");
		
		return null;
	}
	public StaticMethodRef(){
		System.out.println("This is constructor of static");
		
	}
	public static void main(String[] args) {
		Consumer<Integer> s1=StaticMethodRef::print;
		s1.accept(10);
		
		StaticMethodRef O=new StaticMethodRef();
		Supplier<Void> str=O::msg;
		str.get();
		
		Supplier<StaticMethodRef> s=StaticMethodRef::new;
		s.get();
	}

}
