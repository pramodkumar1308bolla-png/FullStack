package com.jsp.ListSenerioBased;

import java.util.HashSet;

public class arrayListequal {

	public static void main(String[] args) {
		HashSet<String> arrList1=new HashSet<String>();
		arrList1.add("Abhi");
		arrList1.add("Gamya");
		arrList1.add("Pramod");
		HashSet<String> arrList2=new HashSet<String>();
		arrList2.add("cherry");
		arrList2.add("Madhuri");
		arrList2.add("Suji");
		HashSet<String> arrList3=new HashSet<String>();
		arrList3.add("Jana");
		arrList3.add("Monish");
		arrList3.add("Tarun");
		System.out.println("The Lists (list1 and list2)are equal " + arrList1.equals(arrList2));
		System.out.println("========================");
		System.out.println("The Lists (list2 and list2)are equal " + arrList2.equals(arrList2));
	}

}
