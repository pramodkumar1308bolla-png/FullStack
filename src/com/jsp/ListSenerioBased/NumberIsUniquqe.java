package com.jsp.ListSenerioBased;

import java.util.HashSet;

public class NumberIsUniquqe {

	public static void main(String[] args) {
		String str="hello World";
		HashSet<Character> Unique=new HashSet<Character>();
		for(char c: str.toCharArray()) {
			Unique.add(c);
		}
		System.out.println("Number of Unique Characters are : " + Unique.size());

	}

}
