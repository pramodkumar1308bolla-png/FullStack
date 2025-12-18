package com.jsp.regex;

import java.util.regex.Pattern;

public class Example2 {
	public static void main(String[] args) {
//		String regex="[a-z,A-Z]{4}[0-9]{3}.*";
//		String regex="[6-9]{1}[0-9]{9}.*";
		String regex="[A-Z]{5}#*[0-9]{2}.*";
		
		String s="ABCDEdfghjk32";
		System.out.println(Pattern.matches(regex, s));

	}
}
