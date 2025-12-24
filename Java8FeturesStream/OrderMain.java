package Java8FeturesStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrderMain {
	public static void main(String[] args) {
		List<Orders> orders = Arrays.asList(
		        new Orders("Laptop", 75000, 101,987654321),
		        new Orders("Mouse", 1200, 102,876543219),
		        new Orders("Phone", 90099, 103,765432198),
		        new Orders("Keyboard", 2000, 101,998765432)
		);
		orders.stream().map(Orders::getPhno).distinct().sorted().forEach(System.out::println);
		orders.stream().map(Orders::getName).distinct().sorted().forEach(System.out::println);
		orders.stream().map(Orders::getId).distinct().sorted().forEach(System.out::println);
//		orders.stream().filter(e->).distinct().sorted().forEach(System.out::println);

		

		
		
		
	}

}
