package Java8Features;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo1 {

	public static void main(String[] args) {
		Predicate<String> p1=(String s)->{
			return s.length()>5;
		};
		System.out.println(p1.test("Hello"));
		System.out.println(p1.test("Welcome"));
		
		BiPredicate<Integer,Integer> p2=(Integer n1,Integer n2)->{
			return n1%2==0 && n2%2==0;
		};
		System.out.println(p2.test(12,20));
		System.out.println(p2.test(14,43));
		
		Consumer<String> c1=(String s)->{
			System.out.println(s+" Who is you girl Friend from 2nd row");
		};
		
		
		BiConsumer<String,Integer> c2=(String name,Integer age)->{
			System.out.println(name+"How is your girl friend");
			System.out.println(age+" days relation ship");
		
		};
		
		c1.accept("Vishnu");
		c2.accept("Vishnu", 20);
		
		System.out.println();
		
		//get() with 0 parameters
		Supplier<String> s1=()->{return "Hello I'm Chitti Speed 1TB memory 1GB";};
		System.out.println(s1.get());
		
		System.out.println();
		Function<Integer,Double> Sqrt=(Integer n)->{return Math.sqrt(n);};
		System.out.println(Sqrt.apply(10));
		
		BiFunction<String, String, String> str=(str1,str2)->{
			return str1+" " + str2;
		};
		System.out.println(str.apply("Hello", "Sana6"));
		
	}

}
