package com.jsp.ListSenerioBased;

import java.util.HashSet;

public class Union_intersection {

	public static void main(String[] args) {
		HashSet<String> arrList1=new HashSet<String>();
		arrList1.add("Abhi");
		arrList1.add("Gamya");
		arrList1.add("Pramod");
		arrList1.add("Tarun");
		arrList1.add("Asritha");
		HashSet<String> arrList2=new HashSet<String>();
		arrList2.add("Tarun");
		arrList2.add("cherry");
		arrList2.add("Madhuri");
		arrList2.add("Suji");
		arrList2.add("Asritha");
		HashSet<String> union=new HashSet<>(arrList1);
		union.addAll(arrList2);
		System.out.println("After Union the list is : " + union);
		System.out.println("-------------------------------------");
		HashSet<String> intersection=new HashSet<String>(arrList1);
		intersection.retainAll(arrList2);
		System.out.println("After retain all the list is " + intersection);
	}

}
