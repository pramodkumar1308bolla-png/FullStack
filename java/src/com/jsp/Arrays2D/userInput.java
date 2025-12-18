package com.jsp.Arrays2D;

import java.util.Scanner;

public class userInput {

	public static void main(String[] args) {
		int r, c;
		int sum = 0;
		int left_sum = 0;
		int right_sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no.of Rows:");
		r = sc.nextInt();
		System.out.print("Enter np.of Colm:");
		c = sc.nextInt();

		int[][] arr = new int[r][c];
		System.out.println("Enter the Elements:");
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();

			}

		}
		//Matrix formation
		System.out.println("2D array:");
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// Sum of all the elements in array
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				sum = sum + arr[i][j];

			}

		}
		System.out.println(sum);
//Diagonal Sum

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				if (i == j) {
					left_sum = left_sum + arr[i][j];

				} else {
					right_sum = right_sum + arr[i][j];
				}

			}

		} 
		System.out.println("Left side Sum : " + left_sum);
		System.out.println("Right side Sum : " + right_sum);

		sc.close();

	}

}
