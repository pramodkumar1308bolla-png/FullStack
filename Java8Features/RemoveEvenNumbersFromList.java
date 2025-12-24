package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveEvenNumbersFromList {
	public static void main(String[] args) {  
//		List<Integer> n=new ArrayList<Integer>(Arrays.asList(10,20,15,23,40));
//		n.removeIf(num->num%2==0);
//		System.out.println(n);
//		
//		
//		
//		
//		List<String> s=new ArrayList<String>(Arrays.asList("abhi","sai","soumi","ankuri"));
//		s.removeIf(str->str.startsWith("a"));
//		System.out.println(s);
//		
//		//DOuble the each
//		List<Integer> n1=new ArrayList<Integer>(Arrays.asList(10,20,15,23,40));
//		n1.replaceAll(rep->rep*2);
//		System.out.println(n1);
//		
//		List<String> s1=new ArrayList<String>(Arrays.asList("abhi","sai","soumi","ankuri"));
//		s1.replaceAll(str->str.toUpperCase());
//		System.out.println(s1);
//		
//		//Remove num<10, squre remaining numbers
//		List<String> s2=new ArrayList<String>(Arrays.asList("abhi","sai","soumi","ankuri"));
//		s2.removeIf(str->str.startsWith("a"));
//		System.out.println(s2);
//		
//		List<Integer> nu=new ArrayList<Integer>(Arrays.asList(10,20,15,23,40));
//		nu.removeIf(n2->n2<10);
//		nu.replaceAll(nm->nm*nm);
//		System.out.println(nu);
//		
//		//Remove null,empty, replace all to uppercase print each name using for each
//		List<String> s3=new ArrayList<String>(Arrays.asList(null,"sai","soumi",""));
//		s3.removeIf(num->num==null || num.isEmpty());
//		s3.replaceAll(str->str.toUpperCase());
//		s3.forEach(System.out::println);
//		
//		
//		//Employee SalUpdate
//		List<Integer> Emp=new ArrayList<Integer>(Arrays.asList(12000,20000,15000,23000,400000));
//		Emp.removeIf(sal->sal<15000);
////		System.out.println(Emp);
//		Emp.replaceAll(sall->sall+sall*10/100);
//		Emp.forEach(System.out::println);
////		System.out.println(Emp);
//		
		// EMailValidation
		List<String> Email = new ArrayList<String>(
				Arrays.asList("abc@gmail.com", "test@yahoo.com", "demo@gmail.com", "invalid@outlook.com"));
		Email.removeIf(str -> !str.endsWith("@gmail.com"));
		Email.replaceAll(str1 -> str1.concat("- VALID"));
		Email.forEach(System.out::println);

		List<Integer> pr = new ArrayList<Integer>(Arrays.asList(499, 999, 1499, 199, 2499));
		pr.removeIf(sal -> sal < 500);
		pr.replaceAll(sall -> sall + sall * 18 / 100);
		pr.forEach(System.out::println);

		List<String> sp = new ArrayList<String>(Arrays.asList("java", "python", "c", "javascript", "go"));
		sp.removeIf(len -> len.length() < 4);
		sp.replaceAll(str1 -> "Language : <".concat(str1) + ">");
		sp.forEach(System.out::println);

		List<Integer> marks = new ArrayList<Integer>(Arrays.asList(35, 48, 60, 72, 28, 90));
		marks.removeIf(ele -> ele < 40);
		marks.replaceAll(ele -> ele + 5);
		marks.forEach(System.out::println);

		List<String> form = new ArrayList<String>(Arrays.asList("admin", "root", "gust", "user123", "test"));
		form.removeIf(len -> len.length() < 5);
		form.replaceAll(str1 -> "USER_".concat(str1));
		form.forEach(System.out::println);
		
		List<Integer> amo = new ArrayList<Integer>(Arrays.asList(4300, 5000, 300, 8000, 150));
		amo.removeIf(sal -> sal < 1000);
		amo.replaceAll(sall -> sall - sall *5 / 100);
		amo.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		
		
		
		
		
		
	}

}
