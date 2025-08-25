package exam;

public class Example {
	static int sum_of_digits(int n) {
//		int rem = 0;
//		int sum = 0;
//		while(n!=0) {
//			rem=n%10;
//			sum=sum+rem;
//			n=n/10;
//		}
//		return sum;
		int ex=2;
		int p=1;
		for(int i=1;i<=ex;i++) {
			p=p*n;
		}
		return p;
		
	}
public static void main(String[] args) {
	//	int n=5;
//	int i=5;
//	System.out.println("This is 1 to n");
//	for(int i=1;i<=n;i++) {
//		System.out.println(i);
//	}
//	while(i<=n) {
//		System.out.println(i);
//		i++;
//		
//	}
//	do {
//		System.out.println(i);
//		i++;
//	}while(i<=n);
	
//	System.out.println("this is n to 1");
//	for(int i=n;i>=1;i--) {
//		System.out.println(i);
//	}
//	while(i>=1) {
//		System.out.println(i);
//		i--;
//	}
//	do {
//		System.out.println(i);
//		i--;
//	}while(i>=1);
//	int base=4;
//	int exp=2;
//	int pow=1;
//	for(int i=1;i<=    exp;i++) {
//		pow=pow*base;
//	}
//	System.out.println(pow);
	int n=1432;
	int sum=0;
	while(n!=0) {
		int r=n%10;
		sum=sum+sum_of_digits(r);
		n=n/10;
	}
	System.out.println(sum);
	
}
}
	
	
	
