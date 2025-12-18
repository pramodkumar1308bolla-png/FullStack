package com.jsp.Arrays2D;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n = 10;
		int first = 0, second = 1;

		System.out.print("Fibonacci Sequence: " + first + ", " + second);

		for (int i = 1; i < n; i++) {
			int next = first + second;
			System.out.print(", " + next);
			first = second;
			second = next;
		}
	}
}
