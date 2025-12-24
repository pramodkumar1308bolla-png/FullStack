package Java8Features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountEvenNumber {
	public static void main(String[] args) {
		List<Integer> s = Arrays.asList(12, 13, 24, 5,5);
		long c = s.stream().filter(n -> n % 2 == 0).count();
		System.out.println(c);

		//starts with a
		List<String> names = Arrays.asList("aacb", "abc", "cca");
		long m = names.stream().filter(e -> e.startsWith("a")).count();
		System.out.println(m);
		
		
		List<Integer> num = Arrays.asList(15,45,20,60);
		List<Integer> n1=num.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(n1);
		
		List<String> upper=names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upper);
		
		//
		Set<Integer> n2=s.stream().collect(Collectors.toSet());
		System.out.println(n2);
		//combine string 
		String join=names.stream().collect(Collectors.joining(","));
		System.out.println(join);
		//claculate sum of num
		Integer sum=num.stream().reduce(0,(a,b)->a+b);
		System.out.println(sum);
		
		Integer max=num.stream().reduce(Integer::max).get();
		System.out.println(max);
		
		
		String na=names.stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
		System.out.println(na);
		
		
		List<List<Integer>> ll = Arrays.asList(Arrays.asList(5,5),Arrays.asList(5,6),Arrays.asList(5,7),Arrays.asList(5,8));
		List<Integer>re=ll.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		System.out.println(re);
		
	
		List<String> str=Arrays.asList("I am a Programmer");
		List<String> w=str.stream().flatMap(e->Arrays.stream(e.split(" "))).collect(Collectors.toList());
		System.out.println(w);
	}

}
