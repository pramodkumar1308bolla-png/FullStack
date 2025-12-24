package Java8FeturesStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EvenStream {
	public static void main(String[] args) {
//		List<Integer> list=Arrays.asList(10,15,20,25,30);
//		list.stream().filter(n->n%2==0).forEach(System.out::println);
//		s.forEach(System.out::println);
		
		
		
		//Find numbers greater than 20
//		List<Integer> list1=Arrays.asList(10,15,20,25,30);
//		list1.stream().filter(n->n>20).forEach(System.out::println);
//		
//		//Squ
//		List<Integer> list2=Arrays.asList(10,15,20,25,30);
//		list2.stream().map(n->n*n).forEach(System.out::println);
//		
		
	
		
		
	
		
		
		
		
		//starts with a
//		List<String> s=Arrays.asList("apple","banana","orange","ava");
//		s.stream().filter(n->n.startsWith(n, 'a')).forEach(System.out::println);
//		
//		
		//leng>5
//		List<String> s1=Arrays.asList("apple","banana","orange","java");
//		s1.stream().filter(n->n.length()>5).forEach(System.out::println);
		
		//filter null from list of Strings
//		List<String> s2=Arrays.asList("apple","banana","orange",null);
//		s2.stream().filter(n->n!=null).forEach(System.out::println);
		

		//div by 3 and 5 from a list
//		List<Integer> list1=Arrays.asList(10,15,20,25,30);
//		list1.stream().filter(n->n%3==0 || n%5==0).forEach(System.out::println);
		
//		//filter emp sal>50000
//		List<Integer> list2=Arrays.asList(10000,150000,20000,25000000,300000);
//		list2.stream().filter(n->n>50000).forEach(System.out::println);
		
		
		//filtler marks>=40
//		List<Integer> list3=Arrays.asList(10,40,45,30,26,85,58);
//		list3.stream().filter(n->n>=40).forEach(System.out::println);
		
		//filter duplicate elements 
//		List<String> s3=Arrays.asList("apple","banana","orange","apple");
//		s3.stream().distinct().forEach(System.out::println);
		
		//filter Strings that contained the word java from a list
//		List<String> s4=Arrays.asList("java","banana","orange","javaFullstack");
//		s4.stream().filter(n->n.contains("java")).forEach(System.out::println);
		
		
		//ordred list contains order amounts filter and display above 1000 rupiees
		
		
		
		
//		
//		List<String> s4=Arrays.asList("java","banana","orange","javaFullstack");
//		s4.stream().map(String::toUpperCase).forEach(System.out::println);
		
//		List<Integer> list3=Arrays.asList(10,4,4);
//		list3.stream().map(ele->ele*ele).forEach(System.out::println);
//		
//		List<String> s4=Arrays.asList("java","banana","orange","javaFullstack");
//		s4.stream().map(String::length).forEach(System.out::println);
		
//		List<Integer> list3=Arrays.asList(10,4,4);
//		list3.stream().map(ele->ele+10).forEach(System.out::println);
//		
//		List<Integer> l1=Arrays.asList(10,20,30);
//		l1.stream().map(String::valueOf).forEach(System.out::println);
		
		
//		List<String> s4=Arrays.asList("java","banana","orange","javaFullstack");
//		s4.stream().map(e->e.charAt(0)).forEach(System.out::println);
		
//		List<String> s1=Arrays.asList("Java","bana");
//		s1.stream().map(e->e.concat("mr")+e).forEach(System.out::println);
		
//		List<Integer> i=Arrays.asList(5,7,3,9);
//		i.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
//		List<String> s4=Arrays.asList("java","banana","orange","javaFullstack");
//		s4.stream().sorted().forEach(System.out::println);
		
		//Sort Strings based on String length
//		List<String> s4=Arrays.asList("java","banana","orangew","javaFullstack");
//		s4.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
//		
//		List<Integer> i=Arrays.asList(3,8,1,6);
//		i.stream().filter(e->e>3).sorted().forEach(System.out::println);
		
//		List<String> s3=Arrays.asList("aca","aaa","Jav","sou");
//		s3.stream().sorted(Comparator).forEach(System.out::println);
		
//		List<Integer> i1=Arrays.asList(3,8,1,6);
//		i1.stream().sorted().limit(2).forEach(System.out::println);
		
		//unique values and print
//		List<Integer> list=Arrays.asList(5,2,5,2,3);
//		list.stream().distinct().forEach(System.out::println);
		
//		List<String> s3=Arrays.asList("acahdgd");
//		s3.stream().distinct().map(String::toUpperCase).forEach(System.out::println);
		
//		list.stream().distinct().sorted().forEach(System.out::println);
		
		
		String ss="acahdgd";
		ss.chars().mapToObj(c->(char)c).forEach(System.out::println);
		
		List<Integer> list=Arrays.asList(5,15,15,25,30);
		list.stream().filter(e->e>10).distinct().forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
