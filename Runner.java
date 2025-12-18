package Java8Features;

import java.util.LinkedHashMap;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Runner {
	public static void main(String[] args) {
//		MobileService.getAllMobiles().forEach(ele->System.out.println(ele));
//		System.out.println("==========================================================================================================");

		// Print all Mobiles price above 100;
//		print ALl Mobiles of samsung
//		print all Mobiles with price above 100 and yom is 2018
//		print all Mobiles Total Sum of price of apple Phones
//		print all Mobiles with ram Size greater than 5 and red Color

//		Create Map of Key and Value as Price of Samsung

		
//		Predicate<Double>p1=(n)->n>50000;
//		MobileService.getAllMobiles().forEach(ele->{
//			if(p1.test(ele.getPrice())) {
//				System.out.println(ele);
//			}
//		});
//	
//		
//		Predicate<String>p2=(n)->n=="Samsung";
//		MobileService.getAllMobiles().forEach(ele->{
//			if(p2.test(ele.getCompany())) {
//				System.out.println(ele);
//			}
//		});
//		
//		
//		System.out.println("============");
//		BiPredicate<Double, Integer> p3=(p,y)->p>40000 && y==2021;
//		
//		MobileService.getAllMobiles().forEach(ele->{
//			if(p3.test(ele.getPrice(),ele.getYom())) {
//				System.out.println(ele);
//			}
//		});
//		
//		System.out.println("=============");
//		Predicate<String> p4=(str)->str.equals("Apple");
//		Predicate<Double> p5=(n)->n.equals(p4);
//		MobileService.getAllMobiles().forEach(ele->{
//			double sum=0;
//			if(p4.test(ele.getCompany())) {
//				System.out.println(ele);
//				if(p5.test(ele.getPrice())){
//					
//					sum+=ele.getPrice();
//					System.out.println(sum);
//					
//				}
//				
//				
//				
//			}
//			
//		});
//		
//		Predicate<String >p6=(str)->str.equalsIgnoreCase("Samsung");
//		
//		LinkedHashMap<String, Double> m1=new LinkedHashMap<String, Double>();
//		
//		
//		MobileService.getAllMobiles().forEach(ele->{
//			if(p6.test(ele.getCompany())) {
//				m1.put(ele.getName(),ele.getPrice());
//			}
//		});
		
		Consumer<String> c1=(s)->{
			System.out.println("hi"+s);
		};
		Consumer<String> c2=(s)->{
			System.out.println("Bye "+s);
		};
		
		c1.andThen(c2).accept("Kavya");	
		
		
		
	

	}

}
