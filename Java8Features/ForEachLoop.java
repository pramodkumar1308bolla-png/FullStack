package Java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ForEachLoop {
	public static void main(String[] args) {
		Predicate<Integer> p1=(n)->n%2==0;
		Function<Integer, Double> f1=(n)->Math.sqrt(n);
		Supplier<Integer> s1=()->10;
		List<Integer> l1=Arrays.asList(1,2,3,4,5,89,6,98);
//		l1.forEach((c1)->System.out.println(c1+5));
		l1.forEach((c1)->{
			if(p1.test(c1)) {
				System.out.println(c1);
				System.out.println(f1.apply(c1+s1.get()));
			}
			});
	}

}
