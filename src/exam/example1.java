package exam;

public class example1 {
	public static void main(String[] args) {
//		int num=1234,rem=0,n=0,count=0,d=1;
//		while(num>0) {
//			rem=rem*10+n%10;
//			n=n/10;
//			count++;
//		}
//		if(count%2 !=0) {
//			System.out.println("Enter even digit count");
//		}
//		int sum=0,sum1=num/d,sum2=num/d,half=count/2;
//		for(int i=1;i<=count;i++) {
//			 d=rem*10;
//			if(i<=half) {
//				sum=sum1+sum2;
//				System.out.println(sum);
//			}
//		}

//        int num = 1242;
//        int count = 0;
//        int temp = num;
//        while (temp > 0) {
//            temp /= 10;
//            count++;
//        }
//
//        if (count % 2 != 0) {
//            System.out.println("Enter even digit count");
//            return;
//        }
//
//        int half = count / 2;
//        int firstHalf = num / (int) Math.pow(10, half);
//        int secondHalf = num % (int) Math.pow(10, half);
//
//        int temp1 = firstHalf;
//        int temp2 = secondHalf;
//
//        while (temp1 > 0 && temp2 > 0) {
//            int sum = (temp1) + (temp2);
//            System.out.println(sum);
//            temp1 /= 10;
//            temp2 /= 10;
//        }
		int n = 1987;
		int sum = 0;
		int count = 0;
		int sum1 = 0;

		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
			count++;

			while (sum != 0) {
				sum1 = sum1 + sum % 10;
				sum1 = sum1 / 10;
				count++;

			}
			System.out.println(sum1);
		}

	}
}
