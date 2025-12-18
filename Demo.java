package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {
		/*
		 * 
		 * Method Reference(Short hand Representation)
		 * Static Method reference
		 * ClassName::methodName
		 * 
		 * Non-Static Method Reference
		 * Object::methodName
		 * 
		 */
//		Consumer<String> c1=(s)->{
//			new MobileService().printMobileOfCompany(s);
//		};
//		Consumer<String> c2=new MobileService()::printMobileOfCompany;
//		
//		c1.accept("Samsung");
//		c2.accept("Apple");
//		
		//List of Strings in Upper Case whose Length is Greater than or equal to 5
		List<String> l1=Arrays.asList("Abd","Virat","Prag","ankur");
		List<Integer> l2=Arrays.asList(1,2,3,4,5,6,5,7,9,8,10);
		List<List<Integer>> l3=new ArrayList<List<Integer>>();
		l3.add(Arrays.asList(1,3,4));
		l3.add(Arrays.asList(6,44,120));
		l3.add(Arrays.asList(99,4));
		
		
		
		
		/*
		List<String> ans1=l1.stream().filter(ele->ele.length()>=5).map(ele->ele.toUpperCase()).collect(Collectors.toList());
		System.out.println(ans1);
		
		//Multiply every number by 3 then print the data which is even number
		l2.stream().map(ele->ele*3).filter(ele->ele%2==0).forEach(System.out::println);*/
		
//		List<Integer>x1=l2.stream().distinct().collect(Collectors.toList());
//		System.out.println(x1);
//		
//		
//		List<Integer>x2=l2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		System.out.println(x2);
//		
//		
//		l2.stream().limit(5).forEach(ele->System.out.print(ele +" "));
//		System.out.println();
//		l2.stream().skip(5).forEach(ele->System.out.print(ele +" "));
//		
//		System.out.println();
//		List<Integer> x3= l3.stream().flatMap(ele->ele.stream()).collect(Collectors.toList());
//		System.out.println(x3);
//		
//		List<Integer> x4= l3.stream().flatMap(ele->ele.stream()).map(i->i+5).collect(Collectors.toList());
//		System.out.println(x4);
//		System.out.println("=============================");
//		//Mod every number 5 and remove the duplicates and get the list
//		List<Integer> x5=l2.stream().map(ele->ele%5).distinct().filter(ele->ele>2).collect(Collectors.toList());
//		System.out.println(x5);
//		
//		
//		System.out.println("Multiply every Odd  number by 3 and remove duplicates ");
//		List<Integer> x6=l2.stream().map(ele->{if(ele%2!=0) {ele=ele*3;}return ele;}).distinct().filter(ele->ele>5).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		System.out.println(x6);
//		
//		System.out.println("Convert nested List intl single list and remove the duplicates and sort them into asc order");
//		
//		List<Integer> x7=l3.stream().flatMap(ele->ele.stream()).distinct().sorted().collect(Collectors.toList());
//		System.out.println(x7);
//		
//		
//		
//		Integer x8=l2.stream().reduce(0,(a,b)->a+b);
//		System.out.println(x8);
//		
//		  Optional<Integer> x9 = l2.stream().reduce((a,b)->a*b);
//		  System.out.println(x9);
//		  
//		  long c=l2.stream().filter(ele->ele>7).count();
//		  System.out.println(c);
//		  
//		  Integer max=l2.stream().max(Comparator.comparing(ele->ele)).get();
//		  System.out.println(max);
//		  
//		  Integer min=l2.stream().min(Comparator.comparing(ele->ele)).get();
//		  System.out.println(min);
//		  
//		  //Find the largest element in list after multiplying add number by 5
//		  Integer c1 = l2.stream().map(ele->{if(ele%2!=0) {ele=ele*5;}return ele;}).max(Comparator.comparing(ele->ele)).get();
//		  System.out.println(c1);
//		  
//		  
//		  System.out.println("==========");
//		  l2.parallelStream().forEach(ele->System.out.println(ele));
//		  
//		  //print the first data which divide by 5
//		  int ans=l2.stream().filter(ele->ele%5==0).findFirst().get();
//		  System.out.println("Ans  : "+ ans);
//		  
//		  
//		  System.out.println("-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-~=-");
//		  boolean ans1 = l2.stream().anyMatch(ele->ele>100);
//		  System.out.println(ans1);
//		  
//		  boolean ans2 = l2.stream().map(ele->ele+50).anyMatch(ele->ele>100);
//		  System.out.println(ans2);
//		  
//		  boolean ans3 = l2.stream().allMatch(ele->ele%2==0);
//		  System.out.println(ans3);
//		  boolean ans4 = l2.stream().filter(ele->ele%2==0).allMatch(ele->ele%2==0);
//		  System.out.println(ans4);
//		  
//		  boolean ans5 = l2.stream().noneMatch(ele->ele%2==0);
//		  System.out.println(ans5);
//		  
//		  boolean ans6 = l2.stream().filter(ele->ele%2!=0).noneMatch(ele->ele%2==0);
//		  System.out.println(ans6);
		  
		 List<Integer> ans7 = l2.stream().map(ele->ele*2).toList();
		 System.out.println(ans7);
		 
		 List<Integer> ans8 = l2.stream().map(ele->ele*2).collect(Collectors.toList());
		 System.out.println(ans8);		
		 
		 
		  
		
		
	}

}
