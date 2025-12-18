package Java8Features;

import java.time.LocalDate;

public class functionalinterface {
	public static void main(String[] args) {
		
//		int[] arr = { 11, 22, 33, 44, 55, 66 };
//		Predicate<Integer> e1 = n -> n % 2 == 0;
//		for (int i : arr) {
//			if (e1.test(i)) {
//				System.out.println(i);
//			}
//		}

//		List<String> names=Arrays.asList("abc","bcd","aem");
//		Predicate<String> s1=n->n.startsWith("a");
//		for (String string : names) {
//			if(s1.test(string))
//				System.out.println(string);
//			
//		}

//		List<String> names=Arrays.asList("abcdefh","bcdedee dushb","aem");
//		Predicate<String> s1=a->a.length()>=6;
//		Predicate<String> ns=s->!s.contains(" ");
//		Predicate<String> v=s1.and(ns);
//		for (String string : names) {
//			if(v.test(string))
//				System.out.println(string);
//			
//		}

//		Predicate<Integer> pass=m->m>=35;
//		System.out.println(pass.test(30) ? "Pass":"Fail");

//		Predicate<Integer> eligible=v->v>=18;
//		System.out.println(eligible.test(21));

//		Predicate<String> validString = s -> s != null && !s.isEmpty();
//
//		List<String> list = Arrays.asList("Java", "", null, "Hi");
//
//		list.stream().filter(validString).forEach(System.out::println);

		// check sumof two numbers is even

//		
//		BiPredicate<Integer, Integer> sum=(a,b)->(a+b)%2==0;
//		System.out.println(sum.test(12, 22));
//		System.out.println(sum.test(5,8));

		// check if first string starts with second string

//		BiPredicate<String,String> startswith=(s1,s2)->s1.startsWith(s2);
//		System.out.println(startswith.test("NavyaNasina", "Navya"));

//		int[] arr1= {1,2,3,4,5};
//		int[] arr2= {2,3,4,5,6};
//		BiPredicate<int[], int[]> checkLength = (a, b) -> a.length == b.length;
//
//		 
//		System.out.println(checkLength.test(arr1, arr2));

		// check both numbers are positive

//		BiPredicate<Integer, Integer> positiveCheck=(a,b)->a>=0 && b>=0;
//		System.out.println(positiveCheck.test(10, 20));

		// check if age and citizenship qualify for voting
//		BiPredicate<Integer, String> check=(a,b)->a>=18 && b.equalsIgnoreCase("Indian");
//		System.out.println(check.test(17,"Indian"));

		// check two strings are same using equals ignore case
//		BiPredicate<String, String> check=(a,b)->a.equalsIgnoreCase(b) ;
//		System.out.println(check.test("indian","Indian"));

		// check if first number is divible by second
		// compare two employess by salary
		// check if two characters are owels
		// check login validation username + Password
		//

		// ---->Consumer

//		Consumer<Integer> num=n->System.out.println("number "+ n);
//		num.accept(10);
		// Convert STring to Upper case
//		Consumer<String> str=n->System.out.println("String "+ n.toUpperCase());
//		str.accept("abc");

//		int[] arr= {1,2,3,4,5};
//		Consumer<Integer> num=n->System.out.println(n);
//		for (int i : arr) {
//			num.accept(i);
//			
//		}

		// Increase all the elements by +5
		// print log error mesages 1.file not found, 2.Invalid password
		// print msg multiple times
		// apply discount of 5% to product
		// append text to a string builder
		// print all employee details
		// to store key value pair into a map
		// to compare to integers and print the larger one
		// by using biConsumer to print array index + value

//	1	int[] arr= {1,2,3,4,5};
//		Consumer<Integer> num=n->System.out.println(n+5);
//		for (int i : arr) {
//			num.accept(i);
//		
//		}
//		int[] arr= {1,2,3,4,5};
//		Consumer<Integer> num=n->System.out.println(n);
//		for (int i : arr) {
//			num.accept(i);
//		
//		}

		// to print a message hello java 8
//		Supplier<String> a=()->"Hello java 8";
//		System.out.println(a.get());

		// to return 100
//		Supplier<Integer> n=()->100;
//		System.out.println(n.get());

		// to get addition of 2 numbers
//		int a=10,b=20;
//		Supplier<Integer> n1=()->a+b;
//		System.out.println(n1.get());

		// to check the number is even or odd
//		int n=2;
//		Supplier<String> q=()->(n%2==0)?"Even":"Odd";
//		System.out.println(q.get());

		// to find square of a number
//		int n=2;
//		Supplier<Integer> a=()->n*n;
//		System.out.println(a.get());

		// reverse a number
//		int n = 123;
//		Supplier<Integer> n1 = () -> {
//
//			int temp = n;
//			int a = 0, rev = 0;
//			while (temp > 0) {
//				a = temp % 10;
//				rev = rev * 10 + a;
//				temp = temp / 10;
//			}
//
//			return rev;
//
//		};
//		System.out.println(n1.get());

		// factorial
//		Supplier<Integer> n1 = () -> {
//			int n = 4;
//			int fact=1;
//			int i = 1;
//			while (i <=4) {
//				
//				fact=fact*i;
//				i++;				
//			}
//
//			return fact;
//			
//
//		};
//		System.out.println(n1.get());

		// return employee obj

//		Supplier<Employee> e1=()->{
//			return null;
//			
//		};
//		
//		

	}

}
