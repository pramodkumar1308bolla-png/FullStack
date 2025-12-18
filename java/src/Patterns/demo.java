package Patterns;

public class demo {
	public static void main(String[] args) {
		int n=11;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
//				System.out.print(i);
//				System.out.print(j);
//				System.out.print(i+j);
//				System.out.print(j+i-1+" ");
				if((i+j)%2==0) {
					System.out.print(1+" ");
				}
				else{
					System.out.print(0+" ");
				}
				
			}
			System.out.println();
		}
	}

}
