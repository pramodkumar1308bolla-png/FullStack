package com.jsp.ListSenerioBased;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LinkedListToArrayList {

	public static void main(String[] args) {
		LinkedHashSet<String>conversion=new LinkedHashSet<String>();
		conversion.add("Cherry");
		conversion.add("Apple");
		conversion.add("Banana");
		conversion.add(null);
		conversion.add("Cherry");
		System.out.println("LinkedHash Set: ");
		for(String item:conversion) {
			System.out.println(item);
		}
		ArrayList<String> list=new ArrayList<String>(conversion);
		System.out.println("ArrayList: " + list);
		
	}

}
