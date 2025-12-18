package Patterns;

public class Demo2 {
	public static void main(String[] args) {
		int n=11;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
//			System.out.print("*");
//				if(j==1) System.out.print("*");
//				if(i==1)System.out.print("*");
//				if(i==j||i+j==n+1) {
//					System.out.print("*");
//				}
//				else {
//					System.out.print(" ");
//				}
//				if(i==1||i==n||j==1||j==n) {
//					System.out.print("* ");
//				}
//				else {
//					System.out.print("  ");
//				}
//				if(i>=j) {
//					System.out.print("* ");
//				}
//				else {
//					System.out.print("  ");
//				}
//				
//				if(i<=j) {
//					System.out.print("* ");
//				}
//				else {
//					System.out.print("  ");
//				}
				if(i<=j) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
				
				
			}
			System.out.println();
		}
	}

}
