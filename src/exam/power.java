package exam;

public class power {
	static int sum_of_digits(int n,int count) {
		int p=1;
		for(int i=1;i<=count;i++) {
			p=p*n;
			
		}
		return p;

}


	public static void main(String[] args) {
		int n=1432,count=0;
		int sum=0,rem=0;
		while(n!=0) {
			 rem=n/10;
			sum=sum+sum_of_digits(rem,count);
			
			n=n/10;
			
		}
		System.out.println(sum);
		

}
}
