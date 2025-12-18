package com.jsp.regex;

import java.util.regex.Pattern;

public class demo {
	public static void main(String[] args) {
//		String regex = ".*abc.*"; ------------->Contains abc any where in the String
//		String regex = ".*D";------------------>Endes with D
//		String regex = "[A,a].*";-------------->Starts with A or a
//		String regex = "[A-Z,a-z].*";
//		String regex = "[0-9].*";
		String regex = "[^A-Z,^a-z,^0-9].*";
		String s=".zabcD";
		System.out.println(Pattern.matches(regex, s));
	}

}
